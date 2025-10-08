package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.repository.CartRepoitory;
import com.example.ecommerce.ecommerce.api.repository.UserRepository;
import com.example.ecommerce.ecommerce.api.service.UserService;
import com.example.ecommerce.ecommerce.lib.error.AppException;
import com.example.ecommerce.ecommerce.mapper.GeneralMapper;
import com.example.ecommerce.ecommerce.model.dto.LoginRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.RegisterRequestDTO;
import com.example.ecommerce.ecommerce.model.entity.Cart;
import com.example.ecommerce.ecommerce.model.entity.User;
import com.example.ecommerce.ecommerce.model.vto.LoginUserVTO;
import com.example.ecommerce.ecommerce.model.vto.UserVto;
import com.example.ecommerce.ecommerce.security.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.example.ecommerce.ecommerce.lib.error.Error.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final GeneralMapper mapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final CartRepoitory cartRepoitory;
    @Override
    public LoginUserVTO login(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow(()->new AppException(USER_NOT_FOUND));
        boolean isPasswordMatches=passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword());
        if(!isPasswordMatches) {
            throw new AppException(USER_NOT_FOUND);
        }
        Map<String,Object> claims = new HashMap<>();
        String token=jwtService.generateToken(loginRequestDTO.getEmail(),claims);
        return LoginUserVTO.builder().token(token).build();
    }

    @Override
    public void register(RegisterRequestDTO registerRequestDTO) {
        if (registerRequestDTO.getEmail().isBlank() || registerRequestDTO.getPassword().isBlank()) {
            throw new AppException(INVALID_CREDENTIAL);
        }else{
            Optional<User> user = userRepository.findByEmail(registerRequestDTO.getEmail());
            if(user.isPresent()){
                throw new AppException(EMAIL_ALREADY_EXIST);
            }else {
                registerRequestDTO.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
                User usr=mapper.toUser(registerRequestDTO);
                usr.setCreatedOn(LocalDateTime.now());
                usr.setStatusId(1);
                cartRepoitory.addCart(Cart.builder().user(usr).createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build());
                userRepository.addUser(usr);
            }
        }
    }

    @Override
    public UserVto getUserById(Long id) {
        User user=userRepository.findById(id)
                .orElseThrow(()->new AppException(USER_NOT_FOUND));
        return mapper.toUserVto(user);
    }
}

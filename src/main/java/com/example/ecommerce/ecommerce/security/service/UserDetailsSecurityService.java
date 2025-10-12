package com.example.ecommerce.ecommerce.security.service;

import com.example.ecommerce.ecommerce.api.repository.UserRepository;
import com.example.ecommerce.ecommerce.lib.CommonData;
import com.example.ecommerce.ecommerce.lib.error.AppException;
import com.example.ecommerce.ecommerce.model.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static com.example.ecommerce.ecommerce.lib.error.Error.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class UserDetailsSecurityService implements UserDetailsService {
    private final UserRepository userRepository;
    private final CommonData commonData;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(()->new AppException(USER_NOT_FOUND));
        commonData.setUserId(user.getId());
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of();
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getEmail();
            }
        };
    }

}

package com.example.ecommerce.ecommerce.api.service;


import com.example.ecommerce.ecommerce.model.dto.LoginRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.RegisterRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.LoginUserVTO;
import com.example.ecommerce.ecommerce.model.vto.UserVto;

public interface UserService {
    LoginUserVTO login(LoginRequestDTO loginRequestDTO);
    void register(RegisterRequestDTO registerRequestDTO);
    UserVto getUserById(Long id);

}

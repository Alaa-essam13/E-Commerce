package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.UserController;
import com.example.ecommerce.ecommerce.api.service.UserService;
import com.example.ecommerce.ecommerce.model.dto.LoginRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.RegisterRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.LoginUserVTO;
import com.example.ecommerce.ecommerce.model.vto.UserVto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;
    @Override
    public ResponseEntity<LoginUserVTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(userService.login(loginRequestDTO));
    }

    @Override
    public ResponseEntity<Void> requestString(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        userService.register(registerRequestDTO);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<UserVto> getUserById(Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}

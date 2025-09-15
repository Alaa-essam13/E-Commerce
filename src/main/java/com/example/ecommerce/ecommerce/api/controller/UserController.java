package com.example.ecommerce.ecommerce.api.controller;

import com.example.ecommerce.ecommerce.model.dto.LoginRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.RegisterRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.LoginUserVTO;
import com.example.ecommerce.ecommerce.model.vto.UserVto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
public interface UserController {

    @PostMapping(path="/login", produces = {"application/json"})
    ResponseEntity<LoginUserVTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO);

    @PostMapping(path = "/register")
    ResponseEntity<Void> requestString(@Valid @RequestBody RegisterRequestDTO registerRequestDTO);

    @GetMapping("/users/{id}")
    ResponseEntity<UserVto> getUserById(@PathVariable("id") Long id);
}

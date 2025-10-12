package com.example.ecommerce.ecommerce.api.controller;

import com.example.ecommerce.ecommerce.model.vto.ScopeResultSet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Validated
public interface ScopeController {

    @GetMapping
    ResponseEntity<ScopeResultSet> getAllScopes();


}

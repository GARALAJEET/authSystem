package com.rio.userAuth.controller;

import com.rio.userAuth.DTO.DTO_login;
import com.rio.userAuth.DTO.DTO_signup;
import com.rio.userAuth.modal.login;
import com.rio.userAuth.modal.signup;
import com.rio.userAuth.service.login_service;
import com.rio.userAuth.service.signup_service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class mainController {
    @Autowired
    private signup_service signupService;
    @Autowired
    private login_service loginService;
    @GetMapping("/Home")
    public String hello(){
        return "Hello from Rio";
    }
    @PostMapping("/signup")
    public   ResponseEntity<String> signup( @Valid @RequestBody DTO_signup s){
         return  signupService.saveSignup(s);

    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid  @RequestBody DTO_login l){

        return loginService.saveLogin(l);
    }
}

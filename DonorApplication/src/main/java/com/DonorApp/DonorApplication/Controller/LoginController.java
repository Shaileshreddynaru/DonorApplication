package com.DonorApp.DonorApplication.Controller;

import com.DonorApp.DonorApplication.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DonorApp.DonorApplication.DTO.UserDto;
import com.DonorApp.DonorApplication.Services.DonService;
import com.DonorApp.DonorApplication.Services.JWTService;
import com.DonorApp.DonorApplication.repo.UserRepo;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(value= {"/login"})
public class LoginController {
    @Autowired
    private UserRepo repo;
    @Autowired
    private DonService ser;
    @Autowired
    private UserDto dto;
   @Autowired
   private JWTService jwtService;
    @Autowired
    AuthenticationManager authManager;

    @PostMapping(" ")

    public ResponseEntity<String> login(@RequestBody UserInfo userInfo, HttpSession session) {



        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(userInfo.getUsername(), userInfo.getPassword()));
        if (authentication.isAuthenticated()) {
            String token=jwtService.generateToken(userInfo.getUsername());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid");
        }
    }
}
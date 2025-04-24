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
import com.DonorApp.DonorApplication.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping(value= {"/registar"})
public class RegisterController {


    @Autowired
    private UserRepo repo;
    @Autowired
    private UserDto dto;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @PostMapping(" ")
    public ResponseEntity<String> readregister(@RequestBody UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        dto.setUsername(userInfo.getUsername());
        dto.setPassword(userInfo.getPassword());

        try {
            repo.save(userInfo);
            return ResponseEntity.ok("success"); }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("username exists try other name");
        }
    }
}
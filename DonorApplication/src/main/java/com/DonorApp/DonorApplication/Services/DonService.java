package com.DonorApp.DonorApplication.Services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication ;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.DonorApp.DonorApplication.DTO.UserDto;
import com.DonorApp.DonorApplication.Model.Donors;
import com.DonorApp.DonorApplication.Model.UserInfo;
import com.DonorApp.DonorApplication.repo.DonRepo;
import com.DonorApp.DonorApplication.repo.UserRepo;

@Service
public class DonService {


    @Autowired
    DonRepo don ;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    Donors ent;
    @Autowired
    private UserRepo repo;
    @Autowired
    AuthenticationManager authManager;


    public List<Donors> getDoners() {
        // TODO Auto-generated method stub
        return don.findAll();
    }



    public Donors readDonoer(Donors donor) {
        // TODO Auto-generated method stub



        return don.save(donor);
    }



    public boolean authenticate(UserDto dto) {
        UserInfo userInfo1 =new UserInfo();

        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        if(!dto.getUsername().equals(userInfo1.getUsername())){
            throw new UsernameNotFoundException("UserInfo does not exist in the database");
        }

        if (!bCryptPasswordEncoder.matches(userInfo1.getPassword(), dto.getPassword())) {
            throw  new BadCredentialsException("The password is incorrect");
        }

        return  true;
    }






}
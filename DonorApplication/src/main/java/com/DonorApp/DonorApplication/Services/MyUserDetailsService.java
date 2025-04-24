package com.DonorApp.DonorApplication.Services;

import com.DonorApp.DonorApplication.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.DonorApp.DonorApplication.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    public UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        UserInfo userInfo =repo.findByUsername(username);
        if(userInfo ==null) {
            System.out.println("no found");
            throw new UsernameNotFoundException("userInfo no fount");
        }
        return new UserPrincipal(userInfo);
    }

}
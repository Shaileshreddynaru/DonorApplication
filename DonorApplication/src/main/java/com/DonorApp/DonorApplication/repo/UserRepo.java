package com.DonorApp.DonorApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.DonorApp.DonorApplication.Model.UserInfo;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Integer>  {

    UserInfo findByUsername(String username);






}
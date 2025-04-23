package com.DonorApp.DonorApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DonorApp.DonorApplication.Model.Posts;

@Repository
public interface PostRepo extends JpaRepository<Posts, Integer>  {




}
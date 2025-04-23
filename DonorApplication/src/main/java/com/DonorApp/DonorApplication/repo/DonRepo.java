package com.DonorApp.DonorApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DonorApp.DonorApplication.Model.Donors;

@Repository
public interface DonRepo extends JpaRepository<Donors, Integer>  {




}
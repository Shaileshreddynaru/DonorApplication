package com.DonorApp.DonorApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.DonorApp.DonorApplication.DTO.DonorDto;
import com.DonorApp.DonorApplication.Model.Donors;
import com.DonorApp.DonorApplication.Model.Posts;
import com.DonorApp.DonorApplication.Services.DonService;
import com.DonorApp.DonorApplication.repo.DonRepo;
import com.DonorApp.DonorApplication.repo.PostRepo;


@RestController
@RequestMapping(value= {"/post"})
public class PostController {
    @Autowired
    PostRepo post ;

    @GetMapping(" ")
    public List<Posts> getPost()
    {
        return post.findAll();
    }


    @PostMapping(" ")
    public Posts readPost(@RequestBody Posts posts) {

        return post.save(posts);

    }

}
package com.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.entity.User;

@RestController
@RequestMapping({"/users"})
public class UserController {

	@GetMapping(path = {"/user"})
    public User getUser(){
        return new User(1,"Smile","Please","s@p.com");
    }
}

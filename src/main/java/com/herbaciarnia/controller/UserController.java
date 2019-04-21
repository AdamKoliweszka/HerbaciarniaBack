/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.User;
import com.herbaciarnia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author user
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/Uzytkownicy",method = RequestMethod.GET)
    public Collection<User> getAllUsers(){
        List<User> users = (List<User>) userService.findAll();
        return users;
        
    }

    
    @RequestMapping(value = "/Uzytkownicy/{username}", method = RequestMethod.DELETE)
    public void deleteUserByUsername(@PathVariable("username") String username){
        userService.deleteOne(username);
    }
    
    @RequestMapping(value = "/Uzytkownicy",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUserByUsername(@RequestBody User user){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userService.updateOne(username,user);
    }

    @RequestMapping(value = "/Uzytkownicy",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody User user){
        userService.insertOne(user);
    }

    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    public String loginUser(){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String s = userService.findAutorityByUsername(username);
        return s;
    }

}

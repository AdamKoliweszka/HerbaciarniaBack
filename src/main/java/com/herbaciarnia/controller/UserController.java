/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.User;
import com.herbaciarnia.service.UserService;
import com.herbaciarnia.validator.RegistrationCustomerValidateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/deleteAccount",method = RequestMethod.GET)
    public void deleteUser(){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userService.deleteByUsername(username);
    }

    @RequestMapping(value = "/Uzytkownicy/{username}", method = RequestMethod.DELETE)
    public void deleteUserByUsername(@PathVariable("username") String username){
        userService.deleteOne(username);
    }
    
    @RequestMapping(value = "/Uzytkownicy",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUserByUsername(@Validated({RegistrationCustomerValidateGroup.class}) @RequestBody User user){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userService.updateOne(username,user);
        return new ResponseEntity<String>("Zmiana hasła powiodła się!",HttpStatus.OK);
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }



}

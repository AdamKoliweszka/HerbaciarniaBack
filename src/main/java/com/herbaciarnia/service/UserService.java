/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.User;
import com.herbaciarnia.repository.AuthorityRepository;
import com.herbaciarnia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthorityRepository authorityRepository;


    public List<User> findAll() {

        List<User> users = (List<User>) repository.findAll();
        
        return users;
    }
    public User findOne(String username) {

        return repository.findOne(username);
    }
    public void deleteOne(String username) {

        repository.delete(username);
    }
    public void updateOne(User user) {
        User updatingUser = repository.findOne(user.getUsername());
        updatingUser.setPassword(user.getPassword());
        updatingUser.setEnabled(user.getEnabled());
        repository.save(updatingUser);
    }
    public void insertOne(User user) {
        List<User> lc = (List<User>)repository.findOne(user.getUsername());
        if(lc.size() == 0) {
            repository.save(user);
        }
    }

    public String findAutorityByUsername(String username)
    {
        return authorityRepository.findAuthorityByUsername(username);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Employee;
import com.herbaciarnia.service.PracownikService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/Pracownicy")
public class PracownikController {
    @Autowired
    PracownikService pracownikService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Employee> getAllPracownicy(){
        List<Employee> gatunki = (List<Employee>) pracownikService.findAll();
        return gatunki;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getPracownikById(@PathVariable("id") long id){
        return pracownikService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePracownikById(@PathVariable("id") long id){
        pracownikService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePracownikById(@RequestBody Employee employee){
        pracownikService.updateOne(employee);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertPracownik(@RequestBody Employee employee){
        pracownikService.insertOne(employee);
    }

}

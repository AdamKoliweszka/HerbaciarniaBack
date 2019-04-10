/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Provider;
import com.herbaciarnia.service.DostawcaService;
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
@RequestMapping("/Dostawcy")
public class DostawcaController {
    @Autowired
    DostawcaService dostawcaService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Provider> getAllDostawcy(){
        List<Provider> gatunki = (List<Provider>) dostawcaService.findAll();
        return gatunki;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Provider getDostawcaById(@PathVariable("id") long id){
        return dostawcaService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDostawcaById(@PathVariable("id") long id){
        dostawcaService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateDostawcaById(@RequestBody Provider provider){
        dostawcaService.updateOne(provider);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertDostawca(@RequestBody Provider provider){
        dostawcaService.insertOne(provider);
    }

}

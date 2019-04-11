/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Provider;
import com.herbaciarnia.service.ProviderService;
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
    ProviderService providerService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Provider> getAllDostawcy(){
        List<Provider> gatunki = (List<Provider>) providerService.findAll();
        return gatunki;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Provider getDostawcaById(@PathVariable("id") long id){
        return providerService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDostawcaById(@PathVariable("id") long id){
        providerService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateDostawcaById(@RequestBody Provider provider){
        providerService.updateOne(provider);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertDostawca(@RequestBody Provider provider){
        providerService.insertOne(provider);
    }

}

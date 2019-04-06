/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Zakup;
import com.herbaciarnia.service.ZakupService;
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
@RequestMapping("/Zakupy")
public class ZakupController {
    @Autowired
    ZakupService zakupService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Zakup> getAllZakupy(){
        List<Zakup> gatunki = (List<Zakup>) zakupService.findAll();
        return gatunki;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Zakup getZakupById(@PathVariable("id") long id){
        return zakupService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteZakupById(@PathVariable("id") long id){
        zakupService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteZakupById(@RequestBody Zakup zakup){
        zakupService.updateOne(zakup);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertZakup(@RequestBody Zakup zakup){
        zakupService.insertOne(zakup);
    }

}

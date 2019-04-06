/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Klient;
import com.herbaciarnia.service.KlientService;
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
@RequestMapping("/Klienci")
public class KlientController {
    @Autowired
    KlientService klientService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Klient> getAllKlienci(){
        List<Klient> gatunki = (List<Klient>) klientService.findAll();
        return gatunki;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Klient getKlientById(@PathVariable("id") long id){
        return klientService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteKlientById(@PathVariable("id") long id){
        klientService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateKlientById(@RequestBody Klient klient){
        klientService.updateOne(klient);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertKlient(@RequestBody Klient klient){
        klientService.insertOne(klient);
    }

}

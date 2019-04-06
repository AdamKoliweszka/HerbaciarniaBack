/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.KrajPochodzenia;
import com.herbaciarnia.service.KrajPochodzeniaService;
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
@RequestMapping("/KrajePochodzenia")
public class KrajPochodzeniaController {
    @Autowired
    KrajPochodzeniaService krajService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<KrajPochodzenia> getAllKraje(){
        List<KrajPochodzenia> kraje = (List<KrajPochodzenia>) krajService.findAll();
        return kraje;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public KrajPochodzenia getKrajById(@PathVariable("id") long id){
        return krajService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteKrajById(@PathVariable("id") long id){
        krajService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteKrajById(@RequestBody KrajPochodzenia kraj){
        krajService.updateOne(kraj);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertKraj(@RequestBody KrajPochodzenia kraj){
        krajService.insertOne(kraj);
    }

}

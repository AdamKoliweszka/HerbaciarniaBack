/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.ArgumentWyszukiwaniaHerbaty;
import com.herbaciarnia.bean.Herbata;
import com.herbaciarnia.service.HerbataService;
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
@RequestMapping("/Herbaty")
public class HerbataController {
    @Autowired
    HerbataService herbataService;
    
    @RequestMapping(path = "/Dostepne",method = RequestMethod.GET)
    public Collection<Herbata> getAllDostepneHerbaty(){
        List<Herbata> herbaty = (List<Herbata>) herbataService.findAllDostepne();
        return herbaty;
        
    }
    
    @RequestMapping(path = "/Dostepne",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Herbata> getAllDostepneHerbatyFiltrowanie(@RequestBody ArgumentWyszukiwaniaHerbaty argument){
        List<Herbata> herbaty = (List<Herbata>) herbataService.findAllDostepneByArgument(argument);
        return herbaty;
        
    }

    @RequestMapping(path = "/Wszystkie",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Herbata> getAllWszystkieHerbatyFiltrowanie(@RequestBody ArgumentWyszukiwaniaHerbaty argument){
        List<Herbata> herbaty = (List<Herbata>) herbataService.findAllWszystkieByArgument(argument);
        return herbaty;

    }
    
    @RequestMapping(path = "/Wszystkie",method = RequestMethod.GET)
    public Collection<Herbata> getAllHerbaty(){
        List<Herbata> gatunki = (List<Herbata>) herbataService.findAll();
        return gatunki;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Herbata getHerbataById(@PathVariable("id") long id){
        return herbataService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteHerbataById(@PathVariable("id") long id){
        herbataService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateHerbataById(@RequestBody Herbata herbata){
        herbataService.updateOne(herbata);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertHerbata(@RequestBody Herbata herbata){
        herbataService.insertOne(herbata);
    }

}

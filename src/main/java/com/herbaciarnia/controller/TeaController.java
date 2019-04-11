/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.ArgumentWyszukiwaniaHerbaty;
import com.herbaciarnia.bean.Tea;
import com.herbaciarnia.service.TeaService;
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
public class TeaController {
    @Autowired
    TeaService teaService;
    
    @RequestMapping(path = "/Dostepne",method = RequestMethod.GET)
    public Collection<Tea> getAllAvaibleTea(){
        List<Tea> tea = (List<Tea>) teaService.findAllAvaible();
        return tea;
        
    }
    
    @RequestMapping(path = "/Dostepne",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Tea> getAllAvaibleTeaFiltered(@RequestBody ArgumentWyszukiwaniaHerbaty argument){
        List<Tea> tea = (List<Tea>) teaService.findAllAvaibleByArgument(argument);
        return tea;
        
    }

    @RequestMapping(path = "/Wszystkie",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Tea> getAllTeaFiltred(@RequestBody ArgumentWyszukiwaniaHerbaty argument){
        List<Tea> herbaty = (List<Tea>) teaService.findAllByArgument(argument);
        return herbaty;

    }
    
    @RequestMapping(path = "/Wszystkie",method = RequestMethod.GET)
    public Collection<Tea> getAllTea(){
        List<Tea> tea = (List<Tea>) teaService.findAll();
        return tea;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tea getTeaById(@PathVariable("id") long id){
        return teaService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeaById(@PathVariable("id") long id){
        teaService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTeaById(@RequestBody Tea tea){
        teaService.updateOne(tea);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertTea(@RequestBody Tea tea){
        teaService.insertOne(tea);
    }

}

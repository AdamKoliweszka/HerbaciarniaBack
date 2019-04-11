/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.CountryOfOrigin;
import com.herbaciarnia.service.CountryOfOriginService;
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
public class CountryOfOriginController {
    @Autowired
    CountryOfOriginService countryService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<CountryOfOrigin> getAllCountries(){
        List<CountryOfOrigin> kraje = (List<CountryOfOrigin>) countryService.findAll();
        return kraje;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CountryOfOrigin getCountryById(@PathVariable("id") long id){
        return countryService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCountryById(@PathVariable("id") long id){
        countryService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCountryById(@RequestBody CountryOfOrigin country){
        countryService.updateOne(country);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertCountry(@RequestBody CountryOfOrigin country){
        countryService.insertOne(country);
    }

}

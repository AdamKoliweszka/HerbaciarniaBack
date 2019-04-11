/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.TeaSpecies;
import com.herbaciarnia.service.TeaSpeciesService;
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
@RequestMapping("/GatunkiHerbaty")
public class GatunekHerbatyController {

    @Autowired
    TeaSpeciesService gatunekService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<TeaSpecies> getAllGatunki() {
        List<TeaSpecies> gatunki = (List<TeaSpecies>) gatunekService.findAll();
        return gatunki;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TeaSpecies getGatunekById(@PathVariable("id") long id) {
        return gatunekService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteGatunekById(@PathVariable("id") long id) {
        if (id > 1) {
            gatunekService.deleteOne(id);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteGatunekById(@RequestBody TeaSpecies gatunek) {
        if (gatunek.getId_Species() > 1) {
            gatunekService.updateOne(gatunek);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertGatunek(@RequestBody TeaSpecies gatunek) {
        gatunekService.insertOne(gatunek);
    }

}

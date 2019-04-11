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
public class TeaSpeciesController {

    @Autowired
    TeaSpeciesService teaSpecies;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<TeaSpecies> getAllTeaSpecies() {
        List<TeaSpecies> teaSpecies = (List<TeaSpecies>) this.teaSpecies.findAll();
        return teaSpecies;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TeaSpecies getTeaSpeciesById(@PathVariable("id") long id) {
        return teaSpecies.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeaSpeciesById(@PathVariable("id") long id) {
        if (id > 1) {
            teaSpecies.deleteOne(id);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTeaSpeciesById(@RequestBody TeaSpecies teaSpecies) {
        if (teaSpecies.getId_Species() > 1) {
            this.teaSpecies.updateOne(teaSpecies);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertTeaSpecies(@RequestBody TeaSpecies teaSpecies) {
        this.teaSpecies.insertOne(teaSpecies);
    }

}

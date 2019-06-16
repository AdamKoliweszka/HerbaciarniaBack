/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.TeaSpecies;
import com.herbaciarnia.service.TeaSpeciesService;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<TeaSpecies> getTeaSpeciesById(@PathVariable("id") long id) {
        TeaSpecies species = teaSpecies.findOne(id);
        if(species != null)
        {
            return new ResponseEntity<TeaSpecies>(species, HttpStatus.OK);

        }else return new ResponseEntity<TeaSpecies>( species,HttpStatus.BAD_REQUEST);


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTeaSpeciesById(@PathVariable("id") long id) {
        String comunicat = teaSpecies.deleteOne(id);
        if (comunicat.equals("Gatunek herbaty został usunięty!")) {
            return new ResponseEntity<String>(comunicat, HttpStatus.OK);

        }else return new ResponseEntity<String[]>( new String[] {comunicat} ,HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTeaSpeciesById(@Valid @RequestBody TeaSpecies teaSpecies) {
        String comunicat = this.teaSpecies.updateOne(teaSpecies);
        if(comunicat.equals("Gatunek herbaty został zaktualizowany!"))
        {
            return new ResponseEntity<String>(comunicat, HttpStatus.OK);

        }else return new ResponseEntity<String[]>( new String[] {comunicat} ,HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertTeaSpecies(@Valid @RequestBody TeaSpecies teaSpecies) {
        if (this.teaSpecies.insertOne(teaSpecies)) {
            return new ResponseEntity<String>("Gatunek herbaty został dodany!", HttpStatus.OK);

        }else{
            return new ResponseEntity<String[]>( new String[] {"Istnieje już gatunek z taką nazwą!"} ,HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}

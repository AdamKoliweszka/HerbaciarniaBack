/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.CountryOfOrigin;
import com.herbaciarnia.service.CountryOfOriginService;

import java.io.Serializable;
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
    public ResponseEntity getCountryById(@PathVariable("id") long id){
        CountryOfOrigin country = countryService.findOne(id);
        if(country != null)
        {
            return new ResponseEntity<CountryOfOrigin>(country, HttpStatus.OK);

        }else return new ResponseEntity<CountryOfOrigin>( country,HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCountryById(@PathVariable("id") long id){
        String comunicat = countryService.deleteOne(id);
        if (comunicat.equals("Kraj pochodzenia został usunięty!")) {
            return new ResponseEntity<String>(comunicat, HttpStatus.OK);

        }else return new ResponseEntity<String[]>( new String[] {comunicat} ,HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCountryById(@Valid @RequestBody CountryOfOrigin country){
        String comunicat = countryService.updateOne(country);
        if(comunicat.equals("Kraj pochodzenia został zaktualizowany!"))
        {
            return new ResponseEntity<String>(comunicat, HttpStatus.OK);

        }else return new ResponseEntity<String[]>( new String[] {comunicat} ,HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertCountry(@Valid @RequestBody CountryOfOrigin country){
        if (countryService.insertOne(country)) {
            return new ResponseEntity<String>("Kraj pochodzenia został dodany!", HttpStatus.OK);

        }else{
            return new ResponseEntity<String[]>( new String[] {"Istnieje już kraj z taką nazwą!"} ,HttpStatus.BAD_REQUEST);
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

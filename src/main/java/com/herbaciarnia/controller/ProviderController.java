/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Provider;
import com.herbaciarnia.service.ProviderService;
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
@RequestMapping("/Dostawcy")
public class ProviderController {
    @Autowired
    ProviderService providerService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Provider> getAllProviders(){
        List<Provider> providers = (List<Provider>) providerService.findAll();
        return providers;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Provider getProviderById(@PathVariable("id") long id){
        return providerService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProviderById(@PathVariable("id") long id){
        providerService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProviderById(@Valid @RequestBody Provider provider){
        providerService.updateOne(provider);
        return new ResponseEntity<String>("Dostawca został zaaktualizowany!", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertProvider(@Valid @RequestBody Provider provider){
        providerService.insertOne(provider);
        return new ResponseEntity<String>("Dostawca został dodany!", HttpStatus.OK);
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

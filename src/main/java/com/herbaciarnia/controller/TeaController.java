/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.ArgumentOfFilteringTea;
import com.herbaciarnia.bean.ArgumentOfFilteringTeaForEmployee;
import com.herbaciarnia.bean.Tea;
import com.herbaciarnia.service.TeaService;
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
@RequestMapping("/Herbaty")
public class TeaController {
    @Autowired
    TeaService teaService;
    
    @RequestMapping(path = "/Dostepne",method = RequestMethod.GET)
    public Collection<Tea> getAllAvaibleTea(){
        List<Tea> tea = (List<Tea>) teaService.findAllAvaible();
        System.out.println(tea.get(0).getImage().length);
        return tea;
        
    }

    @RequestMapping(path = "/Wszystkie",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Tea> getAllTeaFiltred(@RequestBody ArgumentOfFilteringTeaForEmployee argument){
        List<Tea> herbaty = (List<Tea>) teaService.findAllByArgument(argument);
        return herbaty;

    }

    @RequestMapping(path = "/Dostepne",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Tea> getAllAvaibleTeaFiltred(@RequestBody ArgumentOfFilteringTea argument){
        List<Tea> herbaty = (List<Tea>) teaService.findAllAvaibleByArgument(argument);
        return herbaty;

    }
    
    @RequestMapping(path = "/Wszystkie",method = RequestMethod.GET)
    public Collection<Tea> getAllTea(){
        List<Tea> tea = (List<Tea>) teaService.findAll();
        return tea;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tea> getTeaById(@PathVariable("id") long id){

        Tea tea = teaService.findOne(id);
        if(tea != null)
        {
            return new ResponseEntity<Tea>(tea, HttpStatus.OK);

        }else return new ResponseEntity<Tea>( tea,HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeaById(@PathVariable("id") long id){
        teaService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTeaById(@Valid @RequestBody Tea tea){

        String comunicat = this.teaService.updateOne(tea);
        if(comunicat.equals("Herbata została zaktualizowana!"))
        {
            return new ResponseEntity<String>(comunicat, HttpStatus.OK);

        }else return new ResponseEntity<String[]>( new String[] {comunicat} ,HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertTea(@Valid @RequestBody Tea tea){

        if (this.teaService.insertOne(tea)) {
            return new ResponseEntity<String>("Herbata została dodana!", HttpStatus.OK);

        }else{
            return new ResponseEntity<String[]>( new String[] {"Istnieje już herbata z taką nazwą!"} ,HttpStatus.BAD_REQUEST);
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

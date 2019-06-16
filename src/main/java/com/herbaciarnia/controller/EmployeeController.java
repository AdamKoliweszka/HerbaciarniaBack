/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Employee;
import com.herbaciarnia.service.EmployeeService;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.herbaciarnia.validator.EditingDataEmployeeValidateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author user
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    
    @RequestMapping(value = "/Pracownicy",method = RequestMethod.GET)
    public Collection<Employee> getAllEmployees(){
        List<Employee> employees = (List<Employee>) employeeService.findAll();
        return employees;
        
    }
    
    @RequestMapping(value = "/Pracownicy/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") long id){
        return employeeService.findOne(id);
    }
    
    @RequestMapping(value = "/Pracownicy/{id}", method = RequestMethod.DELETE)
    public void deleteEmployeeById(@PathVariable("id") long id){
        employeeService.deleteOne(id);
    }
    
    @RequestMapping(value = "/Pracownicy",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateEmployeeById(@Validated({EditingDataEmployeeValidateGroup.class}) @RequestBody Employee employee){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        employeeService.updateOne(username,employee);
        return new ResponseEntity<String>("Zmiana danych powiodła się!",HttpStatus.OK);
    }

    @RequestMapping(value = "/Pracownicy",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertEmployee(@Valid @RequestBody Employee employee){

        if(employeeService.insertOne(employee))
        {
            return new ResponseEntity<String>("Rejestracja powiodła się!",HttpStatus.OK);
        }else return new ResponseEntity<String[]>( new String[] {"Istnieje już użytkownik z takim loginem!"} ,HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/DanePracownika", method = RequestMethod.GET)
    public Employee getDataOfEmployee(){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return employeeService.findOneByUsername(username);
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

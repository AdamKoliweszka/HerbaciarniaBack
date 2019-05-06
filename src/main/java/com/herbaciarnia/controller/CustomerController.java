/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Customer;
import com.herbaciarnia.service.CustomerService;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.herbaciarnia.validator.RegistrationCustomerValidateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/Klienci")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Customer> getAllCustomers(){
        List<Customer> customers = (List<Customer>) customerService.findAll();
        return customers;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") long id){
        return customerService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomerById(@PathVariable("id") long id){
        customerService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomerById(@Valid @RequestBody Customer customer){
        customerService.updateOne(customer);
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity insertCustomer(@Validated({RegistrationCustomerValidateGroup.class}) @RequestBody Customer customer){
        if(customerService.insertOne(customer))
        {
            return new ResponseEntity<String>("Rejestracja powiodła się!",HttpStatus.OK);
        }
        else return new ResponseEntity<String[]>( new String[] {"Istnieje już użytkownik z takim loginem!"} ,HttpStatus.BAD_REQUEST);


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

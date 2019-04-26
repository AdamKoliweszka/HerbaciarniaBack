/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Customer;
import com.herbaciarnia.service.CustomerService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Customer> gatunki = (List<Customer>) customerService.findAll();
        return gatunki;
        
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
    public void updateCustomerById(@RequestBody Customer customer){
        customerService.updateOne(customer);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertCustomer(@RequestBody Customer customer){
        try {
            customerService.insertOne(customer);
            return new ResponseEntity("Rejestracja powiodła się!",HttpStatus.OK);
        }catch (IllegalArgumentException e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Użytkownik o takim loginie jest już w systemie!")
    void onFailRegistrationException(IllegalArgumentException exception) {}

}

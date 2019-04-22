/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Delivery;
import com.herbaciarnia.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/Dostawy")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Delivery> getAllDeliveries(){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Delivery> deliveries = (List<Delivery>) deliveryService.findAllByUsername(username);
        return deliveries;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Delivery getDeliveryById(@PathVariable("id") long id){
        return deliveryService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDeliveryById(@PathVariable("id") long id){
        deliveryService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateDeliveryById(@RequestBody Delivery delivery){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        if(delivery.getEmployee().getUser().getUsername().equals(username)) {
            deliveryService.updateOne(delivery);

        }


    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertDelivery(@RequestBody Delivery delivery){
        deliveryService.insertOne(delivery);
    }

}

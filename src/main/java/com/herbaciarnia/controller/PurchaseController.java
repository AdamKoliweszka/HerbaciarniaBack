/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Purchase;
import com.herbaciarnia.service.PurchaseService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/Zakupy")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Purchase> getAllPurchases(){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Purchase> purchases = (List<Purchase>) purchaseService.findAllByUsername(username);
        return purchases;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Purchase getPurchaseById(@PathVariable("id") long id){
        return purchaseService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePurchaseById(@PathVariable("id") long id){
        purchaseService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePurchaseById(@RequestBody Purchase purchase){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        if(purchase.getEmployee().getUser().getUsername().equals(username)) {
            purchaseService.updateOne(purchase);

        }


    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertPurchase(@RequestBody Purchase purchase){
        purchaseService.insertOne(purchase);
    }

}

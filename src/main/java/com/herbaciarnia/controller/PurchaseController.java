/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Purchase;
import com.herbaciarnia.bean.Tea;
import com.herbaciarnia.service.PurchaseService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> updatePurchaseById(@RequestBody Purchase purchase){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        boolean wynik = false;
        if(purchase.getEmployee().getUser().getUsername().equals(username)) {
            wynik = purchaseService.updateOne(purchase);
        }else{
            return new ResponseEntity<String>( "Próba modyfikacji nie swojego zamówienia!", HttpStatus.BAD_REQUEST);
        }
        if(wynik)return new ResponseEntity<String>( "Modyfikacja powiodła się!", HttpStatus.OK);
        else return new ResponseEntity<String>( "Próba modyfikacji statusu wstecz!", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertPurchases(@RequestBody List<Purchase> purchases){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Tea> teaList = purchaseService.insertAll(purchases,username);
        if(teaList.size() == 0)return new ResponseEntity<String>( "Zamówienie poprawnie zrealizowane!", HttpStatus.OK);
        else{
            String wynik = "";
            for(Tea tea : teaList)
            {
                wynik += "Herbata " + tea.getName()
                        + " nie jest dostępna w takiej ilości! (maksymalna ilość wynosi "
                        + tea.getAvailable_quantity() + " )\n";
            }
            return new ResponseEntity<String>( wynik, HttpStatus.BAD_REQUEST);
        }
    }

}

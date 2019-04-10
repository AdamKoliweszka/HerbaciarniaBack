/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Purchase;
import com.herbaciarnia.repository.ZakupRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZakupService{

    @Autowired
    private ZakupRepository repository;

    
    public List<Purchase> findAll() {

        List<Purchase> purchase = (List<Purchase>) repository.findAll();
        
        return purchase;
    }
    public Purchase findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(Purchase purchase) {
        Purchase aktualizowanaPurchase = repository.findOne(purchase.getId_purchase());
        
        repository.save(aktualizowanaPurchase);
    }
    public void insertOne(Purchase purchase) {

        repository.save(purchase);
    }
}

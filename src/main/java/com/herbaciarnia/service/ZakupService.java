/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Zakup;
import com.herbaciarnia.repository.ZakupRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZakupService{

    @Autowired
    private ZakupRepository repository;

    
    public List<Zakup> findAll() {

        List<Zakup> zakup = (List<Zakup>) repository.findAll();
        
        return zakup;
    }
    public Zakup findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(Zakup zakup) {
        Zakup aktualizowanaZakup = repository.findOne(zakup.getId());
        
        repository.save(aktualizowanaZakup);
    }
    public void insertOne(Zakup zakup) {

        repository.save(zakup);
    }
}

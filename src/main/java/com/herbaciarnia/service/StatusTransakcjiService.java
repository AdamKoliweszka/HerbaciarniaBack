/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.StatusTransakcji;
import com.herbaciarnia.repository.StatusTransakcjiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusTransakcjiService{

    @Autowired
    private StatusTransakcjiRepository repository;

    
    public List<StatusTransakcji> findAll() {

        List<StatusTransakcji> statuse = (List<StatusTransakcji>) repository.findAll();
        
        return statuse;
    }
    public StatusTransakcji findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(StatusTransakcji status) {
        StatusTransakcji aktualizowanyGatunek = repository.findOne(status.getId());
        aktualizowanyGatunek.setNazwa(status.getNazwa());
        repository.save(aktualizowanyGatunek);
    }
    public void insertOne(StatusTransakcji status) {

        repository.save(status);
    }
}

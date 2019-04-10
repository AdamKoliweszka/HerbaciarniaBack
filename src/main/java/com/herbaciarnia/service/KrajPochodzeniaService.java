/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.CountryOfOrigin;
import com.herbaciarnia.repository.CountryOfOriginRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KrajPochodzeniaService{

    @Autowired
    private CountryOfOriginRepository repository;

    
    public List<CountryOfOrigin> findAll() {

        List<CountryOfOrigin> kraje = (List<CountryOfOrigin>) repository.findAll();
        
        return kraje;
    }
    public CountryOfOrigin findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(CountryOfOrigin kraj) {
        CountryOfOrigin aktualizowanyKraj = repository.findOne(kraj.getId_country());
        aktualizowanyKraj.setName(kraj.getName());
        repository.save(aktualizowanyKraj);
    }
    public void insertOne(CountryOfOrigin kraj) {
        List<CountryOfOrigin> lk = (List<CountryOfOrigin>)repository.findCountryOfOriginByName(kraj.getName());
        if(lk.size() == 0) {
            repository.save(kraj);
        }
    }
}

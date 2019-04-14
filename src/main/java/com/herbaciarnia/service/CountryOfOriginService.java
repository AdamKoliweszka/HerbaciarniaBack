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
public class CountryOfOriginService {

    @Autowired
    private CountryOfOriginRepository repository;

    
    public List<CountryOfOrigin> findAll() {

        List<CountryOfOrigin> countries = (List<CountryOfOrigin>) repository.findAll();
        
        return countries;
    }
    public CountryOfOrigin findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(CountryOfOrigin country) {
        CountryOfOrigin updatingCountry = repository.findOne(country.getId_country());
        updatingCountry.setName(country.getName());
        repository.save(updatingCountry);
    }
    public void insertOne(CountryOfOrigin country) {
        List<CountryOfOrigin> lc = (List<CountryOfOrigin>)repository.findCountryOfOriginByName(country.getName());
        if(lc.size() == 0) {
            repository.save(country);
        }
    }
}

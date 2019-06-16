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
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public String deleteOne(long id) {
        if(id == 1)return "Kraj niezdefiniowany nie może zostać usunięty!";
        CountryOfOrigin deletingCountry = repository.findOne(id);
        if(deletingCountry != null)
        {
            repository.delete(id);
            return "Kraj pochodzenia został usunięty!";
        }else return "Nie istnieje taki kraj pochodzenia!";
    }
    @Transactional
    public String updateOne(CountryOfOrigin country) {
        if(country.getId_country() == 1)return "Kraj niezdefiniowany nie może ulec modyfikacji!";
        List<CountryOfOrigin> countriesWithNames = (List<CountryOfOrigin>) repository.findCountryOfOriginByName(country.getName());
        if(countriesWithNames.size() > 0)return "Istnieje już kraj o takiej nazwie!";
        CountryOfOrigin updatingSpecies = repository.findOne(country.getId_country());
        if(updatingSpecies != null) {
            updatingSpecies.setName(country.getName());
            repository.save(updatingSpecies);
            return "Kraj pochodzenia został zaktualizowany!";
        }else return "Nie istnieje taki kraj pochodzenia!";
    }
    @Transactional
    public boolean insertOne(CountryOfOrigin country) {
        List<CountryOfOrigin> ls = (List<CountryOfOrigin>)repository.findCountryOfOriginByName(country.getName());
        if(ls.size() == 0) {
            repository.save(country);
            return true;
        }else return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.GatunekHerbaty;
import com.herbaciarnia.bean.KrajPochodzenia;
import com.herbaciarnia.repository.GatunekHerbatyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatunekHerbatyService{

    @Autowired
    private GatunekHerbatyRepository repository;

    
    public List<GatunekHerbaty> findAll() {

        List<GatunekHerbaty> gatunek = (List<GatunekHerbaty>) repository.findAll();
        
        return gatunek;
    }
    public GatunekHerbaty findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(GatunekHerbaty gatunek) {
        GatunekHerbaty aktualizowanyGatunek = repository.findOne(gatunek.getId_gatunku());
        aktualizowanyGatunek.setNazwa_gatunku(gatunek.getNazwa_gatunku());
        repository.save(aktualizowanyGatunek);
    }
    public void insertOne(GatunekHerbaty gatunek) {
        List<GatunekHerbaty> lg = (List<GatunekHerbaty>)repository.findGatunekHerbatyByNazwa(gatunek.getNazwa_gatunku());
        if(lg.size() == 0) {
            repository.save(gatunek);
        }
    }
}

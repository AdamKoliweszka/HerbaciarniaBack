/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.TeaSpecies;
import com.herbaciarnia.repository.GatunekHerbatyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatunekHerbatyService{

    @Autowired
    private GatunekHerbatyRepository repository;

    
    public List<TeaSpecies> findAll() {

        List<TeaSpecies> gatunek = (List<TeaSpecies>) repository.findAll();
        
        return gatunek;
    }
    public TeaSpecies findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(TeaSpecies gatunek) {
        TeaSpecies aktualizowanyGatunek = repository.findOne(gatunek.getId_Species());
        aktualizowanyGatunek.setName(gatunek.getName());
        repository.save(aktualizowanyGatunek);
    }
    public void insertOne(TeaSpecies gatunek) {
        List<TeaSpecies> lg = (List<TeaSpecies>)repository.findGatunekHerbatyByNazwa(gatunek.getName());
        if(lg.size() == 0) {
            repository.save(gatunek);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.TeaSpecies;
import com.herbaciarnia.repository.TeaSpeciesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeaSpeciesService {

    @Autowired
    private TeaSpeciesRepository repository;

    
    public List<TeaSpecies> findAll() {

        List<TeaSpecies> species = (List<TeaSpecies>) repository.findAll();
        
        return species;
    }
    public TeaSpecies findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(TeaSpecies species) {
        TeaSpecies updatingSpecies = repository.findOne(species.getId_species());
        updatingSpecies.setName(species.getName());
        repository.save(updatingSpecies);
    }
    public void insertOne(TeaSpecies species) {
        List<TeaSpecies> ls = (List<TeaSpecies>)repository.findTeaSpeciesByName(species.getName());
        if(ls.size() == 0) {
            repository.save(species);
        }
    }
}

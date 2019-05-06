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
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public String deleteOne(long id) {
        if(id == 1)return "Gatunek niezdefiniowany nie może zostać usunięty!";
         TeaSpecies deletingSpecies = repository.findOne(id);
        if(deletingSpecies != null)
        {
            repository.delete(id);
            return "Gatunek herbaty został usunięty!";
        }else return "Nie istnieje taki gatunek!";

    }

    @Transactional
    public String updateOne(TeaSpecies species) {
        if(species.getId_species() == 1)return "Gatunek niezdefiniowany nie może ulec modyfikacji!";
        List<TeaSpecies> speciesWithNames = (List<TeaSpecies>) repository.findTeaSpeciesByName(species.getName());
        if(speciesWithNames.size() > 0)return "Istnieje już gatunek o takiej nazwie!";
        TeaSpecies updatingSpecies = repository.findOne(species.getId_species());
        if(updatingSpecies != null) {
            updatingSpecies.setName(species.getName());
            repository.save(updatingSpecies);
            return "Gatunek herbaty został zaktualizowany!";
        }else return "Nie istnieje taki gatunek!";
    }

    @Transactional
    public boolean insertOne(TeaSpecies species) {
        List<TeaSpecies> ls = (List<TeaSpecies>)repository.findTeaSpeciesByName(species.getName());
        if(ls.size() == 0) {
            repository.save(species);
            return true;
        }else return false;

    }
}

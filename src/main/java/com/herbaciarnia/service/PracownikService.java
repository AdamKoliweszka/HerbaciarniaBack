/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Pracownik;
import com.herbaciarnia.repository.PracownikRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracownikService{

    @Autowired
    private PracownikRepository repository;

    
    public List<Pracownik> findAll() {

        List<Pracownik> pracownik = (List<Pracownik>) repository.findAll();
        
        return pracownik;
    }
    public Pracownik findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(Pracownik pracownik) {
        Pracownik aktualizowanyPracownik = repository.findOne(pracownik.getId());
        aktualizowanyPracownik.setImie(pracownik.getImie());
        aktualizowanyPracownik.setNazwisko(pracownik.getNazwisko());
        pracownik.setDataZatrudnienia(pracownik.getDataZatrudnienia());
        pracownik.setDataZwolnienia(pracownik.getDataZwolnienia());
        aktualizowanyPracownik.getUzytkownik().setHaslo(pracownik.getUzytkownik().getHaslo());
        repository.save(aktualizowanyPracownik);
    }
    public void insertOne(Pracownik pracownik) {

        repository.save(pracownik);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Dostawca;
import com.herbaciarnia.repository.DostawcaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DostawcaService{

    @Autowired
    private DostawcaRepository repository;

    
    public List<Dostawca> findAll() {

        List<Dostawca> dostawca = (List<Dostawca>) repository.findAll();
        
        return dostawca;
    }
    public Dostawca findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(Dostawca dostawca) {
        Dostawca aktualizowanyDostawca = repository.findOne(dostawca.getId());
        aktualizowanyDostawca.setImie(dostawca.getImie());
        aktualizowanyDostawca.setNazwisko(dostawca.getNazwisko());
        aktualizowanyDostawca.setMiejscowosc(dostawca.getMiejscowosc());
        aktualizowanyDostawca.setNumerKonta(dostawca.getNumerKonta());
        aktualizowanyDostawca.setUlica(dostawca.getUlica());
        repository.save(aktualizowanyDostawca);
    }
    public void insertOne(Dostawca dostawca) {

        repository.save(dostawca);
    }
}

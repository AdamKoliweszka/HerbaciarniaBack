/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Klient;
import com.herbaciarnia.repository.KlientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlientService{

    @Autowired
    private KlientRepository repository;

    
    public List<Klient> findAll() {

        List<Klient> klient = (List<Klient>) repository.findAll();
        
        return klient;
    }
    public Klient findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(Klient klient) {
        Klient aktualizowanyKlient = repository.findOne(klient.getId());
        aktualizowanyKlient.setImie(klient.getImie());
        aktualizowanyKlient.setNazwisko(klient.getNazwisko());
        aktualizowanyKlient.setMiejscowosc(klient.getMiejscowosc());
        aktualizowanyKlient.setDataUsunieciaKonta(klient.getDataUsunieciaKonta());
        aktualizowanyKlient.setUlica(klient.getUlica());
        aktualizowanyKlient.getUzytkownik().setPassword(klient.getUzytkownik().getPassword());
        repository.save(aktualizowanyKlient);
    }
    public void insertOne(Klient klient) {

        repository.save(klient);
    }
}

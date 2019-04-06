/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.KrajPochodzenia;
import com.herbaciarnia.repository.KrajPochodzeniaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KrajPochodzeniaService{

    @Autowired
    private KrajPochodzeniaRepository repository;

    
    public List<KrajPochodzenia> findAll() {

        List<KrajPochodzenia> kraje = (List<KrajPochodzenia>) repository.findAll();
        
        return kraje;
    }
    public KrajPochodzenia findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(KrajPochodzenia kraj) {
        KrajPochodzenia aktualizowanyKraj = repository.findOne(kraj.getId_kraju());
        aktualizowanyKraj.setNazwa_kraju(kraj.getNazwa_kraju());
        repository.save(aktualizowanyKraj);
    }
    public void insertOne(KrajPochodzenia kraj) {
        List<KrajPochodzenia> lk = (List<KrajPochodzenia>)repository.findKrajPochodzeniaByNazwa(kraj.getNazwa_kraju());
        if(lk.size() == 0) {
            repository.save(kraj);
        }
    }
}

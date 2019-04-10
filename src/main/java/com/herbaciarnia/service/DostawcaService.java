/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Provider;
import com.herbaciarnia.repository.ProviderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DostawcaService{

    @Autowired
    private ProviderRepository repository;

    
    public List<Provider> findAll() {

        List<Provider> provider = (List<Provider>) repository.findAll();
        
        return provider;
    }
    public Provider findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(Provider provider) {
        Provider aktualizowanyProvider = repository.findOne(provider.getId_provider());
        aktualizowanyProvider.setName(provider.getName());
        aktualizowanyProvider.setSurname(provider.getSurname());
        aktualizowanyProvider.setCity(provider.getCity());
        aktualizowanyProvider.setAccount_number(provider.getAccount_number());
        aktualizowanyProvider.setStreet(provider.getStreet());
        repository.save(aktualizowanyProvider);
    }
    public void insertOne(Provider provider) {

        repository.save(provider);
    }
}

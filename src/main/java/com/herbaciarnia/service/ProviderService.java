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
public class ProviderService {

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
        Provider updatingProvider = repository.findOne(provider.getId_provider());
        updatingProvider.setName(provider.getName());
        updatingProvider.setSurname(provider.getSurname());
        updatingProvider.setCity(provider.getCity());
        updatingProvider.setAccount_number(provider.getAccount_number());
        updatingProvider.setStreet(provider.getStreet());
        repository.save(updatingProvider);
    }
    public void insertOne(Provider provider) {

        repository.save(provider);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Delivery;
import com.herbaciarnia.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    
    public List<Delivery> findAllByUsername(String username) {

        List<Delivery> delivery = (List<Delivery>) repository.findAllByUsername(username);
        
        return delivery;
    }
    public Delivery findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(Delivery delivery) {
        Delivery updatingDelivery = repository.findOne(delivery.getId_delivery());
        updatingDelivery.setStatus(delivery.getStatus());
        repository.save(updatingDelivery);
    }
    public void insertOne(Delivery Delivery) {

        repository.save(Delivery);
    }
}

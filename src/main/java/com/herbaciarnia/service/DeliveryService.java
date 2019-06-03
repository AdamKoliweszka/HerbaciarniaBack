/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Delivery;
import com.herbaciarnia.bean.Tea;
import com.herbaciarnia.repository.DeliveryRepository;
import com.herbaciarnia.repository.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    @Autowired
    private TeaRepository teaRepository;
    
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
    public boolean updateOne(Delivery delivery) {
        Delivery updatingDelivery = repository.findOne(delivery.getId_delivery());
        if(updatingDelivery.getStatus().getId_status() < delivery.getStatus().getId_status()) {

            updatingDelivery.setStatus(delivery.getStatus());
            repository.save(updatingDelivery);
            return true;
        }
        return false;
    }
    @Transactional
    public void insertOne(Delivery delivery) {

        Tea tea = delivery.getTea();
        tea = teaRepository.findOne(tea.getId_tea());
        tea.setAvailable_quantity(tea.getAvailable_quantity() + delivery.getAmount());
        teaRepository.save(tea);
        repository.save(delivery);
    }
}

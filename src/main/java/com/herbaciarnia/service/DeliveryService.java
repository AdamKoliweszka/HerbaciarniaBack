/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Delivery;
import com.herbaciarnia.bean.Employee;
import com.herbaciarnia.bean.Tea;
import com.herbaciarnia.bean.TransactionStatus;
import com.herbaciarnia.repository.DeliveryRepository;
import com.herbaciarnia.repository.EmployeeRepository;
import com.herbaciarnia.repository.TeaRepository;
import com.herbaciarnia.repository.TransactionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    @Autowired
    private TeaRepository teaRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TransactionStatusRepository statusRepository;
    
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
    public void insertOne(Delivery delivery,String username) {

        Tea tea = delivery.getTea();
        tea = teaRepository.findOne(tea.getId_tea());
        tea.setAvailable_quantity(tea.getAvailable_quantity() + delivery.getAmount());
        teaRepository.save(tea);
        delivery.setDate_of_delivery(new Date());
        TransactionStatus status = statusRepository.findOne((long) 1);
        delivery.setStatus(status);
        Employee employee = employeeRepository.findOneByUsername(username);
        delivery.setEmployee(employee);
        repository.save(delivery);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.*;
import com.herbaciarnia.repository.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository repository;

    @Autowired
    private TeaRepository teaRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TransactionStatusRepository transactionStatusRepository;


    public List<Purchase> findAllByUsername(String username) {

        List<Purchase> purchase = (List<Purchase>) repository.findAllByUsername(username);
        
        return purchase;
    }
    public Purchase findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public boolean updateOne(Purchase purchase) {
        Purchase updatingPurchase = repository.findOne(purchase.getId_purchase());
        if(updatingPurchase.getStatus().getId_status() < purchase.getStatus().getId_status()) {
            updatingPurchase.setStatus(purchase.getStatus());
            repository.save(updatingPurchase);
            return true;
        }
        return false;
    }
    public void insertOne(Purchase purchase) {

        repository.save(purchase);
    }

    @Transactional
    public List<Tea> insertAll(List<Purchase> purchases, String username) {
        List<Tea> unavaibleTea = new ArrayList<Tea>();
        Customer customer = customerRepository.findOneByUsername(username);
        List<Employee> le = employeeRepository.findAllEnable();
        Random random = new Random();
        Employee employee = le.get(random.nextInt(le.size()));
        Date date = new Date();
        TransactionStatus status = transactionStatusRepository.findOne((long)1);
        for(Purchase purchase : purchases)
        {
            Tea tea = purchase.getTea();
            tea = teaRepository.findOne(tea.getId_tea());
            if(purchase.getAmount() > tea.getAvailable_quantity())
            {
                unavaibleTea.add(tea);
            }
        }
        if(unavaibleTea.size() == 0) {
            for (Purchase purchase : purchases) {

                Tea tea = purchase.getTea();
                tea = teaRepository.findOne(tea.getId_tea());
                tea.setAvailable_quantity(tea.getAvailable_quantity() - purchase.getAmount());
                teaRepository.save(tea);

                purchase.setStatus(status);
                purchase.setDate_of_purchases(date);
                purchase.setCustomer(customer);
                purchase.setEmployee(employee);
                repository.save(purchase);
            }
        }
        return unavaibleTea;
    }
}

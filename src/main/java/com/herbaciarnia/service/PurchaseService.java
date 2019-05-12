/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Customer;
import com.herbaciarnia.bean.Employee;
import com.herbaciarnia.bean.Purchase;
import com.herbaciarnia.bean.TransactionStatus;
import com.herbaciarnia.repository.CustomerRepository;
import com.herbaciarnia.repository.EmployeeRepository;
import com.herbaciarnia.repository.PurchaseRepository;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.herbaciarnia.repository.TransactionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository repository;

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
    public void updateOne(Purchase purchase) {
        Purchase updatingPurchase = repository.findOne(purchase.getId_purchase());
        updatingPurchase.setStatus(purchase.getStatus());
        repository.save(updatingPurchase);
    }
    public void insertOne(Purchase purchase) {

        repository.save(purchase);
    }

    @Transactional
    public void insertAll(List<Purchase> purchases,String username) {
        Customer customer = customerRepository.findOneByUsername(username);
        List<Employee> le = employeeRepository.findAllEnable();
        Random random = new Random();
        Employee employee = le.get(random.nextInt(le.size()));
        Date date = new Date();
        TransactionStatus status = transactionStatusRepository.findOne((long)1);
        for(Purchase purchase : purchases)
        {
            purchase.setStatus(status);
            purchase.setDate_of_purchases(date);
            purchase.setCustomer(customer);
            purchase.setEmployee(employee);
            repository.save(purchase);
        }

    }
}

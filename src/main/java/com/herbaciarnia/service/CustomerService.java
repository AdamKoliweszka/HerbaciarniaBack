/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Customer;
import com.herbaciarnia.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    
    public List<Customer> findAll() {

        List<Customer> customer = (List<Customer>) repository.findAll();
        
        return customer;
    }
    public Customer findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(Customer customer) {
        Customer updatingCustomer = repository.findOne(customer.getId_customer());
        updatingCustomer.setName(customer.getName());
        updatingCustomer.setSurname(customer.getSurname());
        updatingCustomer.setCity(customer.getCity());
        updatingCustomer.setDate_of_delete_account(customer.getDate_of_delete_account());
        updatingCustomer.setStreet(customer.getStreet());
        updatingCustomer.getUser().setPassword(customer.getUser().getPassword());
        repository.save(updatingCustomer);
    }
    public void insertOne(Customer customer) {

        repository.save(customer);
    }
}

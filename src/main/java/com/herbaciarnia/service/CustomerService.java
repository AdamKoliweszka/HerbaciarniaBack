/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Authority;
import com.herbaciarnia.bean.Customer;
import com.herbaciarnia.bean.User;
import com.herbaciarnia.repository.AuthorityRepository;
import com.herbaciarnia.repository.CustomerRepository;
import java.util.List;

import com.herbaciarnia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;
    
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
    @Transactional
    public void insertOne(Customer customer) {
        User user = customer.getUser();
        if(user.getPassword() == null || user.getPassword().equals(""))throw new IllegalArgumentException("Brak hasła!");
        if(userRepository.findOne(user.getUsername()) == null) {
            user.setEnabled(true);
            userRepository.save(user);
            Authority authority = new Authority();
            authority.setAuthority("KLIENT");
            authority.setUser(user);
            authorityRepository.save(authority);
            repository.save(customer);
        }else{
            throw new IllegalArgumentException("Użytkownik o takiej nazwie istnieje!");
        }
    }
}

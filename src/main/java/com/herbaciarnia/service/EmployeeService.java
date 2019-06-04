/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Authority;
import com.herbaciarnia.bean.Employee;
import com.herbaciarnia.bean.User;
import com.herbaciarnia.repository.AuthorityRepository;
import com.herbaciarnia.repository.EmployeeRepository;
import java.util.List;

import com.herbaciarnia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Employee> findAll() {

        List<Employee> employee = (List<Employee>) repository.findAll();
        
        return employee;
    }
    public Employee findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    @Transactional
    public void updateOne(String username,Employee employee) {
        Employee updatingEmployee = repository.findOneByUsername(username);
        updatingEmployee.setName(employee.getName());
        updatingEmployee.setSurname(employee.getSurname());
        repository.save(updatingEmployee);
    }
    @Transactional
    public boolean insertOne(Employee employee) {
        User user = employee.getUser();
        if(repository.findOneByUsername(user.getUsername()) == null) {
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            Authority authority = new Authority();
            authority.setAuthority("PRACOWNIK");
            authority.setUser(user);
            authorityRepository.save(authority);
            repository.save(employee);
            return true;
        }else{
            return false;
        }
    }
    public Employee findOneByUsername(String username)
    {
        return repository.findOneByUsername(username);
    }
}

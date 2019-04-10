/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Employee;
import com.herbaciarnia.repository.PracownikRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracownikService{

    @Autowired
    private PracownikRepository repository;

    
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
    public void updateOne(Employee employee) {
        Employee aktualizowanyEmployee = repository.findOne(employee.getId_employee());
        aktualizowanyEmployee.setName(employee.getName());
        aktualizowanyEmployee.setSurname(employee.getSurname());
        employee.setDate_of_employment(employee.getDate_of_employment());
        employee.setDate_of_employment(employee.getDate_of_employment());
        aktualizowanyEmployee.getUser().setPassword(employee.getUser().getPassword());
        repository.save(aktualizowanyEmployee);
    }
    public void insertOne(Employee employee) {

        repository.save(employee);
    }
}

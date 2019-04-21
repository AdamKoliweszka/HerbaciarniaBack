/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.Employee;
import com.herbaciarnia.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    
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
        Employee updatingEmployee = repository.findOne(employee.getId_employee());
        updatingEmployee.setName(employee.getName());
        updatingEmployee.setSurname(employee.getSurname());
        employee.setDate_of_employment(employee.getDate_of_employment());
        employee.setDate_of_employment(employee.getDate_of_employment());
        updatingEmployee.getUser().setPassword(employee.getUser().getPassword());
        repository.save(updatingEmployee);
    }
    public void insertOne(Employee employee) {

        repository.save(employee);
    }
    public Employee findOneByUsername(String username)
    {
        return repository.findOneByUsername(username).get(0);
    }
}

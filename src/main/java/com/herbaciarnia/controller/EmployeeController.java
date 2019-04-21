/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.Employee;
import com.herbaciarnia.service.EmployeeService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    
    @RequestMapping(value = "/Pracownicy",method = RequestMethod.GET)
    public Collection<Employee> getAllEmployees(){
        List<Employee> employees = (List<Employee>) employeeService.findAll();
        return employees;
        
    }
    
    @RequestMapping(value = "/Pracownicy/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") long id){
        return employeeService.findOne(id);
    }
    
    @RequestMapping(value = "/Pracownicy/{id}", method = RequestMethod.DELETE)
    public void deleteEmployeeById(@PathVariable("id") long id){
        employeeService.deleteOne(id);
    }
    
    @RequestMapping(value = "/Pracownicy",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEmployeeById(@RequestBody Employee employee){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        employeeService.updateOne(username,employee);
    }

    @RequestMapping(value = "/Pracownicy",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEmployee(@RequestBody Employee employee){
        employeeService.insertOne(employee);
    }

    @RequestMapping(value = "/DanePracownika", method = RequestMethod.GET)
    public Employee getDataOfEmployee(){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return employeeService.findOneByUsername(username);
    }
}

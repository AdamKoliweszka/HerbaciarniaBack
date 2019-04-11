/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.TransactionStatus;
import com.herbaciarnia.service.TransactionStatusService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping("/StatusyTransakcji")
public class StatusTransakcjiController {
    @Autowired
    TransactionStatusService statusService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<TransactionStatus> getAllGatunki(){
        List<TransactionStatus> gatunki = (List<TransactionStatus>) statusService.findAll();
        return gatunki;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TransactionStatus getStatusById(@PathVariable("id") long id){
        return statusService.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStatusById(@PathVariable("id") long id){
        statusService.deleteOne(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStatusById(@RequestBody TransactionStatus status){
        statusService.updateOne(status);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStatus(@RequestBody TransactionStatus status){
        statusService.insertOne(status);
    }

}

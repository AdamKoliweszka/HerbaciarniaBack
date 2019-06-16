/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.TransactionStatus;
import com.herbaciarnia.repository.TransactionStatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionStatusService {

    @Autowired
    private TransactionStatusRepository repository;

    
    public List<TransactionStatus> findAll() {

        List<TransactionStatus> statuses = (List<TransactionStatus>) repository.findAll();
        
        return statuses;
    }
    public TransactionStatus findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(TransactionStatus status) {
        TransactionStatus updatingStatus = repository.findOne(status.getId_status());
        updatingStatus.setName(status.getName());
        repository.save(updatingStatus);
    }
    public void insertOne(TransactionStatus status) {

        repository.save(status);
    }
}

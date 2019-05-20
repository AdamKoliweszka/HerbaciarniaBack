/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.repository;

import com.herbaciarnia.bean.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

    @Query("SELECT p FROM Purchase p WHERE p.employee.user.username = :#{#username } or p.customer.user.username = :#{#username }")
    Iterable<Purchase> findAllByUsername(@Param("username") String username);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.repository;

import com.herbaciarnia.bean.Zakup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZakupRepository extends CrudRepository<Zakup, Long> {

    
    
}

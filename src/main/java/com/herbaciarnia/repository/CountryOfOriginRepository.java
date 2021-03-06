/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.repository;

import com.herbaciarnia.bean.CountryOfOrigin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryOfOriginRepository extends CrudRepository<CountryOfOrigin, Long> {

    @Query("SELECT k FROM CountryOfOrigin k WHERE k.name = :#{#name}")
    Iterable<CountryOfOrigin> findCountryOfOriginByName(@Param("name") String name);

    
}

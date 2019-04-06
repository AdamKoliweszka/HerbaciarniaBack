/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.repository;

import com.herbaciarnia.bean.GatunekHerbaty;
import com.herbaciarnia.bean.KrajPochodzenia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GatunekHerbatyRepository extends CrudRepository<GatunekHerbaty, Long> {
    
    @Query("SELECT g FROM GatunekHerbaty g WHERE g.nazwa_gatunku = :#{#nazwa_gatunku }")
    Iterable<GatunekHerbaty> findGatunekHerbatyByNazwa(@Param("nazwa_gatunku") String nazwa_gatunku);



}

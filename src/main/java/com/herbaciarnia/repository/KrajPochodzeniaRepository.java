/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.repository;

import com.herbaciarnia.bean.KrajPochodzenia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KrajPochodzeniaRepository extends CrudRepository<KrajPochodzenia, Long> {

    @Query("SELECT k FROM KrajPochodzenia k WHERE k.nazwa_kraju = :#{#nazwa_kraju }")
    Iterable<KrajPochodzenia> findKrajPochodzeniaByNazwa(@Param("nazwa_kraju") String nazwa_kraju);

    
}

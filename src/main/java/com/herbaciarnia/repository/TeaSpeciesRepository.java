/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.repository;

import com.herbaciarnia.bean.TeaSpecies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaSpeciesRepository extends CrudRepository<TeaSpecies, Long> {
    
    @Query("SELECT g FROM TeaSpecies g WHERE g.name = :#{#name }")
    Iterable<TeaSpecies> findTeaSpeciesByName(@Param("name") String name);



}

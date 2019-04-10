/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.repository;

import com.herbaciarnia.bean.ArgumentWyszukiwaniaHerbaty;
import com.herbaciarnia.bean.Tea;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HerbataRepository extends CrudRepository<Tea, Long> {
    
    @Query("SELECT h FROM Tea h WHERE h.available_quantity > 0")
    Iterable<Tea> findDostepneHerbaty();
    
    @Query("SELECT h FROM Tea h WHERE h.available_quantity > 0 "
            + " AND h.price_of_selling >= :#{#argument.cenaOd} AND h.price_of_selling <= :#{#argument.cenaDo} "
            + " AND h.tea_species IN :#{#argument.gatunki } "
            + " AND h.country_of_origin IN :#{#argument.kraje } ")
    Iterable<Tea> findDostepneHerbatyByArgument(@Param("argument") ArgumentWyszukiwaniaHerbaty argument);

    @Query("SELECT h FROM Tea h WHERE"
            + " h.price_of_selling >= :#{#argument.cenaOd} AND h.price_of_selling <= :#{#argument.cenaDo} "
            + " AND h.tea_species IN :#{#argument.gatunki } "
            + " AND h.country_of_origin IN :#{#argument.kraje } ")
    Iterable<Tea> findWszystkieHerbatyByArgument(@Param("argument") ArgumentWyszukiwaniaHerbaty argument);

    @Query("SELECT h FROM Tea h WHERE h.available_quantity = 0 "
            + " AND h.price_of_selling >= :#{#argument.cenaOd} AND h.price_of_selling <= :#{#argument.cenaDo} "
            + " AND h.tea_species IN :#{#argument.gatunki } "
            + " AND h.country_of_origin IN :#{#argument.kraje } ")
    Iterable<Tea> findNiedostepneHerbatyByArgument(@Param("argument") ArgumentWyszukiwaniaHerbaty argument);
    
}

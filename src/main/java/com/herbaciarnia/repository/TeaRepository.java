/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.repository;

import com.herbaciarnia.bean.ArgumentOfFilteringTeaForEmployee;
import com.herbaciarnia.bean.ArgumentOfFilteringTea;
import com.herbaciarnia.bean.Tea;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaRepository extends CrudRepository<Tea, Long> {
    
    @Query("SELECT h FROM Tea h WHERE h.available_quantity > 0")
    Iterable<Tea> findAvaibleTea();
    
    @Query("SELECT h FROM Tea h WHERE h.available_quantity > 0 "
            + " AND h.price_of_selling >= :#{#argument.priceFor} AND h.price_of_selling <= :#{#argument.priceTo} "
            + " AND h.tea_species IN :#{#argument.species } "
            + " AND h.country_of_origin IN :#{#argument.countries } ")
    Iterable<Tea> findAvaibleTeaByArgument(@Param("argument") ArgumentOfFilteringTea argument);

    @Query("SELECT h FROM Tea h WHERE"
            + " h.price_of_selling >= :#{#argument.priceFor} AND h.price_of_selling <= :#{#argument.priceTo} "
            + " AND h.tea_species IN :#{#argument.species } "
            + " AND h.country_of_origin IN :#{#argument.countries } ")
    Iterable<Tea> findAllTeaByArgument(@Param("argument") ArgumentOfFilteringTea argument);

    @Query("SELECT h FROM Tea h WHERE h.available_quantity = 0 "
            + " AND h.price_of_selling >= :#{#argument.priceFor} AND h.price_of_selling <= :#{#argument.priceTo} "
            + " AND h.tea_species IN :#{#argument.species } "
            + " AND h.country_of_origin IN :#{#argument.countries } ")
    Iterable<Tea> findUnavaibleTeaByArgument(@Param("argument") ArgumentOfFilteringTea argument);

    @Query("SELECT t FROM Tea t WHERE t.name = :#{#name }")
    Iterable<Tea> findTeaByName(@Param("name") String name);

}

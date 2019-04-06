/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.repository;

import com.herbaciarnia.bean.ArgumentWyszukiwaniaHerbaty;
import com.herbaciarnia.bean.Herbata;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HerbataRepository extends CrudRepository<Herbata, Long> {
    
    @Query("SELECT h FROM Herbata h WHERE h.iloscDostepna > 0")
    Iterable<Herbata> findDostepneHerbaty();
    
    @Query("SELECT h FROM Herbata h WHERE h.iloscDostepna > 0 "
            + " AND h.cenaSprzedazy >= :#{#argument.cenaOd} AND h.cenaSprzedazy <= :#{#argument.cenaDo} " 
            + " AND h.gatunekHerbaty IN :#{#argument.gatunki } "
            + " AND h.krajPochodzenia IN :#{#argument.kraje } ")
    Iterable<Herbata> findDostepneHerbatyByArgument( @Param("argument") ArgumentWyszukiwaniaHerbaty argument);

    @Query("SELECT h FROM Herbata h WHERE"
            + " h.cenaSprzedazy >= :#{#argument.cenaOd} AND h.cenaSprzedazy <= :#{#argument.cenaDo} "
            + " AND h.gatunekHerbaty IN :#{#argument.gatunki } "
            + " AND h.krajPochodzenia IN :#{#argument.kraje } ")
    Iterable<Herbata> findWszystkieHerbatyByArgument( @Param("argument") ArgumentWyszukiwaniaHerbaty argument);

    @Query("SELECT h FROM Herbata h WHERE h.iloscDostepna = 0 "
            + " AND h.cenaSprzedazy >= :#{#argument.cenaOd} AND h.cenaSprzedazy <= :#{#argument.cenaDo} "
            + " AND h.gatunekHerbaty IN :#{#argument.gatunki } "
            + " AND h.krajPochodzenia IN :#{#argument.kraje } ")
    Iterable<Herbata> findNiedostepneHerbatyByArgument( @Param("argument") ArgumentWyszukiwaniaHerbaty argument);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.ArgumentWyszukiwaniaHerbaty;
import com.herbaciarnia.bean.Herbata;
import com.herbaciarnia.repository.HerbataRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HerbataService{

    @Autowired
    private HerbataRepository repository;

    public List<Herbata> findAllDostepne()
    {
        List<Herbata> herbata = (List<Herbata>) repository.findDostepneHerbaty();
        return herbata;
    }
    public List<Herbata> findAllDostepneByArgument(ArgumentWyszukiwaniaHerbaty argument)
    {
        List<Herbata> herbata = (List<Herbata>) repository.findDostepneHerbatyByArgument(argument);
        return herbata;
    }
    public List<Herbata> findAllWszystkieByArgument(ArgumentWyszukiwaniaHerbaty argument)
    {
        List<Herbata> herbaty = null;
        if(argument.isCzyDostepne() && !argument.isCzyNiedostepne())
        {
            herbaty = (List<Herbata>) repository.findDostepneHerbatyByArgument(argument);
        }else if(!argument.isCzyDostepne() && argument.isCzyNiedostepne())
        {
            herbaty = (List<Herbata>) repository.findNiedostepneHerbatyByArgument(argument);
        }else{
            herbaty = (List<Herbata>) repository.findWszystkieHerbatyByArgument(argument);
        }
        return herbaty;
    }
    public List<Herbata> findAll() {

        List<Herbata> herbata = (List<Herbata>) repository.findAll();
        return herbata;
    }
    public Herbata findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(Herbata herbata) {
        Herbata aktualizowanaHerbata = repository.findOne(herbata.getId_herbaty());
        aktualizowanaHerbata.setNazwa_herbaty(herbata.getNazwa_herbaty());
        aktualizowanaHerbata.setCenaDostawy(herbata.getCenaDostawy());
        aktualizowanaHerbata.setCenaSprzedazy(herbata.getCenaSprzedazy());
        aktualizowanaHerbata.setGatunekHerbaty(herbata.getGatunekHerbaty());
        aktualizowanaHerbata.setIloscDostepna(herbata.getIloscDostepna());
        aktualizowanaHerbata.setKrajPochodzenia(herbata.getKrajPochodzenia());
        aktualizowanaHerbata.setOpis(herbata.getOpis());
        repository.save(aktualizowanaHerbata);
    }
    public void insertOne(Herbata herbata) {

        repository.save(herbata);
    }
}

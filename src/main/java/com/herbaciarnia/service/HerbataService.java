/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.ArgumentWyszukiwaniaHerbaty;
import com.herbaciarnia.bean.Tea;
import com.herbaciarnia.repository.TeaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HerbataService{

    @Autowired
    private TeaRepository repository;

    public List<Tea> findAllDostepne()
    {
        List<Tea> tea = (List<Tea>) repository.findAvaibleTea();
        return tea;
    }
    public List<Tea> findAllDostepneByArgument(ArgumentWyszukiwaniaHerbaty argument)
    {
        List<Tea> tea = (List<Tea>) repository.findAvaibleTeaByArgument(argument);
        return tea;
    }
    public List<Tea> findAllWszystkieByArgument(ArgumentWyszukiwaniaHerbaty argument)
    {
        List<Tea> herbaty = null;
        if(argument.isCzyDostepne() && !argument.isCzyNiedostepne())
        {
            herbaty = (List<Tea>) repository.findAvaibleTeaByArgument(argument);
        }else if(!argument.isCzyDostepne() && argument.isCzyNiedostepne())
        {
            herbaty = (List<Tea>) repository.findUnavaibleTeaByArgument(argument);
        }else{
            herbaty = (List<Tea>) repository.findAllTeaByArgument(argument);
        }
        return herbaty;
    }
    public List<Tea> findAll() {

        List<Tea> tea = (List<Tea>) repository.findAll();
        return tea;
    }
    public Tea findOne(long id) {

        return repository.findOne(id);
    }
    public void deleteOne(long id) {

        repository.delete(id);
    }
    public void updateOne(Tea tea) {
        Tea aktualizowanaTea = repository.findOne(tea.getId_tea());
        aktualizowanaTea.setName(tea.getName());
        aktualizowanaTea.setPrice_of_delivery(tea.getPrice_of_delivery());
        aktualizowanaTea.setPrice_of_selling(tea.getPrice_of_selling());
        aktualizowanaTea.setTea_species(tea.getTea_species());
        aktualizowanaTea.setAvailable_quantity(tea.getAvailable_quantity());
        aktualizowanaTea.setCountry_of_origin(tea.getCountry_of_origin());
        aktualizowanaTea.setDescription(tea.getDescription());
        repository.save(aktualizowanaTea);
    }
    public void insertOne(Tea tea) {

        repository.save(tea);
    }
}

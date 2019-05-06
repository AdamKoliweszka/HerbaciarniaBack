/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.ArgumentOfFilteringTea;
import com.herbaciarnia.bean.Tea;
import com.herbaciarnia.repository.TeaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeaService {

    @Autowired
    private TeaRepository repository;

    public List<Tea> findAllAvaible()
    {
        List<Tea> tea = (List<Tea>) repository.findAvaibleTea();
        return tea;
    }
    public List<Tea> findAllAvaibleByArgument(ArgumentOfFilteringTea argument)
    {
        List<Tea> tea = (List<Tea>) repository.findAvaibleTeaByArgument(argument);
        return tea;
    }
    public List<Tea> findAllByArgument(ArgumentOfFilteringTea argument)
    {
        List<Tea> tea = null;
        if(argument.isAvaible() && !argument.isUnavaible())
        {
            tea = (List<Tea>) repository.findAvaibleTeaByArgument(argument);
        }else if(!argument.isAvaible() && argument.isUnavaible())
        {
            tea = (List<Tea>) repository.findUnavaibleTeaByArgument(argument);
        }else{
            tea = (List<Tea>) repository.findAllTeaByArgument(argument);
        }
        return tea;
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
    public String updateOne(Tea tea) {
        List<Tea> speciesWithNames = (List<Tea>) repository.findTeaByName(tea.getName());
        if(speciesWithNames.size() > 0)return "Istnieje już herbata o takiej nazwie!";
        Tea updatingTea = repository.findOne(tea.getId_tea());
        if(updatingTea != null) {
        updatingTea.setName(tea.getName());
        updatingTea.setPrice_of_delivery(tea.getPrice_of_delivery());
        updatingTea.setPrice_of_selling(tea.getPrice_of_selling());
        updatingTea.setTea_species(tea.getTea_species());
        updatingTea.setAvailable_quantity(tea.getAvailable_quantity());
        updatingTea.setCountry_of_origin(tea.getCountry_of_origin());
        updatingTea.setDescription(tea.getDescription());
        repository.save(updatingTea);
            return "Herbata została zaktualizowana!";
        }else return "Nie istnieje taka herbata!";
    }

    @Transactional
    public boolean insertOne(Tea tea) {

        List<Tea> ls = (List<Tea>)repository.findTeaByName(tea.getName());
        if(ls.size() == 0) {
            repository.save(tea);
            return true;
        }else return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.service;

import com.herbaciarnia.bean.ArgumentOfFilteringTeaForEmployee;
import com.herbaciarnia.bean.ArgumentOfFilteringTea;
import com.herbaciarnia.bean.Tea;
import com.herbaciarnia.repository.TeaRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
    public List<Tea> findAllByArgument(ArgumentOfFilteringTeaForEmployee argument)
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
        if(speciesWithNames.size() > 0 && speciesWithNames.get(0).getId_tea() !=  tea.getId_tea())return "Istnieje już herbata o takiej nazwie!";
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
    public Integer insertOne(Tea tea) {

        List<Tea> ls = (List<Tea>)repository.findTeaByName(tea.getName());
        if(ls.size() == 0) {
            repository.save(tea);
            List<Tea> teaList = (List<Tea>) repository.findAll();
            return teaList.size();
        }else return 0;
    }

    public void setImage(long id,MultipartFile file) throws IOException {
        String directoryName = "./files";
        Path path = Paths.get(directoryName);
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
        File newFile = File.createTempFile("tsp_",".txt",new File(directoryName ));
        FileOutputStream fileOutputStream = new FileOutputStream(newFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        String newPath = newFile.getAbsolutePath();
        byte[] bytesOfFile =Files.readAllBytes(Paths.get(newPath));
        Tea tea = repository.findOne(id);
        if(tea != null) {
            tea.setImage(bytesOfFile);
            repository.save(tea);
        }
    }
}

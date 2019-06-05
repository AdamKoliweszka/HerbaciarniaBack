/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herbaciarnia.controller;

import com.herbaciarnia.bean.ArgumentOfFilteringTea;
import com.herbaciarnia.bean.ArgumentOfFilteringTeaForEmployee;
import com.herbaciarnia.bean.Tea;
import com.herbaciarnia.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
@RestController
@RequestMapping(value = "/Plik")
public class FileController {
    @Autowired
    TeaService teaService;



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity insertFile(@PathVariable("id") long id, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Jestem");
        teaService.setImage(id,file);
        return new ResponseEntity("Wysyłanie pliku powiodło się!", HttpStatus.OK);
    }
}

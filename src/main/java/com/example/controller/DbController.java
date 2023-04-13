package com.example.controller;

import com.example.entities.Persons;
import com.example.repository.DbRepository;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DbController {

    Logger logger = LoggerFactory.getLogger(DbController.class);
    @Autowired
    private PersonService service;

    public DbController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/publish")
    public List<Persons> getData() {
        List<Persons> data = service.getAllPersons();
        if (data.size() == 0) {
            logger.info("No data");
            return null;
        } else {
            return data;
        }


    }

    @PostMapping("/post")
    public void saveData(@RequestBody Persons data) {
        try {
            service.add(data);
            logger.info("Data added successfully");
        } catch (Exception e) {
            logger.info("Wrong->", e.getMessage());
        }

    }

}

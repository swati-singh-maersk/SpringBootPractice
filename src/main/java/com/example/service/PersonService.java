package com.example.service;

import com.example.entities.Persons;
import com.example.repository.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private DbRepository repo;

    public  void add(Persons data){
        repo.save(data);
    }

    public List<Persons> getAllPersons(){
        List<Persons> data = new ArrayList<>();
        repo.findAll().forEach(data::add);
        return  data;

    }
}

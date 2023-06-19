package com.entregaTP3.service;

import com.entregaTP3.model.Courses;
import com.entregaTP3.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {


    @Autowired
    private CoursesRepository repository;

    public Courses newRegister(Courses c){return repository.save(c);};

    public List<Courses> getCurses(){return repository.findAll();}
}

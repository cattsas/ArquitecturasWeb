package com.entregaTP3.controller;


import com.entregaTP3.model.Courses;
import com.entregaTP3.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoursesController {

    @Qualifier("coursesService")
    @Autowired
    private final CoursesService service;

    public CoursesController(@Qualifier("coursesService") CoursesService service) {
        super();
        this.service = service;
    }

    //Registra un estudiante en una carrera determinada
    @PostMapping("/register")
    public Courses newRegister(@RequestBody Courses c){return service.newRegister(c);}

    @GetMapping("/courses")
    public Iterable<Courses> getCurses() {return service.getCurses();}

}

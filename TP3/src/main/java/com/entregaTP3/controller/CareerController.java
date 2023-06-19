package com.entregaTP3.controller;

import com.entregaTP3.DTO.DTOCareer;
import com.entregaTP3.DTO.DTOListEnrolledGraduated;
import com.entregaTP3.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CareerController {

    @Qualifier("careerService")
    @Autowired
    private CareerService service;
    public CareerController(@Qualifier("careerService") CareerService service) {
        super();
        this.service = service;
    }
    //Obtiene el listado de carreras con estudiantes inscriptos ordenados por cantidad de estudiantes
    @GetMapping("/careers")
    List<DTOCareer> careerWithEntries() {return service.careerWithEntries(); }

    //genera un reporte de las carreras, que para cada carrera incluya información de los
    //inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y
    //presentar los años de manera cronológica
    @GetMapping("/careerReport")
    List<DTOListEnrolledGraduated> careerReport() {return service.careerReport(); }

}

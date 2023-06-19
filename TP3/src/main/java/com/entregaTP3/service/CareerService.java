package com.entregaTP3.service;

import com.entregaTP3.DTO.DTOCareer;
import com.entregaTP3.DTO.DTOListEnrolledGraduated;
import com.entregaTP3.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {

    @Autowired
    private CareerRepository careerRepository;

    public List<DTOCareer> careerWithEntries() {
        return careerRepository.careerWithEntries();
    }

    public List<DTOListEnrolledGraduated> careerReport() {
        List<DTOListEnrolledGraduated> dtoEnrolled =  careerRepository.careerReportEnrolled();
        List<DTOListEnrolledGraduated> dtoGraduated = careerRepository.careerReportGraduated();


        for(DTOListEnrolledGraduated list1 : dtoEnrolled){
            for(DTOListEnrolledGraduated list2 : dtoGraduated){
                if((list1.getCollegeNotebook()==list2.getCollegeNotebook())&&(list1.getYear()==list2.getYear())) {
                    list1.setQuantityGraduated(list2.getQuantityGraduated());
                }
            }
        }


        for(DTOListEnrolledGraduated list2 : dtoGraduated){
            if(!dtoEnrolled.contains(list2)) {
                dtoEnrolled.add(list2);
            }
        }
        return dtoEnrolled;
    }


}

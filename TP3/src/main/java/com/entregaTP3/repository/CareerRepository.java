package com.entregaTP3.repository;


import com.entregaTP3.DTO.DTOCareer;
import com.entregaTP3.DTO.DTOListEnrolledGraduated;
import com.entregaTP3.model.Career;
import com.entregaTP3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {

    @Query("SELECT"+" new com.entregaTP3.DTO.DTOCareer( t.id_career,t.name,COUNT (cu.id_career) ) "+"FROM Career t JOIN Courses cu ON cu.id_career = t.id_career GROUP BY cu.id_career, t.name")
    public abstract List<DTOCareer> careerWithEntries();


    @Query("SELECT"+" new com.entregaTP3.DTO.DTOListEnrolledGraduated( ca.id_career, ca.name, (Year(cu.inscriptionDate)) ,count(cu.collegeNotebook), SUM(0)) "+"FROM Courses cu JOIN Career ca on cu.id_career = ca.id_career group by cu.id_career, Year(cu.inscriptionDate)")
    List<DTOListEnrolledGraduated> careerReportEnrolled();

    @Query("SELECT"+" new com.entregaTP3.DTO.DTOListEnrolledGraduated( ca.id_career, ca.name, Year(cu.graduationDate), SUM(0), count(cu.collegeNotebook)  ) "+"FROM Courses cu JOIN Career ca on cu.collegeNotebook = ca.id_career WHERE cu.graduationDate IS NOT NULL group by cu.id_career, Year(cu.graduationDate)")
    List<DTOListEnrolledGraduated> careerReportGraduated();
}

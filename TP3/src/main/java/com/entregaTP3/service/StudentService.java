package com.entregaTP3.service;


import com.entregaTP3.DTO.DTOStudentsWithCity;
import com.entregaTP3.model.Student;
import com.entregaTP3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository repository;


    public StudentService(@Qualifier("studentRepository") StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents(){
        return repository.findAll();
    }
    public List<Student> getStudents(String order){
        return repository.findAll(Sort.by(Sort.Direction.ASC, order));
    }

    public Student newStudent (Student p){

        return repository.save(p);
    }

    public Optional<Student> studentById(Integer id) {
        return repository.findById(id);
    }


    public Student updateStudent(Student studentUpdated, Integer id) {
    // no es necesario el put
        Student student = repository.getById(id);
        student.setDni(studentUpdated.getDni());
        student.setName(studentUpdated.getName());
        student.setSurname(studentUpdated.getSurname());
        student.setCity(studentUpdated.getCity());
        student.setGender(studentUpdated.getGender());
        student.setBornDate(studentUpdated.getBornDate());
        return repository.save(student);
    }

    public List<Student> studentByGender(char gender) {
        return repository.getStudentsByGender(gender);
    }


    public List<DTOStudentsWithCity> studentByCareerCity(String withCareer, String city) {return repository.studentByCareerCity(withCareer, city); }
}

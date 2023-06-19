package com.entregaTP3.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.entregaTP3.DTO.DTOStudentsWithCity;
import com.entregaTP3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.entregaTP3.model.Student;



@RestController
public class StudentController {
	
	@Qualifier("studentService")
	@Autowired
	private final StudentService service;

	public StudentController(@Qualifier("studentService") StudentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/students")
	public Iterable<Student> getStudent(@RequestParam(required = false) String order) {
		if (order != null) {
			return service.getStudents(order);
		}
		return service.getStudents();
	}
	
	//@GetMapping("/studentBySurname/{surname}")
	//public Iterable<Student> getStudentBySurname(@PathVariable String surname) {return service.findAllBySurname(surname);}
	
	//@GetMapping("/studentByName/{name}")
	//public Iterable<Student> getStudentByName(@PathVariable String name) {return service.findAllByName(name);}

	/**
	 * Create a new Student
	 * @param p data of new Student
	 * @return Return a boolean answer
	 */
	//Registra un estudiante
	@PostMapping("/students")
	public Student newStudent (@RequestBody Student p) {return service.newStudent(p);}
	//Obtiene estudiantes por numero de libreta
	@GetMapping("/students/{id}")
	Optional <Student> one (@PathVariable Integer id) {return service.studentById(id); }
	
	@PutMapping("/students/{id}")
	Student replaceStudent (@RequestBody Student studentUpdated, @PathVariable Integer id) {return service.updateStudent(studentUpdated,id);}

	//Obtiene estudiantes por genero
	@GetMapping("/students/genero/{gender}")
	List<Student> byGender (@PathVariable char gender) {return service.studentByGender(gender); }

	//Obtiene los estudiantes de una determinada carrera filtrados por ciudad de residencia
	@GetMapping("/students/careerCity/{withCareer}/{city}")
	List<DTOStudentsWithCity> studentByCareerCity (@PathVariable String withCareer, @PathVariable String city) {return service.studentByCareerCity(withCareer,city); }
	

}

package com.entregaTP3.util;


import com.entregaTP3.model.Courses;
import com.entregaTP3.repository.CoursesRepository;
import com.entregaTP3.repository.StudentRepository;
import com.entregaTP3.model.Career;
import com.entregaTP3.model.Student;
import com.entregaTP3.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDataBase(@Qualifier("studentRepository") StudentRepository studentRepository, @Qualifier("careerRepository") CareerRepository careerRepository, @Qualifier("coursesRepository") CoursesRepository courseRepository) {
		return args -> {
			log.info("Preloading"+ studentRepository.save(new Student(1234, "01/01/1985", 'M', "Seba","Perez","Azul")));
			log.info("Preloading"+ studentRepository.save(new Student(5678, "21/11/2000", 'F', "Maria","Gomez","Bahia Blanca")));
			log.info("Preloading"+ careerRepository.save(new Career("tudai",3)));
			log.info("Preloading"+ courseRepository.save(new Courses(1,1,"01/03/2020",null)));

		};
	}

}

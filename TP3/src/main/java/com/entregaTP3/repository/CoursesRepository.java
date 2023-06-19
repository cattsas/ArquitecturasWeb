package com.entregaTP3.repository;

import com.entregaTP3.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository  extends JpaRepository<Courses, Integer> {

}

package com.entregaTP3.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_course;

    @Column
    private int collegeNotebook;

    @Column
    private int id_career;

    @Column
    private Date inscriptionDate;

    @Column
    private Date graduationDate;

    public Courses() {
        //super();
    }

    public Courses(int collegeNotebook, int id_career, String inscriptionDate, String graduationDate) {
        this.collegeNotebook = collegeNotebook;
        this.id_career = id_career;
        this.inscriptionDate = new Date(inscriptionDate);
        if(graduationDate!=null) {
            this.graduationDate = new Date(graduationDate);
        }
    }
}
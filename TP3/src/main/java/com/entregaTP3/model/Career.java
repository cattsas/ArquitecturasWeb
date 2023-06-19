package com.entregaTP3.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_career;

    @Column(name="Nombre_Carrera",nullable=false)
    private String name;
    @Column(name="Duracion",nullable=false)
    private int duration;

    //JPA necesita un constructor vacío para convertir la fila DB en un objeto Java.
    public Career() {
        //super();
    }

    public Career(String name, int duration) {
        //super();
        this.name = name;
        this.duration = duration;
    }

    public int getId_career() {
        return id_career;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Carrera : "+ name + ", duracion : "+ duration;
    }

}
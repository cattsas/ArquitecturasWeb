package com.entregaTP3.DTO;

import java.io.Serializable;

public class DTOStudentsWithCity implements Serializable {

    private int collegeNotebook;
    private String surname;
    private String name;
    private String city;

    public DTOStudentsWithCity(int collegeNotebook, String surname, String name, String city) {
        this.collegeNotebook = collegeNotebook;
        this.surname = surname;
        this.name = name;
        this.city = city;
    }

    public int getCollegeNotebook() {
        return collegeNotebook;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "DTOStudentsWithCity{" +
                "collegeNotebook=" + collegeNotebook +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

package com.entregaTP3.DTO;

import java.io.Serializable;
import java.util.Objects;

public class DTOListEnrolledGraduated implements Serializable {
        private int collegeNotebook;
        private String name;
        private int year;
        private Long quantityEnrolled=(long) 0;
        private Long quantityGraduated=(long) 0;

    public DTOListEnrolledGraduated(int collegeNotebook, String name, int year, Long quantityEnrolled, Long quantityGraduated) {
        this.collegeNotebook = collegeNotebook;
        this.name = name;
        this.year = year;
        this.quantityEnrolled = quantityEnrolled;
        this.quantityGraduated = quantityGraduated;
    }

    public int getCollegeNotebook() {
        return collegeNotebook;
    }

    public void setCollegeNotebook(int collegeNotebook) {
        this.collegeNotebook = collegeNotebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getQuantityEnrolled() {
        return quantityEnrolled;
    }

    public void setQuantityEnrolled(Long quantityEnrolled) {
        this.quantityEnrolled = quantityEnrolled;
    }

    public Long getQuantityGraduated() {
        return quantityGraduated;
    }

    public void setQuantityGraduated(Long quantityGraduated) {
        this.quantityGraduated = quantityGraduated;
    }

    @Override
    public String toString() {
        return "DTOListEnrolledGraduated{" +
                "collegeNotebook=" + collegeNotebook +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", quantityEnrolled=" + quantityEnrolled +
                ", quantityGraduated=" + quantityGraduated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTOListEnrolledGraduated that = (DTOListEnrolledGraduated) o;
        return collegeNotebook == that.collegeNotebook && year == that.year;
    }


}

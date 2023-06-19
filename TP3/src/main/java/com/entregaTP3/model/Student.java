package com.entregaTP3.model;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeNotebook;

	@Column
	private long dni;

	@Column
	private Date bornDate;

	@Column
	private char gender;
	@Column
	private String name;
	@Column
	private String surname;

	@Column
	private String city;


	public Student() {
		
	}

	public Student(long dni, String bornDate, char gender, String name, String surname, String city) {
		this.dni = dni;
		this.bornDate = new Date(bornDate);
		this.gender = gender;
		this.name = name;
		this.surname = surname;
		this.city = city;
	}

	public int getCollegeNotebook() {
		return collegeNotebook;
	}

	public void setCollegeNotebook(int collegeNotebook) {
		this.collegeNotebook = collegeNotebook;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}

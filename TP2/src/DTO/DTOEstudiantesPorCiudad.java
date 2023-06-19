package DTO;

import java.io.Serializable;

public class DTOEstudiantesPorCiudad implements Serializable {

	private int id_estudiante;
	private String apellido;
	private String nombre;
	private String ciudad_residencia;
	
	public DTOEstudiantesPorCiudad(int id_estudiante, String apellido, String nom, String ciudad) {
		
		this.id_estudiante = id_estudiante;
		this.apellido = apellido;
		this.nombre = nom;
		this.ciudad_residencia = ciudad;
	}

	public int getId_estudiante() {
		return id_estudiante;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getCiudadResidencia() {
		return ciudad_residencia;
	}

	@Override
	public String toString() {
		return "DTOEstudiantesPorCiudad [id_estudiante=" + id_estudiante + ", apellido=" + apellido + ", nombre="
				+ nombre + ", ciudad_residencia=" + ciudad_residencia + "]\n";
	}

	
	
	

	
}

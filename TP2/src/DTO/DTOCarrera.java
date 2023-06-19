package DTO;

import java.io.Serializable;

public class DTOCarrera implements Serializable {

	private int id_cursa;
	private String nombre_carrera;
	private long cantidad;
	public DTOCarrera(int id, String nombre_carrera, long cantidad) {
		this.id_cursa = id;
		this.nombre_carrera = nombre_carrera;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id_cursa;
	}

	public long getCantidad() {
		return cantidad;
	}

	public String getNombre_carrera() {
		return nombre_carrera;
	}

	@Override
	public String toString() {
		return "DTOCarrera [nombre_carrera=" + nombre_carrera + ", cantidad=" + cantidad + "]\n";
	}

	
	
}

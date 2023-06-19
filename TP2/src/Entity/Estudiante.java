package Entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Estudiante")
public class Estudiante {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_libreta;
	//@ManyToOne (mappedby ??) / @JoinColumn(name=fk_carrera) ??
	
	@Column(name="Nombres",nullable=false)	
	private String nombres;
	@Column(name="Apellido",nullable=false)
	private String apellido;
	@Column(name="Fecha_Nacimiento",nullable=false)
	private Date fechaNacimiento;
	@Column(name="Genero",nullable=false)
	private String genero;
	@Column(name="Dni",nullable=false)
	private Integer dni;
	@Column(name="Ciudad_Residencia",nullable=false)
	private String ciudadResidencia;
	
	//JPA necesita un constructor vacío para convertir la fila DB en un objeto Java.
	public Estudiante() {
		//super();
	} 
	
	public Estudiante(String nombres, String apellido, Date fechaNacimiento, String genero, Integer dni,String ciudadResidencia) {
		//super();
		this.nombres = nombres;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.dni = dni;
		this.ciudadResidencia = ciudadResidencia;
		
	}

	public int getNum_libreta() {
		return num_libreta;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getfechaNacimiento() {
		return fechaNacimiento;
	}

	public void setfechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
		
	@Override
	public String toString() {
		return "Estudiante : "+ num_libreta + " // " + apellido + ", "+ nombres + ", dni: " + dni + ", ciudad de residencia: " + ciudadResidencia + "\n";  
	}

}

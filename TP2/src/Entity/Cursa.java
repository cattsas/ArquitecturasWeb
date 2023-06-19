package Entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Cursa")
public class Cursa {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cursa;
	/**
	 *@Column(name="num_libreta",nullable=false)
	 *private int num_libreta;
	 *@Column(name="id_carrera",nullable=false)
	 *private int id_carrera; 
	 */
	@Column(name="fechaInscripcion",nullable=false)
	private Date fechaInscripcion;
	@Column(name="fechaGraduacion",nullable=true)
	private Date fechaGraduacion;
	
	@ManyToOne
	private Estudiante estudiante;
	@ManyToOne
	private Carrera carrera;
	
	//JPA necesita un constructor vacío para convertir la fila DB en un objeto Java.
	public Cursa() {
		
	}
	
	public Cursa(Estudiante estudiante, Carrera carrera, Date fechaInscripcion, Date fechaGraduacion) {	
		//super();
		//this.num_libreta = num_libreta;
		//this.id_carrera = id_carrera;
		this.carrera = carrera;
		this.estudiante = estudiante;
		this.fechaInscripcion = fechaInscripcion;
		this.fechaGraduacion = fechaGraduacion;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Date getFechaGraduacion() {
		return this.fechaGraduacion;
	}

	public void setGraduado(Date fechaGraduacion) {
		this.fechaGraduacion = fechaGraduacion;
	}

	public int getId_cursa() {
		return id_cursa;
	}	
	
	public boolean isGraduado() {
		if(this.fechaGraduacion!=null) {
			return true;
		}
		return false;
	}
}

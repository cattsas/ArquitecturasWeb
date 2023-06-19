package repository;

import Entity.Estudiante;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import DTO.DTOEstudiantesPorCiudad;

public class RepoEstudiante extends BaseRepository<Estudiante, Integer> {

	public RepoEstudiante() {
		super(Estudiante.class, Integer.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Estudiante findById(int id) {
//		String jpql= "SELECT a FROM Estudiante a WHERE num_libreta=?1";		
//		Query typedQuery =  em.createQuery(jpql,Estudiante.class);
//		typedQuery.setParameter(1, id);
		// System.out.println(typedQuery.getSingleResult());
		// Estudiante res=(Estudiante) typedQuery.getSingleResult();

		// Date fecha = res.getfechaNacimiento();
		// Estudiante est= new Estudiante(res.getNombres(),res.getApellido(),fecha,
		// res.getGenero(),res.getDni(),res.getCiudadResidencia());

		return (Estudiante) super.findById(id);
		// return (Entity) em.find(Estudiante.class,id);

		// return (Entity) res;
	}

	@Override
	public void create(Estudiante entity) {
		super.create(entity);
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {

		super.delete(id);
	}
	
	public List<Estudiante> getEstudiantes(){
		TypedQuery<Estudiante> typedQuery = super.em.createQuery("SELECT u FROM Estudiante u ORDER BY u.apellido DESC",Estudiante.class);
		return typedQuery.getResultList();
	}
	
	public List<Estudiante> getEstudiantesByGenero(String genero){
		TypedQuery<Estudiante> typedQuery = super.em.createQuery("SELECT u FROM Estudiante u WHERE u.genero =:genero",Estudiante.class);
		typedQuery.setParameter("genero", genero);
		return typedQuery.getResultList();
	}
	
	public List<DTOEstudiantesPorCiudad> getEstudiantesPorCiudadDeResidencia(String carrera_filtro, String ciudad_filtro) {
		String query = "SELECT new DTO.DTOEstudiantesPorCiudad(e.num_libreta, e.apellido, e.nombres,e.ciudadResidencia) FROM Estudiante e JOIN Cursa cu ON e.num_libreta = cu.estudiante.num_libreta JOIN Carrera ca ON cu.carrera.id_carrera= ca.id_carrera WHERE e.ciudadResidencia = :ciudadResidencia AND ca.nombre = :carreraDeterminada";
		TypedQuery<DTOEstudiantesPorCiudad> typedQuery = super.em.createQuery(query, DTOEstudiantesPorCiudad.class);
		typedQuery.setParameter("ciudadResidencia",ciudad_filtro);
		typedQuery.setParameter("carreraDeterminada",carrera_filtro);
		return typedQuery.getResultList();
	}

	/*
	 * * @Override public Entity update(Integer id, Entity entity) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public Object create(Object entity) { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public Object update(int id, Object entity) { // TODO
	 * Auto-generated method stub return null; }
	 */

}

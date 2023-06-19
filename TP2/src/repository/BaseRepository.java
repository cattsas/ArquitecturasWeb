package repository;


import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseRepository<Entity, ID extends Serializable> implements Repository<Entity, ID>{

	protected EntityManager em;
	
	protected Class<Entity> clase;
	
	protected Class<ID> idClass;
	
	
		
	public BaseRepository(Class<Entity> entityClass,Class<ID> idClass) {
		this.em = this.getConection("batamanMySql");
		this.clase=entityClass;
		this.idClass= idClass;
	}
	
	private EntityManager getConection(String tecnologia) {
		
		if(this.em != null) {
			return this.em;
		
		}
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(tecnologia);
		return emf.createEntityManager();
	
	}

	@Override
	public Entity findById(int id) {
		Entity entity = this.em.find(clase, id);
		return entity;
		
	}

	@Override
	public void create(Entity entity) {
		
		this.em.getTransaction().begin();
		this.em.persist(entity);
		this.em.getTransaction().commit();
		//this.em.close();		
	}

	
	@Override
	public void delete(int id) {
		
			Entity entity= this.em.find(clase, id);
			this.em.getTransaction().begin();
			this.em.remove(entity);
			this.em.getTransaction().commit();
			this.em.close();
	}
	
		
		
}

	

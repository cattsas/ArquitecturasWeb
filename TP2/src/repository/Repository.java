package repository;

import java.io.Serializable;

import javax.persistence.Entity;

public interface Repository <Entity , ID extends Serializable> {

	public Entity findById(int id);
	
	public void create(Entity entity);
	
	public void delete(int id);
	
	//public Entity update(Integer id, Entity entity);
	
	
}

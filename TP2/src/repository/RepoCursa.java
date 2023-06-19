package repository;

import Entity.Cursa;
import Entity.Estudiante;

public class RepoCursa extends BaseRepository<Cursa, Integer> {

	public RepoCursa() {
		super(Cursa.class, Integer.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cursa findById(int id) {
		return (Cursa) super.findById(id);
	}

	@Override
	public void create(Cursa entity) {
		super.create(entity);
	}

	@Override
	public void delete(int id) {

		super.delete(id);
	}

}

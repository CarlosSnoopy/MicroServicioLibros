package org.jrotero.models;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
//CrudRepository es una interfaz de JPA que te da las operaciones CRUD
public interface ILibrosRepository extends CrudRepository<LibroEntity, Integer>{
	
	Optional<?>findByNombre(String nombre);
	
	@Query("select nombre from LibroEntity l where l.nombre = ?1")
	List<?>findByNombreSelect(String nombre);
}

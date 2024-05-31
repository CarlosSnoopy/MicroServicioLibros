package org.jrotero.service.libro;

import java.util.List;

import org.jrotero.controller.LibroDTO;
import org.jrotero.models.LibroEntity;
import org.jrotero.service.impl.Libro;

public interface ILibroService {
	//Aqui añadimos los Service que tendra el microservicio
	public LibroDTO getLibro(Integer id) throws Exception;
	public LibroEntity create(Libro libro) throws Exception;
	public LibroEntity update(Integer id, Libro libro);
	public List<LibroDTO > getAllLibros();
	public LibroDTO delete(Integer id);
}

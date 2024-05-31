package org.jrotero.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jrotero.controller.LibroDTO;
import org.jrotero.models.ILibrosRepository;
import org.jrotero.models.LibroEntity;
import org.jrotero.service.libro.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements ILibroService{

	@Autowired
	private ILibrosRepository repository;
	
	
	@Override
	public LibroDTO getLibro(Integer id) throws Exception {
		//En este metodo llamamos al repositorio y que encuentre el libro por su id
		//Luego lo metemos en una variable y crearemos con un metodo el DTO
		var response = repository.findById(id).orElseThrow(() -> new Exception("No se encuentra el libro"));
		var libroResponse = createDto(response);
		//Devolvemos la informacion en una variable que contiene al DTO
		return libroResponse;
	}
	

	@Override
	public LibroEntity create(Libro libro) throws Exception {
		//Para crear los libros lo primero que hareos es hacer un libroCrear e ir rellenando los datos con un builder.
			LibroEntity libroCrear= LibroEntity.builder()
					.id(libro.getId())
					.nombre(libro.getNombre())
					.genero(libro.getGenero())
					.cantidadLibros(libro.getCantidadLibros())
					.build();
			
			return repository.save(libroCrear);

	}

	@Override
	public LibroEntity update(Integer id, Libro libro) {
		var response= repository.findById(id).get();
		response.setNombre(libro.getNombre());
		response.setGenero(libro.getGenero());
		response.setCantidadLibros(libro.getCantidadLibros());
		return repository.save(response);
	}

	//Este metodo se hace para listar los libros
	@Override
	public List<LibroDTO> getAllLibros() {
		//Lo primero que hace el metodo es meter todos los datos en un response
		var response = repository.findAll();
		//Crearemos un list donde luego almacenaremos esos datos y poder enviarlos
		List<LibroDTO> libros = new ArrayList<>();
		//Se hace un forEadch con una lambda que va rellenando los datos 1 a 1
		response.forEach(e -> {
			LibroDTO libro = new LibroDTO();
			libro.setId(e.getId());
			libro.setNombre(e.getNombre());
			libro.setGenero(e.getGenero());
			libro.setCantidadLibros(e.getCantidadLibros());
			libros.add(libro);
		});
		return libros;
	}

	//Metodo del repositorio que elimina por ID
	@Override
	public LibroDTO delete(Integer id) {
		repository.deleteById(id);
		return null;
	}
	
	//Este metodo crea el libro DTO, donde pillamos el libroEntity y luego lo rellenamos con datos
	private LibroDTO createDto(LibroEntity response) {
		var LibrosResponse = new LibroDTO();
		LibrosResponse.setId(response.getId());
		LibrosResponse.setNombre(response.getNombre());
		LibrosResponse.setGenero(response.getGenero());
		LibrosResponse.setCantidadLibros(response.getCantidadLibros());
		return LibrosResponse;
	}
}

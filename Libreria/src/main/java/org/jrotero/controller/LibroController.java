package org.jrotero.controller;

import org.jrotero.service.impl.Libro;
import org.jrotero.service.libro.ILibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/libros")
@AllArgsConstructor
public class LibroController {
	
	private ILibroService service;

	//Metodo para sacar un libro por su ID
	@GetMapping("get/{id}")
	public ResponseEntity<?> getLibro(@Valid @PathVariable Integer id) throws Exception {
		//LLamamos al service que contiene los metodos
		return ResponseEntity.ok(service.getLibro(id));
	}

	//Metodo para crear un libro
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody Libro libro) throws Exception {
		return ResponseEntity.ok(service.create(libro));
	}

	//Metodo para actualizar los datos del libro pasando el id
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Libro libro) {
		return ResponseEntity.ok(service.update(id,libro));
	}

	//Metodo para listar todos los libros
	@GetMapping("/listarLibros")
	public ResponseEntity<?> listarLibros(LibroDTO libro) {
		return ResponseEntity.ok(service.getAllLibros());
	}

	//Metodo para eliminar un libro con su id
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return ResponseEntity.ok(service.delete(id));
	}
	
}

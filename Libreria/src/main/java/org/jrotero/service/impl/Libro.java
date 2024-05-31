package org.jrotero.service.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Estas anotaciones son de lombok y se usan para optimizar codigo (si no esta insatalado el lombok a veces no funciona)
@Data
//Esta anotacion sirve para crear un patron de diseño
@Builder
//Anotaciones para los constructores, uno que tenga todos los argumentos y otro que sea un constructor vacio
@AllArgsConstructor
@NoArgsConstructor
//Anotaciones para los getters y setters
@Getter
@Setter
public class Libro {
	
	private Integer id;
	private String nombre;
	private String genero;
	private Integer cantidadLibros;
}

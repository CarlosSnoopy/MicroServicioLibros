package org.jrotero.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
//Anotacion para crear la tabla de la entidad
@Table(name = "libros")
public class LibroEntity {
	
	//anotacion para indicar el id de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String genero;
	private Integer cantidadLibros;
}

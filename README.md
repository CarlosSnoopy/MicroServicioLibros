Proyecto en STS
Para poder ejecutarlo en postman dejo los ejemplos para usarlo:
GET: http://localhost:8080/libros/listarLibros
POST: http://localhost:8080/libros/crear
        JSON: 
        {
            "id":1,
            "nombre": "aa",
            "genero":"a",
            "cantidadLibros":2
        }
PUT: http://localhost:8080/libros/update/2
      JSON: 
      {
          "nombre": "BB",
          "genero":"B",
          "cantidadLibros":3
    }
DELETE: http://localhost:8080/libros/delete/1
GET: http://localhost:8080/libros/get/1

package com.segunda.preentrega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
EJEMPLOS:
-------------------------------------------------CLIENTES------------------------------
POST http://localhost:8080/clientes/agregar
{
  "nombre": "Hernan",
  "apellido": "Hernandez",
  "dni": 12345678,
  "isactivo": true,
  "reputacion": 5
}

GET http://localhost:8080/clientes/buscar/1

GET http://localhost:8080/clientes

-------------------------------------------------PRODUCTOS------------------------------
POST http://localhost:8080/productos/agregar
{
  "nombre": "Rotomartillo Milwaukee 23inch",
  "precio": 450.99,
  "stock": 40
}

GET http://localhost:8080/productos/buscar/1

GET http://localhost:8080/productos/listar

-------------------------------------------------VENTAS------------------------------
POST http://localhost:8080/ventas/agregar
{
  "fecha": "2024-09-01",
  "total": 1234.56,
  "cliente": {
    "id": 1
  }
}

GET http://localhost:8080/ventas/buscar/1

GET http://localhost:8080/ventas/listar

-------------------------------------------------VENTAPRODUCTO------------------------------

..................................................................................................
!!!!OJO ANTES DE HACER ESTE POST ES NECESARIO QUE SE CREE UN VENTA ASI EXISTE LA VENTA ID = 1!!!!!
..................................................................................................
POST http://localhost:8080/venta-productos/agregar
{
  "venta": {
    "id": 1
  },
  "producto": {
    "id": 1
  },
  "cantidad": 3
}

GET http://localhost:8080/venta-productos/buscar/1

GET http://localhost:8080/venta-productos/listar

DELETE http://localhost:8080/venta-productos/eliminar/1
*/

@SpringBootApplication
public class PreentregaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreentregaApplication.class, args);
	}

}

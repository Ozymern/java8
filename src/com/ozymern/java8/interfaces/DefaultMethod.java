package com.ozymern.java8.interfaces;

public interface DefaultMethod {

	// metodo para leer la cadena por consola
	public void leer(String cadena);

	// los defaultmethod son metodos con implementacion en las interface

	public default void leer(String[] cadenas) {
		for (String cadena : cadenas) {

			System.out.println(cadena);
		}
	}

	// nota una interface puede tener n numero de metodos default
	// las clases que implementan esta interfaz reciben como herencia los metodos
	// default, tambien se pueden sobreescribir
	// si una clase implementa 2 interface con metodos default con la misma firma,
	// es necesario sobreescribir
}

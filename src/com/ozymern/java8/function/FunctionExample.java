package com.ozymern.java8.function;

import java.util.function.Function;

import com.ozymern.java8.commons.Coche;
import com.ozymern.java8.commons.Persona;

public class FunctionExample {

	// ejemplos de las interface funcionales de uso general

	// interface Function<T,R> donde T es el parametro de entrada y R lo que
	// devuelve

	public void FuncionalExamples() {
		// firma del metodo R apply(T t)
		// Function<T,R>
		Function<Persona, String> nombre = per -> per.getNombre();

	}

	public void andThen() {
		// añadir funcionalidad posterior
		// en la primera asignacional devuelve el nombre de una persona, pero en la
		// segunda es una funcion que sobre el nombre devuelve el mismo pero en
		// mayuscula

		Function<Persona, String> nombre = per -> per.getNombre();
		nombre = nombre.andThen(it -> it.toUpperCase());
	}

	// compose añade funcionalidad anterior
	public void compose() {

		Function<Coche, Persona> propietario = it -> it.getPropietario();
		Function<Persona, String> nombre = per -> per.getNombre();

		// optiene el nombre del propietario de un coche
		Function<Coche, String> nombrePropietario = nombre.compose(propietario);
	}
}

package com.ozymern.java8.optional;

import java.util.Optional;

import com.ozymern.java8.commons.Persona;

public class OptionalExample {

	// la clase optional viene a combatir el valor null
	// optinal es una especie de contenedor que puede o no contener determinado
	// valor
	public void probar(String valor) {
		// System.out.println(valor.contains("alejandro"));

		try {
			// si el optional no va a tener valor podemos usar el metodo empty
			Optional<Persona> op = Optional.empty();
			// retorna el valor del tipo persona get();
			Persona per = op.get();
		} catch (Exception e) {
			System.out.println("No hay elemento");
		}
	}

	public void orElse(String valor) {
//		.of
//		el que nos permite recubrir cualquier objeto en un optional.
//	
//		String nombre = "Daniel";
//		Optional<String> oNombre = Optional.of(nombre);
		// crear el optional en base a una referencia que puede ser null, podemos usar
		// el metodo ofNullable ,este uso no es el mas frecuente, aparece cuando estamos
		// tratando con codigo anterior a java8
		Optional<String> op = Optional.ofNullable(valor);
		// si es valor es nulo, le podemos agregar un valor por defecto
		String x = op.orElse("predeterminado");
		System.out.println(x);
	}

	public void orElseThrow(String valor) {
		Optional<String> op = Optional.ofNullable(valor);
		// si el valor es nullo arrojaremos una exception
		op.orElseThrow(NumberFormatException::new);
	}

	public void isPresent(String valor) {
		Optional<String> op = Optional.ofNullable(valor);
		// is present si el valor ha sido inicializado o no, retorna un booleano
		System.out.println(op.isPresent());
	}

	public Optional<String> map(Optional<Persona> persona) {
		// el metodo map sirve para ejecutar una funcion sobre el valor de option si
		// esta presente, sino devuelve un optional vacio
		// map() se usa para transformar un objeto en otro aplicando una función .
		// cuando el tipo devuelto por ejemplo es Optiomal<Optional<String>> se ocupa
		// flashMap() para aplanar y que devuelva Optional<String>
		return persona.map(it -> "hola " + it.getNombre());
	}

	public String saluda(Optional<Persona> persona) {
		return persona.map(Persona::getNombre).map("Hola"::concat).orElse("Estoy solo");
	}

	public static void main(String[] args) {
		OptionalExample app = new OptionalExample();
		// app.probar("alejandro");
		// app.orElse("alejandro");
		// app.orElseThrow("alejandro");
		app.isPresent("alejandro");
		app.isPresent(null);

		Optional<Persona> opot = Optional.of(new Persona(1, "alejandro"));

		System.out.println(app.map(opot));

	}

}

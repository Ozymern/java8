package com.ozymern.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ozymern.java8.commons.Persona;

public class StreamExample {

	// los stream son agrupaciones de elementos sobre los que podemos especificar
	// operaciones

	// anterior a los streams java 8
	private List<String> convertCollecionVersion(List<Persona> personas) {
		List<String> nombres = new ArrayList<String>();
		for (Persona persona : personas) {
			nombres.add(persona.getNombre());
		}
		return nombres;
	}

	// con stream son delcarativos, indicamos que queremos realizar sobre los
	// objetos, no el como
	private List<String> convertStreamVersion(List<Persona> personas) {

		// la clase collection dispone de un metodo stream() que nos devuelve un stream
		// con map indicamos que queremos indicar una conversion sobre los elementos del
		// stream y esta convercion la aplicaremos sobre cada uno de los elementos
		// Collect(Collectors.toList() recoge los elementos stream acomulandolos en una
		// estructura de lista
		// pipeline
		return personas.stream()// creacion
				.map(it -> it.getNombre())// operaciones intermedias
				.collect(Collectors.toList());// operacion terminal

	}

	private void creacionStream() {

		// Colleciont stream()
		List<Persona> personas = new ArrayList<>();
		Stream<Persona> s1 = personas.stream();

		// Arrays.asStream()
		Persona[] personas2 = { new Persona(1, "alejandro"), new Persona(2, "francisca") };
		Stream<Persona> s2 = Arrays.stream(personas2);

		// utilidades de stream
		// el metodo of permite pasar una enumeracion de objetos para crear un nuevo
		// stream
		Stream<Persona> s3 = Stream.of(new Persona(1, "alejandro"), new Persona(2, "francisca"));

	}

	private void operacionesIntermedias(List<Persona> personas) {
		// existen 3 tipos
		// convertir=trasforma los elementos del stream el nuevo stream tiene el mismo
		// numero de elementos
		// estos elementos estan en el mismo orden que el stream inicial ejemplo:
		Stream<String> nombres = personas.stream().map(it -> it.getNombre());

		// filtrar los elementos del stream, metodo filter que acepta un predicado si
		// devuelve true este se conserva en el nuevo stream, si devuelve false no forma
		// parte de el
		// una operacion de filtrado tiene las siguientes caratcteristicas, el nuevo
		// stream tiene un numero distinto de elementos
		// los elementos que siguen en el stream son del mismo orden, y son del mismo
		// tipo del stream inicial
		Stream<String> nombresA = nombres.filter(it -> it.startsWith("A"));

		// ordenar, algunas consideraciones, el stream producido tiene el mismo numero
		// de elementos que el original
		// los elementos estan en distinto orden
		// los elementos son del mismo tipo que el stream original
		// al metodo sorted le pasamos un comparator con lambdan
		nombres.sorted((o1, o2) -> o2.length() - o1.length());
		// ordenacion natural
		nombres.sorted();

		// limitar a los 2 primeros elementos
		nombres.limit(2).forEach(System.out::printf);

		// contar, cuenta el numero de elementos
		long count = nombres.count();

	}

	// es la operacion final la que dispara la ejecucion del pipeline de stream
	private void operacionesTermianles() {
		// reduce opera sobre los elementos de un stream para producir un resultado
		// final,
		// consta de un elemento inicial en este caso "" , y la operacion a realizar en
		// este caso concatenar los elemetos agregando un salto de linea (a,b)->a+"\n"+b
		// , realiza la operacion en todos los elementos del stream
		String todos = Stream.of("Alejandro", "Francisca", "roma").reduce("", (a, b) -> a + "\n" + b);

		// otro metodo terminal (forEach) que es void no devuelve nada
		Stream.of("Alejandro", "Francisca", "roma").forEach(System.out::printf);
		// collector son estructuras modificables que reciben los elementos de un stream
		// y construyen un resultado
		// collector posee groupingBy , por lo general sirven para realizar
		// agrupaciones, operaciones aritmeticas y conversion a
		// collections(List,Set,Map)
		List<String> nombres = Stream.of("Alejandro", "Francisca", "roma").collect(Collectors.toList());
	}

}
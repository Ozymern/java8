package com.ozymern.java8.ordenacion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordenacion {

	public void ordenacionNatural(List<String> nombres) {
		// la clase String implementa la interfaz comparable que compara, basada en el
		// codigo unicode de cada caracter
		Collections.sort(nombres);
		System.out.println(nombres);
	}

	public void ordenacionConCriterio(List<String> nombres) {

		// el criterio sera mostrar los nombres segun su longitud
		// se creara una clase anonima que implementa la interfaz comparable
		Comparator<String> compararLongitud = new Comparator<String>() {
			// un valor devuelto en negativo significa que el primer elemento es menor que
			// el segundo, un valor positivo que el primer elemento es mayor y si es cero
			// que son iguales

			@Override
			public int compare(String o1, String o2) {

				return o1.length() - o2.length();
			}
		};
		Collections.sort(nombres, compararLongitud);
		System.out.println(nombres);

	}

	public void ordenacionJava8(List<String> nombres) {
		// genera comportamiento sin necesidad de encapsularlo en una clase nueva con
		// las lamba
		// (parametros de entrada )-> valor devuelto
//		Comparator<String> compararLongitud = (o1, o2) -> o1.length() - o2.length();
//		Collections.sort(nombres, compararLongitud);
//		
		// compacto si no voy a volver a utilizar la variable compararLongitud
		Collections.sort(nombres, (o1, o2) -> o1.length() - o2.length());

		// tercera forma de hacer una lambda
		Collections.sort(nombres, Comparator.comparing(String::length));
		System.out.println(nombres);

	}

	public static void main(String[] args) {

		Ordenacion ordenacion = new Ordenacion();

		List<String> nombres = Arrays.asList("alejandro", "francisca", "yodita", "roma", "asesina");

		ordenacion.ordenacionNatural(nombres);

		ordenacion.ordenacionConCriterio(nombres);

		ordenacion.ordenacionJava8(nombres);

	}

}

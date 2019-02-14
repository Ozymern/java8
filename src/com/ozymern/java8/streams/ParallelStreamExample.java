package com.ozymern.java8.streams;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {

	// opcion de stream con pararelismo eso es parallelStream

	public void parallel() {

		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 96);
		Integer suma = lista.parallelStream()
				// peek no afecta al flujo del stream, pero nos permite tener notificaciones de
				// que elemento se esta tratando en cada elemento
				.peek(System.out::println).reduce(0, (a, b) -> a + b);
		// la diferencia con el stream normal, esque el orden no es secuencial,
		// ej:96,2,3 la tarea se ejecutara de forma paralela
	}
}

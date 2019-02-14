package com.ozymern.java8.lambda;

import java.lang.reflect.Array;

public class Lambda {

//	una lambdan produce un objeto de una funtionalinterface
//	, esta es la implementacion del unico metodo abstracto de una interfacefuncional
	// ejemplo int compare(T o1, T o2);
	// (o1,02) ->o1.length()-o2.length()

	// lambdaParameter ->LambdaBody
	// si tiene un solo parametro de entrada los parentesis son opcionales
	// no es necesario especificar el tipo de los parametros , aunque se permite
	// el cuerpo de una expresion simple no lleve llaves y siempre devuelven un
	// valor, si se realizan calculos de mayor complejidad y son necesario
	// parentesis, se debe colocar la palabra return
	// ejemplo de lambdan
	// metodo abstract de una interface funcional lambdan expression
	// int m(int a, int b) (a,b)-> a | (int a,int b) -> a
	// int m(int a) (a)-> a | a -> a | a -> {return a;}
	// int m () () -> 5
	// void m (int b) (a) -> {}

	// devolver una implementacion de constante que siempre devuelva 5
	public Constante devuelve5() {
		// int valor() firma que deve implementar mi lambdan
		return () -> 5;
	}

	// devuelve una implementacion de Operador con el metodo de suma de dos enteros
	public Operador obtenerSuma() {
		// int opera(int a, int b);
		return (a, b) -> a + b;

	}

	// devuelve un inicializador de un array de string, el metodo inicializa recibe
	// un array ya creado. su tarea es que
	// todas las posiciones queden inicializadas con el valor indicado en el segundo
	// parametro del metodo inicializa
	public InicializarArrays obtenerInicializador() {
		// void inicializar(String[] array, String valor);
		return (array, valor) -> {
			for (int i = 0; i < array.length; i++) {
				array[i] = valor;
			}

		};

	}
}

interface Constante {
	int valor();

}

interface InicializarArrays {

	void inicializar(String[] array, String valor);

}

interface Operador {

	int opera(int a, int b);
}

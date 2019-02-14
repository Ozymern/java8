package com.ozymern.java8.method.references;

import java.util.Arrays;
import java.util.List;

import com.ozymern.java8.commons.Persona;

public class MethodReference {
	List<String> nombres = Arrays.asList("alejandro", "francisca", "yodita", "roma", "asesina");

	public void methodReferenceExampleStatic() {

		nombres.sort((o1, o2) -> o1.length() - o2.length());
		nombres.sort((o1, o2) -> Utilidades.compare(o1, o2));

		// estamos pasando directamente una referencia al metodo compare
		// (Clase que invocamos)::(metodo estatico al que referenciamos)
		nombres.sort(Utilidades::compare);

	}

	public static void referenciaMetodoStatic() {
		System.out.println("Metodo referido static");
	}

	public void referenciarMetodoInstanciaObjectoArbitrario() {
		String[] nombres = { "alejandro", "francisca", "roma" };

//		Arrays.sort(nombres, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//
//				return o1.compareToIgnoreCase(o2);
//			}
//
//		});
		// exprecion lambdan
		Arrays.parallelSort(nombres, (s1, s2) -> s1.compareToIgnoreCase(s2));
		// int compare(String o1,Stringo2);
		// (o1,o2) = o1.compareToIgnoreCase(o2); String::compareToIgnoreCase se ejecuta
		// sobre el primer parametro y compareIgnoreCse y pasando como paranmetros los
		// demas argumentos (o2)

		Arrays.sort(nombres, String::compareToIgnoreCase);
	}

	public void referenciarMetodoInstanciaObjectoParticular() {

		System.out.println("metodo referido instancia de un objeto particular");

	}

	public void referenciarConstructor() {
		IPersona iper = new IPersona() {

			@Override
			public Persona crear(int id, String nombre) {
				// TODO Auto-generated method stub
				return new Persona(id, nombre);
			}
		};

		iper.crear(1, "Alejandro");
		// con una exprecion lambdan
		IPersona iper2 = (x, y) -> (new Persona(x, y));
		Persona per = iper2.crear(1, "Alejandro");
		System.out.println(per);
		// con methodreference
		IPersona iper3 = Persona::new;
		Persona per2 = iper3.crear(1, "Alejandro");
		System.out.println(per2);
	}

	public void operar() {
		// con lambdan
		Operacion op = () -> MethodReference.referenciaMetodoStatic();
		op.saludar();
		// con metodo referencia
		Operacion op2 = MethodReference::referenciaMetodoStatic;
		op2.saludar();

	}

	public static void main(String[] args) {
		MethodReference methodReference = new MethodReference();
		methodReference.operar();
		methodReference.referenciarMetodoInstanciaObjectoArbitrario();
		Operacion op = methodReference::referenciarMetodoInstanciaObjectoParticular;
		op.saludar();

	}

	public static class Utilidades {
		public static int compare(String o1, String o2) {
			return o1.length() - o2.length();

		}
	}

}

interface Operacion {
	void saludar();
}

interface IPersona {
	Persona crear(int id, String nombre);
}

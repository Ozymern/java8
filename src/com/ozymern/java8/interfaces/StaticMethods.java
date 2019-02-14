package com.ozymern.java8.interfaces;

public interface StaticMethods {

	// ahora se permite a las interfaces tener metodos estaticos
	public static String mayusculaCadena(String cadena) {
		return cadena.toUpperCase();
	}

}

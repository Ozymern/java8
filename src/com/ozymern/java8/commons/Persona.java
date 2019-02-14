package com.ozymern.java8.commons;

public class Persona {

	private int id;

	private String rut;

	private String nombre;

	private int edad;

	public Persona() {

	}

	public Persona(int id, String nombre) {

		this.id = id;
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

}

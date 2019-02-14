package com.ozymern.java8.commons;

public class Coche {
	private String modelo;
	private Persona propietario;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "Coche [modelo=" + modelo + ", propietario=" + propietario + "]";
	}

}

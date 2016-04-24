package com.monroy.modulo;

public abstract class Personaje {
	private String nombre;
	private Raza raza;
	private int fuerza;
	private int inteligencia;
	private int puntoVidaMaximo;
	private int puntoVidaActual;
	private final int MINIMO_FUERZA = 0;
	private final int MINIMO_INTELIGENCIA = 0;
	private final int MINIMO_VIDA = 0;
	private final int MAXIMO_FUERZA = 20;
	private final int MAXIMO_INTELIGENCIA = 20;
	private final int MAXIMO_VIDA = 100;
	
	public Personaje(String nombre, Raza raza, int puntoVidaMaximo, int inteligencia, int fuerza) throws PersonajeException {
		setNombre(nombre);
		setRaza(raza);	
		setFuerza(fuerza);
		setInteligencia(inteligencia);
		setPuntoVidaMaximo(puntoVidaMaximo);
		setPuntoVidaActual(puntoVidaMaximo);
	}
	
	// Get & Set Method // toString
	
	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza < MINIMO_FUERZA || fuerza > MAXIMO_FUERZA)
			throw new PersonajeException(fuerza);
		this.fuerza = fuerza;
	}
	
	public void setInteligencia(int inteligencia) throws PersonajeException {
		if (inteligencia < MINIMO_INTELIGENCIA || inteligencia > MAXIMO_INTELIGENCIA)
			throw new PersonajeException(inteligencia);
		this.inteligencia = inteligencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public int getPuntoVidaMaximo() {
		return puntoVidaMaximo;
	}

	public void setPuntoVidaMaximo(int puntoVidaMaximo) throws PersonajeException {
		if (puntoVidaMaximo < MINIMO_VIDA || puntoVidaMaximo > MAXIMO_VIDA)
			throw new PersonajeException(puntoVidaMaximo);
		this.puntoVidaMaximo = puntoVidaMaximo;
	}

	public int getPuntoVidaActual() {
		return puntoVidaActual;
	}

	public void setPuntoVidaActual(int puntoVidaActual) {
		
		if (puntoVidaActual > puntoVidaMaximo)
			this.puntoVidaActual = puntoVidaMaximo;
		else
			this.puntoVidaActual = puntoVidaActual;
	}
	
	public abstract String imprimirPersonaje();

	@Override
	public String toString() {
		return raza + " " + nombre + " " + puntoVidaActual + "(" + puntoVidaMaximo + ") [Fuerza"
				+ fuerza + ", Inteligencia " + inteligencia + "]";
	}

	
}
	
	
	
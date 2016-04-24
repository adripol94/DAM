package com.monroy.modulo;

public class Clerigo extends Personaje {
	private final int MIMINO_FIERZA = 18;
	private final int INTELIGENCIA_MENOR = 12;
	private final int INTELIGENCIA_MAXIMO = 16;
	private final int CURACION = 10;
	private String dios;

	public Clerigo(String nombre, Raza raza, int puntoVidaMaximo, int fuerza, int inteligencia, String dios) throws PersonajeException {
		super(nombre, raza, puntoVidaMaximo, inteligencia, fuerza);
		setDios(dios);
		setFuerza(fuerza);
		setInteligencia(inteligencia);
	}
	
	public void setDios(String dios) {
		this.dios = dios;
		
	}
	
	public String getDios() {
		return dios;
	}

	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza < MIMINO_FIERZA)
			throw new PersonajeException("Fuerza de Clerigo inferior a lo permitido" + fuerza);
		super.setFuerza(fuerza);
	}
	
	public void setInteligencia(int inteligencia) throws PersonajeException {
		if (inteligencia < INTELIGENCIA_MENOR || inteligencia > INTELIGENCIA_MAXIMO)
			throw new PersonajeException("inteligencia fuera del rango permitido");
		super.setInteligencia(inteligencia);
	}
	
	public void rezar(Personaje personaje) throws PersonajeException {
		if (personaje.getPuntoVidaActual() == personaje.getPuntoVidaMaximo())
			throw new PersonajeException(personaje.getNombre() + " esta al maximo de vida!");
		if (personaje.getPuntoVidaActual() == 0)
			throw new PersonajeException(personaje.getNombre() + " esta muerto.");
		
		personaje.setPuntoVidaActual(personaje.getPuntoVidaActual() + CURACION);
	}

	public String imprimirPersonaje() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return super.toString() + " Clerigo [Dios=" + dios + "]";
	}
	
	
}

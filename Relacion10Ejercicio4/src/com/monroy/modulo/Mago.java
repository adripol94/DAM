package com.monroy.modulo;

import java.util.Arrays;

public class Mago extends Personaje {
	private final int MAXIMO_HECHIZOS = 4;
	private final int MINIMO_INTELIGENCIA = 17;
	private final int MAXIMO_FUERZA = 15;
	private final int DAÑO_HECHIZOS = -10;
	private String nombreHechizos[];
	
	
	public Mago(String nombre, Raza raza, int fuerza, int inteligencia, int puntoVidaMaximo) throws PersonajeException {
		super(nombre, raza, puntoVidaMaximo, inteligencia, fuerza);
		setFuerza(fuerza);
		setInteligencia(inteligencia);
		nombreHechizos = new String[MAXIMO_HECHIZOS];
		// rellenarHechizos();
	}
	
//	private void rellenarHechizos() {
//		for (int i = 0; i < MAXIMO_HECHIZOS; i++) {
//			nombreHechizos[i] = "";
//		}
//	}

	public void setInteligencia(int inteligencia) throws PersonajeException {
		if (inteligencia < MINIMO_INTELIGENCIA)
			throw new PersonajeException("Inteligencia inferior a lo permitido " + inteligencia);
		super.setInteligencia(inteligencia);
	}

	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza > MAXIMO_FUERZA)
			throw new PersonajeException("Fuerza superior a lo permitida: " + fuerza);
		super.setFuerza(fuerza);
	}
	
	public void aprenderHechizo(String hechizo) throws PersonajeException { // FIXME Probar
		int posHechizos = buscarHechizo(hechizo);
		
		if (posHechizos != -1)
			throw new PersonajeException("Ya has aprendido ese hechizo");
		posHechizos = buscarNull();
		
		if (posHechizos == -1)
			throw new PersonajeException("No puedes aprender más hechizos");		
	
		this.nombreHechizos[posHechizos] = hechizo;
	}
	

	public void lanzarHechizo(Personaje personaje, String hechizo) throws PersonajeException {
		int i = buscarHechizo(hechizo);
		if (i == -1)
			throw new PersonajeException("No se ha encontrado dicho hechizo!");
		
		personaje.setPuntoVidaActual(personaje.getPuntoVidaActual() + DAÑO_HECHIZOS);
		
		if (personaje.getPuntoVidaActual() <= 0)
			personaje.setPuntoVidaActual(0);
		nombreHechizos[i] = null;
	}
	
	private int buscarNull() {
		boolean find = false;
		int i = 0, posHechizo = -1;
		
		while (i < MAXIMO_HECHIZOS && !find) {
			if (nombreHechizos[i] == null) {
				find = true;
				posHechizo = i;
			}
			i++;
		}
		return posHechizo;
	}

	private int buscarHechizo(String hechizo) throws PersonajeException {
		boolean find = false;
		int i = 0, posHechizo = -1;
		
		while (i < MAXIMO_HECHIZOS && !find) {
			if (nombreHechizos[i] != null && nombreHechizos[i].equals(hechizo)) {
				find = true;
				posHechizo = i;
			}
			i++;
		}
		return posHechizo;
	}
	
	public String imprimirPersonaje() {
		return this.toString();
	}

	@Override
	public String toString() {
		return super.toString() + " Mago [Hechizos Diponibles=" + Arrays.toString(nombreHechizos);
	}
	
	
	
}

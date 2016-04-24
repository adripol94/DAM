package com.monroy.modulo;

import java.text.DecimalFormat;

import com.monroy.estadistica.Estadisticas;

public class PersonajesArray implements Estadisticas{
	private Personaje personajes[];
	private int posArray;
	private final int MAXIMO_PERSONAJES = 100;

	public PersonajesArray() {
		personajes = new Personaje[MAXIMO_PERSONAJES];
		posArray = 0;
	}

	public PersonajesArray(int nPersonajes) throws PersonajeException {
		if (nPersonajes <= 0 || nPersonajes > MAXIMO_PERSONAJES)
			throw new PersonajeException("Valor negativo" + nPersonajes);
		personajes = new Personaje[nPersonajes];
	}

	public void altaPersonaje(Personaje personaje) throws PersonajeException {
		int pos = buscarEnArray(personaje.getNombre());
		if (pos != -1)
			throw new PersonajeException("El nombre ya fue usado");
		personajes[posArray] = personaje;
		posArray++;
	}

	public void magoAprendeHechizo(String nombreMago, String nombreHechizo) throws PersonajeException {
		int posMago = buscarEnArray(nombreMago);
		Mago mago;

		if (posMago == -1)
			throw new PersonajeException("No se ha encontrado el mago");
		if (!(personajes[posMago] instanceof Mago))
			throw new PersonajeException(nombreMago + " no es un Mago!");
		mago = (Mago) personajes[posMago];

		mago.aprenderHechizo(nombreHechizo);
	}

	public void MagoLanzaHechizo(String nombreMago, String nombrePersonajeAtacado, String hechizo)
			throws PersonajeException {
		int posMago, posAtacado;
		Mago mago;
		Personaje personaje;

		if (nombreMago == nombrePersonajeAtacado)
			throw new PersonajeException("No puedes atacarte a ti mismo");

		posAtacado = buscarEnArray(nombrePersonajeAtacado);
		posMago = buscarEnArray(nombreMago);

		if (posMago == -1)
			throw new PersonajeException("No existe el mago'" + nombreMago + "'");
		if (posAtacado == -1)
			throw new PersonajeException("No existe el personaje '" + nombrePersonajeAtacado + "'");
		if (!(personajes[posMago] instanceof Mago))
			throw new PersonajeException(nombreMago + " no es un Mago!");

		mago = (Mago) personajes[posMago];
		personaje = personajes[posAtacado];
		mago.lanzarHechizo(personaje, hechizo);

		if (personaje.getPuntoVidaActual() <= 0)
			throw new PersonajeException(nombrePersonajeAtacado + " ha muerto!");
	}

	public void clerigoCura(String nombreClerigo, String nombrePersonaje) throws PersonajeException {
		int posClerigo, posPersonaje;
		Clerigo clerigo;

		posClerigo = buscarEnArray(nombreClerigo);
		posPersonaje = buscarEnArray(nombrePersonaje);

		if (posClerigo == -1)
			throw new PersonajeException("No existe el Clerigo '" + nombreClerigo + "'");
		if (posPersonaje == -1)
			throw new PersonajeException("No existe el personaje '" + nombrePersonaje + "'");
		if (!(personajes[posClerigo] instanceof Clerigo))
			throw new PersonajeException(nombreClerigo + " no es un Clerigo!");

		clerigo = (Clerigo) personajes[posClerigo];
		clerigo.rezar(personajes[posPersonaje]);
	}

	public String mostrarListaPersonajes() {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < personajes.length; i++) {
			if (personajes[i] != null)
				if (personajes[i].getPuntoVidaActual() == 0) {
					str.append("Estado de vida: MUERTO :" + personajes[i].imprimirPersonaje() + "\n");
				} else {
					str.append("Estado de vida: VIVO :" + personajes[i].imprimirPersonaje() + "\n");
				}
		}
		return str.toString();
	}

	public String mostrarListaPersonajesOrdenador() {
		Personaje arrayOrdenado[] = personajes.clone();
		Personaje personajeAux;

		for (int i = 0; i < arrayOrdenado.length; i++) {
			if ((personajes[i] != null && personajes[i+1] != null) && (arrayOrdenado[i].getPuntoVidaActual() < arrayOrdenado[i + 1].getPuntoVidaActual())) {
				personajeAux = arrayOrdenado[i + 1];
				arrayOrdenado[i + 1] = arrayOrdenado[i];
				arrayOrdenado[i] = personajeAux;
			}
		}
		return formatearSalidaString(arrayOrdenado);
	}

	private String formatearSalidaString(Personaje[] arrayOrdenado) {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < arrayOrdenado.length; i++) {
			if (arrayOrdenado[i] != null)
				str.append(arrayOrdenado[i] + "\n");
		}
		return str.toString();
	}

	private int buscarEnArray(String str) {
		int pos = -1;
		int i = 0;
		boolean encontrado = false;

		while (i < personajes.length && !encontrado) {
			if (personajes[i] != null && personajes[i].getNombre().equals(str)) {
				encontrado = true;
				pos = i;
			}
			i++;
		}

		return pos;
	}

	@Override
	public double maximo() {
		double maximo = personajes[0].getPuntoVidaActual();
		DecimalFormat df = new DecimalFormat("0.00");
		
		for (int i = 0; i < personajes.length; i++) {
			if (!(personajes[i] == null) && maximo < personajes[i].getPuntoVidaActual())
				maximo = personajes[i].getPuntoVidaActual();
		}
		return Double.parseDouble(df.format(maximo));
	}

	@Override
	public double minimo() {
		double minimo = personajes[0].getPuntoVidaActual();
		DecimalFormat df = new DecimalFormat("0.00");
		
		for (int i = 0; i < personajes.length; i++) {
			if (personajes[i] != null && minimo > personajes[i].getPuntoVidaActual())
				minimo = personajes[i].getPuntoVidaActual();
		}
		return Double.parseDouble(df.format(minimo));
	}

	// Media
	@Override
	public double sumatorio() {
		double media = 0;
		DecimalFormat df = new DecimalFormat("0.00");
		
		for (int i = 0; i < personajes.length; i++) {
			if (personajes[i] != null)
				media = media + personajes[i].getPuntoVidaActual();
		}
		return Double.parseDouble(df.format(media / contarPersonajes()));
	}

	private double contarPersonajes() {
		int n = 0;
		for (int i = 0; i < personajes.length; i++) {
			if (personajes[i] != null)
				n++;
		}
		return n;
	}
}

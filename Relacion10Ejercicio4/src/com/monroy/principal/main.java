package com.monroy.principal;

import java.util.Arrays;
import java.util.Scanner;
import com.monroy.modulo.*;

public class main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		PersonajesArray juego = new PersonajesArray();
		int opc;
		try {
			Personaje A = new Mago("Pocholo", Raza.ORCO, 12, 18, 100);
			juego.altaPersonaje(A);
			Personaje B = new Mago("Fukencio", Raza.HUMANO, 15, 19, 80);
			juego.altaPersonaje(B);
			Personaje C = new Clerigo("Shurmano", Raza.ELFO, 100, 19, 15, "Superman");
			juego.altaPersonaje(C);
			System.out.println(juego.sumatorio());
		} catch (PersonajeException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		do {
			menu();
			opc = pedirInt("Indique una opcion");
			accionMenu(opc, juego);
		} while (opc != 7);

	}

	private static void menu() {
		System.out.println("1. Alta personaje");
		System.out.println("2. Mago aprende hechizo");
		System.out.println("3. Mago lanza hechizo");
		System.out.println("4. Clerigo cura al Mago");
		System.out.println("5. Mostrar listado de personajes");
		System.out.println("6. Mostrar el listado de personajes ordenados por puntos");
		System.out.println("7. Salir");
	}

	private static int pedirInt(String msg) {

		System.out.println(msg);
		return Integer.parseInt(in.nextLine());
	}

	private static String pedirString(String msg) {
		System.out.println(msg);
		return in.nextLine();
	}

	private static Personaje crearJugador() throws PersonajeException {
		Personaje personaje = null;
		int clase = pedirClase();
		String nombre = pedirString("Indique el nombre del jugador");
		Raza raza = pedirRaza();
		int fuerza;
		int inteligencia;
		int vida = pedirInt("Indique la vida del jugador");
		String dios;

		switch (clase) {
		case 1:
			fuerza = pedirInt("Indique la fuerza del personaje (Menor de 15)");
			inteligencia = pedirInt("Indique la inteligencia del jugador (Mayor de 17)");
			personaje = new Mago(nombre, raza, fuerza, inteligencia, vida);
			break;
		case 2:
			fuerza = pedirInt("Indique la fuerza del personaje (Mayor de 18)");
			inteligencia = pedirInt("Indique la inteligencia del jugador (Entre 12 y 16)");
			dios = pedirString("Indique el Dios");
			personaje = new Clerigo(nombre, raza, vida, fuerza, inteligencia, dios);
			break;
		default:
			System.out.println("Clase desconocida.");
			break;
		}

		return personaje;
	}

	private static Raza pedirRaza() {
		boolean error;
		Raza raza = null;

		do {
			System.out.println("Indique el tipo de raza que desee" + Arrays.toString(Raza.values()));
			try {
				raza = Raza.valueOf(in.nextLine().toUpperCase());
				error = false;
			} catch (IllegalArgumentException e) {
				System.out.println("raza desconocida");
				error = true;
			}
		} while (error);
		return raza;
	}

	private static int pedirClase() {
		System.out.println("Indique que clase desea crear");
		System.out.println("1. Mago");
		System.out.println("2. Hechicero");
		return pedirInt("1/2");
	}

	private static void accionMenu(int opc, PersonajesArray juego) {
		Personaje personaje;
		String hechizo, nombrePersonaje1, nombrePersonaje2;

		try {
			switch (opc) {
			case 1:
				personaje = crearJugador();
				juego.altaPersonaje(personaje);
				break;
			case 2:
				hechizo = pedirString("Indique el hechizo a aprender");
				nombrePersonaje1 = pedirString("Indique el nombre del Mago");
				juego.magoAprendeHechizo(nombrePersonaje1, hechizo);
				break;
			case 3:
				hechizo = pedirString("Indique el hechizo a lanzar");
				nombrePersonaje1 = pedirString("Indique el nombre del Mago atacante");
				nombrePersonaje2 = pedirString("Indique el nombre del Mago atacado");
				juego.MagoLanzaHechizo(nombrePersonaje1, nombrePersonaje2, hechizo);
				break;
			case 4:
				nombrePersonaje1 = pedirString("Indique el nombre del Clerigo que curará");
				nombrePersonaje2 = pedirString("Indique el nombre del personaje a curar");
				juego.clerigoCura(nombrePersonaje1, nombrePersonaje2);
				break;
			case 5:
				System.out.println("Personajes:");
				System.out.println(juego.mostrarListaPersonajes());
				break;
			case 6:
				System.out.println("Personajes:");
				System.out.println(juego.mostrarListaPersonajesOrdenador());
				break;
			case 7:
				System.out.println("Saliendo");
				break;
			default:
				System.out.println("Opcion desconocida");
				break;
			}
		} catch (PersonajeException e) {
			System.out.println(e.getMessage());
		}
	}
}

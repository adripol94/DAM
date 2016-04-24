package com.monroy.principal;
import com.monroy.modulo.*;

public class principal {
	
	public static void main(String[] args) {
		try {
			Personaje A = new Mago("Pocholo", Raza.ORCO, 17, 14, 100);
			Personaje B = new Mago("Fukencio", Raza.HUMANO, 15, 13, 80);
			Personaje C = new Clerigo("Shurmano", Raza.ELFO, 100, 19, 15, "Superman");
			
			System.out.println(A.imprimirPersonaje() + "\n" +  B.imprimirPersonaje() + "\n" + C.imprimirPersonaje());
			System.out.println();
			aprenderDosHechizos(A, 2);
			aprenderDosHechizos(B, 1);
			System.out.println();
			System.out.println(A.imprimirPersonaje() + "\n" +  B.imprimirPersonaje());
			
			System.out.println();
			lanzarHechizo(A, B, "Beso vaca");
			lanzarHechizo(B, A, "Cuerda huida");
			curar(C, B, "Superman");
			lanzarHechizo(A, B, "Cuerda huida");
			System.out.println();
			System.out.println(A.imprimirPersonaje() + "\n" +  B.imprimirPersonaje() + "\n" + C.imprimirPersonaje());

			
		} catch (PersonajeException e) {
			e.printStackTrace();
		}

	}

	private static void curar(Personaje c, Personaje b, String string) throws PersonajeException {
		Clerigo clerigo;
		if (!(c instanceof Clerigo))
			throw new PersonajeException("No es un clerigo");
		clerigo = (Clerigo) c;
		clerigo.rezar(b);
		System.out.println(clerigo.getNombre() + " cura a " + b.getNombre());
	}

	private static void lanzarHechizo(Personaje a, Personaje b, String hechizo) throws PersonajeException {
		Mago mago;
		if (!(a instanceof Mago))
			throw new PersonajeException("No es un mago");
		mago = (Mago) a;
		mago.lanzarHechizo(b, hechizo);
		System.out.println("El clerigo " + a.getNombre() + " lanzo un hechizo a " + b.getNombre());
	}

	private static void aprenderDosHechizos(Personaje a, int n) throws PersonajeException {
		Mago mago;
		String hechizos[] = {"Cuerda huida", "Beso vaca"};
		
		if (!(a instanceof Mago))
			throw new PersonajeException("No es un mago");
		mago = (Mago) a;
		for (int i = 0; i < n; i++) {
			mago.aprenderHechizo(hechizos[i]);
		}
		System.out.println("El mago " + mago.getNombre() + " ha aprendido " + n + " hechizos");
	}
	
	
	
}

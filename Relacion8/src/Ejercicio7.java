import java.util.Scanner;

/**
 * Ejercicio:
 * Realizar un programa que solicite una frase e informe de cuantas veces aparecen cada una de las letras del 
 * abecedario en la frase (solo se mostrarán las letras que aparezcan al menos una vez).
 * 
 * @author Adrian Pol
 *
 */
public class Ejercicio7 {
	private static Scanner in = new Scanner(System.in);
	private static final int ASCII = 65;

	public static void main(String[] args) {
		String frase;
		int[] contador = new int[26];

		frase = pedirFrase();
		contarLetras(contador, frase);
		resultado(contador);

	}

	private static String pedirFrase() {
		boolean error;
		String out = "";

		do {
			System.out.println("Introduzca una frase por favor");

			out = in.nextLine();
			error = false;

			if (out.isEmpty()) {
				System.out.println("introduzca un dato por favor");
				error = true;
			}
		} while (error);
		return out;
	}

	private static void contarLetras(int[] v, String frase) {
		int n;
		char c;
		
		for (int i = 0; i < frase.length(); i++) {
			c = Character.toUpperCase(frase.charAt(i));
			n = c;
			if (Character.isLetter(c))
				v[n-ASCII]++;
		}
	}

	public static void resultado(int[] v) {
		boolean ningunaVez = true; // Alguna vez se ha repedito alguna letra, de
									// no ser asi devolvera otra cadena afimando
									// eso.
		char c;
		System.out.println("Numero de veces que se repite cada letra:");

		for (int i = 0; i < v.length; i++) {

			if (v[i] != 0) {
				c = (char) (i + ASCII);
				System.out.println("Numero de veces que se repite " + c + " : " + v[i]);
				ningunaVez = false;
			}
		}
		if (ningunaVez)
			System.out.println("No se ha repetido ninguna palabra");
	}
}
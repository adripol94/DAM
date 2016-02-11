import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {
	private static Scanner in = new Scanner(System.in);
	private static final char GUION = '-';
	private static final int MAXIMO_INTENTOS = 7;

	public static void main(String[] args) {
		String[] palabras = { "hola", "pizza", "sueño", "coche", "ordenador", "teclado", "meme", "bicicleta", "variable", "arbol" };
		String p = palabraAleatoria(palabras);

		String palabraOut = ahorcado(p);
		System.out.println("Palabra: " + palabraOut + ". Palabra a encontrar: " + p + ".");
		
		if (palabraOut.equals(p))
			System.out.println("Enhorabuena bien hecho");
		else
			System.out.println("Otra vez sera");
	}

	private static String ahorcado(String palabra) {
		char l;
		int pos, intentos = 0, c, encontrado = 0;

		StringBuilder p = new StringBuilder(esconderPalabra(palabra));

		while (encontrado < palabra.length() && intentos < MAXIMO_INTENTOS) {
			pos = -1;
			c = 0; // C indicara el numero de veces que se ha encontrado el caracter, si no se encuentra ninguna saltara un intento (c==0).
			System.out.println(p);
			l = pedirLetra(intentos);

			// Buscador: Empezara a buscar el char indicado anteriormente (l) desde la posicion (0 desde el principio) si encuentra algo lo sustituye sino 
			// suma intentos dara una vuelta mas para comprobar si ese mismo caracter se vuelve a repetir desde la ultima posicion encontrada (pos+1).
			do {
				pos = palabra.indexOf(l,pos+1);
				
				if (pos != -1) {
					p.setCharAt(pos, l);
					c++;
					encontrado++;
				}
				else if (c == 0)
					intentos++;
			} while (pos != -1);
		}
		return p.toString();
	}

	// Crea una palabra nueva introduciendo tantos guiones como largo sea el String
	private static String esconderPalabra(String palabra) {
		StringBuilder p = new StringBuilder(palabra.length());
		
		for (int i = 0; i < palabra.length(); i++) {
			p.append(GUION);
		}
		return p.toString();
	}

	private static String palabraAleatoria(String[] v) {
		Random serie = new Random();
		int num;

		// Este metodo genera un numero aleatorio entre 0 y 10
		num = serie.nextInt(10);
		return v[num];
	}

	private static char pedirLetra(int nIntentos) {
		char l = ' '; // l = letra a introducir
		boolean error;

		do {
			System.out.println("Introduzca una letra (" + "Intentos: " + nIntentos + " de " + MAXIMO_INTENTOS + ").");
			try {
				l = Character.toLowerCase(in.nextLine().charAt(0));
				error = false;

			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("valor vacio.");
				error = true;
			}

		} while (error);
		return l;
	}
}

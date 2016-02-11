import java.util.Scanner;

/**
 * Realiza un programa que permita calcular el número de elementos positivos,
 * negativos y ceros de un vector de 10 enteros. Los elementos del vector serán
 * introducidos por teclado.
 * 
 * @author adripol94
 *
 */
public class Ejercicio1 {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int numeros[] = new int[10], elementos[] = new int[3];


		pedirNumeros(numeros);

		elementos = contarElementos(numeros);
		System.out.println("Numero total de ceros " + elementos[0]);
		System.out.println("Numero total de Negativos " + elementos[1]);
		System.out.println("numero total de positivos " + elementos[2]);
	}

	private static void pedirNumeros(int[] vector) {
		int num = 0;
		boolean error;

		for (int i = 0; i < vector.length; i++) {
			do {
				try {
					System.out.println("Introduzca un numero por favor" + (i+1));
					num = Integer.parseInt(in.nextLine());
					error = true;
				} catch ( NumberFormatException e) {
					error = true;
					System.out.println("Caracter no valido!");
				}
			} while (!error);
			vector[i] = num;
		}

	}

	private static int[] contarElementos(int num[]) {
		int numNegativos = 0, numPositivos = 0, numCeros = 0, totalElementos[] = new int[3];

		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0)
				numCeros++;
			else {
				if (num[i] < 0)
					numNegativos++;
				else
					numPositivos++;
			}
		}
		totalElementos[0] = numCeros;
		totalElementos[1] = numNegativos;
		totalElementos[2] = numPositivos;
		return totalElementos;
	}

}

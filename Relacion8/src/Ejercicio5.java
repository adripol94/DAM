import java.util.Scanner;
import java.util.Arrays;

/**
 * Realiza un programa que cargue un vector con n elementos. El programa debe imprimir los elementos del vector y 
 * después desplazarlos una posición, de tal forma que el último pase a la primera posición, el primero a la segunda,
 * el segundo a la tercera, y así sucesivamente. Después imprime los elementos del vector<br>
 * 
 * Vectororiginal: 51023041568839 Vectordesplazado:95102304156883<br>
 * NOTA: No podrá utilizarse vectores auxiliares
 * <blockquote>
 * </blockquote>
 * <br>
 * 
 * @author Adrian Pol
 *
 */
public class Ejercicio5 {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n, vector[];
		
		n = numeroElemento();
		vector = new int[n];
		pedirElementos(n, vector);
		System.out.println(Arrays.toString(vector));
		cambiarElementos(vector);
		System.out.println(Arrays.toString(vector));
	}
	
	private static int numeroElemento() {
		int n = 0;
		boolean error;
		do {
			System.out.println("Indique el numero de elementos que tendra el Vector");
			try {
				n = Integer.parseInt(in.nextLine());
				error = false;
			} catch (NumberFormatException e) {
				System.out.println("caracter no aceptado");
				error = true;
			}
		} while (error);
		return n;
	}
	/* @param i Numero de elementos a introducir */
	private static void pedirElementos(int i, int[] v) {
		int n;
		boolean error;
		
		for (int c = 0; c < i; c++) {
			do {
				System.out.println("Indique un numero para el elemento " + (c+1) + " de " + (i));
				try {
					n = Integer.parseInt(in.nextLine());
					error = false;
					v[c] = n;
				} catch (NumberFormatException e) {
					System.out.println("caracter no aceptado!");
					error = true;
				}
			} while (error);
		}
	}
	
	private static void cambiarElementos(int[] v) {
		int n = v[v.length - 1];
		for (int i = v.length-1; i > 0; i--) {
			v[i] = v[i-1];
		}
		v[0] = n;
	}
}

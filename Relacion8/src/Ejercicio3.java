import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int vector[] = new int[15], n, minimo = 1001, maximo = 0;
	
		for (int i = 0; i < vector.length; i++) {
			n = verificarNumero(vector, i);
			vector[i] = n;
			
			if (minimo > n)
				minimo = n;
			if (maximo < n)
				maximo = n;
		}
		
		System.out.println("Vector completo " + Arrays.toString(vector));
		System.out.println("Minimo numero del vector = " + minimo);
		System.out.println("Maximo numero del vector = " + maximo);
	}

	private static int solicitarNumero(int i) {
		int n = 0;
		System.out.println("Introduzca un numero del 1 al 1000 (" + (i+1) + ")");
		
		try {
			n = Integer.parseInt(in.nextLine());
			
		} catch (NumberFormatException e) {
			System.out.println("Caracter no valido");
		}	
		return n;
	}
	
	private static int verificarNumero(int[] vector, int i) {
		boolean encontrado;
		int c = 0, n, cantidadIntroducidaVector = 0;
		
		do {
			encontrado = false;
			n = solicitarNumero(i);
			
			while (!encontrado && c < cantidadIntroducidaVector) {
				if (vector[c] == n) {
					System.out.println("ese numero ya se ha introducido");
					encontrado = true;
				}
				c++;
			}
			c = 0;
		} while (n < 1 || n > 1000 || encontrado);
		cantidadIntroducidaVector++;
		return n;
	}
}

import java.util.Scanner;

public class Ejercicio2 {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int cantidadNumerosPedir;
		int vector[], vectorOut[];

		cantidadNumerosPedir = CantidadNumeros();
		vector = new int[cantidadNumerosPedir];

		pedirNumeros(vector);

		vectorOut = numerosImparesPosicionPar(vector);

		for (int i = 0; i < vectorOut.length; i++) {
			System.out.println("Numeros impares posiciones Par " + vectorOut[i]);
		}
		System.out.println("Media " + mediaNumerosPares(vector));
	}

	private static void pedirNumeros(int[] v) {
		int num = 0;
		boolean error;

		for (int i = 0; i < v.length; i++) {
			do {
				System.out.println("Introduzca un numero");
				try {
					num = Integer.parseInt(in.nextLine());
					error = false;
				} catch ( NumberFormatException e) {
					System.out.println("Caracter no numerico");
					error = true;
				}
			} while (error);
			v[i] = num;
		}
	}

	private static int CantidadNumeros() {
		boolean error;
		int num = 0;

		do {
			System.out.println("Indique cuantos numeros desea introducir");
			try {
				num = Integer.parseInt(in.nextLine());
				error = false;
			} catch (NumberFormatException e) {
				System.out.println("Caracter no numerico");
				error = true;
			}
		} while (error);
		return num;
	}

	private static int[] numerosImparesPosicionPar(int[] vectorP) {
		int vector[] = devolverPosicionesPar(vectorP);
		int vectorOut[] = new int[vector.length];
		int contadorVector = 0;

		for (int i = 0; i < vector.length; i++) {
			if (vector[i] % 2 == 1) {
				vectorOut[contadorVector] = vector[i];
				contadorVector++;
			}
		}
		return vectorOut;
	}

	private static int[] devolverPosicionesPar(int[] vector) {
		int vectorImpar[] = new int[vector.length];
		int contadorVect = 0;

		for (int i = 1; i < vector.length; i += 2) {
			vectorImpar[contadorVect] = vector[i];
			contadorVect++;
		}
		return vectorImpar;
	}

	public static double mediaNumerosPares(int[] vector) {
		double result = 0;

		for (int i = 0; i < vector.length; i++) {
			if (vector[i] % 2 == 0)
				result += vector[i];
		}
		return result / vector.length;
	}
}

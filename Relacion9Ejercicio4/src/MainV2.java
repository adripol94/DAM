import java.util.Random;

import Matematicas.*;

public class MainV2 {

	public static void main(String[] args) {
		try {
			MatecaticasMatrizV2 matriz = new MatecaticasMatrizV2(3, 3);
			MatecaticasMatrizV2 matriz2 = new MatecaticasMatrizV2(3, 3);

			matriz.añadirValor(new int[] { 2, 0, 1, 3, 0, 0, 5, 1, 1 });
			matriz2.añadirValor(new int[] { 1, 0, 1, 1, 2, 1, 1, 1, 0 });
			System.out.println(matriz + "\n" + matriz2);

			MatecaticasMatrizV2 out = matriz.multiplicar(matriz2);
			System.out.println(out);

			 System.out.println("Matriz actual: ");
			 System.out.println(matriz);
			
			 pruebaRellenar(matriz);
			 System.out.println("Matriz rellenada: \n" + matriz);
			 pruebaBuscar(matriz);
			 pruebaSumar(matriz);
			 pruebaRestar(matriz);
			 pruebaMultiplicar(matriz);
			 pruebaDiagonal(matriz);
			
			 System.out.println("Prueba finalizada sin errores");

		} catch (MatrizMatematicasException e) {
			e.printStackTrace();
		}

	}

	private static void pruebaRellenar(MatecaticasMatrizV2 matriz) throws MatrizMatematicasException {
		System.out.println("Prueba rellenar Matriz");
		System.out.println("Cantidad " + matriz.matrizCantidadRellenada());
		Random aleatorio = new Random();

		for (int i = 0; i < matriz.length(); i++) {

			matriz.añadirValor(aleatorio.nextInt(10));
			System.out.println("Cantidad " + matriz.matrizCantidadRellenada());
		}
	}

	private static void pruebaDiagonal(MatecaticasMatrizV2 matriz) {
		System.out.println("Prueba Producto en diagonal: ");
		int n = matriz.productoDiagonal();
		System.out.println(n);
	}

	private static void pruebaMultiplicar(MatecaticasMatrizV2 matriz) {
		System.out.println("Prueba Multiplicar la Matriz x 2");
		matriz.multiplicar(2);
		System.out.println(matriz);
	}

	private static void pruebaRestar(MatecaticasMatrizV2 matriz) throws MatrizMatematicasException {
		int[][] m = { { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println("Prueba restar en la matriz");
		MatecaticasMatrizV2 out = matriz.resta(m);
		System.out.println(out);
	}

	private static void pruebaSumar(MatecaticasMatrizV2 matriz) throws MatrizMatematicasException {
		int[][] m = { { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println("Prueba sumar en la matriz");
		MatecaticasMatrizV2 out = matriz.suma(m);
		System.out.println(out);
	}

	private static void pruebaBuscar(MatecaticasMatrizV2 matriz) {
		System.out.println("Prueba de buscar");

		if (matriz.search(20))
			System.out.println("Numero 20 encontrado");
		else
			System.out.println("Numero 20 no encontrado");

	}
}

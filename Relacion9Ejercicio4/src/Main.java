import Matematicas.*;

public class Main {

	public static void main(String[] args) {
		try {
			MatrizMatematica matriz = new MatrizMatematica(4, 4, 10);

			System.out.println("Matriz Actual \n" + matriz);
			
			 pruebaBuscar(matriz);
			 pruebaSumar(matriz);
			 pruebaRestar(matriz);
			 pruebaMultiplicar(matriz);
			 pruebaDiagonal(matriz);
			
			 System.out.println("--------------Prueba finalizada sin errores-------------");

		} catch (MatrizMatematicasException e) {
			e.printStackTrace();
		}

	}


	private static void pruebaDiagonal(MatrizMatematica matriz) {
		System.out.println("Prueba Producto en diagonal: ");
		int n = matriz.productoDiagonal();
		System.out.println(n);
	}

	private static void pruebaMultiplicar(MatrizMatematica matriz) {
		System.out.println("Prueba Multiplicar la Matriz x 2");
		matriz.multiplicar(2);
		System.out.println(matriz);
	}

	private static void pruebaRestar(MatrizMatematica matriz) throws MatrizMatematicasException {
		MatrizMatematica m = new MatrizMatematica(4,4,10);
		System.out.println("Prueba restar en la matriz----------------");
		System.out.println("Matriz a restar \n" + m);
		MatrizMatematica out = matriz.restar(m);
		System.out.println("Matriz Resultado \n" + out);
	}

	private static void pruebaSumar(MatrizMatematica matriz) throws MatrizMatematicasException {
		MatrizMatematica m = new MatrizMatematica(4, 4, 10);
		System.out.println("Prueba sumar en la matriz----------------");
		System.out.println("Matriz a Sumar \n" + m);
		MatrizMatematica out = matriz.sumar(m);
		System.out.println("Matriz Resultado \n" + out);
	}

	private static void pruebaBuscar(MatrizMatematica matriz) {
		System.out.println("Prueba de buscar--------------------");

		if (matriz.buscar(20))
			System.out.println("Numero 20 encontrado \n");
		else
			System.out.println("Numero 20 no encontrado \n");

	}
}


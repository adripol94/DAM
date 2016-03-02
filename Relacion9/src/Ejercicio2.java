import java.util.Random;

/**
 * Realizar un programa que cargue aleatoriamente una matriz de 5 x3 elementos con números de 1 a 100, 
 * la imprima y calcule :
 * <li>La media de los elementos pares.<br>
 * <li>El máximo elemento de cada fila y el mínimo de cada columna.</li>
 * @author Adrian Pol
 *
 */
public class Ejercicio2 {
	private static final int MAXIMO = 100;
	
	public static void main(String[] args) {
		int[][] matriz = new int[5][3];
		
		rellenarMatriz(matriz);
		int media = mediaPares(matriz);
		int[][] salida = maximoMinimo(matriz);
		imprimirArray(salida);
		System.out.println("Media de numeros pares " + media);
		System.out.println("\n Matriz:");
		System.out.println(toString(matriz));
	}
	
	private static String toString(int matriz[][]) {
		StringBuilder str = new StringBuilder(matriz.length);
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				str.append("[" + matriz[i][j] + "] ");
			}
			str.append("\n");
		}
		return str.toString();
	}
		

	private static void imprimirArray(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.println("Fila numero " + i + " Valor Maximo: " + matriz[i][0] + " Valor Minimo: " + matriz[i][1]);
		}
	}

	private static int random() {
		Random aleatorio = new Random();
		return aleatorio.nextInt(MAXIMO);
	}
	
	private static void rellenarMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = random();
			}
		}
	}
	
	private static int mediaPares(int[][] matriz) {
		int n = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] % 2 == 0) {
					n += matriz[i][j];
				}
			}
		}
		return n;
	}
	
	private static int[][] maximoMinimo(int[][] matriz) {
		int[][] out = new int[matriz.length][2];
		
		for (int i = 0; i < matriz.length; i++) {
			out[i][0] = matriz[i][0];
			out[i][1] = matriz[i][1];
			for (int j = 0; j < matriz[0].length; j++) {
				if (out[i][0] < matriz[i][j])
					out[i][0] = matriz[i][j];
				else if (out[i][1] > matriz[i][j])
					out[i][1] = matriz[i][j];
			}
		}
		return out;
	}
}

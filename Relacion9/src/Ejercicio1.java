import java.util.Random;

/**
 * Realizar un programa que cargue una matriz de enteros de 3 x 4 con números aleatorios de de 1 a 1000.
 * El programa imprimirá la matriz y calculará su elemento mínimo informando de la posición (fila, columna)
 * en la que se encuentra.
 * @author Adrian Pol
 *
 */
public class Ejercicio1 {
	private static final int MAXIMO = 1000;

	public static void main(String[] args) {
		int[][] numeros = new int[3][4];
		
		rellenarMatriz(numeros);
		int[] posicion = calcularMinimo(numeros);
		System.out.println("El numero minimo es " + posicion[2] + "; Posicionado en fila: [" + posicion[0] +
				"] Columna; [" + posicion[1] + "]");
		System.out.println("La matriz contenía los numeros:");
		System.out.println(toString(numeros));
	}
	
	private  static int random() {
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
	
	private static int[] calcularMinimo(int matriz[][]) {
		int minimo = MAXIMO;
		int[] out = new int[3];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] < minimo) {
					out[0] = i;
					out[1] = j;
					minimo = matriz[i][j];
				}
			}
		}
		out[2] = minimo;
		return out;
	}
	
	private static String toString(int matriz[][]) {
		StringBuilder str = new StringBuilder(matriz.length);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				str.append("[" + matriz[i][j] + "] ");
			}
		}
		return str.toString();
	}
}

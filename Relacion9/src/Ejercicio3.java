import java.util.Random;

public class Ejercicio3 {

	public static void main(String[] args) {
		int[][] matriz = new int[4][4];
		
		System.out.println("Rellenando tabla");
		rellenarMatriz(matriz);
		System.out.println(toString(matriz));
		System.out.println("Intercambiar filas por columnas");
		intercambioFilaColumna(matriz);
		System.out.println("Nueva Matriz");
		System.out.println(toString(matriz));
	}

	private static String toString(int[][] matriz) {
		StringBuilder str = new StringBuilder(matriz.length * matriz.length);
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				str.append("[ " + matriz[i][j] + "]");
			}
			str.append("\n");
		}
		
		return str.toString();
	}

	private static int random() {
		Random aleatorio = new Random();
		return aleatorio.nextInt(10);
	}

	private static void rellenarMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = random();
			}
		}
	}

	private static void intercambioFilaColumna(int m[][]) {
		int aux;
		for (int i = 0; i < m.length; i++) {
			for (int j = i; j < m[i].length;  j++) {
				aux = m[i][j];
				m[i][j] = m[j][i];
				m[j][i] = aux;
			}
		}
	}
}

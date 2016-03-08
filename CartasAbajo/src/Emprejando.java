import java.util.Random;

public class Emprejando {
	private int[][] tablero;
	private boolean[][] posCasillasAcertadas;
	private int numeroAciertos;
	private final int TAMAÑO_TABLERO = 4;

	public Emprejando() {
		tablero = new int[TAMAÑO_TABLERO][TAMAÑO_TABLERO];
		// Aqui se guardaran las posiciones de las casillas acertadas.
		posCasillasAcertadas = new boolean[TAMAÑO_TABLERO][TAMAÑO_TABLERO];
		numeroAciertos = 0;
		rellenarTablero();
	}

	/**
	 * Comprara si son iguales o no, de ser así, se mantendaran visibles.
	 * 
	 * @param carta1
	 *            new int[] {fila, columna}
	 * @param carta2
	 *            new int[] {fila, columna}
	 */
	/*
	 * Lo abriremos a publico aunque no hace falta que se utilize pero por si
	 * acaso
	 */
	public boolean equals(int[] carta1, int[] carta2) {
		int filaCarta1 = carta1[0], filaCarta2 = carta2[0];
		int columnaCarta1 = carta1[1], columnaCarta2 = carta2[1];

		if (tablero[filaCarta1][columnaCarta1] == tablero[filaCarta2][columnaCarta2])
			return true;
		else
			return false;
	}

	/**
	 * Dispondra de 2 int[] uno para sacar la carta 1 y otro para la 2, el
	 * primer numero sera para fila el segundo para columna.<br>
	 * <blockquote> int[] = {fila y columna}; </blockquote>
	 * 
	 * @throws EmparejandoException
	 *             Cartas fuera de rango disponible.
	 * @throws EmparejandoFinException 
	 * 				Se hayan acertados todos las parejas.
	 */
	public String mostarCarta(int[] carta1, int[] carta2) throws EmparejandoException, EmparejandoFinException {
		StringBuilder str;
		if (carta1[0] < 0 && carta1[0] > TAMAÑO_TABLERO || carta1[1] < 0 && carta1[1] > TAMAÑO_TABLERO)
			throw new EmparejandoException("Carta 1 esta fuera del tablero");

		if (carta2[0] < 0 && carta2[0] > TAMAÑO_TABLERO || carta2[1] < 0 && carta2[1] > TAMAÑO_TABLERO)
			throw new EmparejandoException("Carta 2 esta fuera del tablero");

		str = new StringBuilder();

		for (int i = 0; i < TAMAÑO_TABLERO; i++) {
			for (int j = 0; j < TAMAÑO_TABLERO; j++) {
				if ((i == carta1[0] && j == carta1[1] || i == carta2[0] && j == carta2[1]) || posCasillasAcertadas[i][j])
					str.append("[" + tablero[i][j] + "]  ");
				else
					str.append("[ ]  ");
			}
			str.append("\n \n");
		}

		bloquearCarta(carta1, carta2);

		return str.toString();
	}

	/**
	 * En caso que sean iguales las cartas serán visible hasta el final del
	 * juego, comprueba si e juego ha terminado
	 * 
	 * @param carta1
	 * 		
	 * @param carta2
	 * @throws EmparejandoFinException 
	 */
	private void bloquearCarta(int[] carta1, int[] carta2) throws EmparejandoFinException {
		if (equals(carta1, carta2)) {
			posCasillasAcertadas[carta1[0]][carta1[1]] = true;
			posCasillasAcertadas[carta2[0]][carta2[1]] = true;
			numeroAciertos++;
			if (numeroAciertos == TAMAÑO_TABLERO)
				throw new EmparejandoFinException("Enhorabuena ha ganado!!");
		}
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < TAMAÑO_TABLERO; i++) {
			for (int j = 0; j < TAMAÑO_TABLERO; j++) {
				if (posCasillasAcertadas[i][j] == true)
					str.append("[" + tablero[i][j] + "]  ");
				else
					str.append("[ ]  ");
			}
			str.append("\n \n");
		}
		return str.toString();
	}

	/* numero 1 y 2 pertenece a los numeros introducidos para emparejar */
	private void rellenarTablero() {
		int fila, columna, numero1 = 1, numero2 = 1;

		while (numero2 <= TAMAÑO_TABLERO * 2 || numero1 <= TAMAÑO_TABLERO * 2) {
			fila = random();
			columna = random();

			if (tablero[fila][columna] == 0) {
				if (numero1 <= TAMAÑO_TABLERO * 2) {
					tablero[fila][columna] = numero1;
					numero1++;
				} else {
					tablero[fila][columna] = numero2;
					numero2++;
				}
			}
		}

	}

	private int random() {
		Random aleatorio = new Random();
		return aleatorio.nextInt(TAMAÑO_TABLERO);
	}

}

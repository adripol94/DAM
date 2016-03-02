import java.util.Random;

public class PisaMinas {
	private static StringBuilder[][] tablero;
	private static int posJugadorI, posJugadorJ;
	private static final String ICONO_JUGADOR = "J";
	private static final int NUMERO_MINAS = 3;
	private static final String ICONO_MINA = "M";
	private static final int TAMAÑO_TABLERO = 8;

	public static void iniciarJuego() {
		inicializacionJuego();

		Random aleatorio = new Random();
		int i, j, minimo = TAMAÑO_TABLERO / 2;
		int x = 0;

		// Posición Inicial
		tablero[posJugadorI][posJugadorJ].deleteCharAt(0);
		tablero[posJugadorI][posJugadorJ].append(ICONO_JUGADOR);

		// Colocación de las Minas
		while (x < NUMERO_MINAS) {
			i = aleatorio.nextInt(minimo);
			j = aleatorio.nextInt(minimo);
			if (!tablero[i][j].equals(ICONO_MINA) && !tablero[i][j].equals(ICONO_JUGADOR)) {
				tablero[i][j].deleteCharAt(0);
				tablero[i][j].append(ICONO_MINA);
				x++;
			}
		}
	}

	private static void inicializacionJuego() {
		int i, j;
		posJugadorI = 0;
		posJugadorJ = 0;

		i = TAMAÑO_TABLERO / 2;
		j = TAMAÑO_TABLERO / 2;
		tablero = new StringBuilder[i][j];

		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[0].length; columna++) {
				tablero[fila][columna] = new StringBuilder(" ");
			}
		}
	}
	
	public static void moverArriba() throws PisaMinasException, MinaException {
		if (posJugadorI == 0)
			throw new PisaMinasException("No puede mover más arriba");
		
		if (tablero[posJugadorI - 1][posJugadorJ].equals(ICONO_MINA))
			throw new MinaException("Ha pisado una mina");
		
		limpiarCasillaTablero();
		posJugadorI--;
		tablero[posJugadorI][posJugadorJ].deleteCharAt(0);
		tablero[posJugadorI][posJugadorJ].append(ICONO_JUGADOR);
		
	}
	
	public static void moverIzquierda() throws PisaMinasException, MinaException {
		if (posJugadorJ == 0)
			throw new PisaMinasException("No puede mover más a la izquierda");

		// FIXME No funciona
		if (tablero[posJugadorI][posJugadorJ - 1].equals(ICONO_MINA))
			throw new MinaException("Ha pisado una mina");
		
		limpiarCasillaTablero();
		posJugadorJ--;
		tablero[posJugadorI][posJugadorJ].deleteCharAt(0);
		tablero[posJugadorI][posJugadorJ].append(ICONO_JUGADOR);
	}
	
	public static void moverDerecha() throws PisaMinasException, MinaException {
		if (posJugadorJ == tablero[0].length)
			throw new PisaMinasException("No puede mover más a la derecha");
		
		if (tablero[posJugadorI][posJugadorJ + 1].equals(ICONO_MINA))
			throw new MinaException("Ha pisado una mina");
		
		limpiarCasillaTablero();
		posJugadorJ++;
		tablero[posJugadorI][posJugadorJ].deleteCharAt(0);
		tablero[posJugadorI][posJugadorJ].append(ICONO_JUGADOR);
	}
	
	public static void moverAbajo() throws PisaMinasException, MinaException {
		if (posJugadorI == tablero.length)
			throw new PisaMinasException("No puede mover más abajo");
		
		if (tablero[posJugadorI + 1][posJugadorJ].equals(ICONO_MINA))
			throw new MinaException("Ha pisado una mina");
		
		limpiarCasillaTablero();
		posJugadorI++;
		tablero[posJugadorI][posJugadorJ].deleteCharAt(0);
		tablero[posJugadorI][posJugadorJ].append(ICONO_JUGADOR);
	}

	private static void limpiarCasillaTablero() {
		tablero[posJugadorI][posJugadorJ].deleteCharAt(0);
		tablero[posJugadorI][posJugadorJ].append(" ");
	}
	
	public static String getTablero() {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				out.append("[" + tablero[i][j] + "]");
			}
			out.append("\n");
		}

		return out.toString();
	}

}

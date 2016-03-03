import java.util.Random;

public class PisaMinas {
	private static char[][] tablero;
	private static int posJugadorI, posJugadorJ;
	private static final char ICONO_JUGADOR = 'J';
	private static final int NUMERO_MINAS = 3;
	private static final char ICONO_MINA = 'M';
	private static final int TAMAÑO_TABLERO = 8;
	private static final int POS_INICIALF = 0;
	private static final int POS_INICIALC = 0;

	public static void iniciarJuego() {
		inicializacionJuego();

		Random aleatorio = new Random();
		int i, j, minimo = TAMAÑO_TABLERO / 2;
		int x = 0;

		// Posición Inicial
		tablero[posJugadorI][posJugadorJ] = (ICONO_JUGADOR);

		// Colocación de las Minas
		while (x < NUMERO_MINAS) {
			i = aleatorio.nextInt(minimo);
			j = aleatorio.nextInt(minimo);
			if (!(tablero[i][j] == ICONO_MINA) && !(tablero[i][j] == ICONO_JUGADOR) && j != 8 && i != 8) {
				tablero[i][j] = ICONO_MINA;
				x++;
			}
		}
	}

	private static void inicializacionJuego() {
		int i, j;
		posJugadorI = POS_INICIALF;
		posJugadorJ = POS_INICIALC;

		i = TAMAÑO_TABLERO / 2;
		j = TAMAÑO_TABLERO / 2;
		tablero = new char[i][j];

		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[0].length; columna++) {
				tablero[fila][columna] = ' ';
			}
		}
	}
	
	private static void comprobarFin() throws MinaException {
		if (posJugadorI == 8 && posJugadorJ == 8)
			throw new MinaException("Fin del juego!. Ha llegado a la meta");
	}
	
	public static void moverArriba() throws PisaMinasException, MinaException {
		if (posJugadorI == 0)
			throw new PisaMinasException("No puede mover más arriba");
		
		if (tablero[posJugadorI - 1][posJugadorJ] == ICONO_MINA)
			throw new MinaException("Ha pisado una mina");
		
		limpiarCasillaTablero();
		posJugadorI--;
		tablero[posJugadorI][posJugadorJ] = ICONO_JUGADOR;
		comprobarFin();
	}

	public static void moverIzquierda() throws PisaMinasException, MinaException {
		if (posJugadorJ == 0)
			throw new PisaMinasException("No puede mover más a la izquierda");

		// FIXME No funciona
		if (tablero[posJugadorI][posJugadorJ - 1] == ICONO_MINA)
			throw new MinaException("Ha pisado una mina");
		
		limpiarCasillaTablero();
		posJugadorJ--;
		tablero[posJugadorI][posJugadorJ] = ICONO_JUGADOR;
		comprobarFin();
	}
	
	public static void moverDerecha() throws PisaMinasException, MinaException {
		if (posJugadorJ == tablero[0].length)
			throw new PisaMinasException("No puede mover más a la derecha");
		
		if (tablero[posJugadorI][posJugadorJ + 1] == ICONO_MINA)
			throw new MinaException("Ha pisado una mina");
		
		limpiarCasillaTablero();
		posJugadorJ++;
		tablero[posJugadorI][posJugadorJ] = ICONO_JUGADOR;
		comprobarFin();
	}
	
	public static void moverAbajo() throws PisaMinasException, MinaException {
		if (posJugadorI == tablero.length)
			throw new PisaMinasException("No puede mover más abajo");
		
		if (tablero[posJugadorI + 1][posJugadorJ] == ICONO_MINA)
			throw new MinaException("Ha pisado una mina");
		
		limpiarCasillaTablero();
		posJugadorI++;
		tablero[posJugadorI][posJugadorJ] = ICONO_JUGADOR;
		comprobarFin();
	}

	private static void limpiarCasillaTablero() {
		tablero[posJugadorI][posJugadorJ] = ' ';
	}
	
	public static String getTablero() {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j] == ICONO_JUGADOR)
					out.append("[" + tablero[i][j] + "]");
				else
					out.append("[ ]");
			}
			out.append("\n");
		}

		return out.toString();
	}

}

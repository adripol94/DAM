public class Conecta4 {
	private final char ICONO_J1;
	private final char ICONO_J2;
	private int contadorFichas4;
	private int[] posFichas = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
	private char[][] tablero = new char[10][10];

	public Conecta4() {
		ICONO_J1 = 'R';
		ICONO_J2 = 'A';
	}

	private void comprobar4(int n) throws Conecta4FinException {
		char icono = tablero[posFichas[n]][n];

		comprobarVertical(n, icono);
		comprobarHorizontal(n, icono);

	}

	/**
	 * Por defecto entra dos veces en los bucles Der y Izq, una vez si o si en
	 * los bucles, por tanto deberemos restar el contador a -1 evitando asi que
	 * compruebe 2 veces la posicion en la que esta.
	 * 
	 * @param posColumna
	 *            Posicion de la columna.
	 * @param posFila
	 *            Posicion de la fila
	 * @throws Conecta4FinException
	 *             En caso de 4 rayas de daría esta exception.
	 */
	private void comprobarHorizontal(int n, char icono) throws Conecta4FinException {
		int posColumna = n;
		char casilla;
		contadorFichas4 = 0;
		
		casilla = tablero[posFichas[n]][posColumna];
		while (posColumna > 0 && casilla == icono) {
			posColumna--;
			casilla = tablero[posFichas[n]][posColumna];
			contadorFichas4++;
		}
		fichas4();
		
		posColumna = n;

		casilla = tablero[posFichas[n]][posColumna];
		while (posColumna < 9 && casilla == icono) {
			posColumna++;
			casilla = tablero[posFichas[n]][posColumna];
			contadorFichas4++;
		}

		fichas4();

	}

	private void comprobarVertical(int n, char icono) throws Conecta4FinException {
		char casilla;
		int posFila = posFichas[n];
		contadorFichas4 = 1;

			casilla = tablero[posFila][n];
			while (posFila < 9 && casilla == icono) {
				posFila++;
				casilla = tablero[posFila][n];
				contadorFichas4++;
			}
			fichas4();
	}

	private void fichas4() throws Conecta4FinException {
		if (contadorFichas4 == 4)
			throw new Conecta4FinException("Conecta 4: Enhorabuena a ganado el ");
	}

	/**
	 * Hará la gestión de introducir las fichas
	 * 
	 * @param n
	 *            Columna en la que se introducirá dicha ficha.
	 * @param j
	 *            Numero del jugador (j1 == true / false)
	 * @throws Conecta4Exception
	 *             Columna llena posFichas == 0
	 * @throws Conecta4FinException
	 *             Se dara cuando el juego haya terminado
	 */
	public void introducirFicha(int n, boolean j1) throws Conecta4Exception, Conecta4FinException {
		if (n < 0 || n > tablero.length)
			throw new Conecta4Exception("Posición no admitida");

		if (posFichas[n] < 0)
			throw new Conecta4Exception("Esta lleno de fichas!");

		if (j1 == true)
			tablero[posFichas[n]][n] = ICONO_J1;
		else
			tablero[posFichas[n]][n] = ICONO_J2;
		comprobar4(n);
		posFichas[n]--;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(tablero.length * tablero[0].length);

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j] == '\u0000') // \u0000 = null : Valor por
												// defecto de char.
					str.append("[ ]");
				else if (tablero[i][j] == 'R')
					str.append("[R]");
				else
					str.append("[A]");
			}
			str.append("\n");
		}
		return str.toString();
	}
}

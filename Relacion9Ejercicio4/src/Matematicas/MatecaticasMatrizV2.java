package Matematicas;

public class MatecaticasMatrizV2 {
	private Integer[][] matriz;
	private int f, c;
	private int cantidadNumerosIntroducidos;

	public MatecaticasMatrizV2(int i, int j) {
		f = i;
		c = j;
		matriz = new Integer[i][j];
		rellenarMatriz();
		cantidadNumerosIntroducidos = 0;
	}

	private void rellenarMatriz() {
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				matriz[i][j] = null;
			}
		}
	}

	public void borrarValor(int n) throws MatrizMatematicasException {
		if (!search(n) && cantidadNumerosIntroducidos == 0)
			throw new MatrizMatematicasException("Valor no encontrado");

		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				if (matriz[i][j] == n) {
					matriz[i][j] = null;
					cantidadNumerosIntroducidos--;
				}
			}
		}
	}

	public int matrizCantidadRellenada() {
		return cantidadNumerosIntroducidos;
	}

	public void añadirValor(int[] n) throws MatrizMatematicasException {
		if (cantidadNumerosIntroducidos >= f * c)
			throw new MatrizMatematicasException("No hay espacio disponible: " + cantidadNumerosIntroducidos);
		int i = 0, j, k = 0;

		while (k < n.length) {
			while (i < f) {
				j = 0;
				while (j < c) {
					if (matriz[i][j] == null) {
						matriz[i][j] = n[k];
						k++;
						cantidadNumerosIntroducidos++;
					}
					j++;
				}
				i++;
			}
		}
	}

	public void añadirValor(int n) throws MatrizMatematicasException {
		if (cantidadNumerosIntroducidos >= f * c)
			throw new MatrizMatematicasException("No hay espacio disponible: " + cantidadNumerosIntroducidos);
		boolean numeroIntroducido = false;
		int i = 0, j;

		while (i < f && !numeroIntroducido) {
			j = 0;
			while (j < c && !numeroIntroducido) {
				if (matriz[i][j] == null) {
					matriz[i][j] = n;
					cantidadNumerosIntroducidos++;
					numeroIntroducido = true;
				}
				j++;
			}
			i++;
		}
	}

	/**
	 * Sumará los numeros de una matriz a introducir.
	 * 
	 * @param m
	 *            Matriz int
	 * @return Matriz int
	 * @throws MatrizMatematicasException
	 *             Que el tamaño del objeto sea diferente al tamaño de la matriz
	 *             introducida.
	 */
	public MatecaticasMatrizV2 suma(int[][] m) throws MatrizMatematicasException {
		return cuentaBasica(m, true);
	}

	/**
	 * Restará los numeros de una matriz a introducir.
	 * 
	 * @param m
	 *            Matriz int
	 * @return Matriz int
	 * @throws MatrizMatematicasException
	 *             Que el tamaño del objeto sea diferente al tamaño de la matriz
	 *             introducida.
	 */
	public MatecaticasMatrizV2 resta(int[][] m) throws MatrizMatematicasException {
		return cuentaBasica(m, false);
	}

	private MatecaticasMatrizV2 cuentaBasica(int[][] m, boolean suma) throws MatrizMatematicasException {
		MatecaticasMatrizV2 out;
		if (m.length != f && c != m[0].length)
			throw new MatrizMatematicasException("Diferencia en las dimensiones");

		out = new MatecaticasMatrizV2(m.length, m[0].length);

		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				if (suma)
					out.matriz[i][j] = matriz[i][j] + m[i][j];
				else
					out.matriz[i][j] = matriz[i][j] - m[i][j];
			}
		}
		return out;
	}

	/**
	 * Multpilicara todos los numeros introducidos (editara el valor original
	 * del objeto).
	 * 
	 * @param n
	 *            Numero a multiplicar
	 */
	public void multiplicar(int n) {
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				matriz[i][j] *= n;
			}
		}
	}

	public boolean search(int n) {
		int i = 0, j = 0;
		boolean find = false;

		while (i < f && !find) {
			while (j < c && !find) {
				if (matriz[i][j] == n)
					find = true;
				j++;
			}
			i++;
			j = 0;
		}
		return find;
	}

	public int productoDiagonal() {
		int result = 1;
		for (int i = 0; i < f; i++) {
			result *= matriz[i][i];
		}
		return result;
	}

	public MatecaticasMatrizV2 multiplicar(MatecaticasMatrizV2 m) throws MatrizMatematicasException {
		int k = 0, y, x;
		MatecaticasMatrizV2 matriz = new MatecaticasMatrizV2(f, c);
		for (int c = 0; c < m.matriz.length; c++) {
			for (int i = 0; i < m.matriz.length; i++) {	
				for (int j = 0; j < m.matriz.length; j++) {
					x = m.matriz[j][i];
					y = this.matriz[c][j];
					k = (y * x) + k;
				}
				matriz.añadirValor(k);
				k = 0;
			}
		}
		return matriz;
	}

	public int length() {
		return f * c;
	}

	public boolean equals(MatecaticasMatrizV2 m) {
		boolean equals = true;
		int i = 0, j = 0;

		while (i < f && equals) {
			while (j < c && equals) {
				if (matriz[i][j] != m.matriz[i][j])
					equals = false;
			}
		}
		return equals;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(f * c);

		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				if (matriz[i][j] == null)
					str.append("[" + "0" + "]");
				else
					str.append("[" + matriz[i][j] + "]");
			}
			str.append("\n");
		}
		return str.toString();
	}
}

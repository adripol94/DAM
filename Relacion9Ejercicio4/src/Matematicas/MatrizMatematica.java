package Matematicas;

import java.util.Random;

/**
 * Realizar una Clase MatrizMatematica con al menos los métodos que se indican.
 * Se debe incluir una excepción propia para las condiciones de error.<br>
 * <li>Constructor donde se indique el número de filas y columnas de la matriz
 * <li>Método toString
 * <li>Método equals (dos matrices son iguales si todos sus elementos son iguales)
 * <li>Método para sumar una matriz con otra. Debe devolver la matriz resultado de la suma. 
 * Tener en cuenta que sólo se puede sumar dos matrices si tienen las mismas dimensiones
 * <li>Idem para la resta de matrices.
 * <li>Método para multiplicar un número por una matriz. La matriz original debe modificarse multiplicando
 * todos los elementos por ese número.
 * <li>Método que busque un elemento en una matriz. Debe devolver un boolean.
 * <li>Método para calcular el producto de todos los elementos de la diagonal principal de la matriz.</li><br>
 * Realizar también el programa principal probando estos métodos
 * @author Adrian Pol
 *
 */
public class MatrizMatematica {
	private int[][] m;
	private int i;
	private int j;
	
	/**
	 * Constructor para crear Matriz Matematicas vacia.
	 * @param i numero filas
	 * @param j numero columnas
	 * @throws MatrizMatematicasException parametros < 0
	 */
	public MatrizMatematica(int i, int j) throws MatrizMatematicasException {
		if (i < 0 || j < 0)
			throw new MatrizMatematicasException("Parametros menor que 0");
		this.i = i;
		this.j = j;
		m = new int[i][j];
	}
	
	/**
	 * Constructor para crear Matriz Matematica rellenada automaticamente.
	 * @param i tamaño de filas
	 * @param j tamaño de columnas
	 * @param t numero maximo para Random
	 * @throws MatrizMatematicasException numeros < 0 
	 */
	public MatrizMatematica(int i, int j, int t) throws MatrizMatematicasException {
		if (i < 0 || j < 0 || t < 0)
			throw new MatrizMatematicasException("Parametros menor que 0");
		this.i = i;
		this.j = j;
		m = new int[i][j];
		inicializacion(m, t);
	}
	
	private void inicializacion(int[][] m, int t) {
		Random aleatorio = new Random();
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = aleatorio.nextInt(t);
			}
		}
	}

	public String toString() {
		StringBuilder str = new StringBuilder(m.length * m[0].length);
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				str.append("[" + m[i][j] + "]");
			}
			str.append("\n");
		}
		return str.toString();
	}
	
	public boolean equals(int[][] m) {
		int i = 0,j = 0;
		boolean equals = true;
		
		if (!sameDimensions(m))
			return false; // Return porque es la unica manero que sé en el se evitara pasar por
						  // while sin poner un condicional.
		
		while (i < m.length && equals) {
			while (j < m[0].length && equals) {
				if (this.m[i][j] != m[i][j])
					equals = false;
				j++;
			}
			i++;
		}
		return equals;
	}
	
	private boolean sameDimensions(int[][] m) {
		if (this.m.length == m.length && this.m[0].length == m[0].length)
			return true;
		return false;
	}
	
	public MatrizMatematica sumar(MatrizMatematica m) throws MatrizMatematicasException {
		return matrizAcction(m.m, true);
	}
	
	public MatrizMatematica restar(MatrizMatematica m) throws MatrizMatematicasException {
		return matrizAcction(m.m, false);
	}
	
	private MatrizMatematica matrizAcction(int[][] m, boolean n) throws MatrizMatematicasException {
		if (!sameDimensions(m))
			throw new MatrizMatematicasException("Matrices con distintas dimensiones");
		MatrizMatematica matrizOut = new MatrizMatematica(m.length, m[0].length);
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (n)
					matrizOut.m[i][j] = this.m[i][j] + m[i][j];
				else
					matrizOut.m[i][j] = this.m[i][j] - m[i][j];
			}
		}
		return matrizOut;
	}
	
	public void multiplicar(int n) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = m[i][j] * n;
			}
		}
	}
	
	public boolean buscar(int n) {
		boolean find = false;
		int i = 0, j = 0;
		
		while (i < m.length && !find) {
			while (j < m[0].length && !find) {
				if (m[i][j] == n)
					find = true;
				j++;
			}
			i++;
		}
		return find;
	}
	
	public int productoDiagonal() {
		int result = 1;
		for (int i = 0; i < m.length; i++) {
			result *= m[i][i];
		}
		return result;
	}
	
	
	public int length() {
		return i * j;
	}
}

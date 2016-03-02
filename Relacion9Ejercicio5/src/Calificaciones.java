
/*
 * Filas = Alumnos
 * Columnas = Asignaturas
 */
public class Calificaciones {
	private int posAlumnoMatriz;
	private int[][] dam;
	private final String[] ASIGNATURAS = { "PROG", "BD", "LM", "ENDES", "FOL" };
	private final int NUMERO_ALUMNOS = 30;
	private final int NUMERO_ASIGNATURAS = 5;

	public Calificaciones() {
		dam = new int[NUMERO_ALUMNOS][NUMERO_ASIGNATURAS];
		posAlumnoMatriz = 0;
	}

	public String obtenerAsignaturas(int i) {
		return ASIGNATURAS[i];
	}

	public int length() {
		return NUMERO_ALUMNOS * NUMERO_ASIGNATURAS;
	}

	public void setAlumno(int[] notas) throws CalificacionesException {
		if (notas.length == dam[0].length + 1)
			throw new CalificacionesException("Notas dirente al numero de asignaturas");
		if (posAlumnoMatriz >= dam.length)
			throw new CalificacionesException("Maximo de notas superado");

		// FIXME dam[posAlumnoMatriz] = notas;
		for (int j = 0; j < NUMERO_ASIGNATURAS; j++) {
			dam[posAlumnoMatriz][j] = notas[j];
		}
		posAlumnoMatriz++;
	}

	public int getAlumnosLength() {
		return dam.length;
	}

	public int getAsignaturasLenght() {
		return dam[0].length;
	}

	// Posiciones de la Matriz
	// 0 = Alumnos suspensos con 0 asignaturas
	// 1 = Alumnos suspensos con 1 asignatura
	// ...
	public int[] supensosAsignaturas5() {
		int[] cantidadSuspensoFinal;
		int[] suspensos = new int[30]; // FIXME Comprobar si este metodo es el
										// más ineficiente.
		final int aprovado = 5;

		// Sacara el numero de asignaturas de cada alumnos inferior a 5.
		for (int i = 0; i < dam.length; i++) {
			for (int j = 0; j < dam[0].length; j++) {
				if (dam[i][j] < aprovado)
					suspensos[i]++;
			}
		}

		cantidadSuspensoFinal = sacarSuspensosOrden(suspensos);

		return cantidadSuspensoFinal;
	}

	/*
	 * Sacara el numero de los alumnos que tienen 5 asignaturas suspensas, 4, 3,
	 * 2, 1, 0
	 */
	private int[] sacarSuspensosOrden(int[] suspensos) {
		int asignaturas = 0;
		int[] cantidadSuspensos = new int[NUMERO_ASIGNATURAS + 1];

		while (asignaturas < NUMERO_ASIGNATURAS) {
			for (int i = 0; i < suspensos.length; i++) {
				if (suspensos[i] == asignaturas)
					cantidadSuspensos[asignaturas]++;
			}
			asignaturas++;
		}
		return cantidadSuspensos;
	}

	public double[] notaMediaAsignaturas() {
		double[] mediaAsignaturas = new double[NUMERO_ASIGNATURAS];
		for (int j = 0; j < dam[0].length; j++) {
			for (int i = 0; i < dam.length; i++) {
				mediaAsignaturas[j] += dam[i][j];
			}
		}

		for (int i = 0; i < mediaAsignaturas.length; i++) {
			mediaAsignaturas[i] = mediaAsignaturas[i] / NUMERO_ALUMNOS;
		}

		return mediaAsignaturas;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(dam.length * dam[0].length);

		for (int i = 0; i < ASIGNATURAS.length; i++) {
			str.append(" [" + ASIGNATURAS[i] + "]");
		}
		str.append("\n");
		for (int i = 0; i < dam.length; i++) {
			for (int j = 0; j < dam[0].length; j++) {
				str.append("   [" + dam[i][j] + "]");
			}
			str.append("\n");
		}
		return str.toString();
	}
}

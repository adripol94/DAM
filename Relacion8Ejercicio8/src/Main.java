import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Alumno[] alumnos;
		int n = pedirCantidadAlumnos();
		char opc;
		
		alumnos = new Alumno[n];
		pedirDatosAlumno(alumnos, n);
		do {
			menu();
			opc = pedirOPC();
			tratarMenu(opc, alumnos);
		} while (opc != 'g');
	}
	
	private static void tratarMenu(char opc, Alumno[] alumnos) {
		switch (opc) {
		case 'a':
			alumnosAprovados(alumnos);
			break;
		case 'b':
			alumnosSuspensos(alumnos);
			break;
		case 'c':
			mostrarMedia(alumnos);
			break;
		case 'd':
			int n = pedirNota();
			alumnosSuperiorNota(alumnos, n);
			break;
		case 'e':
			alumnoNotaMaxMin(alumnos);
			break;
		case 'f':
			listarNotas(alumnos);
			break;
		case 'g':
			System.out.println("Hasta la vista");
			break;
		default:
			System.out.println("Opción desconocida");
			break;
		}
		
	}

	private static void listarNotas(Alumno[] alumnos) {
		int mayor, j ;
		Alumno nAux;
		
		for (int i = alumnos.length - 1; i <= 0; i--) {
			mayor = i;
			for ( j = i + 1; j < alumnos.length; j++) {
				if (alumnos[i].getNota() > alumnos[mayor].getNota())
					mayor = j;
			}
			nAux = alumnos[i];
			alumnos[i] = alumnos[j];
			alumnos[j] = nAux;
		}
	}

	private static void alumnoNotaMaxMin(Alumno[] alumnos) {
		double notaMax = alumnos[0].getNota(), notaMin = alumnos[0].getNota();
		for (int i = 1; i < alumnos.length; i++) {
			if (notaMin > alumnos[i].getNota()) {
				notaMin = alumnos[i].getNota();
			} else if (notaMax < alumnos[i].getNota()) {
				notaMax = alumnos[i].getNota();
			}
		}
		System.out.println("Nota Max: " + notaMax + " Nota Min: " + notaMin);
	}

	private static int pedirNota() {
		boolean error;
		int n = 0;
		
		do {
			error = false;
			System.out.println("Indique la nota a buscar");
			try {
				n = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("dato no aceptado");
				error = true;
			}
		} while (!error);
		return n;
	}

	private static void alumnosSuperiorNota(Alumno[] alumnos, int n) {
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i].getNota() > n)
				System.out.println(alumnos);
		}
	}

	private static void mostrarMedia(Alumno[] alumnos) {
		int media = 0;
		for (int i = 0; i < alumnos.length; i++) {
			media += alumnos[i].getNota();
		}
		System.out.println("Media de la calse " + media);
	}

	private static void alumnosSuspensos(Alumno[] alumnos) {
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i].getNota() < 5)
				System.out.println(alumnos);
		}
	}

	private static void alumnosAprovados(Alumno[] alumnos) {
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i].getNota() > 4)
				System.out.println(alumnos);
		}
	}
	
	

	private static char pedirOPC() {
		char c;
		System.out.println("Elja una opcion");
		c = in.nextLine().charAt(0);
		return c;
	}

	private static void menu() {
		System.out.println("a. Mostrar los alumnos aprobados (con su nota)");
		System.out.println("b. Mostrar los alumnos suspensos (con su nota)");
		System.out.println("c. Mostrar la nota media de la clase");
		System.out.println("d. Mostrar los alumnos que tienen más de una nota X (se solicitirá x)");
		System.out.println("e. Mostrar el alumno con la nota máxima y mínima.");
		System.out.println("f. Mostrar un listado ordenado de forma decreciente por la nota");
		System.out.println("g. Salir");
	}

	private static void pedirDatosAlumno(Alumno[] alumnos, int n) {
		String nombre;
		int nota = 0;
		boolean error;
		
		for (int i = 0; i < n; i++) {
			
			do {
				error = false;
				System.out.println("Nombre del alumno numero " + (i+1));
				nombre = in.nextLine();
			} while(!error)	;
			
			do {
				error = true;
				System.out.println("Indique la nota del alumno " + nombre);
				try {
					nota = Integer.parseInt(in.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Dato no valido");
					error = true;
				}
			} while (!error);
			try {
			alumnos[i] = new Alumno(nombre, nota);
			} catch (AlumnoException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static int pedirCantidadAlumnos() {
		boolean error;
		int n = 0;
		
		do {
			error = false;
			System.out.println("¿Cuantos alumnos va a introducir?");
			try {
				n = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				error = true;
				System.out.println("Formato no aceptado");
			}
		} while (!error);
		return n;
	}
}

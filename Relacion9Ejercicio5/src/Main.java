import java.util.Random;
import java.util.Scanner;

/**
 * Realizar un programa que lea las calificaciones obtenidas por los alumnos de
 * 1º de DAM (30 alumnos) en las 5 asignaturas y saque por pantalla lo
 * siguiente:</br>
 * a. Número de alumnos con 5 asignaturas suspensas, con 4, con 3, con 2, con1
 * ycon0.</br>
 * b. Nota media de cada una de las asignaturas</br>
 * (Para simplificar, cargar las notas aleatoriamente)
 * 
 * @author adripol94
 *
 */
public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		Calificaciones object  = new Calificaciones();
		
		rellenarMatriz(object);
		
		do {
			menu();
			opc = elegirOpcion();
			accionMenu(object, opc);
		} while (opc != 4);
	}

	private static void rellenarMatriz(Calificaciones object) {
		Random aleatorio = new Random();
		int[] notasAlumnos = new int[5];
		
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 5; j++) {
				notasAlumnos[j] = aleatorio.nextInt(10);
			}
			
			try {
				object.setAlumno(notasAlumnos);
			} catch (CalificacionesException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void menu() {
		System.out.println("1. Numero de asignaturas suspensas (0...5)");
		System.out.println("2. Ver la nota media de cada asignatura");
		System.out.println("3. Ver cada alumnos y sus notas");
		System.out.println("4. Salir");
	}

	private static int elegirOpcion() {
		int opc = 0;
		boolean error;
		do {
			try {
				System.out.println("Elja un opción");
				opc = Integer.parseInt(in.nextLine());
				error = false;
			} catch (NumberFormatException | NullPointerException e) {
				error = true;
			}
		} while (opc < 0 || error);
		return opc;
	}
	
	private static void accionMenu(Calificaciones object, int opc) {
		int[] out;
		double[] outD;
		switch (opc) {
		case 1:
			out = object.supensosAsignaturas5();
			imprimirResultadoSuspensos(out);
			break;
		case 2:
			outD = object.notaMediaAsignaturas();
			imprimirResultadoMedia(outD, object);
			break;
		case 3:
			System.out.println(object);
			break;
		case 4:
			System.out.println("Saliendo...");
			break;
		default:
			System.out.println("Opcion Desconocida");
		}
	}

	private static void imprimirResultadoMedia(double[] out, Calificaciones object) {
		for (int i = 0; i < out.length; i++) {
			System.out.println("Media de la asginatura " + object.obtenerAsignaturas(i));
			System.out.println(out[i] + "\n");
		}
	}

	private static void imprimirResultadoSuspensos(int[] out) {
		for (int i = 0; i < out.length; i++) {
		System.out.println("Numero de alumnos que han suspendido " + i + " veces " + out[i]);
		}
	}
	
}

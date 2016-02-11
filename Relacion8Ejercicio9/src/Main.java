import java.util.Scanner;

/**
 * Mostrar un listado con nombre de alumno y su nota ordenado por nota de forma
 * decreciente. Realizar un programa que presente el siguiente menú: 1. Guardar
 * un refrán: Se solicitará la frase con el refrán se guardará. Si el
 * refrán ya estaba se mostrará un mensaje de error y no se guardará. 2.
 * Buscar un refrán que contenga una palabra: Se solicitará una palabra y se
 * buscará el primer refrán que contenga esa palabra. Si no se encuentra se
 * mostrará el mensaje de error 3. Listado de refranes: Se mostrará por
 * pantalla un listado de todos los refranes guardados ordenados
 * alfabéticamente. 4. Salir NOTAS: Se guardarán un máximo de 50 refranes, si
 * se intenta superar este máximo se producirá un error. Debe crearse una
 * clase Refranes y una clase PrincipalRefranes Debe realizarse la clase
 * Refranes para que no tenga entrada/salida por pantalla. Los errores se
 * trasmitirán a través de excepciones. Debe crearse una excepción propia
 * ExcepciónRefranes e implementarse su tratamiento.
 * 
 * @author adripol94
 * @version 0.1
 */
public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n, opc;
		boolean error;
		Refranes refranes = null;
		
		do {
			try {
				error = false;
				n = pedirInt("Indique el numero de refranes a introducir");
				refranes = new Refranes(n);
			} catch (RefranesException e) {
				System.out.println(e.getMessage());
				error = true;
			}
		} while (error);
		
		do {
			menu();
			opc = pedirInt("Idique una opción del menu");
			try {
				tratarMenu(refranes, opc);
			} catch (RefranesException e) {
				System.out.println(e.getMessage());
			}
		} while (opc != 4);

	}

	private static void menu() {
		System.out.println("1. Guardar un refrán");
		System.out.println("2. Buscar un refrán que contenga una palabra");
		System.out.println("3. Listado de refranes");
		System.out.println("4. Salir");
	}

	private static int pedirInt(String str) {
		boolean error;
		int n = 0;

		do {
			error = false;
			System.out.println(str);
			try {
				n = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException | NullPointerException e) {
				System.out.println("Caracter no valido");
				error = true;
			}
		} while (error);
		return n;
	}

	private static String pedirString(String str) {
		boolean error;
		String Out;

		do {
			error = false;
			System.out.println(str);
			Out = in.nextLine();

			if (Out.isEmpty())
				error = true;
		} while (error);
		return Out;
	}

	public static void tratarMenu(Refranes refs, int opc) throws RefranesException {
		String str;
		Refran refran;

		switch (opc) {
		case 1:
			str = pedirString("Introduzca el refran por favor");
			refran = new Refran(str);
			refs.addRefran(refran);
			break;
		case 2:
			str = pedirString("Introduzca un palabra a buscar por favor");
			refran = refs.buscarRefran(str);
			System.out.println(refran);
			break;
		case 3:
			listarRefranes(refs);
			break;
		case 4:
			System.out.println("Saliendo");
			break;
		default:
			System.out.println("Opción desconocida");
			break;
		}
	}

	private static void listarRefranes(Refranes refran) {
		// FIXME Terminar!.

	}
}

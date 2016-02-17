import java.util.Scanner;
import socios.*;

/**
 * <p>
 * Realizar un programa que permita gestionar un club de socios admitiendo altas
 * y bajas de Socios, y modificaciones de los datos, así como consultas de
 * socios del club. Para cada socio se guardará su DNI, número de socio
 * (1-100), nombre y teléfono. El programa presentará un menú de este tipo:
 * </p>
 * <br>
 * 1. Alta de Socio: Se pedirá DNI, nombre y teléfono, y se le asignará un
 * número de socio, el más bajo de entre todos los números libres. <br>
 * 2. Baja de Socio: Se solicitará el número de socio, se pedirá
 * confirmación con los datos del socio y si la respuesta es afirmativa se
 * dará de baja. <br>
 * 3. Modificar Datos Socio: Se solicitará el número de socio y se mostrará
 * el dato antiguo y si se desea se podrá modificar. Puede modificarse el
 * nombre y el teléfono <br>
 * 4. Listado de socios ordenado por número de socio <br>
 * 5. Listado de socios ordenado por nombre <br>
 * 6. Buscar un socio por DNI: Se solicitará el DNI del socio y se mostrarán
 * sus datos si existe <br>
 * 7. Salir
 * 
 * @author Adrián Pol
 *
 */
public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		ClubSocio club = new ClubSocio();
		
		do {
			menu();
			opc = elegirOpcion();
			tratarMenu(opc, club);
		} while (opc != 7);
	}

	private static void menu() {
		System.out.println(); // Añadir limpieza al menu.
		System.out.println("1. Alta de socio");
		System.out.println("2. Baja de socio");
		System.out.println("3. Modificar Socio");
		System.out.println("4. Listado de socios ordenado por número de socio");
		System.out.println("5. Listado de socios ordenado por nombre");
		System.out.println("6. Buscar socio por DNI");
		System.out.println("7. Salir");
	}

	private static void tratarMenu(int opc, ClubSocio club) {
		int n;
		String dni;
		Socio socio;
		try {
			switch (opc) {
			case 1:
				socio = pedirDatosSocio();
				club.altaSocio(socio);
				System.out.println("Socio dado de alta correctamente");
				break;
			case 2:
				n = pedirInt("Introduzca el codigo de socio por favor");
				if (pedirConfirmacion("Desea dar de baja a socio (" + n + ") S/N", n, club))
					club.bajaSocio(n);
				System.out.println("Socio borrado correctamente");
				break;
			case 3:
				n = pedirInt("Introduzca el numero de socio por favor");
				modificarSocio(club, n);
				System.out.println("Socio modificado correctamente");
				break;
			case 4:
				club.listarSocioPorNCodSocio();
				System.out.println(club);
				break;
			case 5:
				club.listarSocioPorNombre();
				System.out.println(club);
				break;
			case 6:
				dni = pedirString("Introduzca el DNI que desee buscar");
				club.buscarSocioDNI(dni);
				System.out.println(club);
			case 7:
				System.out.println("Saliendo...");
				break;
			default: 
				System.out.println("Opción desconocida!");
				break;
			}
		} catch (SociosException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void modificarSocio(ClubSocio club, int n) {
		Socio socio = club.buscarSocioCod(n);
		boolean error;
		String datoParaCambiar;
		System.out.println(socio);
		// Se usaran dos bucles por separados con sus respectivos try catch con
		// la intencion de evitar que pregunte de nuevo si quiere telefono o
		// nombre
		if (pedirConfirmacion("Desea modificar el socio (" + n + ") S/N", n, club)) {
			if (quiereTelefono()) {
				do {
					try {
						error = false;
						datoParaCambiar = pedirNuevosDatos("Telefono");
						club.modificaSocioTelefono(n, datoParaCambiar);
					} catch (SociosException e) {
						System.out.println(e.getMessage());
						error = true;
					}
				} while (error);
			} else {
				do {
					try {
						error = false;
						datoParaCambiar = pedirNuevosDatos("Nombre");
						club.modificaSocioNombre(n, datoParaCambiar);
					} catch (SociosException e) {
						System.out.println(e.getMessage());
						error = true;
					}
				} while (error);
			}

		}

	}

	private static String pedirNuevosDatos(String opcion) {
		String datoParaCambiar;

		System.out.println("Introduzca el nuevo " + opcion);
		datoParaCambiar = in.nextLine();
		return datoParaCambiar;
	}


	private static boolean quiereTelefono() {
		boolean error, respuesta = false;
		int n;
		do {
			error = false;
			System.out.println("1. Telefono");
			System.out.println("2. Nombre");
			System.out.println("¿Desea modificar su telefono o su nombre?");
			n = Integer.parseInt(in.nextLine());
			if (n != 1 || n != 2)
				error = true;
		} while (error);
		if (n == 1)
			respuesta = true;
		return respuesta;
	}

	private static boolean pedirConfirmacion(String string, int n, ClubSocio club) {
		boolean error, respuesta = false;
		char c;
		Socio socio = club.buscarSocioCod(n);
		System.out.println(socio);

		do {
			error = false;
			System.out.println(string);
			c = Character.toUpperCase(in.nextLine().charAt(0));
			if (!(c == 'S' || c == 'N'))
				error = true;
		} while (error);
		if (c == 'S')
			respuesta = true;
		return respuesta;
	}

	private static int pedirInt(String string) {
		System.out.println(string);
		return Integer.parseInt(in.nextLine());
	}

	private static int elegirOpcion() {
		System.out.println("Indique una opción para el menu: ");
		return Integer.parseInt(in.nextLine());
	}

	private static Socio pedirDatosSocio() {
		boolean error;
		Socio socio = null;

		do {
			String dni = pedirString("Introduzca un dni por favor");
			String nombre = pedirString("Introduzca un nombre por favor");
			String telefono = pedirString("Introduzca un telefono por favor");

			try {
				error = false;
				socio = new Socio(dni, nombre, telefono);
			} catch (SociosException e) {
				System.out.println(e.getMessage());
				error = true;
			}
		} while (error);
		return socio;
	}

	private static String pedirString(String msg) {
		System.out.println(msg);
		return in.nextLine();
	}

}

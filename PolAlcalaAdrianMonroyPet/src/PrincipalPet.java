import java.util.Scanner;

public class PrincipalPet {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opc = 0;
		MonroyPet perro, gato;
		boolean error = false;

		perro = new MonroyPet("1", "PERRO");
		gato = new MonroyPet("2", "GATO");

		do {
			try {
				mostrarMenu();
				opc = solicitarOpcion();
				accionMenu(opc, perro, gato);

			} catch (MonroyPetException e) {
				System.out.println(e.getMessage());
				error = true;
			}
		} while (opc != 7 && !error);

	}

	private static void accionMenu(int opc, MonroyPet p, MonroyPet g) throws MonroyPetException {
		int mascota, num;
		String msg;

		switch (opc) { // FIXME elegirMascota(); en vez de poner if en todos lados. 
		case 1:
			mascota = solicitarMascota();
			if (mascota == 1)
				p.alimetar();
			else
				g.alimetar();
			break;
		case 2:
			num = solicitarNumeroAlimentos();
			mascota = solicitarMascota();
			if (mascota == 1)
				p.comprarComida(num);
			else
				g.comprarComida(num);
			break;
		case 3:
			num = solicitarMinutos();
			mascota = solicitarMascota();
			if (mascota == 1)
				p.jugar(num);
			else
				g.jugar(num);
			break;
		case 4:
			System.out.println("Indique el mensaje");
			msg = teclado.nextLine();
			System.out.println("Que mascota desea usar para enviar el mensaje");
			mascota = solicitarMascota();
			if (mascota == 1)
				p.recibirMensaje(msg);
			else
				g.recibirMensaje(msg);
			break;
		case 5:
			mascota = solicitarMascota();
			if (mascota == 1)
				System.out.println(p.leerMensaje());
			else
				System.out.println(g.leerMensaje());
			break;
		case 6:
			System.out.println(p);
			System.out.println(g);
			System.out.println("Tiempo jugado en total " + MonroyPet.tiempoJuego());
			break;
		case 7:
			System.out.println("Adios");
			break;
		default:
			System.out.println("Opcion desconocida");
		}
	}

	private static void mostrarMenu() {
		System.out.println("1. Dar comida");
		System.out.println("2. Comprar comida");
		System.out.println("3. Jugar");
		System.out.println("4. Enviar mensaje");
		System.out.println("5. Recibir mensaje");
		System.out.println("6. Informacion de mascotas");
		System.out.println("7. Salir");
	}

	// Este metodo debe modificarse

	private static int solicitarInt(String msg) {
		int num = 0;
		boolean error;

		do {
			try {
				System.out.println(msg);
				num = Integer.parseInt(teclado.nextLine());
				error = false;
			} catch (NumberFormatException e) {
				System.out.println("Caracter no aceptado");
				error = true;
			}
		} while (error);
		return num;
	}

	/**
	 * Solicita una opcion validando que este entre 1 y 7
	 * 
	 * @return opcion elegida
	 */
	public static int solicitarOpcion() {
		int opc;

		do {
			opc = solicitarInt("Introduce opc (1-7): ");
		} while (opc < 0 || opc > 7);
		return opc;
	}

	/**
	 * Solicita el numero de mascota, validando que sea 1 o 2
	 * 
	 * @return mascota elegida (1 o 2)
	 */
	private static int solicitarMascota() {
		int mascota;

		do {
			mascota = solicitarInt("Introduce mascota(1-2): ");
		} while (!(mascota == 1 || mascota == 2));
		return mascota;
	}

	/**
	 * Solicita el numero de alimentos
	 * 
	 * @return numero de alimentos
	 */
	private static int solicitarNumeroAlimentos() {
		int alimentos;

		do {
			alimentos = solicitarInt("Introduce numero de alimentos: ");
		} while (alimentos < 0);
		return alimentos;
	}

	/**
	 * Solicita el numero de minutos jugados
	 * 
	 * @return minutos jugados
	 */
	private static int solicitarMinutos() {
		int minutos;

		do {
			minutos = solicitarInt("Introduce numero de minutos: ");
		} while (minutos < 0);
		return minutos;
	}

}

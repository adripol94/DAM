import java.util.Scanner;

/**
 * Realizar un programa que realice una pequeña versión del juego
 * Buscaminas. </br>
 * Empezamos el juego mostrando un tablero de 8 x 8 donde sólo se verá la
 * posición del jugador ( J ) en la posición (1,1) y el resto el carácter
 * <li>El juego consiste en llegar a la posición final (8,8) sin pisar ninguna
 * mina. Se colocarán 20 minas aleatoriamente en el tablero.
 * <li>El jugador elegirá donde quiere moverse con los cursores, teniendo en
 * cuenta que no puede salirse del tablero.
 * <li>El juego acaba cuando el jugador gana o cuando pierde pisando una mina.
 * </li>
 * 
 * @author Adrian Pol
 *
 */
public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		char opc;
		PisaMinas.iniciarJuego();

		try {
			do {
				System.out.println(PisaMinas.getTablero());
				menu();
				opc = capturarTeclado();
				accionMenu(opc);
			} while (opc != 'e');
		} catch (MinaException e) {
			System.out.println(e.getMessage() + " Fin del juego");
		}
	}

	private static void accionMenu(char opc) throws MinaException {
		try {
			switch (opc) {
			case 'w':
				PisaMinas.moverArriba();
				break;
			case 's':
				PisaMinas.moverAbajo();
				break;
			case 'd':
				PisaMinas.moverDerecha();
				break;
			case 'a':
				PisaMinas.moverIzquierda();
				break;
			case 'e':
				System.out.println("Juego abortado..");
				break;
			default:
				System.out.println("Opción desconocida");
				break;
			}
		} catch (PisaMinasException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void menu() {
		System.out.println("Mover hacia arriba w");
		System.out.println("Mover hacia abajo s");
		System.out.println("Mover hacia derecha d");
		System.out.println("Mover hacia izquierda a");
		System.out.println("Abortar e");
	}

	private static char capturarTeclado() {
		return in.nextLine().charAt(0);
	}

}

import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Emprejando juego = new Emprejando();

		int[] carta1;
		int[] carta2;
		String salidaCartas;
		boolean salir = false;

		try {
			do {
				try {
					System.out.println(juego);
					carta1 = preguntarCarta(1);
					carta2 = preguntarCarta(2);
					salidaCartas = juego.mostarCarta(carta1, carta2);
					System.out.println(salidaCartas);
					
				} catch (EmparejandoException e) {
					System.out.println(e.getMessage());
				}
			} while (!salir);

		} catch (EmparejandoFinException e) {
			System.out.println(e.getMessage());
			System.out.println(juego);
		}
	}

	private static int[] preguntarCarta(int carta) {
		int fila, columna;
		System.out.println("Indique la fila de la carta " + carta);
		fila = Integer.parseInt(in.nextLine());

		System.out.println("Indique la columna de la carta " + carta);
		columna = Integer.parseInt(in.nextLine());

		return new int[] { fila - 1, columna - 1 };
	}

}

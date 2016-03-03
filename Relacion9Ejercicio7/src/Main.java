import java.util.Random;
import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Conecta4 juego = new Conecta4();
		int columna;
		boolean j = random(), salir = false;
		
		do {
			System.out.println(juego);
			columna = preguntarColumna(juego, j);

			try {
				juego.introducirFicha(columna, j);
				j = cambiarTurno(j);
				
			} catch (Conecta4Exception e) {
				System.out.println(e.getMessage());
				 
			} catch (Conecta4FinException e) {
				if (j)
					System.out.println(e.getMessage() + "Rojo");
				else
					System.out.println(e.getMessage() + "Amarillo");
				salir = true;
			} 

		} while (columna != -1 && !salir);
		System.out.println(juego);
	}

	private static boolean cambiarTurno(boolean j) {
		if (j == true)
			j = false;
		else
			j = true;
		return j;
	}

	private static int preguntarColumna(Conecta4 juego, boolean j1) {
		int n;

		if (j1 == true)
			System.out.println("Soy Rojo. Indique una columna (0 para abortar)");
		else
			System.out.println("Soy Amarillo. Indique una columna (0 para abortar)");
		n = Integer.parseInt(in.nextLine());

		return n - 1;
	}

	private static boolean random() {
		Random aleatorio = new Random();
		return aleatorio.nextBoolean();
	}

}

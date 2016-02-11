
public class MonroyPet {
	private static final int NUMERO_MENSAJES_MAXIMO = 5;
	private static final int NUMERO_MINUTOS_MAXIMO = 20;
	private static final int COSTE_COMIDA = 30;
	private static final int PUNTOS_JUGAR = 3;
	private int numMensaje;
	private String mensaje;
	private int puntos;
	private String nombre;
	private String tipo;
	private int cantidadComida;
	private int minutos;
	private static int tipoJuegoTotal = 100;
	
	MonroyPet(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
		cantidadComida = 2;
	}
	
	public void jugar(int minutos) throws MonroyPetException {
		if (minutos > NUMERO_MINUTOS_MAXIMO)
			throw new MonroyPetException("No puede jugar mas de 20m");

		if (minutos + tipoJuegoTotal > 100) {
			minutos = 100 - tipoJuegoTotal;
			puntos = minutos * PUNTOS_JUGAR;
			tipoJuegoTotal = 0;
			throw new MonroyPetException("Las mascotas tienen sueño... Se van a dormir");
		}
		this.minutos += minutos;
		tipoJuegoTotal += minutos;
		puntos += (minutos * PUNTOS_JUGAR);
	}
	
	public void comprarComida(int cantidad) throws MonroyPetException {
		if (puntos - (cantidad * COSTE_COMIDA) < 0)
			throw new MonroyPetException("No tienes suficientes puntos");
		cantidadComida += cantidad;
		puntos = puntos - (cantidad * COSTE_COMIDA);
	}
	
	public void alimetar() throws MonroyPetException {
		if (cantidadComida == 0)
			throw new MonroyPetException("No tienes comida compra");
		cantidadComida--;
	}
	
	public void setNombre(String nombre) throws MonroyPetException{
		if (nombre.isEmpty())
			throw new MonroyPetException("Nombre no valido");
		this.nombre = nombre;
	}
	/** Se usara para recivir el mensaje de otra mascota */
	public void recibirMensaje(String msg) throws MonroyPetException {
		if (numMensaje == NUMERO_MENSAJES_MAXIMO)
			throw new MonroyPetException("Ya tiene un mensaje");
		mensaje = msg;
		numMensaje = 1;
	}
	
	public String leerMensaje() throws MonroyPetException {
		if (numMensaje < NUMERO_MENSAJES_MAXIMO)
			throw new MonroyPetException("No tiene ningun mensaje");
		numMensaje--;
		return mensaje;
	}

	public int getNumMensaje() {
		return numMensaje;
	}

	public void setNumMensaje(int numMensaje) {
		this.numMensaje = numMensaje;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}
	
	public static int tiempoJuego() {
		return tipoJuegoTotal;
	}
	
	public boolean equals(MonroyPet mascota) {
		boolean igual = false;
		
		if (this.nombre == mascota.nombre && this.tipo == mascota.tipo) {
			igual = true;
		}
		return igual;
	}
	
	public String toString() {
		return "Nombre: " + nombre + " ,tipo " + tipo + " ,comida: "
				+ cantidadComida + " ,minutos jugados: " + minutos + " Puntos " + puntos;
	}

	public int getCantidadComida() {
		return cantidadComida;
	}

	public String getMensaje() {
		return mensaje;
	}
}

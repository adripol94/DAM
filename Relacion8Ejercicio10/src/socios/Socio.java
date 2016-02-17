package socios;

	
public class Socio {
	private String dni;
	private String nombre;
	private String telefono;
	private int codSocio;
	
	public Socio(String dni, String nombre, String telefono) throws SociosException {
		validarDNI(dni);
		this.dni = dni;
		setTelefono(telefono);
		setNombre(nombre);
	}
	
	public String getDni() {
		return dni;
	}
	
	void setCodCocio(int i) {
		codSocio = i;
	}

	private void validarDNI(String dni) throws SociosException {
		if (dni.isEmpty() || dni.length() == 8 || !Character.isLetter(dni.charAt(dni.length() - 1)))
			throw new SociosException("DNI vacío o no valido");
		
		char c = dni.charAt(dni.length() - 1), caracter; // c recogera la letra del DNI
		int n, i = 0;
		boolean out = false;
		String num = dni.substring(0, dni.length() - 1); // Guardara toda la secuencia de numeros
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B",
				"N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
		
		while ( i < num.length() && !out) {
			caracter = num.charAt(i);			
			if (!Character.isDigit(caracter))
				out = true;
			i++;
		}
		
		if (out)
			throw new SociosException("DNI no valido");
		n = Integer.parseInt(num);
		n = n % 23;
		caracter = letras[n].charAt(0);
		
		if (c != caracter)
			throw new SociosException("DNI no valido");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws SociosException {
		if (nombre.isEmpty())
			throw new SociosException("Nombre no puedo estar vacio");
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) throws SociosException {
		if (telefono.length() < 9)
			throw new SociosException("telefono no valido");
		
		this.telefono = telefono;
	}
	
	public int getCodSocio() {
		return codSocio;
	}
	
	public boolean equals(Socio otro) {
		boolean iguales = false;
		if (dni.equals(otro.dni))
			iguales = true;
		return iguales;
	}
	
	@Override
	public String toString() {
		return "Socio [dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", codSocio=" + codSocio + "]";
	}

}

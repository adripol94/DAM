package socios;

public class ClubSocio {
	private Socio socios[] = new Socio[100];
	private int contadorSociosIntroducidos = 0;

	public void altaSocio(Socio socio) throws SociosException {
		boolean socioIntroducido = false;
		int i = 0;

		contadorSociosIntroducidos++;
		if (contadorSociosIntroducidos == 101)
			throw new SociosException("No hay mas espacio para más socios");

		if (mejoraEjercicio11(socio))
			throw new SociosException("El DNI ya existe!");

		while (!socioIntroducido && i < this.socios.length) {
			if (this.socios[i] == null) {
				socio.setCodCocio(i);
				this.socios[i] = socio;
				socioIntroducido = true;
			}
			i++;
		}
	}
	// Ejercicio 11 Que el DNI no se repita

	private boolean mejoraEjercicio11(Socio socio) throws SociosException {
		int i = 0;
		boolean encontrado = false;

		while (i < socio.getDni().length() && !encontrado) {
			if (socios[i] != null) {
				if (socios[i].getDni().equals(socio.getDni()))
					encontrado = true;
			}
			i++;
		}
		return encontrado;
	}

	public void bajaSocio(int codSocio) throws SociosException {
		boolean socioEncontrado = false;
		int i = 0;

		while (i < socios.length && !socioEncontrado) {
			if (socios[i].getCodSocio() == codSocio) {
				socios[i] = null;
				socioEncontrado = true;
			}
			i++;
		}
		if (!socioEncontrado)
			throw new SociosException("No se ha encontrado el socio");
	}

	public Socio buscarSocioDNI(String dni) throws SociosException {
		boolean socioEncontrado = false;
		int i = 0, salida = -1;

		while (i < socios.length && !socioEncontrado) {
			if (socios[i].getDni().equals(dni)) {
				socioEncontrado = true;
				salida = i;
			}
			i++;
		}
		if (salida == -1)
			throw new SociosException("No se ha encontrado un socio");

		return socios[salida];
	}

	public Socio buscarSocioCod(int codSocio) {
		Socio socio = socios[codSocio];
		return socio;
	}

	public void modificaSocioTelefono(int codSocio, String telefono) throws SociosException {
		socios[codSocio].setTelefono(telefono);
	}

	public void modificaSocioNombre(int codSocio, String nombre) throws SociosException {
		socios[codSocio].setNombre(nombre);
	}

	public void listarSocioPorNCodSocio() {
		int i, j;
		Socio aux;

		for (i = 0; i < socios.length; i++) {
			for (j = i; j < socios.length; j++) {
				if (socios[j - 1].getCodSocio() < 0) {
					aux = socios[j];
					socios[j] = socios[j - 1];
					socios[j - 1] = aux;
				}
			}
		}
	}

	public void listarSocioPorNombre() {
		int i, j;
		Socio aux;

		for (i = 0; i < socios.length; i++) {
			for (j = i; j < socios.length; j++) {
				if (socios[j - 1].getNombre().compareTo(socios[j].getNombre()) < 0) {
					aux = socios[j];
					socios[j] = socios[j - 1];
					socios[j - 1] = aux;
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder(socios.length);

		for (int i = 0; i < socios.length; i++) {
			if (socios[i] != null)
				out.append(socios[i].toString() + "\n");
		}
		return out.toString();
	}

}

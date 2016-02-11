
public class Refranes {
	private final int MAXIMO_REFRANES = 3;
	private final int ASCII = 65;
	private Refran[] vRefranes;
	private int i;

	Refranes(int n) throws RefranesException {
		if (n <= 0)
			throw new RefranesException("Tamaño en negativo no aceptado");

		i = 0;
		vRefranes = new Refran[MAXIMO_REFRANES];
	}

	public void addRefran(Refran obj) throws RefranesException {
		Refran refran;
		if (i > 0) {
			refran = buscarRefran(obj.getRefran());

			if (refran != null)
				throw new RefranesException("Refran repetido");
		}
		vRefranes[i] = obj;
		i++;
	}

	public Refran buscarRefran(String str) throws RefranesException {
		if (i == 0)
			throw new RefranesException("No se ha introducido ningun refran");

		Refran obj = null;
		boolean out = false;
		int j = 0;

		while (j < i && !out) {
			if (vRefranes[j].getRefran().contains(str)) {
				obj = vRefranes[j];
				out = true;
			}
			j++;
		}
		if (obj == null)
			throw new RefranesException("No hay coincidencias");
		return obj;
	}

	public String listarRefranes() {
		// FIXME No end.
		return "";
	}
}

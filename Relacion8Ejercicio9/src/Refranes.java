public class Refranes {
	private final int MAXIMO_REFRANES = 3;
	private Refran[] vRefranes;
	private int i;

	Refranes(int n) throws RefranesException {
		if (n <= 0)
			throw new RefranesException("Tamaño en negativo no aceptado");

		i = 0;
		vRefranes = new Refran[MAXIMO_REFRANES];
	}

	public void addRefran(Refran obj) throws RefranesException {
		if (i >= vRefranes.length)
			throw new RefranesException("No se admiten más refranes");
		
		if (i > 0) {
			Refran refran = null;
			
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
			return obj;
	}

	public String listarRefranes() {
		char c;
		int a, j, a2, pos = 0, i;
		Refran aux;
		
		for (i = 0; i < this.i; i++) {
			c = Character.toUpperCase(vRefranes[i].getRefran().charAt(0));
			a = c;
			for (j = i + 1; j < this.i; j++) {
				c = Character.toUpperCase(vRefranes[j].getRefran().charAt(0));
				a2 = c;
				if (a > a2) {
					pos = j;
					a = a2;
				}
			}
			aux = vRefranes[i];
			vRefranes[i] = vRefranes[pos];
			vRefranes[pos] = aux;
		}
		return this.toString();
	}
		
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < this.i; i++) {
			str.append("Refranes: " + vRefranes[i].getRefran() + "\n");
		}
		return str.toString();
	}
}

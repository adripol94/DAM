public class Refranes {
	private Refran[] vRefranes;
	private int i; // Total refrains.
	
	// NO SE USARÁ GET DEL VECTOR YA QUE SE PASA POR REFERENCIA Y NO COPIA!

	Refranes(int n) throws RefranesException {
		if (n <= 0)
			throw new RefranesException("Tamaño en negativo no aceptado");

		i = 0;
		vRefranes = new Refran[n];
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
		int i , j;
		Refran aux;
		
		// Metodo Burbuja.
		// Comparamos las Cadenas con compareTo de tal forma que soltara un menor que 0 en caso de ser mayo.
		// ANA LOPEZ
		// ANA ZAPATERO
		// Z mayor que L devolvera un negativo.
		
		for (i = 0; i < this.i; i++) {
			for (j = i + 1; j < this.i; j++) {
				if (vRefranes[j - 1].getRefran().compareTo(vRefranes[j].getRefran()) > 0) {
					aux = vRefranes[j];
					vRefranes[j] = vRefranes[j - 1];
					vRefranes[j - 1] = aux;
				}
			}
			
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

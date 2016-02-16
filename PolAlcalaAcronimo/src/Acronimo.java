
public class Acronimo {
	private String palabra;
	
	Acronimo(String acronimo) throws AcronimoException {
		setAcronimo(acronimo);
	}

	private void setAcronimo(String acronimo) throws AcronimoException {
		if (acronimo.isEmpty())
			throw new AcronimoException("Acronimo esta vácio");
		palabra = acronimo.trim();
	}
	
	public String getAcronimo() {
		return palabra;
	}
	
	public String siglas() {
		char c;
		boolean espacio = true;
		
		StringBuilder siglas = new StringBuilder();
		for (int i = 0; i < palabra.length(); i++) {
			c = palabra.charAt(i);
			if (Character.isWhitespace(c))
				espacio = true;
			if (Character.isLetter(c) && Character.isUpperCase(c) && espacio) {
				espacio = false;
				siglas.append(Character.toString(c));
			}		
		}
		return siglas.toString();
	}
}

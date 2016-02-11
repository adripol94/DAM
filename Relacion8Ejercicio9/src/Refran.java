/**
 * Guardara los refranes del proyecto 
 * @author adripol94
 *
 */
public class Refran {
	private String refran;
	
	Refran(String refran) throws RefranesException {
		setRefran(refran);
	}

	private void setRefran(String refran2) throws RefranesException {
		if (refran2.isEmpty())
			throw new RefranesException("Refran está vacío");
		refran = refran2;
	}

	public String getRefran() {
		return refran;
	}
	

	public boolean equals(Refran ref) {
		boolean x = false;
		
		if (refran.equals(ref.refran))
			x = true;
		return x;
	}

	@Override
	public String toString() {
		return "Refran [" + refran + "]";
	}
	
	
}

import static org.junit.Assert.*;

import org.junit.Test;

public class AcronimoTest {

	@Test
	public void test() {
		String out;
		try {
			Acronimo acro = new Acronimo("Organizacion de Naciones UnidaS, 2016 ");
			out = acro.siglas();
			assertEquals("ONU", out);
		} catch (AcronimoException e) {
			e.printStackTrace();
		}
		
	}

}

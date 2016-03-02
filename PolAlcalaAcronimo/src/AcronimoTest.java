import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AcronimoTest {
	private String str;
	private String result;
	
	public AcronimoTest(String str, String result) {
		this.str = str;
		this.result = result;
	}
	
	@Parameters
	public static Collection<Object[]> AcronimoParatemers() {
		return Arrays.asList(new Object[][] {
			{"Organizacion de Naciones Unidas", "ONU"},{"OraganizacioneS de las Nacionalidades del 2007 InternacOlales", "ONI"},
			{"Centro Nacional de Inteligencia", "CNI"}
		});
	}
	
	@Test
	public void Test() {
		try {
			Acronimo acr = new Acronimo(str);
			assertEquals(acr.siglas(), result);
		} catch (AcronimoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

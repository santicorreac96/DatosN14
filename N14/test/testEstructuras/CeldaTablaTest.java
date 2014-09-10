package testEstructuras;

import estructuraDeDatos.CeldaTabla;
import junit.framework.TestCase;
import mundo.Restaurante;

public class CeldaTablaTest extends TestCase
{
	
	private CeldaTabla<Restaurante, String> test ;
	
	public void testDarElemento()
	{
		test = new CeldaTabla<Restaurante, String>(null, null,null);
		assertNull(test.darElemento());
		assertNull(test.darLlave());
		Restaurante r = new Restaurante("", "", "", "", "", "", "", "", "", "", "", "", "", "", "",0);
		test  = new CeldaTabla<Restaurante, String>(r, r.getID(),r.getID());
		assertEquals(r, test.darElemento());
	}
	
	public void testDarLlave()
	{
		test = new CeldaTabla<Restaurante, String>(null, null,null);
		assertNull(test.darElemento());
		assertNull(test.darLlave());
		Restaurante r = new Restaurante("r", "a", "b", "", "", "", "", "", "", "", "", "", "", "", "",0);
		test  = new CeldaTabla<Restaurante, String>(r, r.getID(),r.getID());
		assertEquals(r.getID(), test.darLlave());
	}

	

}

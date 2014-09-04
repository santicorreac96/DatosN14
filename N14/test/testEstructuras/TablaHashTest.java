package testEstructuras;

import junit.framework.TestCase;
import mundo.Restaurante;
import mundo.comparadorRestaurantes;
import estructuraDeDatos.ITablaHash;
import estructuraDeDatos.TablaHash;

public class TablaHashTest extends TestCase
{
	private ITablaHash<Restaurante, String> tablaPrueba;
	
	private Restaurante r1;
	private Restaurante r2;
	
	private void setupEscenario1()
	{
		tablaPrueba = new TablaHash<Restaurante, String>();
		r1 =  new Restaurante("r1", "bog", "co", "", "", "", "", "", "", "", "", "", "", "", "");
		r2 = new Restaurante("r2", "med", "col", "", "", "", "", "", "", "", "", "", "", "", "");
	}
	
	public void testAgregar()
	{
		setupEscenario1();
		tablaPrueba.agregar(r1, r1.getID(), new comparadorRestaurantes());
		tablaPrueba.agregar(r2, r2.getID(), new comparadorRestaurantes());
		assertEquals(2, tablaPrueba.darCantidadElementos());
	}
	
	public void testBuscar()
	{
		setupEscenario1();
		tablaPrueba.agregar(r1, r1.getID(), new comparadorRestaurantes());
		tablaPrueba.agregar(r2, r2.getID(), new comparadorRestaurantes());
		assertEquals(2, tablaPrueba.darCantidadElementos());
		assertEquals(r1, tablaPrueba.darElemento(r1.getID(), new comparadorRestaurantes()));
	}
	
	public void testEliminar()
	{
		setupEscenario1();
		tablaPrueba.agregar(r1, r1.getID(), new comparadorRestaurantes());
		tablaPrueba.agregar(r2, r2.getID(), new comparadorRestaurantes());
		assertEquals(2, tablaPrueba.darCantidadElementos());
		try {
			tablaPrueba.eliminar(r1.getID(), new comparadorRestaurantes());
		} catch (Exception e) {
			
		}
		assertEquals(1, tablaPrueba.darCantidadElementos());
		assertEquals(r2, tablaPrueba.darElemento(r2.getID(), new comparadorRestaurantes()));
		
		
		
	}
}

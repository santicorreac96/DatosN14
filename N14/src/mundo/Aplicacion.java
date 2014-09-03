package mundo;

public class Aplicacion 
{
	private ConsultorRestaurantes consultorRestaurante;
	private Restaurante[] restaurantes;
	public final static String CONTRASENA_ADMIN = "RESTAU-ADMIN";
	
	public Aplicacion ()
	{
		consultorRestaurante = new ConsultorRestaurantes();
	}
	
	public Restaurante[] cargarDatos()
	{
		consultorRestaurante.cargarXLS();
		restaurantes = consultorRestaurante.darRestaurantesPrueba();
		return restaurantes;
	}

}

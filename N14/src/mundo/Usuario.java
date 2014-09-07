package mundo;

import estructuraDatos.IListaEncadenadaDoble;
import estructuraDatos.ListaEncadenadaDoble;

public class Usuario extends Persona
{
	
	public final static int CEDULA =1;
	public final static int USER  =2;
	
	public static final int MAYOR = 3;

	public static final int EXACTAMENTE = 4;
	
	private String user;
	
	private String password;
	
	private IListaEncadenadaDoble<Restaurante> listaFavoritos;

	
	private ConsultorRestaurantes usada;
	
	private int criterioComparacion;
	
	public Usuario(String nUser , String nPass, String nombre, String apellido, String cedula, String email, ConsultorRestaurantes consultor)
	{
		super(nombre, apellido, cedula, email);
		usada = consultor;
		user =nUser;
		password = nPass;
		listaFavoritos = new ListaEncadenadaDoble<Restaurante>();

	}

	public String darUsuario() 
	{
		return user;
	}

	public String darPassword() 
	{
		return password;
	}


	public void cambiarPassword(String nPass) 
	{
		password = nPass;
	}

	public void asignarCriterioComparacion(int criterio)
	{
		criterioComparacion =criterio;
	}

	public int compararPor(Usuario objeto)
	{
		if(criterioComparacion == USER)
		{
			return user.compareTo(objeto.user);
		}
		else 
		{
			return cedula.compareTo(objeto.cedula);
		}
	}
	
	public void agregarFavorito(Restaurante favorito)
	{
		listaFavoritos.adicionar(favorito, new comparadorID());
	}
	
	public void eliminarFavorito( Restaurante favorito) throws Exception
	{
		listaFavoritos.eliminar(favorito, new comparadorID());
	}

	public IListaEncadenadaDoble<Restaurante> buscarRestaurantes(String cocina, String localidad)
	{
		IListaEncadenadaDoble<Restaurante> resp = new ListaEncadenadaDoble<Restaurante>();
		Restaurante ini = listaFavoritos.volverActualPrimero();
		while( ini != null)
		{
			if(ini.getCocina().equals(cocina)&& ini.getCiudad().equals(localidad))
			{
				resp.adicionar(ini, new comparadorID());
			}
			ini = listaFavoritos.adelantarse();
		}
		return resp;
	}

}

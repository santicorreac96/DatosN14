package mundo;

import java.io.File;

import estructuraDatos.IListaEncadenadaDoble;
import estructuraDatos.ListaEncadenadaDoble;
import estructuraDeDatos.ITablaHash;
import estructuraDeDatos.TablaHash;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ConsultorRestaurantes implements IConsultorRestaurantes
{

	public static final Object CONTRASENA_ADMIN = "RESTAU-ADMIN";
	private ITablaHash<Restaurante, String> tablaIdentifcadorCompuesto;
	private ITablaHash<Restaurante, String> tablaLocalidadEstado;
	private Restaurante[] restauranteArregloPrueba;
	private IListaEncadenadaDoble<Usuario> registrados;
	private int indiceActual;
	private Categoria[] categoriasRestaurante; 
	private Cocina[] cocinasRestaurante;
	private Usuario usuarioRegistradoActual; 
	private IListaEncadenadaDoble<Categoria> listaOrdenadaCategorias;
	private IListaEncadenadaDoble<Cocina> listaOrdenadaCocinas;

	public ConsultorRestaurantes()
	{
		tablaIdentifcadorCompuesto  = new TablaHash<Restaurante, String>();
		tablaLocalidadEstado  =new TablaHash<Restaurante, String>();
		restauranteArregloPrueba = new Restaurante[5000];
		indiceActual = 0;
		cocinasRestaurante = new Cocina[2310];
		categoriasRestaurante = new Categoria[38];
		listaOrdenadaCategorias = new ListaEncadenadaDoble<Categoria>();
		listaOrdenadaCocinas = new ListaEncadenadaDoble<Cocina>();
	}

	@Override
	public void cargarXLS() 
	{
		try 
		{
			File FileActual =  new File("./datos/Datos.xls");
			Workbook libro = Workbook.getWorkbook(FileActual);
			Sheet hoja = libro.getSheet(0);
			for ( int j = 1 ; j<hoja.getRows();j++)
			{
				String nombre = hoja.getCell(1, j).getContents();
				String direccion = hoja.getCell(2, j).getContents();
				String ciudad = hoja.getCell(5, j).getContents();
				String estado = hoja.getCell(6, j).getContents();
				String post = hoja.getCell(9, j).getContents();
				String telefono = hoja.getCell(11, j).getContents();
				String fax = hoja.getCell(12, j).getContents();
				String latitud = hoja.getCell(13, j).getContents();
				String longitud = hoja.getCell(14, j).getContents();
				String barrio = hoja.getCell(15, j).getContents();
				barrio = barrio.replace("\"", "");
				barrio = barrio.replace("[", "");
				barrio= barrio.replace("]", "");
				String web = hoja.getCell(16, j).getContents();
				String email = hoja.getCell(17, j).getContents();
				String categoria = hoja.getCell(19, j).getContents();
				categoria = categoria.replace("\"", "");
				categoria = categoria.replace("[", "");
				categoria = categoria.replace("]", "");
				String[] tags = categoria.split(",");
				String horario = hoja.getCell(23, j).getContents();
				String cocina = hoja.getCell(25, j).getContents();
				cocina = cocina.replace("\"", "");
				cocina = cocina.replace("[", "");
				cocina = cocina.replace("]", "");
				String[] tags2 = cocina.split(",");
				Restaurante r = new Restaurante(nombre, ciudad, estado,direccion,post,telefono,fax,latitud,longitud,barrio,web,email,categoria,horario,cocina,indiceActual);
				tablaIdentifcadorCompuesto.agregar(r, r.getID(), new comparadorRestaurantes());
				tablaLocalidadEstado.agregar(r, r.getCiudad()+"-"+r.getEstado(), new comparadorRestaurantes());
				darCategoriasPopulares(tags);
				darCocinasPopulares(tags2,r.getEstado());
				restauranteArregloPrueba[indiceActual] = r;
				indiceActual++;
			}
			System.out.println("Leyo ultimo");
		}
		catch ( Exception e)
		{
			System.out.println("Excepcion en metodo cargar xls: " + e.getMessage()+indiceActual);
		}
		
	}
	
	public static void main(String[] args) {		ConsultorRestaurantes r =  new ConsultorRestaurantes();
		r.cargarXLS();		
	}

	public Restaurante[] darRestaurantesPrueba()
	{
		return restauranteArregloPrueba;
	}

	@Override
	public IListaEncadenadaDoble<Restaurante> buscarPorIdentidicadorCompuesto(
			String id) {
		
		IListaEncadenadaDoble<Restaurante> lista = tablaIdentifcadorCompuesto.darLista(id, new comparadorID());
		IListaEncadenadaDoble<Restaurante> resp = new ListaEncadenadaDoble<Restaurante>();
		Restaurante ini  = lista.volverActualPrimero();
		while(ini!=null)
		{
			if(ini.getID().contains(id))
			{
				System.out.println(ini.getID());
				resp.adicionar(ini, new comparadorID());
			}
			ini = lista.adelantarse();
		}
		return  resp;
	}

	@Override
	public IListaEncadenadaDoble<Restaurante> buscarPorLocacion(String estado,String ciudad) 
	{
		IListaEncadenadaDoble<Restaurante> lista = tablaLocalidadEstado.darLista(ciudad+"-"+estado,new ComparadorLocalidad());
		IListaEncadenadaDoble<Restaurante> resp = new ListaEncadenadaDoble<Restaurante>();
		Restaurante ini  = lista.volverActualPrimero();
		while(ini!=null)
		{
			if(ini.getID().contains(ciudad)&& ini.getID().contains(estado))
			{
				System.out.println(ini.getID());
				resp.adicionar(ini, new comparadorID());
			}
			ini = lista.adelantarse();
		}
		return  resp;
	}

	@Override
	public void registrarUsuario(String pUser, String pPass, String nNombre, String nApellido, String nCedula,String nMail) throws Exception 
	{
		// TODO Auto-generated method stub
		Usuario nuevo = new Usuario(pUser,pPass,nNombre,nApellido,nCedula,nMail,this);
		Usuario nuevo1 = new Usuario(pUser,pPass,nNombre,nApellido,nCedula,nMail,this);
		if(registrados.buscarElemento(nuevo, new comparadorNombreUs()) != null || registrados.buscarElemento(nuevo1,new comparadorCedula()) != null)
		{
			throw new Exception("Ya existe una persona registrada con esos datos");
		}
		else
		{
			registrados.adicionar(nuevo,new comparadorNombreUs());
		}
		
	}
	
	public boolean verificarUsuario(String pPass, String pUser) 
	{
		Usuario buscado = new Usuario(pUser, pPass, "", "", "", "",this);
		Usuario encontrado = registrados.buscarElemento(buscado, new comparadorNombreUs());
		if(encontrado!=null)
		{
			if(encontrado.darPassword().equals(pPass))
			{
				usuarioRegistradoActual = encontrado;
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public Usuario darUsuarioActual() {
		// TODO Auto-generated method stub
		return usuarioRegistradoActual;
	}

	public void eliminarRestaurante(String id) throws Exception 
	{
		IListaEncadenadaDoble<Restaurante> r =  buscarPorIdentidicadorCompuesto(id);
		Restaurante ini = r.volverActualPrimero();
		while(ini!=null)
		{
			restauranteArregloPrueba[ini.getPos()] = null;
			tablaIdentifcadorCompuesto.eliminar(ini.getID(), new comparadorRestaurantes());
			String[] c = ini.getID().split("-");
			tablaLocalidadEstado.eliminar(c[1]+"-"+c[2], new comparadorRestaurantes());
			String[] tipsCocina = ini.getCocina().split(",");
			String[] tipsCategoria = ini.getCategoria().split(",");
			for(int i =  0; i <tipsCocina.length;i++)
			{
				String coc = tipsCocina[i];
				boolean borro = false;
				for(int j = 0 ; j<cocinasRestaurante.length &&!borro;j++)
				{
					Cocina act = cocinasRestaurante[j];
					if(act.getNombre().equals(coc)&& act.getEstado().equals(ini.getEstado()))
					{
						act.bajarCantidad();
						listaOrdenadaCocinas.eliminar(act, new comparadorCocinaNombre());
						borro = true;
						listaOrdenadaCocinas.adicionar(act, new comparadorCocinaCantidad());
					}
				}
			}
			for(int i =  0; i <tipsCategoria.length;i++)
			{
				String coc = tipsCategoria[i];
				boolean borro = false;
				for(int j = 0 ; j<categoriasRestaurante.length &&!borro;j++)
				{
					Categoria act = categoriasRestaurante[j];
					if(act.getNombre().equals(coc))
					{
						
						act.bajarCantidad();
						try {
							listaOrdenadaCategorias.eliminar(act, new comparadorNombreCategoria());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						borro = true;
						listaOrdenadaCategorias.adicionar(act, new comparadorCantidadCategorias());
					}
				}
			}
			ini = r.adelantarse();
		}
		
	}
	
	public void darCategoriasPopulares(String[] categoriaT)
	{
		int indez = 0;
		String revisadas = "";
		while(indez<categoriaT.length)
		{
			
			boolean teermino = false;
			String categoria = categoriaT[indez];
			
			if(revisadas.contains(categoria)==false)
			{
				for(int i = 0 ; i<categoriasRestaurante.length && !teermino;i++)
				{
					Categoria actual = categoriasRestaurante[i];
					if(actual!=null)
					{
						if(actual.getNombre().equals(categoria))
						{
							try {
								listaOrdenadaCategorias.eliminar(actual, new comparadorNombreCategoria());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							actual.setCantidad();
							teermino = true;
							listaOrdenadaCategorias.adicionar(actual, new comparadorCantidadCategorias());
						}
					}
					else
					{
						categoriasRestaurante[i] =  new Categoria(1, categoria);
						listaOrdenadaCategorias.adicionar(categoriasRestaurante[i], new comparadorCantidadCategorias());
						teermino = true;
					}
				}

			}
			indez++;		
			revisadas+=categoria+"-";
		}
	}

		public void darCocinasPopulares(String[] cocinaT, String estado)
		{
			int indez = 0;
			String revisadas = "";
			while(indez<cocinaT.length)
			{
				
				boolean teermino = false;
				String categoria = cocinaT[indez];
				
				if(revisadas.contains(categoria)==false)
				{
					for(int i = 0 ; i<cocinasRestaurante.length && !teermino;i++)
					{
						Cocina actual = cocinasRestaurante[i];
						if(actual!=null)
						{
							if(actual.getNombre().equals(categoria) && actual.getEstado().equals(estado) )
							{
								try {
									listaOrdenadaCocinas.eliminar(actual, new comparadorCocinaNombre());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								actual.setCantidad();
								teermino = true;
								listaOrdenadaCocinas.adicionar(actual, new comparadorCocinaCantidad());
							}
						}
						else
						{
							cocinasRestaurante[i] =  new Cocina(1, categoria,estado);
							listaOrdenadaCocinas.adicionar(cocinasRestaurante[i] , new comparadorCocinaCantidad());
							teermino = true;
						}
					}

				}
				indez++;		
				revisadas+=categoria+"-";
			}	

		}
	
		public IListaEncadenadaDoble<Categoria> darCategorias()
		{
			return listaOrdenadaCategorias;
		}
		
		public IListaEncadenadaDoble<Cocina> darCocinas()
		{
			return listaOrdenadaCocinas;
		}
		
		public Restaurante[] crearArregloPorLocacion(String estado, String ciudad)
		{
			IListaEncadenadaDoble<Restaurante> lista =  buscarPorLocacion(estado, ciudad);
			Restaurante[] respuesta = new Restaurante[lista.darTamano()];
			
			Restaurante ini = lista.volverActualPrimero();
			int indice = 0;
			while(ini!=null)
			{
				respuesta[indice] = ini;
				indice++;
				ini = lista.adelantarse();
			}
			return respuesta;			
		}
		
		public Restaurante[] crearArregloPorId(String id)
		{
			IListaEncadenadaDoble<Restaurante> lista =  buscarPorIdentidicadorCompuesto(id);
			Restaurante[] respuesta = new Restaurante[lista.darTamano()];
			
			Restaurante ini = lista.volverActualPrimero();
			int indice = 0;
			while(ini!=null)
			{
				respuesta[indice] = ini;
				indice++;
				ini = lista.adelantarse();
			}
			return respuesta;			
		}
		
		

}

package mundo;

import java.io.File;

import estructuraDatos.ListaEncadenadaDoble;
import estructuraDeDatos.ITablaHash;
import estructuraDeDatos.TablaHash;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ConsultorRestaurantes implements IConsultorRestaurantes
{
	
	private ITablaHash<Restaurante, String> tablaIdentifcadorCompuesto;
	private Restaurante[] restauranteArregloPrueba;
	private int indiceActual;
	
	public ConsultorRestaurantes()
	{
		tablaIdentifcadorCompuesto  = new TablaHash<Restaurante, String>();
		restauranteArregloPrueba = new Restaurante[5000];
		indiceActual = 0;
		
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
				String horario = hoja.getCell(21, j).getContents();
				String cocina = hoja.getCell(23, j).getContents();
				cocina = cocina.replace("\"", "");
				cocina = cocina.replace("[", "");
				cocina = cocina.replace("]", "");
				Restaurante r = new Restaurante(nombre, ciudad, estado,direccion,post,telefono,fax,latitud,longitud,barrio,web,email,categoria,horario,cocina);
				tablaIdentifcadorCompuesto.agregar(r, r.getID(), new comparadorRestaurantes());
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
	
	public static void main(String[] args) {
		 new ConsultorRestaurantes().cargarXLS();
	}

	public Restaurante[] darRestaurantesPrueba()
	{
		return restauranteArregloPrueba;
	}

	@Override
	public ListaEncadenadaDoble<Restaurante> buscarPorIdentidicadorCompuesto(
			String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListaEncadenadaDoble<Restaurante> buscarPorLocacion(String estado,
			String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarUsuario(Usuario pUser) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario darUsuarioActual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarRestaurante(String id) {
		// TODO Auto-generated method stub
		
	}
	
	

}

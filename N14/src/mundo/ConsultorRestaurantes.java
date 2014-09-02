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
	
	private ITablaHash<Restaurante, String> tabla;
	private ListaEncadenadaDoble<String> ids;
	
	public ConsultorRestaurantes()
	{
		tabla  = new TablaHash<Restaurante, String>();
		ids = new ListaEncadenadaDoble<String>();
		
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
				Restaurante r = new Restaurante(nombre, ciudad, estado);
				ids.adicionar(r.getID(), new comparadorID());
				String  id = ids.buscarElemento(r.getID(), new comparadorID() ).hashCode()+"";
				System.out.println(tabla.agregar(r, id, new comparadorNombre())+"\t"+r.getID());
			}
			System.out.println("Leyo ultimo");

		}
		catch ( Exception e)
		{
			System.out.println("excepcion" + e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		 new ConsultorRestaurantes().cargarXLS();
	}

	
	

}

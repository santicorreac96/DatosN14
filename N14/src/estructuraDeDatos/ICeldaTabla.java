package estructuraDeDatos;

import java.io.Serializable;

public interface ICeldaTabla <E,K extends String> extends Serializable
{
	
	/**
	 * Metodo que retorna el elemento en la celda
	 * @return el elemento en la celda
	 */
	public abstract E darElemento();
	
	/**
	 * Metodo que retorna la llave del elemento guardado
	 * @return la llave del elemento
	 */
	public abstract K darLlave();
	
	
	/**
	 * metodo que da la ID del elemento
	 * @return
	 */
	public abstract K darID();

	
	
	

}

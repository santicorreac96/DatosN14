package estructuraDeDatos;

public interface ICeldaTabla <E,K extends String>
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

	
	
	

}

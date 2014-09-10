package estructuraDeDatos;

import java.io.Serializable;

public class CeldaTabla<E,K extends String> implements ICeldaTabla<E, K >, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private E elementoActual;
	private K id;
	private K llave;

	public CeldaTabla(E nElemento,K nid, K nLlave) 
	{
		elementoActual = nElemento;
		id = nid;
		llave = nLlave;
	}

	@Override
	public E darElemento() {
		// TODO Auto-generated method stub
		return elementoActual;
	}

	@Override
	public K darLlave() {
		// TODO Auto-generated method stub
		return llave;
	}
	
	public K darID()
	{
		return id;
	}


}

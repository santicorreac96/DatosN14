package estructuraDeDatos;

public class CeldaTabla<E,K> implements ICeldaTabla<E, K>
{
	private E elementoActual;
	
	private K llave;

	public CeldaTabla(E nElemento, K nLlave) 
	{
		elementoActual = nElemento;
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

	@Override
	public void modificarElemento(E pElemento) 
	{
		elementoActual = pElemento;
	}

}

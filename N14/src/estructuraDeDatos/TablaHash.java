package estructuraDeDatos;

import estructuraDatos.ListaEncadenadaDoble;

public class TablaHash<E,K> implements ITablaHash<E, K>
{
	
	private  ListaEncadenadaDoble<K>[] celdas;

	@Override
	public E agregar(E nElemento, K nLlave) 
	{
		int pos = funcion(nLlave);
		celdas[pos].adicionar(nElemento, comparador);						
	}

	@Override
	public E darElemento(K pLlave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E eliminar(K pLlave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int darCantidadElementos() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private int funcion(K pLlave)
	{
		int valor = (Integer) pLlave;
		
	}

}

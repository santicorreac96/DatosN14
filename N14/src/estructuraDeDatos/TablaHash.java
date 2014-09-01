package estructuraDeDatos;

import java.util.Comparator;

import estructuraDatos.ListaEncadenadaDoble;

public class TablaHash<E,K> implements ITablaHash<E, K>
{
	
	private  ListaEncadenadaDoble<E>[] celdas;
	
	private int cantidadElementos;

	@Override
	public void agregar(E nElemento, K nLlave, Comparator<E> comparador) 
	{
		int pos = funcion(nLlave);
		celdas[pos].adicionar(nElemento, comparador);	
		cantidadElementos++;
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
		return valor;
		
	}

}

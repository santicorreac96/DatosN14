package estructuraDeDatos;

import java.util.Comparator;

import estructuraDatos.ListaEncadenadaDoble;

public class TablaHash<E,K> implements ITablaHash<E, K>
{
	
	private  ListaEncadenadaDoble<CeldaTabla<E, K>>[] celdas;
	
	private int cantidadElementos;

	public void agregar(E nElemento, K nLlave, Comparator<CeldaTabla<E, K>> comparador) 
	{
		int pos = funcion(nLlave);
		CeldaTabla<E,K> celdaMeter = new CeldaTabla(nElemento, nLlave);
		if(celdas[pos].buscarElemento(celdaMeter,comparador)==null)
		{
			celdas[pos].adicionar(celdaMeter, comparador);
		}
		cantidadElementos++;
	}

	@Override
	public E darElemento(K pLlave) {
		cantidadElementos++;
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

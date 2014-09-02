package estructuraDeDatos;

import java.util.Comparator;

import estructuraDatos.ListaEncadenadaDoble;

public class TablaHash<E,K extends String> implements ITablaHash<E, K >
{
	
	private  ListaEncadenadaDoble<CeldaTabla<E, K>>[] celdas;

	private int cantidadElementos;
	
	public TablaHash()
	{
		celdas =  new ListaEncadenadaDoble[5000];

		for(int i =  0; i< celdas.length;i++)
		{
			celdas[i] = new ListaEncadenadaDoble<CeldaTabla<E,K>>();
		}

	}

	public int agregar(E nElemento, K nLlave, Comparator<CeldaTabla<E, K>> comparador) 
	{
		int pos = funcion(nLlave);
		CeldaTabla<E,K> celdaMeter = new CeldaTabla(nElemento, nLlave);
		celdas[pos].adicionar(celdaMeter, comparador);
		cantidadElementos++;
		return pos;
	}

	@Override
	public E darElemento(K pLlave) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E eliminar(E elemento ,K pLlave, Comparator<E> comparador) 
	{
		int pos = funcion(pLlave);
		celdas[pos].eliminar(elemento, comparador);
	}

	@Override
	public int darCantidadElementos() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private int funcion(K pLlave)
	{
		int valor = Integer.parseInt(pLlave);
		return Math.abs(valor-1)%5000;
	}

}

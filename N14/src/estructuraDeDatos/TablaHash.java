package estructuraDeDatos;

import java.io.Serializable;
import java.util.Comparator;

import mundo.comparadorID;
import mundo.comparadorRestaurantesID;


public class TablaHash<E,K extends String> implements ITablaHash<E, K >,Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  IListaEncadenadaDoble<CeldaTabla<E, K>>[] celdas;

	private int cantidadElementos;

	private int tamano;
	
	private Comparator<CeldaTabla<E, K>> comparadorAgregar;
	
	public TablaHash()
	{
		tamano = 5000;
		celdas =  new ListaEncadenadaDoble[tamano];

		for(int i =  0; i< celdas.length;i++)
		{
			celdas[i] = new ListaEncadenadaDoble<CeldaTabla<E,K>>();
		}

	}

	public void agregar(E nElemento, K nLlave, K id,Comparator<CeldaTabla<E, K>> comparador) 
	{

		comparadorAgregar = comparador;
		int pos = funcion(nLlave);
		CeldaTabla<E,K> celdaMeter = new CeldaTabla(nElemento,id, nLlave);
		celdas[pos].adicionar(celdaMeter, comparador);
		cantidadElementos++;
		if(cantidadElementos/tamano>0.8)
		{
			agrandarArreglo();
		}
	}

	@Override
	public E darElemento(K pLlave, K id, Comparator<CeldaTabla<E, K>> comparador) 
	{
		int pos = funcion(pLlave);
		CeldaTabla<E,K> buscada = new CeldaTabla(null, id ,pLlave);
		CeldaTabla<E,K> encontrada = celdas[pos].buscarElemento(buscada, comparador);
		return encontrada.darElemento();
		
	}

	@Override
	public void  eliminar(K pLlave,K id, Comparator<CeldaTabla<E, K>> comparador) throws Exception 
	{
		int pos = funcion(pLlave);
		CeldaTabla<E,K> buscada = new CeldaTabla(null,id, pLlave);
		CeldaTabla<E,K> encontrada = celdas[pos].buscarElemento(buscada, comparador);
		celdas[pos].eliminar(encontrada, comparador);
		cantidadElementos--;
	}

	@Override
	public int darCantidadElementos() 
	{
		return cantidadElementos;
	}
	
	private int funcion(K pLlave)
	{
		int val = 0 ;
		char[] letras = pLlave.toCharArray();
		for(int i = 0 ; i<letras.length;i++)
		{
			val+=letras[i]-60;
		}
		return Math.abs(val%tamano);
	}
	
	private void agrandarArreglo()
	{
		int tamanoant = tamano;
		tamano  = tamano *2;
		 IListaEncadenadaDoble<CeldaTabla<E, K>>[] anterior = celdas;
		 celdas =  new ListaEncadenadaDoble[tamano];

			for(int i =  0; i< celdas.length;i++)
			{
				celdas[i] = new ListaEncadenadaDoble<CeldaTabla<E,K>>();
			}
			cantidadElementos=0;
		for(int i = 0 ; i<tamanoant;i++)
		{
			IListaEncadenadaDoble<CeldaTabla<E, K>> reshash =  anterior[i];
			
			if(reshash.darTamano()>0)
			{
				reshash.volverActualPrimero();
				CeldaTabla<E, K> act = reshash.darActual();
				agregar(act.darElemento(), act.darLlave(), act.darID(),comparadorAgregar);
				act = anterior[i].adelantarse();
				while(act !=null)
				{
					agregar(act.darElemento(), act.darLlave(),act.darID() ,comparadorAgregar);
					act = anterior[i].adelantarse();
				}
			}
		}
	}

	public IListaEncadenadaDoble<E> darLista(K pLlave, Comparator<E> comparador)
	{
		IListaEncadenadaDoble<E> resp = new ListaEncadenadaDoble<E>();
		int pos = funcion(pLlave);
		IListaEncadenadaDoble ce  =celdas[pos];
		E ini = null;
		CeldaTabla<E, K> act = celdas[pos].volverActualPrimero();
		if(act!=null)
		{
			ini = act.darElemento();
		}
		while(ini!=null)
		{
			resp.adicionar(ini, comparador);
			act = celdas[pos].adelantarse();
			if(act!=null)
			{
				ini = act.darElemento();
			}
			else
			{
				ini = null;
			}
		}
		return resp;
		
	}

}

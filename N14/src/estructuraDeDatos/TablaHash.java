package estructuraDeDatos;

import java.util.Comparator;

import estructuraDatos.IListaEncadenadaDoble;
import estructuraDatos.ListaEncadenadaDoble;

public class TablaHash<E,K extends String> implements ITablaHash<E, K >
{
	
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

	public void agregar(E nElemento, K nLlave, Comparator<CeldaTabla<E, K>> comparador) 
	{

		comparadorAgregar = comparador;
		int pos = funcion(nLlave);
		CeldaTabla<E,K> celdaMeter = new CeldaTabla(nElemento, nLlave);
		celdas[pos].adicionar(celdaMeter, comparador);
		cantidadElementos++;
		if(cantidadElementos/tamano>0.8)
		{
			agrandarArreglo();
		}
	}

	@Override
	public E darElemento(K pLlave, Comparator<CeldaTabla<E, K>> comparador) 
	{
		int pos = funcion(pLlave);
		CeldaTabla<E,K> buscada = new CeldaTabla(null, pLlave);
		CeldaTabla<E,K> encontrada = celdas[pos].buscarElemento(buscada, comparador);
		return encontrada.darElemento();
		
	}

	@Override
	public void  eliminar(K pLlave, Comparator<CeldaTabla<E, K>> comparador) throws Exception 
	{
		int pos = funcion(pLlave);
		CeldaTabla<E,K> buscada = new CeldaTabla(null, pLlave);
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
				agregar(act.darElemento(), act.darLlave(), comparadorAgregar);
				act = anterior[i].adelantarse();
				while(act !=null)
				{
					agregar(act.darElemento(), act.darLlave(), comparadorAgregar);
					act = anterior[i].adelantarse();
				}
			}
		}
	}

}

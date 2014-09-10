package estructuraDeDatos;

import java.io.Serializable;
import java.util.Comparator;


public interface ITablaHash <E,K extends String> extends Serializable
{
	
/**
 * Metodo que permite agregar un elemento a la tabla 
 * @param nElemento El elemento a agregar a la tabla
 * @param nLlave La llave utilizada para determinar la posicion en la tabla
 * @param comparador El comparador para ubicar el objeto en la lista
 * @return
 */
public abstract void agregar(E nElemento, K nLlave,K id,Comparator<CeldaTabla<E, K>> comparador);
	
	/**
	 * Metodo que retorna un elemento de la tabla de hash
	 * @param pLlave La llave utilizada para  encontrar el elemento
	 * @param comparador Comparador utilizado para encontrar el elemento en la lista.
	 * @return El elemento buscado.
	 */
	public abstract E darElemento(K pLlave,K id ,Comparator<CeldaTabla<E, K>> comparador) ;
	
	/**
	 * metodo que permite eliminar un elemento de la tabla de hash
	 * @param pLlave La llave utilizada para  encontrar el elemento
	 * @param comparador Comparador utilizado para encontrar el elemento en la lista.
	 * @throws Exception Si no hay elementos en la lista a eliminar.
	 */
	public abstract void eliminar(K pLlave, K id, Comparator<CeldaTabla<E, K>> comparador) throws Exception ;
	
	/**
	 * Metodo que retorna la cantidad total de elementos en la tabla
	 * @return La cantidad de elementos en la tabla
	 */
	public abstract int darCantidadElementos();
	
	
	public abstract IListaEncadenadaDoble darLista(K pLlave, Comparator<E> comparador);


}

package estructuraDeDatos;

import java.util.Comparator;

public interface ITablaHash <E,K extends String>
{
	
public abstract int agregar(E nElemento, K nLlave,Comparator<CeldaTabla<E, K>> comparador);
	
	public abstract E darElemento(K pLlave, Comparator<CeldaTabla<E, K>> comparador) ;
	
	public abstract void eliminar(K pLlave, Comparator<CeldaTabla<E, K>> comparador) throws Exception ;
	
	public abstract int darCantidadElementos();


}

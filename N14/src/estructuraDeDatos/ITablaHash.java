package estructuraDeDatos;

import java.util.Comparator;

public interface ITablaHash <E,K>
{
	
public abstract void agregar(E nElemento, K nLlave,Comparator<E> comparador);
	
	public abstract E darElemento(K pLlave);
	
	public abstract E eliminar(K pLlave);
	
	public abstract int darCantidadElementos();

}

package estructuraDeDatos;

import java.util.Comparator;

public interface ITablaHash <E,K extends String>
{
	
public abstract void agregar(E nElemento, K nLlave,Comparator<CeldaTabla<E, K>> comparador);
	
	public abstract E darElemento(K pLlave);
	
	public abstract E eliminar(K pLlave);
	
	public abstract int darCantidadElementos();


}

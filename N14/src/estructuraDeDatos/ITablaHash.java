package estructuraDeDatos;

public interface ITablaHash <E,K>
{
	
public abstract E agregar(E nElemento, K nLlave);
	
	public abstract E darElemento(K pLlave);
	
	public abstract E eliminar(K pLlave);
	
	public abstract int darCantidadElementos();

}

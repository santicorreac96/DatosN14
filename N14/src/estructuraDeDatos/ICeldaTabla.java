package estructuraDeDatos;

public interface ICeldaTabla <E,K>
{
	
	public abstract E darElemento();
	
	public abstract K darLlave();
	
	public abstract void modificarElemento(E pElemento);
	
	
	
	

}

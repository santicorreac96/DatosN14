package estructuraDeDatos;

public interface ICeldaTabla <E,K extends String>
{
	
	public abstract E darElemento();
	
	public abstract K darLlave();
	
	public abstract void modificarElemento(E pElemento);
	
	
	
	

}

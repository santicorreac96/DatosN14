package mundo;

import java.io.Serializable;
import java.util.Comparator;

public class comparadorCantidadCategorias implements Comparator<Categoria> ,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Categoria arg0, Categoria arg1) 
	{
		if(arg0.getCantidad()>arg1.getCantidad())
		{
			return -1;
		}
		else if(arg0.getCantidad()==arg1.getCantidad())
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}

}

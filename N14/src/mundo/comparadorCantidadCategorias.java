package mundo;

import java.util.Comparator;

public class comparadorCantidadCategorias implements Comparator<Categoria>
{

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

package mundo;

import java.util.Comparator;

public class comparadorCocinaCantidad implements Comparator<Cocina>
{

	@Override
	public int compare(Cocina o1, Cocina o2) 
	{
		if(o1.getCantidad()>o2.getCantidad())
		{
			return -1;
		}
		else if(o1.getCantidad()==o2.getCantidad())
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
}

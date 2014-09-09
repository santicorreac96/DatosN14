package mundo;

import java.util.Comparator;

public class comparadorCocinaNombre implements Comparator<Cocina>
{

	@Override
	public int compare(Cocina o1, Cocina o2) 
	{
		return o1.getNombre().compareTo(o2.getNombre());
	}

}

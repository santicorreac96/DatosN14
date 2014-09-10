package mundo;

import java.io.Serializable;
import java.util.Comparator;

public class comparadorCocinaNombre implements Comparator<Cocina>,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Cocina o1, Cocina o2) 
	{
		return o1.getNombre().compareTo(o2.getNombre());
	}

}

package mundo;

import java.util.Comparator;

public class comparadorCedula implements Comparator<Usuario>
{

	@Override
	public int compare(Usuario o1, Usuario o2) 
	{
		return o1.darCedula().compareTo(o2.darCedula());
	}

}

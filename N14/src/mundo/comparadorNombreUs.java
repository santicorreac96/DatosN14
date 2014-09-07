package mundo;

import java.util.Comparator;

public class comparadorNombreUs implements Comparator<Usuario>
{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		
		return o1.darUsuario().compareTo(o2.darUsuario());
	}

	
}

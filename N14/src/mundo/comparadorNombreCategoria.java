package mundo;

import java.io.Serializable;
import java.util.Comparator;

public class comparadorNombreCategoria implements Comparator<Categoria>,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Categoria o1, Categoria o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}

}

package mundo;

import java.util.Comparator;

public class comparadorNombreCategoria implements Comparator<Categoria>
{

	@Override
	public int compare(Categoria o1, Categoria o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}

}

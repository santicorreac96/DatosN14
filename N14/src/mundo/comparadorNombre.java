package mundo;

import java.util.Comparator;

import estructuraDeDatos.CeldaTabla;

public class comparadorNombre implements Comparator<CeldaTabla<Restaurante, String>>

{

	@Override
	public int compare(CeldaTabla<Restaurante, String> o1,
			CeldaTabla<Restaurante, String> o2) {
		// TODO Auto-generated method stub
		return o1.darElemento().getNombre().compareTo(o2.darElemento().getNombre());
	}

}

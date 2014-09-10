package mundo;

import java.io.Serializable;
import java.util.Comparator;

import estructuraDeDatos.CeldaTabla;

public class comparadorRestaurantesID implements Comparator<CeldaTabla<Restaurante, String>>,Serializable
{
	
	@Override
	public int compare(CeldaTabla<Restaurante, String> o1,
			CeldaTabla<Restaurante, String> o2) {
		// TODO Auto-generated method stub
		return o1.darID().compareTo(o2.darID());
	}

}

package mundo;

import java.util.Comparator;

public class ComparadorLocalidad implements Comparator<Restaurante >
{

	@Override
	public int compare(Restaurante o1, Restaurante o2) 
	{
String s1 = o1.getCiudad()+"-"+o1.getEstado();
String s2 = o2.getCiudad()+"-"+o2.getEstado();
return s1.compareTo(s2);
	}
	
	

}

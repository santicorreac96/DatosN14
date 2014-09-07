package mundo;

import java.util.Comparator;

public class comparadorID implements Comparator<Restaurante>
{

	@Override
	public int compare(Restaurante o1, Restaurante o2) {
		String s1 = o1.getID();
		String s2 = o2.getID();
		return s1.compareTo(s2);
	}
	
	

}

package net.ycod3r.utils;

import java.util.Comparator;

import net.ycod3r.domain.Moyenne;

public class MoyenneComparatorDesc implements Comparator<Moyenne>{

	@Override
	public int compare(Moyenne o1, Moyenne o2) {
		
		int classeCompare = o1.getEleve().getClasse().getName().compareTo(o2.getEleve().getClasse().getName());
		int moyenneCompare = o2.getMoyenne().compareTo(o1.getMoyenne()); 
		
		int compare = classeCompare;
		if(compare == 0)
			compare = moyenneCompare;
		
		return compare;
	}

}

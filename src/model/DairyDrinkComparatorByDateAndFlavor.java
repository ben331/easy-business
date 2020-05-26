package model;

import java.util.Comparator;

public class DairyDrinkComparatorByDateAndFlavor implements Comparator<DairyDrink> {
	@Override
	public int compare(DairyDrink d1, DairyDrink d2) {
		int difference;
		if(d1 instanceof Yoghurt && d2 instanceof Oat) {
			difference = 1;
		}else if(d1 instanceof Oat && d2 instanceof Yoghurt) {
			difference = -1;
		}else { 
			difference = d1.getPreparationDate().compareTo(d2.getPreparationDate());
			if (difference ==0 && (d1 instanceof Yoghurt && d2 instanceof Yoghurt)){
				difference = ((Yoghurt)(d1)).getFlavor().compareTo(((Yoghurt)(d2)).getFlavor());
			}
		}
		return difference;
	}
}

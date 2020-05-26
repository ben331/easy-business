package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("serial")
public class Yoghurt extends DairyDrink implements AnalyzableByCost, Serializable{
	
	public static final ArrayList<String> FLAVORS = new ArrayList<String>(Arrays.asList("Strawberry", "Blackberry", "Berries", "Lulo", "Passion fruit", "Mango", "Pineapple", "Peach", "Grape", "Arequipe", "Soursop", "Koumiss"));
	
	private String flavor;
	
	public Yoghurt(int code, String name, LocalDate preparationDate, char size, char sugarLevel, Settings settings, String flavor) {
		super(code,  name,   preparationDate, size, sugarLevel, settings);
		this.flavor=flavor;
	}

	public String getFlavor() {
		return flavor;
	}
	
	@Override
	public double getSalePrice() {
		return getSettings().getYoghurtPrice(getSize());
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	@Override
	public boolean isExpired() {
		LocalDate expiryDate = (LocalDate) Period.ofDays(getSettings().getDaysForYoghurtExpire()).addTo(getPreparationDate());
		return LocalDate.now().isAfter(expiryDate);
	}

	@Override
	public int calculateBreakEvenPoint(double gain) {
		int breakEvenPoint = (int) ((getSettings().getFixedCostYoghurt()+gain) / (getSalePrice() - getSettings().getVarCostYoghurt(getSize())));
		return breakEvenPoint;
	}
	
	@Override
	public int compareTo(DairyDrink y) {
		int difference  = super.compareTo(y);
		if(difference ==0) {
			difference = this.flavor.compareTo(((Yoghurt)(y)).flavor);
		}if(difference ==0) {
			difference = y.getSize() - this.getSize();
		}
		return difference;
	}
}

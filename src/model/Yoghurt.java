package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Yoghurt extends DairyDrink implements AnalyzableByCost, Expirable{
	
	public static final ArrayList<String> FLAVORS = new ArrayList<String>(Arrays.asList("Strawberry", "Blackberry", "Berries", "Lulo", "Passion fruit", "Mango", "Pineapple", "Peach", "Grape", "Arequipe", "Soursop", "Koumiss"));
	
	private String flavor;
	
	public Yoghurt(int code, String name, double salePrice, LocalDate preparationDate, char size, char sugarLevel, String flavor) {
		super(code,  name,  salePrice,  preparationDate, size, sugarLevel);
		this.flavor=flavor;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	@Override
	public boolean isExpired(int days) {
		
		return false;
	}

	@Override
	public void calculateBreakEvenPoint() {
		
	}
	
}

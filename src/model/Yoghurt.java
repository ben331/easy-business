package model;

import java.time.LocalDate;

public class Yoghurt extends DairyDrink implements AnalyzableByCost, Expirable{

	private String flavor;
	
	public Yoghurt(String code, String name, double salePrice, LocalDate preparationDate, char size, char sugarLevel, String flavor) {
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

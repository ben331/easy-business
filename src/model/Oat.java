package model;

import java.time.LocalDate;

public class Oat extends DairyDrink implements AnalyzableByCost, Expirable {

	private String typeOat;
	
	public Oat(String code, String name, double salePrice, LocalDate preparationDate, char size, char sugarLevel, String typeOat) {
		super(code,  name,  salePrice,  preparationDate, size, sugarLevel);
		this.typeOat=typeOat;
	}

	public String getTypeOat() {
		return typeOat;
	}

	public void setTypeOat(String typeOat) {
		this.typeOat = typeOat;
	}

	@Override
	public boolean isExpirable(int days) {
		
		return false;
	}

	@Override
	public void calculateBreakEvenPoint() {
		
	}
	
	
}

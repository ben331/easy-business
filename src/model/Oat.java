package model;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Oat extends DairyDrink implements AnalyzableByCost, Expirable, Serializable {

	private String typeOat;
	
	public Oat(int code, String name, LocalDate preparationDate, char size, char sugarLevel, Settings settings, String typeOat) {
		super(code,  name,    preparationDate, size, sugarLevel, settings);
		this.typeOat=typeOat;
	}

	public String getTypeOat() {
		return typeOat;
	}

	public void setTypeOat(String typeOat) {
		this.typeOat = typeOat;
	}
	
	@Override
	public double getSalePrice() {
		return getSettings().getOatPrice(getSize());
	}

	@Override
	public boolean isExpired(int days) {
		
		return false;
	}

	@Override
	public int calculateBreakEvenPoint(double gain) {
		int breakEvenPoint = (int) ((getSettings().getFixedCostOat() + gain)/ (getSalePrice() - getSettings().getVarCostOat(getSize())));
		return breakEvenPoint;
	}
}

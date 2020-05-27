package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@SuppressWarnings("serial")
public class Oat extends DairyDrink implements AnalyzableByCost, Serializable {

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
	public boolean isExpired() {
		LocalDate expiryDate = (LocalDate) Period.ofDays(getSettings().getDaysForOatExpire()).addTo(getPreparationDate());
		return LocalDate.now().isAfter(expiryDate);
	}

	@Override
	public int calculateBreakEvenPoint(double gain) {
		int breakEvenPoint = (int) Math.ceil((getSettings().getFixedCostOat() + gain)/ (getSalePrice() - getSettings().getVarCostOat(getSize())));
		return breakEvenPoint;
	}
}

package model;

public class Settings {
	private double priceYoghurt;
	private double priceOat;
	public double getPriceYoghurt() {
		return priceYoghurt;
	}
	public void setPriceYoghurt(double priceYoghurt) {
		this.priceYoghurt = priceYoghurt;
	}
	public double getPriceOat() {
		return priceOat;
	}
	public void setPriceOat(double priceOat) {
		this.priceOat = priceOat;
	}
	
	public Settings() {
		priceYoghurt = 11000;
		priceOat = 10000;
	}
	
	
}

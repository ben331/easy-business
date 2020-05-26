package model;

import java.io.Serializable;
import java.util.ArrayList;

import customException.EmptyDataException;

@SuppressWarnings("serial")
public class Settings implements Serializable {
	private ArrayList<String> productsNames;
	private ArrayList<DairyProduct> products;
	
	
	private double priceBigYoghurt;
	private double priceMedianYoghurt;
	private double priceSmallYoghurt;
	
	private double priceBigOat;
	private double priceMedianOat;
	private double priceSmallOat;
	
	private double fixedCostYoghurt;
	private double fixedCostOat;
	
	private double varCostBigYoghurt;
	private double varCostMedianYoghurt;
	private double varCostSmallYoghurt;
	
	private double varCostBigOat;
	private double varCostMedianOat;
	private double varCostSmallOat;
	
	private double fixedCostSeller;
	private double varCostSeller;
	
	private double fixedCostOperator;
	private double varCostOperator;
	
	private double fixedCostDomiciliary;
	private double varCostDomiciliary;
	
	private int daysForYoghurtExpire;
	private int daysForOatExpire;
	
	
	
	public Settings() {
		super();
		this.products = new ArrayList<DairyProduct>();
		this.productsNames = new ArrayList<String>();
		this.priceBigYoghurt = 25000;
		this.priceMedianYoghurt = 11000;
		this.priceSmallYoghurt = 6000;
		this.priceBigOat = 23000;
		this.priceMedianOat = 10000;
		this.priceSmallOat = 5500;
		this.fixedCostYoghurt = 50000;
		this.fixedCostOat = 40000;
		this.varCostBigYoghurt = 15000;
		this.varCostMedianYoghurt = 6000;
		this.varCostSmallYoghurt = 3000;
		this.varCostBigOat = 13750;
		this.varCostMedianOat = 5500;
		this.varCostSmallOat = 2750;
		
		fixedCostSeller=25000;
		varCostSeller=4000;
		
		fixedCostOperator=50000;
		varCostOperator=8000;
		
		fixedCostDomiciliary=20000;
		varCostDomiciliary=5000;
		
		daysForYoghurtExpire = 12;
		daysForOatExpire = 13;
	}
	
	
	
	public double getFixedCostSeller() {
		return fixedCostSeller;
	}



	public void setFixedCostSeller(double fixedCostSeller) {
		this.fixedCostSeller = fixedCostSeller;
	}



	public double getVarCostSeller() {
		return varCostSeller;
	}



	public void setVarCostSeller(double varCostSeller) {
		this.varCostSeller = varCostSeller;
	}



	public double getFixedCostOperator() {
		return fixedCostOperator;
	}



	public void setFixedCostOperator(double fixedCostOperator) {
		this.fixedCostOperator = fixedCostOperator;
	}



	public double getVarCostOperator() {
		return varCostOperator;
	}



	public void setVarCostOperator(double varCostOperator) {
		this.varCostOperator = varCostOperator;
	}



	public double getFixedCostDomiciliary() {
		return fixedCostDomiciliary;
	}



	public void setFixedCostDomiciliary(double fixedCostDomiciliary) {
		this.fixedCostDomiciliary = fixedCostDomiciliary;
	}



	public double getVarCostDomiciliary() {
		return varCostDomiciliary;
	}



	public void setVarCostDomiciliary(double varCostDomiciliary) {
		this.varCostDomiciliary = varCostDomiciliary;
	}



	public double getPriceBigYoghurt() {
		return priceBigYoghurt;
	}



	public void setPriceBigYoghurt(double priceBigYoghurt) {
		this.priceBigYoghurt = priceBigYoghurt;
	}



	public double getPriceMedianYoghurt() {
		return priceMedianYoghurt;
	}



	public void setPriceMedianYoghurt(double priceMedianYoghurt) {
		this.priceMedianYoghurt = priceMedianYoghurt;
	}



	public double getPriceSmallYoghurt() {
		return priceSmallYoghurt;
	}



	public void setPriceSmallYoghurt(double priceSmallYoghurt) {
		this.priceSmallYoghurt = priceSmallYoghurt;
	}



	public double getPriceBigOat() {
		return priceBigOat;
	}



	public void setPriceBigOat(double priceBigOat) {
		this.priceBigOat = priceBigOat;
	}



	public double getPriceMedianOat() {
		return priceMedianOat;
	}



	public void setPriceMedianOat(double priceMedianOat) {
		this.priceMedianOat = priceMedianOat;
	}



	public double getPriceSmallOat() {
		return priceSmallOat;
	}



	public void setPriceSmallOat(double priceSmallOat) {
		this.priceSmallOat = priceSmallOat;
	}



	public double getFixedCostYoghurt() {
		return fixedCostYoghurt;
	}



	public void setFixedCostYoghurt(double fixedCostYoghurt) {
		this.fixedCostYoghurt = fixedCostYoghurt;
	}



	public double getFixedCostOat() {
		return fixedCostOat;
	}



	public void setFixedCostOat(double fixedCostOat) {
		this.fixedCostOat = fixedCostOat;
	}



	public double getVarCostBigYoghurt() {
		return varCostBigYoghurt;
	}



	public void setVarCostBigYoghurt(double varCostBigYoghurt) {
		this.varCostBigYoghurt = varCostBigYoghurt;
	}



	public double getVarCostMedianYoghurt() {
		return varCostMedianYoghurt;
	}



	public void setVarCostMedianYoghurt(double varCostMedianYoghurt) {
		this.varCostMedianYoghurt = varCostMedianYoghurt;
	}



	public double getVarCostSmallYoghurt() {
		return varCostSmallYoghurt;
	}



	public void setVarCostSmallYoghurt(double varCostSmallYoghurt) {
		this.varCostSmallYoghurt = varCostSmallYoghurt;
	}



	public double getVarCostBigOat() {
		return varCostBigOat;
	}



	public void setVarCostBigOat(double varCostBigOat) {
		this.varCostBigOat = varCostBigOat;
	}



	public double getVarCostMedianOat() {
		return varCostMedianOat;
	}



	public void setVarCostMedianOat(double varCostMedianOat) {
		this.varCostMedianOat = varCostMedianOat;
	}



	public double getVarCostSmallOat() {
		return varCostSmallOat;
	}



	public void setVarCostSmallOat(double varCostSmallOat) {
		this.varCostSmallOat = varCostSmallOat;
	}



	public void addDairyProduct( String name, String salePrice, String description) throws EmptyDataException {
		
		double sPrice = Double.parseDouble(salePrice);
		
		String emptyFields = verifyFields(name, sPrice,description);
		if(!emptyFields.equals("")) {
			throw new EmptyDataException(emptyFields);
		}
		
		DairyProduct dp = new DairyProduct(name, sPrice,description);
		products.add(dp);
		
		String productName = products.size()+ ". "+name;
		productsNames.add(productName);
	}
	public ArrayList<String> getProductsNames() {
		return productsNames;
	}
	public ArrayList<DairyProduct> getProducts() {
		return products;
	}
	
	public String verifyFields(String name, double salePrice,String description) {
		String emptyFields="";

		if(name.equals("")) {
			emptyFields+="name -";
		}if(salePrice<=0) {
			emptyFields+="SalePrice ";
		}if(description.equals("")) {
			emptyFields+="description ";
		}
		return emptyFields;
	}
	
	public double getYoghurtPrice(char size) {
		double price=0;
		switch(size) {
		case DairyDrink.BIG:
			price = priceBigYoghurt;
			break;
		case DairyDrink.MEDIAN:
			price = priceMedianYoghurt;
			break;
		case DairyDrink.SMALL:
			price = priceSmallYoghurt;
			break;
		}
		return price;
	}
	
	public double getOatPrice(char size) {
		double price=0;
		switch(size) {
		case DairyDrink.BIG:
			price = priceBigOat;
			break;
		case DairyDrink.MEDIAN:
			price = priceMedianOat;
			break;
		case DairyDrink.SMALL:
			price = priceSmallOat;
			break;
		}
		return price;
	}
	
	public double getVarCostYoghurt(char size) {
		double price=0;
		switch(size) {
		case DairyDrink.BIG:
			price = varCostBigYoghurt;
			break;
		case DairyDrink.MEDIAN:
			price = varCostMedianYoghurt;
			break;
		case DairyDrink.SMALL:
			price = varCostSmallYoghurt;
			break;
		}
		return price;
	}
	
	public double getVarCostOat(char size) {
		double price=0;
		switch(size) {
		case DairyDrink.BIG:
			price = varCostBigOat;
			break;
		case DairyDrink.MEDIAN:
			price = varCostMedianOat;
			break;
		case DairyDrink.SMALL:
			price = varCostSmallOat;
			break;
		}
		return price;
	}



	public int getDaysForYoghurtExpire() {
		return daysForYoghurtExpire;
	}



	public void setDaysForYoghurtExpire(int daysForYoghurtExpire) {
		this.daysForYoghurtExpire = daysForYoghurtExpire;
	}



	public int getDaysForOatExpire() {
		return daysForOatExpire;
	}



	public void setDaysForOatExpire(int daysForOatExpire) {
		this.daysForOatExpire = daysForOatExpire;
	}
}

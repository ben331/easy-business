package model;

import java.time.LocalDate;
import java.util.ArrayList;

import customException.EmptyDataException;

public class Settings {
	private ArrayList<String> productsNames;
	private ArrayList<DairyProduct> products;
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
		productsNames = new ArrayList<String>();
		products = new ArrayList<DairyProduct>();
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
	
}

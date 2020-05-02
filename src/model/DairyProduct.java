package model;

import java.time.LocalDate;

public class DairyProduct {

	private String code;
	private String name;
	private double salePrice;
	private LocalDate preparationDate;
	
	public DairyProduct(String code, String name, double salePrice, LocalDate preparationDate) {
		super();
		this.code = code;
		this.name = name;
		this.salePrice = salePrice;
		this.preparationDate = preparationDate;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public LocalDate getPreparationDate() {
		return preparationDate;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public void setPreparationDate(LocalDate preparationDate) {
		this.preparationDate = preparationDate;
	}
	
	
	
}

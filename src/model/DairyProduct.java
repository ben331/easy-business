package model;

import java.time.LocalDate;

public class DairyProduct {

	private int code;
	private String name;
	private double salePrice;
	private LocalDate preparationDate;
	private String description;
	
	public DairyProduct(int code, String name, double salePrice, LocalDate preparationDate) {
		super();
		this.code = code;
		this.name = name;
		this.salePrice = salePrice;
		this.preparationDate = preparationDate;
	}
	
	public DairyProduct(String name, double salePrice, String description) {
		super();
		this.name = name;
		this.salePrice = salePrice;
		this.setDescription(description);
	}
	
	public DairyProduct(int code, String name, double salePrice, LocalDate preparationDate, String description) {
		super();
		this.code = code;
		this.name = name;
		this.salePrice = salePrice;
		this.preparationDate = preparationDate;
		this.setDescription(description);
	}

	public int getCode() {
		return code;
	}
	
	public Integer getCode1() {
		return new Integer(code);
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

	public void setCode(int code) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}

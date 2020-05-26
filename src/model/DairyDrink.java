package model;

import java.time.LocalDate;

public class DairyDrink extends DairyProduct {

	public static final char SMALL = 's';
	public static final char MEDIAN = 'm';
	public static final char BIG = 'b';
	public static final char LOW = 'l';
	public static final char NORMAL = 'n';
	
	private char size;
	private char sugarLevel;
	
	public DairyDrink(int code, String name, double salePrice, LocalDate preparationDate, char size, char sugarLevel) {
		super(code,  name,  salePrice,  preparationDate);
		this.size=size;
		this.sugarLevel=sugarLevel;
	}

	public char getSize() {
		return size;
	}

	public char getSugarLevel() {
		return sugarLevel;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public void setSugarLevel(char sugarLevel) {
		this.sugarLevel = sugarLevel;
	}
	
	

}

package model;

import java.time.LocalDate;
public class DairyDrink extends DairyProduct implements Comparable<DairyDrink>{

	public static final char SMALL = 's';
	public static final char MEDIAN = 'm';
	public static final char BIG = 'b';
	public static final char LOW = 'l';
	public static final char NORMAL = 'n';
	
	private Settings settings;
	private char size;
	private char sugarLevel;
	
	public DairyDrink(int code, String name, LocalDate preparationDate, char size, char sugarLevel, Settings settings) {
		super(code, name, 0, preparationDate);
		this.size=size;
		this.sugarLevel=sugarLevel;
		this.setSettings(settings);
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

	@Override
	public int compareTo(DairyDrink d) {
		int difference;
		if(this instanceof Yoghurt && d instanceof Oat) {
			difference = 1;
		}else if(this instanceof Oat && d instanceof Yoghurt) {
			difference = -1;
		}else {
			difference =0;
		}
		return difference;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}
}

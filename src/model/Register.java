package model;

import java.io.Serializable;
import java.time.LocalTime;

@SuppressWarnings("serial")
public class Register implements Serializable {

	public String detail;
	public double value;
	public boolean expense;
	private LocalTime time;
	
	public Register(String detail, double value, boolean expense,LocalTime time) {
		super();
		this.detail = detail;
		this.value = value;
		this.expense = expense;
		this.time=time;
	}

	public String getDetail() {
		return detail;
	}

	public double getValue() {
		return value;
	}

	public boolean isExpense() {
		return expense;
	}

	public LocalTime getTime() {
		return time;
	}
}

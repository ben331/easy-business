package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import customException.EmptyDataException;

public class CashRegister {
 
	private ArrayList<Register> registers;
	private double cash;
	
	public CashRegister() {
		registers = new ArrayList<Register>();
	}

	public double getCash() {
		return cash;
	}

	public ArrayList<Register> getRegisters() {
		return registers;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}
	
	public void registerMoney(String d, double v, boolean e) throws EmptyDataException {
		
		//Validations
		if(d.equals(""))
			throw new EmptyDataException("Detail");
		if(v==0)
			throw new EmptyDataException("Value");
		if(v<0)
			throw new NumberFormatException("Type a positive value");
		
		//If the register is an egress, then the value will be negative
		if(e)
			v = v*-1;
		
		Register register = new Register(d, v, e, LocalTime.now());	
		registers.add(register);
		
		cash +=v;
	}
}

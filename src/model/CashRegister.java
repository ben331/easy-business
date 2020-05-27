package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import customException.EmptyDataException;
import customException.InsufficientBalanceException;


@SuppressWarnings("serial")
public class CashRegister implements Serializable {
 
	public static final String FILE_NAME_PREFIX="data/registersCash/Registers_OfDate_";
	public static final String EXTENSION = ".reg";
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
	
	public void registerMoney(String d, double v, boolean e) throws EmptyDataException, InsufficientBalanceException {
		
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
		
		if((cash + v) < 50000) {
			throw new InsufficientBalanceException(-v, cash);
		}
		
		Register register = new Register(d, v, e, LocalTime.now());	
		registers.add(register);
		
		cash +=v;
	}
	
	public void saveRegisters() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME_PREFIX+LocalDate.now()+EXTENSION));
    	oos.writeObject(registers);
    	oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public void loadRegistersOfDate(LocalDate localDate) throws ClassNotFoundException, EmptyDataException, IOException, InsufficientBalanceException {
		if(localDate == null) {
			throw new EmptyDataException("Date");
		}
		String fileName = FILE_NAME_PREFIX + localDate + EXTENSION;
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			registers = (ArrayList<Register>)(ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
			if(localDate.isEqual(LocalDate.now())) {
				registerMoney("In existence", cash, false);
				cash= cash/2;
			}else {
				throw e;
			}
		}
		
	}
	
	public double determineCash() {
		double cash=0;
		for(int i=0; i<registers.size();i++) {
			cash+=registers.get(i).getValue();
		}
		this.cash = cash;
		return cash;
	}
}

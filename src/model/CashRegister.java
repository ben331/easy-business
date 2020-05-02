package model;

import java.util.ArrayList;
import java.util.List;

public class CashRegister {
 
	private Register registersRoot;
	private double cash;
	
	public CashRegister() {}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}
	
	public void registerMoner(String d, double v, boolean e) {
		
	}
	
	public List<Register> getRegisters(){
		List<Register> registers = new ArrayList<Register>();
		if(registersRoot!=null) {
			BSTtoListInOrder(registersRoot, registers);
		}
		return registers;
	}
	
	/**
	 * 
	 * @param current is a Register and an element of a BST. current!=null 
	 * @param list is a list of registers. list!=null
	 */
	private void BSTtoListInOrder(Register current, List<Register> list) {
		if(current.getLeft()!=null) {
			BSTtoListInOrder(current.getLeft(), list);
		}
		list.add(current);
		if(current.getRigth()!=null) {
			BSTtoListInOrder(current.getRigth(), list);
		}
	}
}

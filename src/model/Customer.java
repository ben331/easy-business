package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends Person{

	private Customer nextCustomer;
	private Customer prevCustomer;
	private double debValue;
	private ArrayList<LocalDate> purchasesDates;
	private ArrayList<String> purchasesDetail;
	
	public Customer(String id, String name, String lastName, String celphoneNumber, String address, double debValue) {
		super( id,  name,  lastName,  celphoneNumber,  address);
		this.debValue=debValue;
	}
	
	public boolean hasDebt() {
		
	}

	public Customer getNextCustomer() {
		return nextCustomer;
	}

	public Customer getPrevCustomer() {
		return prevCustomer;
	}
	
	public double getDebValue() {
		return debValue;
	}

	public ArrayList<LocalDate> getPurchasesDates() {
		return purchasesDates;
	}

	public ArrayList<String> getPurchasesDetail() {
		return purchasesDetail;
	}

	public void setNextCustomer(Customer nextCustomer) {
		this.nextCustomer = nextCustomer;
	}

	public void setPrevCustomer(Customer prevCustomer) {
		this.prevCustomer = prevCustomer;
	}
	
	public void setDebValue(double debValue) {
		this.debValue = debValue;
	}

	public void setPurchasesDates(ArrayList<LocalDate> purchasesDates) {
		this.purchasesDates = purchasesDates;
	}

	public void setPurchasesDetail(ArrayList<String> purchasesDetail) {
		this.purchasesDetail = purchasesDetail;
	}
	
}

package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class Customer extends Person{

	private Customer nextCustomer;
	private Customer prevCustomer;
	private double debtValue;
	private ArrayList<LocalDate> purchasesDates;
	private ArrayList<String> purchasesDetail;
	
	public Customer(String id, String name, String lastName, String celphoneNumber, String address, Image photo) {
		super( id,  name,  lastName,  celphoneNumber,  address, photo);
	}
	
	public boolean hasDebt() {
		return debtValue > 0;
	}

	public Customer getNextCustomer() {
		return nextCustomer;
	}

	public Customer getPrevCustomer() {
		return prevCustomer;
	}
	
	public double getDebtValue() {
		return debtValue;
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
	
	public void setDebtValue(double debValue) {
		this.debtValue = debValue;
	}

	public void setPurchasesDates(ArrayList<LocalDate> purchasesDates) {
		this.purchasesDates = purchasesDates;
	}

	public void setPurchasesDetail(ArrayList<String> purchasesDetail) {
		this.purchasesDetail = purchasesDetail;
	}
	
}

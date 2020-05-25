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
		purchasesDates = new ArrayList<LocalDate>();
		purchasesDetail = new ArrayList<String>();
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
	
	public int compareByDate(Customer c) {
		int difference;
		if(purchasesDates.size()==0 && c.getPurchasesDates().size()==0) {
			difference=0;
		}else if(purchasesDates.size()==0 && c.getPurchasesDates().size()>0) {
			difference=-1;
		}else if(purchasesDates.size()>0 && c.getPurchasesDates().size()==0) {
			difference = 1;
		}else{
			LocalDate last1=purchasesDates.get(purchasesDates.size()-1);
			LocalDate last2=c.getPurchasesDates().get(c.getPurchasesDates().size()-1);
			
			difference = last1.compareTo(last2);
		};
		
		return difference;
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

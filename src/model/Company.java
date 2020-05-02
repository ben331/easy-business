package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Company {
	
	private CashRegister cashRegister;
	
	private ArrayList<DairyProduct> dairyProducts;
	
	private ArrayList<DairyDrink> dairyDrinks;
	
	private Employee employees;
	
	private Employee activeEmployeesRoot;
	
	private Customer firstDebtor;
	
	private Customer firstCustomer;
	
	
	public void saveData() {
		
	}
	
	public void loadData() {
		
	}
	
	public void addYoghurts(String f, char s, char sz, int n) {
		
	}
	
	public void addOats(char t, int n) {
		
	}
	
	public void addProduct(String c, String n, double sp) {
		
	}
	
	public void sellProduct(String id, DairyProduct d, boolean paid) {
		
	}
	
	public void discardProduct(String code) {
		
	}
	
	public ArrayList<DairyProduct> searchExpiredProducts(){
		ArrayList<DairyProduct> expiredProducts=null;
		return expiredProducts;
	}
	
	public Customer searchCustomer(String id) {
		Customer customer = null;
		return customer;
	}
	
	public Customer searchDebtor(String id) {
		Customer debtor = null;
		return debtor;
	}
	
	public Employee searchEmployee(String id) {
		Employee employee = null;
		return employee;
	}
	
	public ArrayList<Register> searchRegisterOfDate(LocalDate date){
		ArrayList<Register> registers = null;
		return registers;
	}
	
	public void sortPByFlavorAndSize() {
		
	}
	
	public void sortPBySugarLevelAndFlavor() {
		
	}
	
	public void sortPByDateAndFlavor() {
		
	}
	
	public void sortCByFullName() {
		
	}
	
	public void sortCByLastPurchase() {
		
	}
	
	public void saveRegisters() {
		
	}
	
	public void collectMoney(String c) {
		
	}
	
	public void payPayroll() {
		
	}
	
	public void predictUpcomingSales() {
		
	}
	
	public void registerEntry(String id) {
		
	}
	
	public void registerDeparture(String id) {
		
	}
	
	public void addCustomer(String id, String name, String lastName, String celphoneNumber, String address, double debtValue) {
		Customer newCustomer = new Customer( id,  name,  lastName,  celphoneNumber,  address,  debtValue);
		
		if(firstCustomer==null) {
			firstCustomer=newCustomer;
		}else {
			Customer current = firstCustomer;
			while(current.getNextCustomer()!=firstCustomer) {
				current = current.getNextCustomer();
			}
			current.setNextCustomer(newCustomer);
			newCustomer.setPrevCustomer(current);
			newCustomer.setNextCustomer(firstCustomer);
			firstCustomer.setPrevCustomer(newCustomer);
			firstCustomer=newCustomer;
		}
	}

	public void addEmployee(String id, String name, String lastName, String celphoneNumber, String address, int hoursWorked, Employee head) {
		Employee newEmployee = new Employee(id,  name,  lastName,  celphoneNumber,  address,  hoursWorked); 
		if(head!=null) {
			addEmployee(newEmployee, head);
		}else {
			head = newEmployee;
		}
	}
	
	public void addNewProduct(String c, String n, double sp, LocalDate	pd) {
		
	}
	
	public String determineBalancePoints(double gain) {
		String report="";
		return report;
	}
}

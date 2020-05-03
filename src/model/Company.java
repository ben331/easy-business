package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Company {
	
	private CashRegister cashRegister;
	
	private ArrayList<DairyProduct> dairyProducts;
	
	private ArrayList<DairyDrink> dairyDrinks;
	
	private Employee employeesRoot;
	
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

	public void addEmployee(String id, String name, String lastName, String celphoneNumber, String address, int hoursWorked) {
		Employee newEmployee = new Employee(id,  name,  lastName,  celphoneNumber,  address,  hoursWorked); 
		Employee current = employeesRoot;
		boolean wasAdded=false;
		
		if(employeesRoot!=null) {
			while(!wasAdded) {
				if(current.compareTo(newEmployee)<0) {
					if(current.getLeft()!=null) {
						current.setLeft(newEmployee);
						wasAdded=true;
					}else {
						current=current.getLeft();
					}
				}else {
					if(current.getRight()!=null) {
						current.setRight(newEmployee);
						wasAdded=true;
					}else {
						current=current.getRight();
					}
				}
			}
		}else {
			employeesRoot=newEmployee;
		}
	}
	
	public void addNewProduct(String c, String n, double sp, LocalDate	pd) {
		
	}
	
	public String determineBalancePoints(double gain) {
		String report="";
		return report;
	}
	
	public ArrayList<DairyProduct> getDairyProducts() {
		return dairyProducts;
	}
	
	public ArrayList<DairyDrink> getDairyDrink(){
		return dairyDrinks;
	}

	public CashRegister getCashRegister() {
		return cashRegister;
	}

	public ArrayList<DairyDrink> getDairyDrinks() {
		return dairyDrinks;
	}

	public Employee getEmployeesRoot() {
		return employeesRoot;
	}

	public Employee getActiveEmployeesRoot() {
		return activeEmployeesRoot;
	}

	public Customer getFirstDebtor() {
		return firstDebtor;
	}

	public Customer getFirstCustomer() {
		return firstCustomer;
	}
	
	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		if(employeesRoot!=null) {
			BSTtoListInOrder(employeesRoot, employees);
		}
		return employees;
	}
	
	private void BSTtoListInOrder(Employee current, List<Employee> list) {
		if(current.getLeft()!=null) {
			BSTtoListInOrder(current.getLeft(), list);
		}
		list.add(current);
		if(current.getRight()!=null) {
			BSTtoListInOrder(current.getRight(), list);
		}
	}
	
	public List<Customer> getCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		if(firstCustomer.getNextCustomer()!=null) {
			LinkListToListInOrder(firstCustomer, customers);
		}
		return customers;
	}
	
	private void LinkListToListInOrder(Customer current, List<Customer>List) {
		if(current.getNextCustomer()!=null) {
			List.add(current);
			LinkListToListInOrder(current.getNextCustomer(), List);
		}
		List.add(current);
	}
}

package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import customException.*;
import javafx.scene.image.Image;

public class Company {
	
	//Attributes
	private CashRegister cashRegister;
	
	private ArrayList<DairyProduct> dairyProducts;
	
	private ArrayList<DairyDrink> dairyDrinks;
	
	private Employee employeesRoot;
	
	private Employee activeEmployeesRoot;
	
	private Customer firstDebtor;
	
	private Customer firstCustomer;
	
	private Settings settings;
	
	
	//Constructor----------------------------------------------------------------------------------------------------------------------
	public Company() {
		cashRegister = new CashRegister();
		dairyProducts = new ArrayList<DairyProduct>();
		dairyDrinks = new ArrayList<DairyDrink>();
		settings = new Settings();
	}
	
	
	//Getters---------------------------------------------------------------------------------------------------------------------------
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
		if(firstCustomer!=null) {
			Customer current = firstCustomer;
			do {
				customers.add(current);
				current=current.getNextCustomer();
			}while(current!=firstCustomer);
		}
		return customers;
	}
	
	//Analyzer methods-----------------------------------------------------------------------------------------------------------------
	
	//Customer Methods-----------------------------------------------------------------------------------------------------------------
	
	public Customer searchCustomer(String id) throws EmptyDataException {
		if(id==null || id.equals("")) {
			throw new EmptyDataException("id");
		}
		Customer customer=null;
		Customer current = firstCustomer;
		if(firstCustomer!=null) {
			do {
				current = current.getNextCustomer();
			}while(current!=firstCustomer && !current.getId().equals(id));
			if(current.getId().equals(id)) {
				customer = current;
			}
		}
		return customer;
	}
	
	public void addDebtor(Customer newDebtor) {		
		//Case: Empty list.
		if(firstDebtor==null) {
			firstDebtor=newDebtor;
			firstDebtor.setNextCustomer(newDebtor);
			firstDebtor.setPrevCustomer(newDebtor);
		}
		//Case: List with size: 1.
		else if(firstDebtor == firstDebtor.getNextCustomer()){
			firstDebtor.setNextCustomer(newDebtor);
			firstDebtor.setPrevCustomer(newDebtor);
			newDebtor.setNextCustomer(firstDebtor);
			newDebtor.setPrevCustomer(firstDebtor);
		}
		//Case: List with size >= 2.
		else {
			Customer last = firstDebtor.getPrevCustomer();
			last.setNextCustomer(newDebtor);
			newDebtor.setPrevCustomer(last);
			newDebtor.setNextCustomer(firstDebtor);
			firstDebtor.setPrevCustomer(newDebtor);
		}
	}
	
	public void addCustomer(String id, String name, String lastName, String celphoneNumber, String address, Image photo) throws EmptyDataException, DoubleRegistrationException {
		
		String emptyData=verifyFields(id, name, lastName, celphoneNumber, address);
		
		if(!emptyData.equals("")) {
			throw new EmptyDataException(emptyData);
		}
		
		if(searchCustomer(id)!=null) {
			throw new DoubleRegistrationException(id, "Customers");
		}
		
		Customer newCustomer = new Customer( id,  name,  lastName,  celphoneNumber,  address, photo);
		
		//Case: Empty list.
		if(firstCustomer==null) {
			firstCustomer=newCustomer;
			firstCustomer.setNextCustomer(newCustomer);
			firstCustomer.setPrevCustomer(newCustomer);
		}
		//Case: List with size: 1.
		else if(firstCustomer == firstCustomer.getNextCustomer()){
			firstCustomer.setNextCustomer(newCustomer);
			firstCustomer.setPrevCustomer(newCustomer);
			newCustomer.setNextCustomer(firstCustomer);
			newCustomer.setPrevCustomer(firstCustomer);
		}
		//Case: List with size >= 2.
		else {
			Customer last = firstCustomer.getPrevCustomer();
			last.setNextCustomer(newCustomer);
			newCustomer.setPrevCustomer(last);
			newCustomer.setNextCustomer(firstCustomer);
			firstCustomer.setPrevCustomer(newCustomer);
		}
	}
	
	public void sortCByFullName() { //Bubble Sort
		if(firstCustomer!=null) {
			boolean thereWasSwap=true;
			
			while(thereWasSwap) {
				Customer current = firstCustomer;
				thereWasSwap=false;
				
				//Case: list >=2
				while(current.getNextCustomer()!=firstCustomer) {
					if(current.getNextCustomer().compareTo(current)<0) {
						swap(current, current.getNextCustomer());
						thereWasSwap = true;
					}
					current=current.getNextCustomer();
				}
			}
		}
	}
	
	private void swap(Customer c1, Customer c2) {
		
		//Case: list size: 2.
		if(c2.getNextCustomer()==firstCustomer) {
			firstCustomer = c2;
		}
		//Case: list size: 3.
		else if(c1.getPrevCustomer()==c2.getNextCustomer()){
			Customer c3=c1.getPrevCustomer();
			c1.setNextCustomer(c3);
			c1.setPrevCustomer(c2);
			
			c2.setNextCustomer(c1);
			c2.setPrevCustomer(c3);
			
			c3.setNextCustomer(c2);
			c3.setPrevCustomer(c1);
		}
		//Case: list size >= 4.
		else {
			Customer pc1 = c1.getPrevCustomer();
			Customer nc2 = c2.getNextCustomer();
			
			pc1.setNextCustomer(c2);
			
			c2.setPrevCustomer(pc1);
			c2.setNextCustomer(c1);
			
			c1.setPrevCustomer(c2);
			c1.setNextCustomer(nc2);
		}
		
		//Case: c1 is the first
		if(c1==firstCustomer) {
			firstCustomer = c2;
		}
		//Case: c1 is the last
		else if(c2==firstCustomer) {
			firstCustomer = c1;
		}
	}
	
	public void sortCByLastPurchase() { //Bubble Sort
		if(firstCustomer!=null) {
			boolean thereWasSwap=true;
			
			while(thereWasSwap) {
				Customer current = firstCustomer;
				thereWasSwap=false;
				
				//Case: list >=2
				while(current.getNextCustomer()!=firstCustomer) {
					if(current.getNextCustomer().compareByDate(current)<0) {
						swap(current, current.getNextCustomer());
						thereWasSwap = true;
					}
					current=current.getNextCustomer();
				}
			}
		}
	}
	
	//Stock scene methods-------------------------------------------------------------------------------------------------------------
	public void saveData() {
		
	}
	
	public void loadData() {
		
	}
	
	public String addYoghurts(int numberOfYoghurts, char size, char suggar, String flavor) throws EmptyDataException {
		int code = searchLastCode();
		String initialCode = code+"";
		String finalCode = (code + numberOfYoghurts -1)+"";
		for(int i=0; i<numberOfYoghurts; i++) {
			addYoghurt(code, "Yoghurt", settings.getPriceYoghurt(), LocalDate.now(), size, suggar,flavor );
			code++;
		}
		
		return "The codes generated are between "+initialCode+" and "+ finalCode+".\n\nRemember assign the code to each Yoghurt";
	}
	
	public void addYoghurt(int code, String name, double salePrice, LocalDate preparationDate, char size, char sugarLevel, String flavor) {
		Yoghurt yoghurt = new Yoghurt(code,  name,  salePrice,  preparationDate,  size,  sugarLevel,  flavor);
		dairyDrinks.add(yoghurt);
	}
	
	public String addOats(int numberOfOats, char size, char suggar, String typeOat) throws EmptyDataException {
		if(typeOat.equals("")) {
			throw new EmptyDataException("Type Oat");
		}
		int code = searchLastCode();
		String initialCode = code+"";
		String finalCode = (code + numberOfOats)+"";
		for(int i=0; i<numberOfOats; i++) {
			addOat(code, "Avena", settings.getPriceYoghurt(), LocalDate.now(), size, suggar,typeOat );
			code++;
		}
		
		return "The codes generated are between "+initialCode+" and "+ finalCode+"\nRemember assign the code to each Oat";
	}
	
	public void addOat(int code, String name, double salePrice, LocalDate preparationDate, char size, char sugarLevel, String typeOat) {
		Oat oat = new Oat( code,  name,  salePrice,  preparationDate,  size, sugarLevel, typeOat);
		dairyDrinks.add(oat);
	}
	
	public void addProduct(String c, String n, double sp) {
		
	}
	
	public void sellProduct(String id, String c, boolean paid) throws EmptyDataException, BuyerWithDebtException, InsufficientBalanceException {
		Customer customer = searchCustomer(id);
		String detail;
		int code = Integer.parseInt(c);
		DairyProduct product = searchProduct(code);
		
		if(product instanceof Yoghurt) {
			detail = product.getName()+" "+((Yoghurt) product).getFlavor();
		}else if(product instanceof Oat) {
			detail = product.getName()+" "+((Oat) product).getTypeOat();
		}else {
			detail = product.getName();
		}
		
		if(paid) {
			cashRegister.registerMoney(customer.getName()+" paid", product.getSalePrice(), false);
		}else {
			addDebtor(customer);
			customer.setDebtValue(product.getSalePrice());
		}
		
		customer.getPurchasesDetail().add(detail);
		customer.getPurchasesDates().add(LocalDate.now());
		
		discardProduct(code);
		
		
	}
	
	public DairyProduct searchProduct(int code) {
		DairyProduct product=null;
		boolean found = false;
		if(dairyDrinks!=null) {
			for(int i=0;i<dairyDrinks.size() && !found;i++) {
				if(code==dairyDrinks.get(i).getCode()) {
					product = dairyDrinks.get(i);
					found = true;
				}
			}
		}if(dairyProducts!=null && !found) {
			for(int i=0;i<dairyProducts.size() && !found;i++) {
				if(code==dairyProducts.get(i).getCode()) {
					product = dairyProducts.get(i);
					found = true;
				}
			}
		}
		return product;
	}
	
	public boolean discardProduct(int code) {
		DairyProduct product = searchProduct(code);
		if(product !=null) {
			dairyDrinks.remove(product);
			dairyProducts.remove(product);
		}
		return product !=null;
	}
	
	public DairyProduct searchProduct(String code) {
		return null;
	}
	
	public ArrayList<DairyProduct> searchExpiredProducts(){
		ArrayList<DairyProduct> expiredProducts=null;
		return expiredProducts;
	}
	
	public void charge(String id) throws EmptyDataException, InsufficientBalanceException {
		Customer debtor = searchCustomer(id);
		
		double value=debtor.getDebtValue();
		String detail=debtor.getName()+" paid";
		
		cashRegister.registerMoney(detail, value, false);
		
		deleteDebtor(debtor.getId());
		debtor.setDebtValue(0);
	}
	
	public void deleteDebtor(String id) throws EmptyDataException {
		
		//Case > 0
		if(firstDebtor!=null) {
			Customer debtor = searchCustomer(id);
			//Case 1: list size: 1.
			if(firstDebtor==firstDebtor.getNextCustomer()) {
				firstDebtor=null;
			}
			//Case 1: list size: 2.
			else if(debtor.getNextCustomer().getNextCustomer()==debtor) {
				firstDebtor=debtor.getNextCustomer();
				firstDebtor.setNextCustomer(null);
				firstDebtor.setPrevCustomer(null);
			}
			//Case 1: list size >= 3.
			else {
				Customer prev=debtor.getPrevCustomer();
				Customer next=debtor.getNextCustomer();
				
				prev.setNextCustomer(next);
				next.setPrevCustomer(prev);
				if(debtor==firstDebtor) {
					firstDebtor=debtor.getNextCustomer();
				}
			}
		}
	}
	public void sortByName() {
		if(firstDebtor!=null) {
			boolean thereWasSwap=true;
			
			while(thereWasSwap) {
				Customer current = firstDebtor;
				thereWasSwap=false;
				
				//Case: list >=2
				while(current.getNextCustomer()!=firstDebtor) {
					if(current.getNextCustomer().compareTo(current)<0) {
						swap(current, current.getNextCustomer());
						thereWasSwap = true;
					}
					current=current.getNextCustomer();
				}
			}
		}
	}
	
	public void sortByDebt() {
		if(firstDebtor!=null) {
			boolean thereWasSwap=true;
			
			while(thereWasSwap) {
				Customer current = firstDebtor;
				thereWasSwap=false;
				
				//Case: list >=2
				while(current.getNextCustomer()!=firstDebtor) {
					if(current.getNextCustomer().compareToDebt(current)<0) {
						swap(current, current.getNextCustomer());
						thereWasSwap = true;
					}
					current=current.getNextCustomer();
				}
			}
		}
	}
	
	public void sortByDate() {
		if(firstDebtor!=null) {
			boolean thereWasSwap=true;
			
			while(thereWasSwap) {
				Customer current = firstDebtor;
				thereWasSwap=false;
				
				//Case: list >=2
				while(current.getNextCustomer()!=firstDebtor) {
					if(current.getNextCustomer().compareByDate(current)<0) {
						swap(current, current.getNextCustomer());
						thereWasSwap = true;
					}
					current=current.getNextCustomer();
				}
			}
		}
	}
	public ArrayList<Register> searchRegisterOfDate(LocalDate date){
		ArrayList<Register> registers = null;
		return registers;
	}
	
	public void sortPByFlavorAndSize() { // Selection Sort
		DairyDrink temp;
		DairyDrink current;
		int minIndex;
		for(int i=0; i<dairyDrinks.size() -1;i++) {
			 minIndex = i;
			
			for(int j=i; j<dairyDrinks.size(); j++) {
				current = dairyDrinks.get(j);
				if(current.compareTo(dairyDrinks.get(minIndex))<0) {
					minIndex = j;
				}
			}
			
			temp = dairyDrinks.get(i);
			dairyDrinks.set(i, dairyDrinks.get(minIndex));
			dairyDrinks.set(minIndex, temp);
		}
	}
	
	public void sortPBySugarLevelAndFlavor() {
		Collections.sort(dairyDrinks, new DairyDrinkComparatorBySugarLevelAndFlavor());
	}
	
	public void sortPByDateAndFlavor() {
		Collections.sort(dairyDrinks, new DairyDrinkComparatorByDateAndFlavor());
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

	public Employee searchEmployee(String id) {
		Employee employee = employeesRoot;
		return employee;
	}
	
	public void addEmployee(String id, String name, String lastName, String celphoneNumber, String address, Image photo, char position) throws Exception {
		
		String emptyData=verifyFields(id, name, lastName, celphoneNumber, address);
		
		if(!emptyData.equals("")) {
			throw new EmptyDataException(emptyData);
		}
		
		if(searchEmployee(id)!=null) {
			throw new DoubleRegistrationException(id, "Employees");
		}
		
		Employee employee=null;
		
		switch(position) {
		case Employee.SELLER:
			employee = new Seller(id, name, lastName, celphoneNumber, address, photo);
			break;
		case Employee.OPERATOR:
			employee = new Operator(id, name, lastName, celphoneNumber, address, photo);
			break;
		case Employee.DOMICILIARY:
			employee = new Domiciliary(id, name, lastName, celphoneNumber, address, photo);
			break;
		default:
			throw new Exception("Invalided position of employee");
		}
		Employee current = employeesRoot;
		boolean wasAdded=false;
		
		if(employeesRoot!=null) {
			while(!wasAdded) {
				if(current.compareTo(employee)<0) {
					if(current.getLeft()==null) {
						current.setLeft(employee);
						employee.setHead(current);
						wasAdded=true;
					}else {
						current=current.getLeft();
					}
				}else {
					if(current.getRight()==null) {
						current.setRight(employee);
						employee.setHead(current);
						wasAdded=true;
					}else {
						current=current.getRight();
					}
				}
			}
		}else {
			employeesRoot=employee;
		}
	}
	
	public String determineBalancePoints(double gain) {
		String report="";
		return report;
	}
	
	
	//Auxiliary methods
	public String verifyFields(String id, String name, String lastName, String celphoneNumber, String address) {
		String fields="";
		if(id.equals("")) {
			fields="Id ";
		}if(name.equals("")) {
			fields+="Name ";
		}if(lastName.equals("")) {
			fields+="Lastname ";
		}if(celphoneNumber.equals("")) {
			fields+="CelphoneNumber ";
		}if(address.equals("")) {
			fields+="Address ";
		}
		return fields;
	}
	
	public int searchLastCode() {
		int lastCode = 0;
		for(int i=0; i<dairyDrinks.size();i++) {
			if(dairyDrinks.get(i).getCode()>lastCode) {
				lastCode = dairyDrinks.get(i).getCode();
			}
		}
		
		for(int i=0; i<dairyProducts.size();i++) {
			if(dairyProducts.get(i).getCode()>lastCode) {
				lastCode = dairyProducts.get(i).getCode();
			}
		}
		return lastCode + 1;
	}

}

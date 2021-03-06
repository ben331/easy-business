package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import customException.*;
import javafx.scene.image.Image;

public class Company implements Serializable{
	
	private static final long serialVersionUID = 42L;
	
	//Attributes
	private CashRegister cashRegister;
	
	private ArrayList<DairyProduct> dairyProducts;
	
	private ArrayList<DairyDrink> dairyDrinks;
	
	private Employee employeesRoot;
	
	private Employee activeEmployeesRoot;
	
	private Customer firstDebtor;
	
	private Customer firstCustomer;
	
	private Settings settings;
	
	
	public Settings getSettings() {
		return settings;
	}


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
	
	public List<Employee> getActiveEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		if(activeEmployeesRoot!=null) {
			BSTtoListInOrder(activeEmployeesRoot, employees);
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
	
	public List<Customer> getDebtors(){
		List<Customer> debtors = new ArrayList<Customer>();
		if(firstDebtor!=null) {
			Customer current = firstDebtor;
			do {
				debtors.add(current);
				current=current.getNextCustomer();
			}while(current!=firstDebtor);
		}
		return debtors;
	}
	
	//Analyzer methods-----------------------------------------------------------------------------------------------------------------
	
	//Customer Methods-----------------------------------------------------------------------------------------------------------------
	
	public Customer searchCustomer(String id) throws EmptyDataException {
		if(id.equals("")) {
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
	
	public void addDebtor(Customer c) {
		
		Customer newDebtor = new Customer(c.getId(), c.getName(), c.getLastName(), c.getCelphoneNumber(), c.getAddress(), c.getPhoto());
		newDebtor.setDebtValue(c.getDebtValue());
		
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
	
	public Customer searchDebtor(String id) throws EmptyDataException {
		if(id==null || id.equals("")) {
			throw new EmptyDataException("id");
		}
		Customer customer=null;
		Customer current = firstDebtor;
		if(firstDebtor!=null) {
			do {
				current = current.getNextCustomer();
			}while(current!=firstDebtor && !current.getId().equals(id));
			if(current.getId().equals(id)) {
				customer = current;
			}
		}
		return customer;
	}
	
	public void charge(String id) throws EmptyDataException, InsufficientBalanceException {
		Customer c = searchCustomer(id);
		if(c.hasDebt()) {
			
			cashRegister.registerMoney(c.getName()+" Paid", c.getDebtValue(), false);
			c.setDebtValue(0);
			Customer debtor = searchDebtor(id);
			deleteDebtor(debtor);
		}
	}
	
	public void deleteDebtor(Customer debtor) throws EmptyDataException {
		
		//Case > 0
		if(firstDebtor!=null) {
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
		
		//Case: c1 is the first
		if(c1==firstCustomer) {
			firstCustomer = c2;
		}
		//Case: c1 is the last
		else if(c2==firstCustomer) {
			firstCustomer = c1;
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

	public String addYoghurts(int numberOfYoghurts, char size, char suggar, String flavor) throws EmptyDataException {
		int code = searchLastCode();
		String initialCode = code+"";
		String finalCode = (code + numberOfYoghurts -1)+"";
		for(int i=0; i<numberOfYoghurts; i++) {
			addYoghurt(code, "Yoghurt", LocalDate.now(), size, suggar,flavor );
			code++;
		}
		
		return "The codes generated are between "+initialCode+" and "+ finalCode+".\n\nRemember assign the code to each Yoghurt";
	}
	
	public void addYoghurt(int code, String name, LocalDate preparationDate, char size, char sugarLevel, String flavor) {
		Yoghurt yoghurt = new Yoghurt(code,  name, preparationDate,  size,  sugarLevel, settings, flavor);
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
			addOat(code, "Avena", LocalDate.now(), size, suggar,typeOat );
			code++;
		}
		
		return "The codes generated are between "+initialCode+" and "+ finalCode+"\nRemember assign the code to each Oat";
	}
	
	public void addOat(int code, String name, LocalDate preparationDate, char size, char sugarLevel, String typeOat) {
		Oat oat = new Oat( code,  name, preparationDate,  size, sugarLevel, settings, typeOat);
		dairyDrinks.add(oat);
	}
	
	public String addProducts(String num, int indexName) {
		int n =Integer.parseInt(num);
		DairyProduct base = settings.getProducts().get(indexName);
		int initialCode = searchLastCode();
		int code = initialCode;
		int finalCode = initialCode + n - 1;
		
		for(int i=0; i<n; i++) {
			DairyProduct dp = new DairyProduct(code, base.getName(), base.getSalePrice(), LocalDate.now(), base.getDescription());
			dairyProducts.add(dp);
			code++;
		}
		return "The codes generated are between "+initialCode+" and "+ finalCode+"\nRemember assign the code to each Product";
	}
	
	public void addProduct(int code, String name, double salePrice, LocalDate preparationDate) {
		DairyProduct d= new DairyProduct(code, name, salePrice, preparationDate);
		dairyProducts.add(d);
	}
	
	public void sellProduct(String id, String c, boolean paid) throws EmptyDataException, BuyerWithDebtException, InsufficientBalanceException, SaleOfExpiredProductException {
		Customer customer = searchCustomer(id);
		
		if(customer.hasDebt()) {
			throw new BuyerWithDebtException(customer.getName(), customer.getDebtValue());
		}
		
		String detail;
		int code = Integer.parseInt(c);
		DairyProduct product = searchProduct(code);
		
		if(product instanceof DairyDrink) {
			if(((DairyDrink) product).isExpired()) {
				throw new SaleOfExpiredProductException(product.getCode());
			};
		}
		
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
			customer.setDebtValue(product.getSalePrice());
			addDebtor(customer);
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
	
	public boolean payPayroll() throws EmptyDataException, InsufficientBalanceException, IOException {
		
		boolean paid=false;
		if(employeesRoot!=null) {
			
			
			String report = "\n---------------------------PAYMENT--PAYROLL---REPORT-----------------------------------\n\n\n";
			report+=generateReport(employeesRoot);
			BufferedWriter br = new BufferedWriter(new FileWriter(Employee.FILE_NAME_PREFIX+LocalDate.now()+Employee.EXTENSION));
			br.write(report);
			br.close();
			
			double totalPayRoll = payAndReset(employeesRoot);
					
			cashRegister.registerMoney("Payment PayRoll", totalPayRoll, true);
			paid=true;
		}
		return paid;
	}
	
	private String generateReport(Employee e) {
		String report="";
		if(e.getLeft()!=null) {
			report = generateReport(e.getLeft());
		}
		
		report += "\n Id: "+e.getId()+"        Name: "+e.getName()+"     Hours Worked: "+e.getHoursWorked()+ "    Salary: "+e.calculateSalary()+"\n";
		
		if(e.getRight()!=null) {
			report += generateReport(e.getRight());
		}
		
		return report;
	};
	
	private double payAndReset(Employee nodo) {
		double sum=0;
		if(nodo!=null) {
			if(nodo.getLeft()!=null) {
				sum+=payAndReset(nodo.getLeft());
			}
			
			sum+=nodo.calculateSalary();
			nodo.setHoursWorked(0);
			
			if(nodo.getRight()!=null) {
				sum+=payAndReset(nodo.getRight());
			}
		}
		return sum;
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
	
	public String predictUpcomingSales() {
		String report="";
		
		//If there are customers
		if(firstCustomer!=null) {
			Customer current = firstCustomer;
			ArrayList<String[]> purchases = new ArrayList<String[]>();
			
			//Find probably purchase of every Customer
			do {
				purchases.add(purchasesForTheNextWeekOfCustomer(current));
				current = current.getNextCustomer();
			}while(current!=firstCustomer);
			
			ArrayList<String[]> categories = new ArrayList<String[]>();
			categories.add(new String[] {"","0"});
			
			//Determine Categories of purchases
			for(int i=0; i<purchases.size();i++) {
				
				boolean categoryExists = false;
				for(int j=0; j<categories.size() ;j++) {
					if(purchases.get(i)[0].equals(categories.get(j)[0])) {
						int f1 = Integer.parseInt((categories.get(j)[1]));
						int f2 = Integer.parseInt((purchases.get(i)[1]));
						
						categories.get(j)[1]=""+(f1+f2);
						
						categoryExists = true;
						
					}
				}					
				
				if(!categoryExists) {
					categories.add(purchases.get(i));
				}
			}
			
			//Remove base category
			categories.remove(0);
			
			//Determine the thow categories with most frecuency
			String[] p1 = null;
			String[] p2 = null;
			int max=0;
			int fi;
			for(int i=0; i<categories.size();i++) {
				fi=Integer.parseInt(categories.get(i)[1]);
				if(fi>max) {
					p1 = categories.get(i);
					max = fi;
				}
			}
			categories.remove(p1);
			
			max=0;
			for(int i=0; i<categories.size();i++) {
				fi=Integer.parseInt(categories.get(i)[1]);
				if(fi>max) {
					p2 = categories.get(i);
					max = fi;
				}
			}
			
			if(p1!=null) {
				report+= p1[1]+" sales of product: "+ p1[0]+"\n\n";
			}if(p2!=null) {
				report+= p2[1]+" sales of product: "+ p2[0];
			}
		}
		if(report.equals("")) {
			report = "None";
		}
		
		report= "The most likely sales for the next week are: \n"+report;
		return report;
	}
	
	private String[] purchasesForTheNextWeekOfCustomer(Customer c) {
		String purchase[] = new String[] {"","0"}; //The first item is the detail, and the second item is the frecuency or number of products

		//Determinate the intervals between every purchase
		ArrayList<Period> intervals = new ArrayList<Period>();		
		
		//If the customer is a candidate for a regular customer. (Have purchases more than 10).
		if(c.getPurchasesDates().size()>Customer.NUMBER_OF_PURCHASES_OF_REGULAR_CUSTOMER) {
			
			//Determinate every interval.
			for(int i= 0; i<c.getPurchasesDates().size() - 1;i++) {
				intervals.add(Period.between(c.getPurchasesDates().get(i), c.getPurchasesDates().get(i+1)));
			}
			
			
			//Determinate average period between evry purchase.
			int averagePeriodInDays=0;
			for(int i=0; i<intervals.size();i++) {
				averagePeriodInDays+=intervals.get(i).getDays();
			}
			averagePeriodInDays = averagePeriodInDays / intervals.size();
			Period averagePeriod = Period.ofDays(averagePeriodInDays);
			
			
			//Determinate standarDeviation of every purchase.
			double standardDeviation=0;			
			for(int i=0; i<intervals.size();i++) {
				standardDeviation = Math.pow((averagePeriodInDays - intervals.get(i).getDays()), 2)/intervals.size();
			}
			standardDeviation = Math.sqrt(standardDeviation);
			
			
			//Date of seven days later.
			LocalDate aWeekLater =  (LocalDate) Period.ofWeeks(1).addTo(LocalDate.now());
			//Next purchase is equals to the last purchase date plus the average period
			LocalDate nextPurchase = (LocalDate) averagePeriod.addTo(c.getPurchasesDates().get(c.getPurchasesDates().size() -1));
			
			
			//If the customer is regular, and it's probably he buy the next week
			if(standardDeviation/averagePeriodInDays<0.20  && nextPurchase.isBefore(aWeekLater)) {
				
				//Determine favorite purchase
				ArrayList<String[]> categories = new ArrayList<String[]>();
				categories.add(new String[] {"","0"});
				
				//Determine Categories of purchases
				for(int i=0; i<c.getPurchasesDetail().size();i++) {
					for(int j=0; j<categories.size();i++) {
						if(c.getPurchasesDetail().get(i).equals(categories.get(j)[0])) {
							int f1 = Integer.parseInt((categories.get(j)[1]));
							
							categories.get(j)[1]=""+(++f1);
							
						}else {
							categories.add( new String[] {c.getPurchasesDetail().get(i), ""+1});
						}
					}					
				}
				
				categories.remove(0);
				
				//Determine categorie with most frecuency
				int max=0;
				int fi;
				for(int i=0; i<categories.size();i++) {
					fi=Integer.parseInt(categories.get(i)[1]);
					if(fi>max) {
						purchase = categories.get(i);  //This is the favorite purchase. ["detail", "#"].
						max = fi;
					}
				}
				
			}
		}
		
		//If the customer is not a regular customer, he doesn't have favorite purchase. ["","0"]
		return purchase;
	}
	
	public boolean registerEntry(String id) throws Exception {
		boolean registered=false;
		
		if(id.equals("")) {
			throw new EmptyDataException("Id");
		}
		
		if(searchActiveEmployee(id)!=null) {
			throw new DoubleRegistrationException(id, "Actives Employees");
		}
		
		Employee e=searchEmployee(id);
		
		if(e!=null) {
			
			Employee employee;
			
			if(e instanceof Seller) {
				employee = new Seller(e.getId(), e.getName(), e.getLastName(), e.getCelphoneNumber(), e.getAddress(), e.getPhoto(), settings);
			}else if(e instanceof Operator) {
				employee = new Operator(e.getId(), e.getName(), e.getLastName(), e.getCelphoneNumber(), e.getAddress(), e.getPhoto(), settings);
			}else {
				employee = new Domiciliary(e.getId(), e.getName(), e.getLastName(), e.getCelphoneNumber(), e.getAddress(), e.getPhoto(), settings);
			}
			
			Employee current = activeEmployeesRoot;
			employee.setTimeEntry(LocalTime.now());
			boolean wasAdded=false;
			
			if(activeEmployeesRoot!=null) {
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
				activeEmployeesRoot=employee;
			}
			
			registered = true;
		}
		return registered;
	}
	
	public Employee searchActiveEmployee(String id) {
		return searchActiveEmployee(activeEmployeesRoot, id);
	}
	
	private Employee searchActiveEmployee(Employee nodo, String id) {
		if(nodo!=null) {
			if(nodo.getId().compareTo(id)<0) {
				return searchActiveEmployee(nodo.getRight(), id);
			}else if(nodo.getId().compareTo(id)>0) {
				return searchActiveEmployee(nodo.getLeft(), id);
			}else {
				return nodo;
			}
		}else {
			return null;
		}
	}
	
	public int registerDeparture(String id) {
		
		Employee nodo=searchActiveEmployee(id);
		if(nodo!=null) {
			
			//Registers the hours worked
			Employee employee = searchEmployee(id);
			int hours = (int) Duration.between(nodo.getTimeEntry(), LocalTime.now()).toHours();
			employee.setHoursWorked(employee.getHoursWorked() + hours);
			
			if((nodo.getLeft()==null || nodo.getRight()==null) && !(nodo.getLeft()==null && nodo.getRight()==null)) {      //Delete element with one child
				if(nodo==activeEmployeesRoot) {
					if(nodo.getLeft()!=null) {
						nodo.getLeft().setHead(null);
						activeEmployeesRoot=nodo.getLeft();
					}else {
						nodo.getRight().setHead(null);
						activeEmployeesRoot=nodo.getRight();
					}
				}else {
					if(nodo.getLeft()!=null) {
						nodo.getLeft().setHead(nodo.getHead());
						if(nodo.getHead().getLeft()==nodo) {
							nodo.getHead().setLeft(nodo.getLeft());
						}else {
							nodo.getHead().setRight(nodo.getLeft());
						}					
					}else {
						nodo.getRight().setHead(nodo.getHead());
						if(nodo.getHead().getLeft()==nodo) {
							nodo.getHead().setLeft(nodo.getRight());
						}else {
							nodo.getHead().setRight(nodo.getRight());
						}
					}				
				}
				return hours;
				
				
			}else if(nodo.getLeft()==null && nodo.getRight()==null) {     //Delete sheet
				if(nodo==activeEmployeesRoot) {
					activeEmployeesRoot=null;
				}else {
					if(nodo.getHead().getLeft()==nodo) {
						nodo.getHead().setLeft(null);
					}else {
						nodo.getHead().setRight(null);
					}
				}
				return hours;
				
				
			}else {				                                             //Delete element with both children
				Employee min = nodo.getRight().getMin();
				registerDeparture(min.getId());
				min.setHead(nodo.getHead());
				min.setRight(nodo.getRight());
				min.setLeft(nodo.getLeft());
				nodo.getLeft().setHead(min);
				if(nodo.getRight()!=null) {
					nodo.getRight().setHead(min);
				}
				if(nodo==activeEmployeesRoot) {
					activeEmployeesRoot=min;
				}else {
					if(nodo.getHead().getLeft()==nodo) {
						nodo.getHead().setLeft(min);
					}else {
						nodo.getHead().setRight(min);
					}
				}
				return hours;
			}
		}
		return -1;
	}
	public Employee searchEmployee(String id) {
		
		return searchEmployee(employeesRoot, id);
	}
	
	private Employee searchEmployee(Employee nodo, String id) {
		if(nodo!=null) {
			if(nodo.getId().compareTo(id)<0) {
				return searchEmployee(nodo.getRight(), id);
			}else if(nodo.getId().compareTo(id)>0) {
				return searchEmployee(nodo.getLeft(), id);
			}else {
				return nodo;
			}
		}else {
			return null;
		}
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
			employee = new Seller(id, name, lastName, celphoneNumber, address, photo, settings);
			break;
		case Employee.OPERATOR:
			employee = new Operator(id, name, lastName, celphoneNumber, address, photo, settings);
			break;
		case Employee.DOMICILIARY:
			employee = new Domiciliary(id, name, lastName, celphoneNumber, address, photo, settings);
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
		if(gain<0){
			throw new NumberFormatException();
		}
		Yoghurt y = new Yoghurt(0, "", LocalDate.now(), DairyDrink.MEDIAN, DairyDrink.NORMAL, settings, "");
		Oat o = new Oat(0, "", LocalDate.now(), DairyDrink.MEDIAN, DairyDrink.NORMAL, settings, "");
		
		int b1 = y.calculateBreakEvenPoint(gain);
		int b2 = o.calculateBreakEvenPoint(gain);
		
		return "The minimun sales required to get a gain: "+gain+" is: \n "+b1+" Sales of median yoghurt(s) and, \n"+b2+" Sales of median oat(s).";
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


	public String determinateWarnings() {
		String warnings = "EXPIRED DAIRY DRINKS: \n\n";
		
		for(int i=0; i<dairyDrinks.size();i++) {
			if(dairyDrinks.get(i).isExpired()) {
				warnings+=dairyDrinks.get(i).getName()+ " "+dairyDrinks.get(i).getCode()+"\n";
			}
		}
		
		warnings+="\n DEBTORS SINCE A MONTH AGO: ";
		
		if(firstDebtor!=null) {
			Customer current = firstDebtor;
			do {

				LocalDate lastPurchase = current.getPurchasesDates().get(current.getPurchasesDates().size() -1);
				
				if(((LocalDate) Period.ofMonths(1).addTo(lastPurchase)).isBefore(LocalDate.now())) {
					warnings+="Name: "+current.getName()+ "   Id: "+current.getId()+"\n";
				}
				
				current = current.getNextCustomer();
			}while(current!=firstDebtor);
		}
		
		return warnings;
	}

}

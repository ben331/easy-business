package model;

import java.time.LocalDate;
import java.time.Period;
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
	
	public void payPayroll() {
		
	}
	
	public String predictUpcomingSales() {
		String report="";
		
		if(firstCustomer!=null) {
			Customer current = firstCustomer;
			ArrayList<String[]> purchases = new ArrayList<String[]>();
			do {
				purchases.add(purchasesForTheNextWeekOfCustomer(current));
				current = current.getNextCustomer();
			}while(current!=firstCustomer);
			
			if(purchases.size()!=0) {
				ArrayList<String[]> categories = new ArrayList<String[]>();
				categories.add(new String[] {"","0"});
				
				//Determine Categories of purchases
				for(int i=0; i<purchases.size();i++) {
					for(int j=0; j<categories.size();i++) {
						if(purchases.get(i)[0].equals(categories.get(j)[0])) {
							int f1 = Integer.parseInt((categories.get(j)[1]));
							int f2 = Integer.parseInt((purchases.get(i)[1]));
							
							categories.get(j)[1]=""+(f1+f2);
							
						}else {
							categories.add(purchases.get(i));
						}
					}					
				}
				
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
				categories.remove(max);
				
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
		}
		if(report.equals("")) {
			report = "None";
		}
		
		report= "The most likely sales for the next week are: \n"+report;
		return report;
	}
	
	private String[] purchasesForTheNextWeekOfCustomer(Customer c) {
		String purchase[] = new String[] {"","0"}; //The first item is the detail, and the second item is the frecuency
		ArrayList<Period> intervals = new ArrayList<Period>();
		
		if(c.getPurchasesDates().size()>Customer.NUMBER_OF_PURCHASES_OF_REGULAR_CUSTOMER) {
			for(int i= 0; i<c.getPurchasesDates().size() - 1;i++) {
				intervals.add(Period.between(c.getPurchasesDates().get(i), c.getPurchasesDates().get(i+1)));
			}
		}
		
		int averagePeriodInDays=0;
		
		for(int i=0; i<intervals.size();i++) {
			averagePeriodInDays+=intervals.get(i).getDays();
		}
		
		averagePeriodInDays = averagePeriodInDays / intervals.size();
		Period averagePeriod = Period.ofDays(averagePeriodInDays);
		
		double standardDeviation=0;
		
		for(int i=0; i<intervals.size();i++) {
			standardDeviation = Math.pow((averagePeriodInDays - intervals.get(i).getDays()), 2)/intervals.size();
		}
		
		standardDeviation = Math.sqrt(standardDeviation);
		
		LocalDate aWeekLater =  (LocalDate) Period.ofWeeks(1).addTo(LocalDate.now());
		LocalDate nextPurchase = (LocalDate) averagePeriod.addTo(LocalDate.now());
		
		//If the customer is regular, and it is probably he buy the next week
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
					purchase = categories.get(i);
					max = fi;
				}
			}
			
		}
		
		return purchase;
	}
	
	public void registerEntry(String id, String name, String lastName, String celphoneNumber, String address, Image photo, char position) throws Exception {
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
		Employee current = activeEmployeesRoot;
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
	}
	
	public Employee searchActiveEmployee(String id) {
		searchActiveEmployee(activeEmployeesRoot, id);
		return searchActiveEmployee(id);
	}
	
	private Employee searchActiveEmployee(Employee nodo, String id) {
		if(nodo!=null) {
			if(nodo.getName().compareTo(id)<0) {
				return searchActiveEmployee(nodo.getRight(), id);
			}else if(nodo.getName().compareTo(id)>0) {
				return searchActiveEmployee(nodo.getLeft(), id);
			}else {
				return nodo;
			}
		}else {
			return nodo=null;
		}
	}
	
	public boolean registerDeparture(String id) {
		
		Employee nodo=searchActiveEmployee(id);
		if(nodo==null) {
			return false;
		}else if(nodo.getLeft()==null | nodo.getRight()==null) {      //Delete element with one child
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
			return true;
			
			
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
			return true;
			
			
		}else {				                                             //Delete element with both children
			Employee min = nodo.getRight().getMin();
			registerDeparture(min);
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
			return true;
		}
	}
	public Employee searchEmployee(String id) {
		searchEmployee(employeesRoot, id);
		return searchEmployee(id);
	}
	
	private Employee searchEmployee(Employee nodo, String id) {
		if(nodo!=null) {
			if(nodo.getName().compareTo(id)<0) {
				return searchEmployee(nodo.getRight(), id);
			}else if(nodo.getName().compareTo(id)>0) {
				return searchEmployee(nodo.getLeft(), id);
			}else {
				return nodo;
			}
		}else {
			return nodo=null;
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
		if(gain<=0){
			throw new NumberFormatException();
		}
		Yoghurt y = new Yoghurt(0, "", LocalDate.now(), DairyDrink.MEDIAN, DairyDrink.NORMAL, settings, "");
		Oat o = new Oat(0, "", LocalDate.now(), DairyDrink.MEDIAN, DairyDrink.NORMAL, settings, "");
		
		int b1 = y.calculateBreakEvenPoint(gain);
		int b2 = o.calculateBreakEvenPoint(gain);
		
		return "The minimun sales required to get a gain: "+gain+"is: \n "+b1+" Sales of median yoghurt(s) and, \n"+b2+" Sales of median oat(s) and, \n";
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

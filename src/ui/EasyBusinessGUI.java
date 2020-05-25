package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import customException.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.*;


public class EasyBusinessGUI {
	//Constant
	public static final String DEFAULT_PROFILE_PHOTO = "imgs/deafultProfile.jpg";
	//Relations--------------------------------------------------------------------------------------------------------------------------
	private Company company;
	
	//Constructor--------------------------------------------------------------------------------------------------------------------------
	public EasyBusinessGUI(Company company) {
		this.company = company;
	}
	
	//Main Scene fields----------------------------------------------------------------------------------------------------------------------------
	@FXML
    private BorderPane mainPane;
	
	public BorderPane getMainPane() {
		return mainPane;
	}
	
	//Scene CashRegister fields --------------------------------------------------------------------------------------------------------------------------
    @FXML
    private DatePicker registersDate;

    @FXML
    private TableView<Register> cashTable;

    @FXML
    private TableColumn<Register, String> movementColumn;

    @FXML
    private TableColumn<Register, String> detailColumn;

    @FXML
    private TableColumn<Register, String> timeColumn;

    @FXML
    private TextField cash;

    @FXML
    private ToggleGroup registerType;

    @FXML
    private RadioButton radButEgress;
    
    @FXML
    private TextField valueToRegister;

    @FXML
    private TextField detailToRegister;
    
    @FXML
    private Button buttonRegister;

    @FXML
    private Button buttonBackToToday;

    
    
    //Inventary Scene fields--------------------------------------------------------------------------------------------------------------------------
    
    @FXML
    private ToggleGroup occupation;

    @FXML
    private TableView<DairyDrink> dairyDrinksTable;

    @FXML
    private TableColumn<DairyDrink, String> drinkColumn;

    @FXML
    private TableColumn<DairyDrink, String> codeColumn;
    
    @FXML
    private TableColumn<DairyDrink, String> flavorColumn;

    @FXML
    private TableColumn<DairyDrink, String> sizeColumn;

    @FXML
    private TableColumn<DairyDrink, String> suggarColumn;

    @FXML
    private TableColumn<DairyDrink, String> typeOatColumn;

    @FXML
    private TableColumn<DairyDrink, String> dateDrinkColumn;

    @FXML
    private ToggleGroup Sorting;

    @FXML
    private ImageView drinkImg;

    @FXML
    private TableView<?> dairyProductsTable;

    @FXML
    private TableColumn<DairyProduct, String> productColumn;

    @FXML
    private TableColumn<DairyProduct, String> codeProductColumn;

    @FXML
    private TableColumn<DairyProduct, String> descriptionColumn;

    @FXML
    private TableColumn<DairyProduct, String> dateProductColumn;

    @FXML
    private ImageView productImg;
    
    @FXML
    private TextField quantityOats;

    @FXML
    private ToggleGroup sizeOats;

    @FXML
    private ToggleGroup suggarOats;

    @FXML
    private TextField typeOat;
    
    @FXML
    private TextField quantityProducts;

    @FXML
    private MenuButton productMenu;

    @FXML
    private TextField among;

    @FXML
    private Button addYoghurts;

    @FXML
    private ToggleGroup size;

    @FXML
    private MenuButton flavorMenu;

    @FXML
    private ToggleGroup suggar;

    @FXML
    private Label loading;
    
    //Employees Scene fields---------------------------------------------------------------------------------------------------------------

    @FXML
    private TableView<Employee> activeETable;

    @FXML
    private TableColumn<Employee, String> idActiveEColumn;

    @FXML
    private TableColumn<Employee, String> nameActiveEColumn;

    @FXML
    private TableColumn<Employee, String> lastnameActiveEColumn;

    @FXML
    private TableColumn<Employee, String> positionActiveEColumn;

    @FXML
    private TableColumn<Employee, String> timeEntryColumn;

    @FXML
    private ImageView employeeImg;

    @FXML
    private TextField activeEName;

    @FXML
    private TextField activeEId;

    @FXML
    private ImageView activeEImg;

    @FXML
    private TextField employeeSelectedName;

    @FXML
    private TextField hours;
    
    //Analizing Scene fields------------------------------------------------------------------------------------------------------------------------------------------------
    
    @FXML
    private TextField gain;

    @FXML
    private TextArea report;
    
    //Form Scene fields------------------------------------------------------------------------------------------------------------------------------------------------    
    @FXML
    private TextField idForm;

    @FXML
    private TextField nameForm;

    @FXML
    private TextField lastnameForm;

    @FXML
    private TextField addressForm;

    @FXML
    private TextField celNumberForm;

    @FXML
    private TextField photoForm;
    
    @FXML
    private RadioButton operator;

    @FXML
    private RadioButton domiciliary;

    @FXML
    private RadioButton seller;
    
    //Customers Scene fields------------------------------------------------------------------------------------------------------------------------------------------------
    
    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, String> idCustomerColumn;

    @FXML
    private TableColumn<Customer, String> nameCustomerColumn;

    @FXML
    private TableColumn<Customer, String> lastnameCustomerColumn;

    @FXML
    private TableColumn<Customer, String> celphoneCustomerColumn;

    @FXML
    private TableColumn<Customer, String> addressCustomerColumn;

    @FXML
    private TableColumn<Customer, String> dateCustomerColumn;

    @FXML
    private ImageView customerImg;

    @FXML
    private TextField customerFullName;

    @FXML
    private TextField customerId;

    @FXML
    private TextField customerCel;

    @FXML
    private TextField customerAddress;

    @FXML
    private ToggleGroup sortingCustomers;

    @FXML
    private RadioButton sortByDate;
    
    //Debtors scene fields
    @FXML
    private TextField debt;

    @FXML
    private ToggleGroup sortingDebtors;

    @FXML
    private TableView<?> debtorTable;

    @FXML
    private TableColumn<?, ?> idDebtorColumn;

    @FXML
    private TableColumn<?, ?> nameDebtorColumn;

    @FXML
    private TableColumn<?, ?> lastnameDebtorColumn;

    @FXML
    private TableColumn<?, ?> debtColumn;
    
    @FXML
    private CheckBox paid;

    @FXML
    private TextField customerBuyingId;
    
    
    //Employees scene fields-----------------------------------------------------------------------------------------------------------
    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> idEmployeeColumn;

    @FXML
    private TableColumn<Employee, String> nameEmployeeColumn;

    @FXML
    private TableColumn<Employee, String> lastnameEmployeeColumn;

    @FXML
    private TableColumn<Employee, String> celphoneEmployeeColumn;

    @FXML
    private TableColumn<Employee, String> addressEmployeeColumn;

    @FXML
    private TableColumn<Employee, String> positionColumn;

    @FXML
    private TextField employeeId;

    @FXML
    private TextField employeeCel;

    @FXML
    private TextField EmployeeAddress;
        
    //Employee methods----------------------------------------------------------------------------------------------------------------
    @FXML
    void addEmployee(ActionEvent event) throws Exception {
    	try {
    		if(photoForm.getText().equals("")) {
    			throw new EmptyDataException("Photo");
    		}
    		
    		Image image = new Image(new File(photoForm.getText()).toURI().toString());
    		
    		char position;
    		
    		if(seller.isSelected()) {
    			position = Employee.SELLER;
    		}else if(operator.isSelected()) {
    			position = Employee.OPERATOR;
    		}else {
    			position = Employee.DOMICILIARY;
    		}
    		
    		company.addEmployee(idForm.getText(), nameForm.getText(), lastnameForm.getText(), celNumberForm.getText(), addressForm.getText(), image, position);
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Successfull Process");
			alert.setContentText("Employee added successfully");
			alert.showAndWait();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Employees.fxml"));
	    	loader.setController(this);
	    	Parent scene = loader.load();
	    	mainPane.setCenter(scene);
	    	initializeTableEmployees();
	    	
			
    	}catch(EmptyDataException e) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    }

    @FXML
    void browseEmployee(ActionEvent event) {

    }
    
    @FXML
    void searchEmployee(ActionEvent event) {

    }

    //Main Scene Methods------------------------------------------------------------------------------------------------------------------
    
    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void saveChanges(ActionEvent event) {

    }
    
    @FXML
    void about(ActionEvent event) {

    }
    
    //Navigators Methods--------------------------------------------------------------------------------------------------------------------------
    @FXML
    void showDialogeToAddEmployee(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeForm.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }
    
    @FXML
    void showCashRegister(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("CashRegister.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    	initializeTableCashRegister();
    	cash.setText(company.getCashRegister().getCash()+"");
    }
    
    @FXML
    void showActiveEmployees(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ActiveEmployees.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }

    @FXML
    void showAnalysis(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Analysis.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }

    @FXML
    void showCustomers(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Customers.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    	initializeTableCustomers();
    }

    @FXML
    void showDairyDrinks(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DairyDrinks.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }

    @FXML
    void showDairyProducts(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DairyProducts.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }

    @FXML
    void showDebtors(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Debtors.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }

    @FXML
    void showEmployees(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Employees.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    	initializeTableEmployees();
    }

    @FXML
    void showSettings(ActionEvent event) {

    }
    
    @FXML
    void showDialogeToAddCustomer(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerForm.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }

    @FXML
    void showDialogueToAddOats(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogueToAddOats.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }

    @FXML
    void showDialogueToAddYoghurts(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogueToAddYoghurts.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }

    @FXML
    void showDialogueToSell(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogueToSell.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }
    
    @FXML
    void showDialogueToAddProducts(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogueToAddProducts.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }
    
    //Cash Register Methods-------------------------------------------------------------------------------------------------------------
    
    @FXML
    void saveRegisters(ActionEvent event) throws FileNotFoundException, IOException {
    	company.getCashRegister().saveRegisters();
    }
    
    @FXML
    void showDialogueToRegister(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogueToRegister.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }
    
    @FXML
    void toRegister(ActionEvent event) throws IOException {
    	try {
    		int value = Integer.parseInt(valueToRegister.getText());
    		company.getCashRegister().registerMoney(detailToRegister.getText(), value, radButEgress.isSelected());
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("CashRegister.fxml"));
        	loader.setController(this);
        	Parent scene = loader.load();
        	mainPane.setCenter(scene);
        	initializeTableCashRegister();
        	cash.setText(company.getCashRegister().getCash()+"");
    	}catch(EmptyDataException | NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    }
    
    @FXML
    void searchRegisters(ActionEvent event) throws ClassNotFoundException {
    	
    	try {
    		company.getCashRegister().saveRegisters();
    		company.getCashRegister().loadRegistersOfDate(registersDate.getValue());
    		initializeTableCashRegister();
    		cash.setText(company.getCashRegister().determineCash()+"");
    		buttonRegister.setDisable(true);
    		buttonBackToToday.setDisable(false);
    	}catch(IOException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Registers not found.\nThere are not registers for that day, file was deleted or the file changed location");
			alert.showAndWait();
    	}catch(EmptyDataException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    }
    
    @FXML
    void backToToday(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException, EmptyDataException {
    	company.getCashRegister().loadRegistersOfDate(LocalDate.now());
    	initializeTableCashRegister();
		cash.setText(company.getCashRegister().determineCash()+"");
		buttonRegister.setDisable(false);
		buttonBackToToday.setDisable(true);
    }
    
    //Customers Methods---------------------------------------------------------------------------------------------------------------
    
    @FXML
    void addCustomer(ActionEvent event) throws IOException {
    	try {
    		Image image;
    		if(photoForm.getText().equals("")) {
    			image = new Image(new File(DEFAULT_PROFILE_PHOTO).toURI().toString());
    		}else {
    			image = new Image(new File(photoForm.getText()).toURI().toString());
    		}
    		
    		company.addCustomer(idForm.getText(), nameForm.getText(), lastnameForm.getText(), celNumberForm.getText(), addressForm.getText(), image);
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Successfull Process");
			alert.setContentText("Customer added successfully");
			alert.showAndWait();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Customers.fxml"));
	    	loader.setController(this);
	    	Parent scene = loader.load();
	    	mainPane.setCenter(scene);
	    	initializeTableCustomers();
	    	
			
    	}catch(EmptyDataException | DoubleRegistrationException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    }
    
    @FXML
    void charge(ActionEvent event) {

    }

    @FXML
    void searchDebtor(ActionEvent event) {

    }
    
    @FXML
    void searchCustomer(ActionEvent event) {
    	try {
    		Customer customer = company.searchCustomer(customerId.getText());
    		if(customer == null) {
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Warning");
    			alert.setContentText("Customer not found");
    			alert.showAndWait();
    		}else {
    			customerFullName.setText(customer.getName()+" "+customer.getLastName());
    			customerCel.setText(customer.getCelphoneNumber());
    			customerAddress.setText(customer.getAddress());
    			customerImg.setImage(customer.getPhoto());
    		}
    	}catch(EmptyDataException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    }

    @FXML
    void sortDebtors(ActionEvent event) {

    }
    
    @FXML
    void sell(ActionEvent event) {

    }

    @FXML
    void sortCustomers(ActionEvent event) {
    	if(sortByDate.isSelected()) {
    		new Thread() {
    			@Override
    			public void run() {
    				company.sortCByLastPurchase();;
    			}
    		}.start();
    		Platform.runLater( new Thread() {
    			@Override
    			public void run() {
    				initializeTableCustomers();
    			}
    		});
    	}else {
    		new Thread() {
    			@Override
    			public void run() {
    				company.sortCByFullName();
    			}
    		}.start();
    		Platform.runLater( new Thread() {
    			@Override
    			public void run() {
    				initializeTableCustomers();
    			}
    		});
    	}
    }
    
    //Form Methods--------------------------------------------------------------------------------------------------------------------
    @FXML
    void chooseImageFile(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	fc.getExtensionFilters().add(new ExtensionFilter("Image Files","*.png","*.jpg"));
    	File selectedFile = fc.showOpenDialog(null);
    	
    	if(selectedFile!=null) {
    		photoForm.setText(selectedFile.getAbsolutePath());
    	}
    }
    
    @FXML
    void browse(ActionEvent event) {

    }
    
    //Active Employees Methods--------------------------------------------------------------------------------------------------------------------
    @FXML
    void checkOut(ActionEvent event) {
    	
    }
    
    @FXML
    void registerEntry(ActionEvent event) {

    }

    @FXML
    void searchActiveE(ActionEvent event) {

    }
    
    //Inventary scene Methods---------------------------------------------------------------------------------------------------------------
    @FXML
    void sortDairyDrinks(ActionEvent event) {

    }
    
    @FXML
    void discard(ActionEvent event) {

    }

    @FXML
    void addOats(ActionEvent event) {

    }
    
    @FXML
    void addProducts(ActionEvent event) {

    }
    
    @FXML
    void quantityYoghurts(ActionEvent event) {

    }
    
    @FXML
    void discardDrink(ActionEvent event) {

    }

    @FXML
    void sellDrink(ActionEvent event) {

    }
    
    @FXML
    void discardProduct(ActionEvent event) {

    }

    @FXML
    void sellProduct(ActionEvent event) {

    }
    
    //Analysis scene Methods-----------------------------------------------------------------------------------------------------------------
    @FXML
    void getSalesRequired(ActionEvent event) {

    }

    @FXML
    void predictUpcomingSales(ActionEvent event) {

    }
    
    //Initializer Methods----------------------------------------------------------------------------------------------------------------
    private void initializeTableEmployees() {
    	ObservableList<Employee> employees = FXCollections.observableArrayList(company.getEmployees());
    	employeeTable.setItems(employees);
    	
    	idEmployeeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));  
    	nameEmployeeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));  
    	lastnameEmployeeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));  
    	celphoneEmployeeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("celphoneNumber"));  
    	addressEmployeeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));  
    	positionColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("position")); 
    }
    
    private void initializeTableCustomers() {
    	ObservableList<Customer> customers = FXCollections.observableArrayList(company.getCustomers());
    	customerTable.setItems(customers);
    	
    	idCustomerColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));  
    	nameCustomerColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));  
    	lastnameCustomerColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));  
    	celphoneCustomerColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("celphoneNumber"));  
    	addressCustomerColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));  
    	dateCustomerColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("dateCustomer")); 
    }
    
    private void initializeTableDairyProducts() {
    	ObservableList<DairyDrink> dairyProducts = FXCollections.observableArrayList(company.getDairyDrink());
    	dairyDrinksTable.setItems(dairyProducts);
    	
    	drinkColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("drink"));
    	codeColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("code"));
    	flavorColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("flavor"));
    	sizeColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("size"));
    	suggarColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("suggar"));
    	typeOatColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("typeOat"));
    	dateDrinkColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("dateDrin"));
    }
    
    private void initializeTableCashRegister() {
    	ObservableList<Register> cashRegisters = FXCollections.observableArrayList(company.getCashRegister().getRegisters());
    	cashTable.setItems(cashRegisters);
    	
    	detailColumn.setCellValueFactory(new PropertyValueFactory<Register,String>("detail"));
    	movementColumn.setCellValueFactory(new PropertyValueFactory<Register,String>("value"));
    	timeColumn.setCellValueFactory(new PropertyValueFactory<Register,String>("time"));

    }
}

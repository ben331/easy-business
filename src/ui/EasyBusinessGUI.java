package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.ChoiceBox;
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
	private static final String FILE_NAME_MODEL = "data/company.srl";
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
    private CheckBox paid;

    @FXML
    private TextField customerBuyingId;

    @FXML
    private TextField codeToSell;
    
    @FXML
    private TableColumn<DairyDrink, Integer> codeColumn;
    
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
    private TableView<DairyProduct> dairyProductsTable;

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
    private ChoiceBox<String> menuProduct;
    
    @FXML
    private TextField quantityOats;

    @FXML
    private ToggleGroup sizeOats;
    
    @FXML
    private RadioButton sugarAndFlavor;
    
    @FXML
    private RadioButton flavorAndSize;

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
    private RadioButton radBig;
    
    @FXML
    private RadioButton radMedian;
    
    @FXML
    private RadioButton radSmall;
    
    @FXML
    private RadioButton radNormal;
    
    @FXML
    private RadioButton radLow;
    
    @FXML
    private Button addYoghurts;

    @FXML
    private ToggleGroup size;

    @FXML
    private ChoiceBox<String> flavorMenu;

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
    
    //Settings--------------------------------------------------------------------------------------------------------------------------------
    
    @FXML
    private TextField nameProduct;

    @FXML
    private TextField salePrice;

    @FXML
    private TextArea description;
    
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
    private RadioButton radioName;

    @FXML
    private RadioButton radioDebt;

    @FXML
    private RadioButton radioPurchaseDate;

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
    private TableView<Customer> debtorTable;

    @FXML
    private TableColumn<Customer, String> idDebtorColumn;

    @FXML
    private TableColumn<Customer, String> nameDebtorColumn;

    @FXML
    private TableColumn<Customer, String> lastnameDebtorColumn;

    @FXML
    private TableColumn<Customer, String> debtColumn;
    
    //Settings fields-----------------------------------------------------------------------------------------------------------------
    
    @FXML
    private Button buttonSet1;
    
    @FXML
    private TextField pBigY;

    @FXML
    private TextField pMedianY;

    @FXML
    private TextField pSmallY;

    @FXML
    private TextField pBigO;

    @FXML
    private TextField pMedianO;

    @FXML
    private TextField pSmallO;

    @FXML
    private TextField vBigY;

    @FXML
    private TextField vMedianY;

    @FXML
    private TextField vSmallY;

    @FXML
    private TextField vBigO;

    @FXML
    private TextField vMedianO;

    @FXML
    private TextField vSmallO;

    @FXML
    private TextField fYoghurt;

    @FXML
    private TextField fOat;
    
    @FXML
    private TextField expireDYog;

    @FXML
    private TextField expireDOat;

    @FXML
    private TextField vCostS;

    @FXML
    private TextField vCostO;

    @FXML
    private TextField vCostD;

    @FXML
    private TextField fCostS;

    @FXML
    private TextField fCostO;

    @FXML
    private TextField fCostD;

    @FXML
    private Button buttonSet2;
    
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
    private TextField employeeName;

    @FXML
    private TextField employeeId;

    @FXML
    private TextField employeeCel;

    @FXML
    private TextField employeeAddress;
    
    @FXML
	private TextField codeSell;
        
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
    void searchEmployee(ActionEvent event) {
    	String id=employeeId.getText();
    	Employee employee=company.searchEmployee(id);
    	if(employee==null) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Employee not found");
			alert.showAndWait();
    	}else {
    		employeeCel.setText(employee.getCelphoneNumber());
        	employeeAddress.setText(employee.getAddress());
        	employeeName.setText(employee.getName());
        	employeeImg.setImage(employee.getPhoto());
    	}
    	
    }

    //Main Scene Methods------------------------------------------------------------------------------------------------------------------

    @FXML
    void saveChanges(ActionEvent event) throws FileNotFoundException, IOException {
    	saveData();
    	company.getCashRegister().saveRegisters();
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Save");
		alert.setContentText("Data saved successfully");
		alert.showAndWait();
    }
    
	public void saveData() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME_MODEL));
    	oos.writeObject(company);
    	oos.close();
	}
	
	public void loadData() throws ClassNotFoundException, IOException {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(FILE_NAME_MODEL));
			company = (Company)(ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Welcome");
			alert.setContentText("Welcome to Easy Business \n To Start registers an initial amount greater than $ 50 000");
			alert.showAndWait();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogueToRegister.fxml"));
	    	loader.setController(this);
	    	Parent scene = loader.load();
	    	mainPane.setCenter(scene);
	    	
	    	valueToRegister.setPromptText("Type an initial amoung");
	    	detailToRegister.setText("Initial Amoung");
	    	detailToRegister.setDisable(true);;
	    	radButEgress.setDisable(true);
		}
		
	}
	
    
    @FXML
    void about(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setContentText("Credits\n\n Anderson Cardenas\nBenjamin Silva\n\nAlgorithms II");
		alert.showAndWait();
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
    	initializeActiveEmployees();
    }

    @FXML
    void showAnalysis(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Analysis.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }
    
    @FXML
    void showDialogueToAddNewProduct(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogueToAddNewProduct.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    }

    @FXML
    void showDialogueToSetPrices(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings1.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    	
    	pBigY.setText(company.getSettings().getPriceBigYoghurt()+"");
    	pMedianY.setText(company.getSettings().getPriceMedianYoghurt()+"");
    	pSmallY.setText(company.getSettings().getPriceSmallYoghurt()+"");
    	pBigO.setText(company.getSettings().getPriceBigOat()+"");
    	pMedianO.setText(company.getSettings().getPriceMedianOat()+"");
    	pSmallO.setText(company.getSettings().getPriceSmallOat()+"");
    	vBigY.setText(company.getSettings().getVarCostBigYoghurt()+"");
    	vMedianY.setText(company.getSettings().getVarCostMedianYoghurt()+"");
    	vSmallY.setText(company.getSettings().getVarCostSmallYoghurt()+"");
    	vBigO.setText(company.getSettings().getVarCostBigOat()+"");
    	vMedianO.setText(company.getSettings().getVarCostMedianOat()+"");
    	vSmallO.setText(company.getSettings().getVarCostSmallOat()+"");
    	fYoghurt.setText(company.getSettings().getFixedCostYoghurt()+"");
    	fOat.setText(company.getSettings().getFixedCostOat()+"");
    }
    
    @FXML
    void showDialogueToSetSalarys(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SalarySettings.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    	
    	fCostS.setText(company.getSettings().getFixedCostSeller()+"");
    	fCostO.setText(company.getSettings().getFixedCostOperator()+"");
    	fCostD.setText(company.getSettings().getFixedCostDomiciliary()+"");
    	
    	vCostS.setText(company.getSettings().getVarCostSeller()+"");
    	vCostO.setText(company.getSettings().getVarCostOperator()+"");
    	vCostD.setText(company.getSettings().getVarCostDomiciliary()+"");
    	
    	expireDYog.setText(company.getSettings().getDaysForYoghurtExpire()+"");
    	expireDOat.setText(company.getSettings().getDaysForOatExpire()+"");
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
    	initializeTableDairyDrinks();
    }

    @FXML
    void showDairyProducts(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DairyProducts.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    	initializeTableDairyProducts();
    }


	@FXML
    void showDebtors(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Debtors.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    	initializeTableDebtor();
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
    void showSettings(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
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
    	ObservableList<String> flavors = FXCollections.observableArrayList(Yoghurt.FLAVORS);
    	flavorMenu.setItems(flavors);;
    }

    @FXML
    void showDialogueToSell(ActionEvent event) throws IOException {
    	try {
    		int code = Integer.parseInt(codeToSell.getText());
    		
    		if(company.searchProduct(code)==null) {
        		Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("Warning");
        		alert.setContentText("Product not found");
        		alert.showAndWait();
        	}else {
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogueToSell.fxml"));
            	loader.setController(this);
            	Parent scene = loader.load();
            	mainPane.setCenter(scene);
            	codeSell.setText(code+"");
        	}
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Warning");
    		alert.setContentText("Type a natural number");
    		alert.showAndWait();
    	}
    }
    
    @FXML
    void showDialogueToAddProducts(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("DialogueToAddProducts.fxml"));
    	loader.setController(this);
    	Parent scene = loader.load();
    	mainPane.setCenter(scene);
    	ObservableList<String> products = FXCollections.observableArrayList(company.getSettings().getProductsNames());
    	menuProduct.setItems(products);
    }
    
    @FXML
    void showWarnings(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Warnings.fxml"));
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
    	}catch(EmptyDataException | NumberFormatException | InsufficientBalanceException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    }
    
    @FXML
    void searchRegisters(ActionEvent event) throws ClassNotFoundException, InsufficientBalanceException {
    	
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
    void backToToday(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException, EmptyDataException, InsufficientBalanceException {
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
    void charge(ActionEvent event) throws IOException{
    	try {
        	company.charge(customerId.getText());
        	initializeTableDebtor();
        	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Charged");
			alert.setContentText("Debt charged, new registered in cash register");
			alert.showAndWait();
    	}catch(InsufficientBalanceException | EmptyDataException e){
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    	
    }

    @FXML
    void searchDebtor(ActionEvent event) throws EmptyDataException {
    	try {
    		String id= customerId.getText();
        	Customer debtor=company.searchDebtor(id);
        	if(debtor!=null) {
        		customerFullName.setText(debtor.getName());
            	debt.setText(""+debtor.getDebtValue());
            	customerImg.setImage(debtor.getPhoto());
        	}else {
        		Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Warning");
    			alert.setContentText("Debtor not found");
    			alert.showAndWait();
        	}
        	
    	}catch(EmptyDataException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    	
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
    	if(radioName.isSelected()) {
    		company.sortByName();
    	}else if(radioDebt.isSelected()) {
    		company.sortByDebt();
    	}else {
    		company.sortByDate();
    	}
    	initializeTableDebtor(); 
    }

    @FXML
    void sortCustomers(ActionEvent event) {
    	
    	if(sortByDate.isSelected()) {
    		company.sortCByLastPurchase();
    	}else {
    		company.sortCByFullName();
    	}
    	initializeTableCustomers();
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
    
    //Active Employees Methods--------------------------------------------------------------------------------------------------------------------
    @FXML
    void checkOut(ActionEvent event) {
    	String id=activeEId.getText();
    	
    	int hours = company.registerDeparture(id);
    	if(hours>=0) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Successfull Process");
			alert.setContentText("Employee went out. \nHours Worked: "+hours+" hours.");
			alert.showAndWait();
	    	initializeActiveEmployees();
    	}
    	
    	initializeActiveEmployees();
    }
    
    @FXML
    void registerEntry(ActionEvent event) throws Exception {
    	try {
    		
    		if(company.registerEntry(activeEId.getText())) {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Successfull Process");
    			alert.setContentText("Employee was registered successfully");
    			alert.showAndWait();
    	    	initializeActiveEmployees();
    		}else {
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Warning");
    			alert.setContentText("Employee not found");
    			alert.showAndWait();
    		}
			
    	}catch(EmptyDataException | DoubleRegistrationException e) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    }

    @FXML
    void searchActiveE(ActionEvent event) {
    	String id = activeEId.getText();
    	Employee activeEmployee= company.searchEmployee(id);
    	
    	if(activeEmployee !=null) {
    		activeEName.setText(activeEmployee.getName());
    		employeeImg.setImage(activeEmployee.getPhoto());
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Employee not found");
			alert.showAndWait();
    	}
    	
    }
    
    @FXML
    void payPayroll(ActionEvent event) throws IOException {
    	try {
    		if(company.payPayroll()) {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Payroll paid successsfully");
    			alert.setContentText("Cahs register updated \n New registers of salary generated in folder 'registersPayRoll'.");
    			alert.showAndWait();
    		}else{
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Warning");
    			alert.setContentText("There is not employees");
    			alert.showAndWait();
    		}
			
		} catch (EmptyDataException | InsufficientBalanceException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
    }
    
    //Inventary scene Methods---------------------------------------------------------------------------------------------------------------
    @FXML
    void sortDairyDrinks(ActionEvent event) {
    	if(flavorAndSize.isSelected()) {
    		company.sortPByFlavorAndSize();
    	}else if(sugarAndFlavor.isSelected()) {
    		company.sortPBySugarLevelAndFlavor();
    	}else {
    		company.sortPByDateAndFlavor();
    	}
    	
    	initializeTableDairyDrinks();
    }
    
    @FXML
    void discard(ActionEvent event) {
    	try {
    		int num = Integer.parseInt(codeToSell.getText());
    		
    		if(company.discardProduct(num)){
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Product removed");
    			alert.setContentText("This product was discarded");
    			alert.showAndWait();
    			initializeTableDairyProducts();
        	}else {
        		Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Warning");
    			alert.setContentText("Product not found");
    			alert.showAndWait();
        	}
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Type a natural number");
			alert.showAndWait();
    	}
    }
    
    @FXML
    void discardDrink(ActionEvent event) {
    	try {
    		int num = Integer.parseInt(codeToSell.getText());
    		
    		if(company.discardProduct(num)){
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Product removed");
    			alert.setContentText("This product was discarded");
    			alert.showAndWait();
    			initializeTableDairyDrinks();
        	}else {
        		Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Warning");
    			alert.setContentText("Product not found");
    			alert.showAndWait();
        	}
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Type a natural number");
			alert.showAndWait();
    	}
    }

    @FXML
    void addOats(ActionEvent event) throws IOException {
    	try {
    		int numberOfOats = Integer.parseInt(among.getText());
    		char size;
    		char suggar;
    		String typeOat;
    		
    		if(radBig.isSelected()) {
    			size = DairyDrink.BIG;
    		}else if(radMedian.isSelected()) {
    			size = DairyDrink.MEDIAN;
    		}else {
    			size = DairyDrink.SMALL;
    		}
    		
    		if(radNormal.isSelected()) {
    			suggar = DairyDrink.NORMAL;
    		}else {
    			suggar = DairyDrink.LOW;
    		}
    		
    		typeOat = this.typeOat.getText();
    		
    		String confirmation= company.addOats(numberOfOats, size, suggar, typeOat);
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("DairyDrinks.fxml"));
        	loader.setController(this);
        	Parent scene = loader.load();
        	mainPane.setCenter(scene);
        	initializeTableDairyDrinks();
        	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Dairys Added successfully");
			alert.setContentText(confirmation);
			alert.showAndWait();	
    	}catch(NumberFormatException | EmptyDataException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Please, type a natural number");
			alert.showAndWait();
    	}
    	
    }
    
    @FXML
    void addYoghurts(ActionEvent event) throws IOException {
    	try {
    		int numberOfYoghurts = Integer.parseInt(among.getText());
    		char size;
    		char suggar;
    		String flavor;
    		
    		if(radBig.isSelected()) {
    			size = DairyDrink.BIG;
    		}else if(radMedian.isSelected()) {
    			size = DairyDrink.MEDIAN;
    		}else {
    			size = DairyDrink.SMALL;
    		}
    		
    		if(radNormal.isSelected()) {
    			suggar = DairyDrink.NORMAL;
    		}else {
    			suggar = DairyDrink.LOW;
    		}
    		if(flavorMenu.getSelectionModel().getSelectedItem()==null) {
    			throw new EmptyDataException("Flavor");
    		}
    		flavor = flavorMenu.getSelectionModel().getSelectedItem().toString();
    		
    		String confirmation= company.addYoghurts(numberOfYoghurts, size, suggar, flavor);
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("DairyDrinks.fxml"));
        	loader.setController(this);
        	Parent scene = loader.load();
        	mainPane.setCenter(scene);
        	initializeTableDairyDrinks();
        	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("DairyDrinks Added successfully");
			alert.setContentText(confirmation);
			alert.showAndWait();	
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Please, type a natural number");
			alert.showAndWait();
    	}catch(EmptyDataException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
    	}
    	
    }
    
    @FXML
    void addProducts(ActionEvent event) throws IOException {
    	try {
    		if(menuProduct.getSelectionModel()==null) {
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Warning");
    			alert.setContentText("Select a product, or create a product in settings");
    			alert.showAndWait();
    		}else {
    			String m = company.addProducts(quantityProducts.getText(), menuProduct.getSelectionModel().getSelectedIndex());
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("DairyProducts Added successfully");
    			alert.setContentText(m);
    			alert.showAndWait();
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("DairyProducts.fxml"));
    	    	loader.setController(this);
    	    	Parent scene = loader.load();
    	    	mainPane.setCenter(scene);
    	    	initializeTableDairyProducts();
    		}
    		
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Type a natural number");
			alert.showAndWait();
    	}
    }
    
    @FXML
    void sell(ActionEvent event) throws IOException {
    	try {
    		if(company.searchCustomer(customerBuyingId.getText())==null) {
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Warning");
    			alert.setContentText("Customer not found");
    			alert.showAndWait();
    		}else {
    			company.sellProduct(customerBuyingId.getText(), codeSell.getText(), paid.isSelected());
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Sale done successfully");
    			alert.setContentText("Sale done successfully");
    			alert.showAndWait();
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("DairyDrinks.fxml"));
    	    	loader.setController(this);
    	    	Parent scene = loader.load();
    	    	mainPane.setCenter(scene);
    	    	initializeTableDairyDrinks();
    		}
		} catch (EmptyDataException | BuyerWithDebtException | InsufficientBalanceException | SaleOfExpiredProductException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
			e.printStackTrace();
		}
    }
 
    
    //Analysis scene Methods-----------------------------------------------------------------------------------------------------------------
    @FXML
    void getSalesRequired(ActionEvent event) {
    	
    	//Heavy Algorithm
    	new Thread() {
    		@Override
    		public void run() {
    			try {
    	    		double g = Double.parseDouble(gain.getText());
    	    		String m = company.determineBalancePoints(g);
    	    		
    	    		Platform.runLater( new Thread() {
    	    			public void run() {
    	    				report.setText(m);
    	    			}
    	    		});
    				
    	    	}catch(NumberFormatException e) {
    	    		Platform.runLater( new Thread() {
    	    			public void run() {
    	    				Alert alert = new Alert(AlertType.WARNING);
    	    				alert.setTitle("Warning");
    	    				alert.setContentText("Type a positive real number in the field: gain");
    	    				alert.showAndWait();
    	    			}
    	    		});	    		
    	    	}
    		}
    	}.start();
    }

    @FXML
    void predictUpcomingSales(ActionEvent event) {
    	
    	
    	//Heavy Algorithm
    	new Thread() {
    		@Override
    		public void run() {
    			String report = company.predictUpcomingSales();
    			
    			Platform.runLater( new Thread() {
    				@Override
    				public void run() {
    					updateReport(report);
    				}
    			});
    		}
    	}.start();
    }
    
    private void updateReport(String r) {
		report.setText(r);
	}
    //Warnings methods----------------------------------------------------------------------------------------------------------------
    @FXML
    private TextArea warningsTxt;

    @FXML
    void updateWarnings(ActionEvent event) {
    	warningsTxt.setText(company.determinateWarnings());
    }
    
    //Setting methods-----------------------------------------------------------------------------------------------------------------
    
    @FXML
    void addNewProduct(ActionEvent event) throws IOException {
    	try {
    		company.getSettings().addDairyProduct(nameProduct.getText(), salePrice.getText(), description.getText());
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Added successfully");
			alert.setContentText("New product added successfully");
			alert.showAndWait();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("DairyProducts.fxml"));
	    	loader.setController(this);
	    	Parent scene = loader.load();
	    	mainPane.setCenter(scene);
	    	initializeTableDairyProducts();
	    	
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Type a positive real number in the field: price");
			alert.showAndWait();
    	}catch(EmptyDataException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
			
    	}
    }
    //Settings methods------------------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    void edit1(ActionEvent event) {
    	pBigY.setDisable(false);
    	pMedianY.setDisable(false);
    	pSmallY.setDisable(false);
    	pBigO.setDisable(false);
    	pMedianO.setDisable(false);
    	pSmallO.setDisable(false);
    	vBigY.setDisable(false);
    	vMedianY.setDisable(false);
    	vSmallY.setDisable(false);
    	vBigO.setDisable(false);
    	vMedianO.setDisable(false);
    	vSmallO.setDisable(false);
    	fYoghurt.setDisable(false);
    	fOat.setDisable(false);
    	buttonSet1.setVisible(true);
    }

    @FXML
    void saveSettings1(ActionEvent event) {
    	
    	try {
    		company.getSettings().setPriceBigYoghurt(Double.parseDouble(pBigY.getText()));
        	company.getSettings().setPriceMedianYoghurt(Double.parseDouble(pMedianY.getText()));
        	company.getSettings().setPriceSmallYoghurt(Double.parseDouble(pSmallY.getText()));
        	
        	company.getSettings().setPriceBigOat(Double.parseDouble(pBigO.getText()));
        	company.getSettings().setPriceMedianOat(Double.parseDouble(pMedianO.getText()));
        	company.getSettings().setPriceSmallOat(Double.parseDouble(pSmallO.getText()));
        	
        	company.getSettings().setVarCostBigYoghurt(Double.parseDouble(vBigY.getText()));
        	company.getSettings().setVarCostMedianYoghurt(Double.parseDouble(vMedianY.getText()));
        	company.getSettings().setVarCostSmallYoghurt(Double.parseDouble(vSmallY.getText()));
        	
        	company.getSettings().setVarCostBigOat(Double.parseDouble(vBigO.getText()));
        	company.getSettings().setVarCostMedianOat(Double.parseDouble(vMedianO.getText()));
        	company.getSettings().setVarCostSmallOat(Double.parseDouble(vSmallO.getText()));
        	
        	company.getSettings().setFixedCostOat(Double.parseDouble(fOat.getText()));
        	company.getSettings().setFixedCostYoghurt(Double.parseDouble(fYoghurt.getText()));
        	
        	buttonSet1.setVisible(false);
        	
        	pBigY.setDisable(true);
        	pMedianY.setDisable(true);
        	pSmallY.setDisable(true);
        	pBigO.setDisable(true);
        	pMedianO.setDisable(true);
        	pSmallO.setDisable(true);
        	vBigY.setDisable(true);
        	vMedianY.setDisable(true);
        	vSmallY.setDisable(true);
        	vBigO.setDisable(true);
        	vMedianO.setDisable(true);
        	vSmallO.setDisable(true);
        	fYoghurt.setDisable(true);
        	fOat.setDisable(true);
        	buttonSet1.setVisible(false);
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Type a positive real number in each field");
			alert.showAndWait();
    	}
    	
    	
    }    

    @FXML
    void edit2(ActionEvent event) {
    	fCostS.setDisable(false);
    	fCostO.setDisable(false);
    	fCostD.setDisable(false);
    	
    	vCostS.setDisable(false);
    	vCostO.setDisable(false);
    	vCostD.setDisable(false);
    	
    	expireDYog.setDisable(false);
    	expireDOat.setDisable(false);
    	
    	buttonSet2.setVisible(true);
    }

    @FXML
    void saveSettings2(ActionEvent event) {
    	try {
    		company.getSettings().setFixedCostSeller(Double.parseDouble(fCostS.getText()));
    		company.getSettings().setFixedCostOperator(Double.parseDouble(fCostO.getText()));
    		company.getSettings().setFixedCostDomiciliary(Double.parseDouble(fCostD.getText()));
    		
    		company.getSettings().setVarCostSeller(Double.parseDouble(vCostS.getText()));
    		company.getSettings().setVarCostOperator(Double.parseDouble(vCostO.getText()));
    		company.getSettings().setVarCostDomiciliary(Double.parseDouble(vCostD.getText()));
    		
    		company.getSettings().setDaysForYoghurtExpire((Integer.parseInt(expireDYog.getText())));
    		company.getSettings().setDaysForOatExpire((Integer.parseInt(expireDOat.getText())));
    		   		
    		fCostS.setDisable(true);
        	fCostO.setDisable(true);
        	fCostD.setDisable(true);
        	
        	vCostS.setDisable(true);
        	vCostO.setDisable(true);
        	vCostD.setDisable(true);
        	
        	expireDYog.setDisable(true);
        	expireDOat.setDisable(true);
    		
        	buttonSet2.setVisible(false);
        	
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setContentText("Type a positive real number in each field");
			alert.showAndWait();
    	}
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
    
    private void initializeTableDairyDrinks() {
    	ObservableList<DairyDrink> dairyDrinks = FXCollections.observableArrayList(company.getDairyDrink());
    	dairyDrinksTable.setItems(dairyDrinks);
    	
    	drinkColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("name"));
    	codeColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, Integer>("code1"));
    	flavorColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("flavor"));
    	sizeColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("size"));
    	suggarColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("sugarLevel"));
    	typeOatColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("typeOat"));
    	dateDrinkColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("preparationDate"));
    }
    
    private void initializeTableCashRegister() {
    	ObservableList<Register> cashRegisters = FXCollections.observableArrayList(company.getCashRegister().getRegisters());
    	cashTable.setItems(cashRegisters);
    	
    	detailColumn.setCellValueFactory(new PropertyValueFactory<Register,String>("detail"));
    	movementColumn.setCellValueFactory(new PropertyValueFactory<Register,String>("value"));
    	timeColumn.setCellValueFactory(new PropertyValueFactory<Register,String>("STime"));

    }

    private void initializeTableDebtor() {
    	ObservableList<Customer> debtors = FXCollections.observableArrayList(company.getDebtors());
    	 debtorTable.setItems(debtors);
    	 idDebtorColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("id"));
    	 nameDebtorColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
    	 lastnameDebtorColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("lastName"));
    	 debtColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("debtValue"));
    	 dateCustomerColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("lastDate"));
    }
    private void initializeTableDairyProducts() {
    	ObservableList<DairyProduct> dairyProducts = FXCollections.observableArrayList(company.getDairyProducts());
    	dairyProductsTable.setItems(dairyProducts);;
    	productColumn.setCellValueFactory(new PropertyValueFactory<DairyProduct,String>("name"));
        codeProductColumn.setCellValueFactory(new PropertyValueFactory<DairyProduct,String>("code"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<DairyProduct,String>("description"));
        dateProductColumn.setCellValueFactory(new PropertyValueFactory<DairyProduct,String>("preparationDate"));
	}
    private void initializeActiveEmployees() {
    	ObservableList<Employee> activeEmployees = FXCollections.observableArrayList(company.getActiveEmployees());
    	activeETable.setItems(activeEmployees);
    	idActiveEColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
    	nameActiveEColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
    	lastnameActiveEColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
    	positionActiveEColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("position"));
    	timeEntryColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("timeSEntry"));

    }
}

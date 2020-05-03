package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.*;

public class EasyBuisnessGUI {

	private Company comp;

    @FXML
    private DatePicker registersDate;

    @FXML
    private TableView<CashRegister> cashTable;

    @FXML
    private TableColumn<CashRegister, String> movementColumn;

    @FXML
    private TableColumn<CashRegister, String> detailColumn;

    @FXML
    private TableColumn<CashRegister, String> timeColumn;

    @FXML
    private TextField balance;

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
    private TextField valueToRegister;

    @FXML
    private TextField detailToRegister;

    @FXML
    private Label loading;
    
    @FXML
    private BorderPane mainPane;

    @FXML
    private TableView<?> activeETable;

    @FXML
    private TableColumn<?, ?> idActiveEColumn;

    @FXML
    private TableColumn<?, ?> nameActiveEColumn;

    @FXML
    private TableColumn<?, ?> lastnameActiveEColumn;

    @FXML
    private TableColumn<?, ?> positionActiveEColumn;

    @FXML
    private TableColumn<?, ?> timeEntryColumn;

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
    
    @FXML
    private TextField gain;

    @FXML
    private TextArea report;
    
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
    private TableView<?> customerTable;

    @FXML
    private TableColumn<?, ?> idCustomerColumn;

    @FXML
    private TableColumn<?, ?> nameCustomerColumn;

    @FXML
    private TableColumn<?, ?> lastnameCustomerColumn;

    @FXML
    private TableColumn<?, ?> celphoneCustomerColumn;

    @FXML
    private TableColumn<?, ?> addressCustomerColumn;

    @FXML
    private TableColumn<?, ?> dateCustomerColumn;

    @FXML
    private TableColumn<?, ?> dateCustomerColumn1;

    @FXML
    private ImageView customerImg;

    @FXML
    private TextField debt;

    @FXML
    private ToggleGroup sortingDebtors;
    
    @FXML
    private TextField customerName;

    @FXML
    private TextField customerId;

    @FXML
    private TextField customerCel;

    @FXML
    private TextField customerAddress;

    @FXML
    private ToggleGroup sortingCustomers;
    
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
    
    @FXML
    private TextField idEmployeeForm;

    @FXML
    private TextField nameEmployeeForm;

    @FXML
    private TextField lastnameEmployeeForm;

    @FXML
    private TextField addressEmployeeForm;

    @FXML
    private TextField celNumberEmployeeForm;

    @FXML
    private TextField photoEmployeeForm;
    
    @FXML
    private TableView<?> employeeTable;

    @FXML
    private TableColumn<?, ?> idEmployeeColumn;

    @FXML
    private TableColumn<?, ?> nameEmployeeColumn;

    @FXML
    private TableColumn<?, ?> lastnameEmployeeColumn;

    @FXML
    private TableColumn<?, ?> celphoneEmployeeColumn;

    @FXML
    private TableColumn<?, ?> addressEmployeeColumn;

    @FXML
    private TableColumn<?, ?> positionColumn;

    @FXML
    private TextField employeeId;

    @FXML
    private TextField employeeCel;

    @FXML
    private TextField EmployeeAddress;

    public EasyBuisnessGUI(Company comp) throws IOException {
		this.comp = comp;
	}
    
    public BorderPane getMainPane() {
		return mainPane;
	}
    
    @FXML
    void endDay(ActionEvent event) {

    }

    @FXML
    void searchRegisters(ActionEvent event) {

    }

    @FXML
    void toRegisterEgress(ActionEvent event) {

    }

    @FXML
    void toRegisterIngress(ActionEvent event) {

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
    void toRegister(ActionEvent event) {

    }
    
    @FXML
    void about(ActionEvent event) {

    }

    @FXML
    void cashRegister(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void saveChanges(ActionEvent event) {

    }

    @FXML
    void showActiveEmployess(ActionEvent event) {

    }

    @FXML
    void showAnalysis(ActionEvent event) {

    }

    @FXML
    void showCustomers(ActionEvent event) {

    }

    @FXML
    void showDairyDrinks(ActionEvent event) {

    }

    @FXML
    void showDairyProducts(ActionEvent event) {

    }

    @FXML
    void showDebtors(ActionEvent event) {

    }

    @FXML
    void showEmployees(ActionEvent event) {

    }

    @FXML
    void showSettings(ActionEvent event) {

    }
    
    @FXML
    void registerEntry(ActionEvent event) {

    }

    @FXML
    void searchActiveE(ActionEvent event) {

    }
    
    @FXML
    void getSalesRequired(ActionEvent event) {

    }

    @FXML
    void predictUpcomingSales(ActionEvent event) {

    }
    
    @FXML
    void addCustomer(ActionEvent event) {

    }

    @FXML
    void browse(ActionEvent event) {

    }
    
    @FXML
    void showDialogeToAddCustomer(ActionEvent event) {

    }

    @FXML
    void sortCustomers(ActionEvent event) {

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

    @FXML
    void showDialogueToAddProducts(ActionEvent event) {

    }
    
    @FXML
    void charge(ActionEvent event) {

    }

    @FXML
    void searchDebtor(ActionEvent event) {

    }

    @FXML
    void sortDebtors(ActionEvent event) {

    }
    
    @FXML
    void sell(ActionEvent event) {

    }
    

    @FXML
    void addEmployee(ActionEvent event) {

    }

    @FXML
    void browseEmployee(ActionEvent event) {

    }
    
    @FXML
    void searchEmployee(ActionEvent event) {

    }

    @FXML
    void showDialogeToAddEmployee(ActionEvent event) {

    }
    
    private void initializeTableCashRegister() {
    	ObservableList<CashRegister> cashRegisters = FXCollections.observableArrayList();
    	cashTable.setItems(cashRegisters);
    	
    	detailColumn.setCellValueFactory(new PropertyValueFactory<CashRegister,String>("detail"));
    	movementColumn.setCellValueFactory(new PropertyValueFactory<CashRegister,String>("movement"));
    	timeColumn.setCellValueFactory(new PropertyValueFactory<CashRegister,String>("time"));

    }
    
    private void initializeTableDairyProducts() {
    	ObservableList<DairyDrink> dairyProducts = FXCollections.observableArrayList(comp.getDairyDrink());
    	dairyDrinksTable.setItems(dairyProducts);
    	
    	drinkColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("drink"));
    	codeColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("code"));
    	flavorColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("flavor"));
    	sizeColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("size"));
    	suggarColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("suggar"));
    	typeOatColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("typeOat"));
    	dateDrinkColumn.setCellValueFactory(new PropertyValueFactory<DairyDrink, String>("dateDrin"));
    }
    
    
}

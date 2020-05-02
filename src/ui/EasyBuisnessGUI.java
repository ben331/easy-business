package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class EasyBuisnessGUI {

    @FXML
    private DatePicker registersDate;

    @FXML
    private TableView<?> cashTable;

    @FXML
    private TableColumn<?, ?> movementColumn;

    @FXML
    private TableColumn<?, ?> detailColumn;

    @FXML
    private TableColumn<?, ?> timeColumn;

    @FXML
    private TextField balance;

    @FXML
    private TableView<?> dairyDrinksTable;

    @FXML
    private TableColumn<?, ?> drinkColumn;

    @FXML
    private TableColumn<?, ?> codeColumn;

    @FXML
    private TableColumn<?, ?> flavorColumn;

    @FXML
    private TableColumn<?, ?> sizeColumn;

    @FXML
    private TableColumn<?, ?> suggarColumn;

    @FXML
    private TableColumn<?, ?> typeOatColumn;

    @FXML
    private TableColumn<?, ?> dateDrinkColumn;

    @FXML
    private ToggleGroup Sorting;

    @FXML
    private ImageView drinkImg;

    @FXML
    private TableView<?> dairyProductsTable;

    @FXML
    private TableColumn<?, ?> productColumn;

    @FXML
    private TableColumn<?, ?> codeProductColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

    @FXML
    private TableColumn<?, ?> dateProductColumn;

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
    
}

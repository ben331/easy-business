package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Company;

public class Main extends Application{
	
	private EasyBusinessGUI easyBusinessGUI;
	private Company company;
	
	public Main() {
		company = new Company();
		easyBusinessGUI = new EasyBusinessGUI(company);
	}

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PrincipalScene.fxml"));
		loader.setController(easyBusinessGUI);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Easy Business");
		primaryStage.show();
	}
}

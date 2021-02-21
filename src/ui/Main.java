package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InfrastructureDepartment;

public class Main extends Application {

	private InfrastructureDepartment infD;
	private InfrastructureDepartmentGUI infDGUI;
	
	public Main() {
		infD = new InfrastructureDepartment();
		infDGUI = new InfrastructureDepartmentGUI(infD);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(infDGUI);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Billboard Manager");
		infDGUI.initializeTableView();
		primaryStage.show();
	}

}

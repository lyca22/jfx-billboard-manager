package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Billboard;
import model.InfrastructureDepartment;

public class InfrastructureDepartmentGUI {

	private InfrastructureDepartment infD;
	
	@FXML
	private VBox mainPane;
	
	@FXML
	private TableView<Billboard> tvBillboardList;
	
	@FXML
	private TableColumn<Billboard, String> tcWidth;
	
	@FXML
	private TableColumn<Billboard, String> tcHeight;
	
	@FXML
	private TableColumn<Billboard, String> tcUsed;
	
	@FXML
	private TableColumn<Billboard, String> tcBrand;
	
	public InfrastructureDepartmentGUI(InfrastructureDepartment infD) {
		setInfD(infD);
	}

	public InfrastructureDepartment getInfD() {
		return infD;
	}

	public void setInfD(InfrastructureDepartment infD) {
		this.infD = infD;
	}
	
	public void initializeTableView() {
		ObservableList<Billboard> observableList;
		observableList = FXCollections.observableArrayList(infD.getBillboards());
		tvBillboardList.setItems(observableList);
		tcWidth.setCellValueFactory(new PropertyValueFactory<Billboard, String>("width"));
		tcHeight.setCellValueFactory(new PropertyValueFactory<Billboard, String>("height"));
		tcUsed.setCellValueFactory(new PropertyValueFactory<Billboard, String>("useText"));
		tcBrand.setCellValueFactory(new PropertyValueFactory<Billboard, String>("brand"));
	}
	
	public void openAddBillboardMenu(ActionEvent e) {
		Dialog<String> dialog = new Dialog<>();
		dialog.setTitle("Add Billboard");
		dialog.setHeaderText("Add a new billboard:");
		ButtonType addButtonType = new ButtonType("Add billboard", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField widthText = new TextField();
		widthText.setPromptText("Width");
		TextField heightText = new TextField();
		heightText.setPromptText("Height");
		HBox hbox = new HBox();
		ToggleGroup usedGroup = new ToggleGroup();
		RadioButton yes = new RadioButton();
		RadioButton no = new RadioButton();
		yes.setToggleGroup(usedGroup);
		no.setToggleGroup(usedGroup);
		Label yesText = new Label("Yes		");
		Label noText = new Label("No");
		hbox.getChildren().addAll(yes, yesText, no, noText);
		TextField brandText = new TextField();
		brandText.setPromptText("Brand");

		grid.add(new Label("Width"), 0, 0);
		grid.add(widthText, 1, 0);
		grid.add(new Label("cm"), 2, 0);
		grid.add(new Label("Height"), 0, 1);
		grid.add(heightText, 1, 1);
		grid.add(new Label("cm"), 2, 1);
		grid.add(new Label("Is it being used?"), 0, 2);
		grid.add(hbox, 1, 2);
		grid.add(new Label("Brand"), 0, 3);
		grid.add(brandText, 1, 3);
		dialog.getDialogPane().setContent(grid);
		
		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == addButtonType) {
		    	try {
		    		double width = Double.parseDouble(widthText.getText());
			    	double height = Double.parseDouble(heightText.getText());
			    	boolean iu = yes.isSelected() || no.isSelected() ? yes.isSelected() : null;
			    	String brand = brandText.getText();
			    	addBillboard(width, height, iu, brand);
			    	System.out.println("Done");
		    	}catch(NumberFormatException nfe) {
		    		System.out.println("NumberFormatException found");
		    	}catch(NullPointerException npe) {
		    		System.out.println("NullPointerException found");
		    	}
		    }
		    return null;
		});
		
		dialog.showAndWait();
		
	}
	
	public void addBillboard(double w, double h, boolean iu, String b) {
		infD.addBillboard(w, h, iu, b);
		initializeTableView();
	}
	
}

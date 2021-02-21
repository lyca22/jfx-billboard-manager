package ui;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	
}

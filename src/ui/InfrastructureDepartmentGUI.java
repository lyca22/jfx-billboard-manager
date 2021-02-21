package ui;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import model.InfrastructureDepartment;

public class InfrastructureDepartmentGUI {

	private InfrastructureDepartment infD;
	
	@FXML
	private GridPane mainPane;
	
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

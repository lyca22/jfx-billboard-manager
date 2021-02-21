package model;

import java.util.ArrayList;
import java.util.List;

public class InfrastructureDepartment {

	public static final String BILLBOARD_FILE_NAME = "data/billboard.bbd";
	
	private List<Billboard> billboards;
	
	public InfrastructureDepartment() {
		setBillboards(new ArrayList<Billboard>());
	}

	public List<Billboard> getBillboards() {
		return billboards;
	}

	public void setBillboards(List<Billboard> billboards) {
		this.billboards = billboards;
	}
	
	public void addBillboard(double w, double h, boolean iu, String b) {
		Billboard newBillboard = new Billboard(w, h, iu, b);
		billboards.add(newBillboard);
	}
	
	@SuppressWarnings("unused")
	private void saveBillboards() {
		
	}
	
	@SuppressWarnings("unused")
	private void loadBillboard() {
		
	}
	
	public void exportDangerousBillboardReport(String fn) {
		
	}
	
	public void importData(String fn) {
		
	}
	
	public String toString() {
		return null;
	}
	
}

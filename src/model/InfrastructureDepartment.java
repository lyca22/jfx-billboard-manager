package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class InfrastructureDepartment {

	public static final String BILLBOARD_FILE_NAME = "data/billboard.bbd";
	public static final double DANGEROUS_AREA = 160000;
	
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
	
	public void saveBillboards() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BILLBOARD_FILE_NAME));
	    oos.writeObject(billboards);
	    oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public boolean loadBillboard() throws IOException, ClassNotFoundException{
		File file = new File(BILLBOARD_FILE_NAME);
		boolean loaded = false;
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			billboards = (List<Billboard>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	public void exportDangerousBillboardReport(String fn, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fn);
		for(Billboard b: billboards) {
			if(b.calculateArea() >= DANGEROUS_AREA) {
				pw.println(b.getWidth()+separator+b.getHeight()+separator+b.isInUse()+separator+b.getBrand());
			}
		}
		pw.close();
	}
	
	public void importData(String fn, String separator) throws IOException, NullPointerException, NumberFormatException {
		BufferedReader br = new BufferedReader(new FileReader(fn));
		String line = br.readLine();
		while(line != null){
		      String[] parts = line.split(separator);
		      double w = Double.parseDouble(parts[0]);
		      double h = Double.parseDouble(parts[1]);
		      addBillboard(w, h, parts[2].equals("true"), parts[3]);
		      line = br.readLine();
		    }
		    br.close();
	}
	
	public String toString(String separator) {
		String text = "Billboard list:\n";
		for(Billboard b: billboards) {
			text += b.getWidth() + separator + b.getHeight() + separator + b.isInUse() + separator + b.getBrand() + "\n";
		}
		return text;
	}
	
}

import java.awt.Dimension;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Company {
	private String name;
	private double  currentFederal, toDateFederal, currentState, toDateState, currentLocal, toDateLocal, totalDeduction, grossWage, netPay, toDateDeduction;
	
	
	
	public Company()
	{
		
		name = null;
		currentFederal=0;
		toDateFederal=0;
		currentState=0;
		toDateState=0;
		currentLocal=0;
		toDateLocal=0;
		totalDeduction=0;
		grossWage=0;
		netPay=0;
		toDateDeduction =0;
	}
	
	public void collectData(Employee employee)
	{
		this.currentFederal += employee.getCurrentFederal();
		this.currentState += employee.getCurrentState();
		this.currentLocal += employee.getCurrentLocal();
		
		this.toDateFederal += employee.getToDateFederal();
		this.toDateState += employee.getToDateState();
		this.toDateLocal += employee.getToDateLocal();
		
		this.totalDeduction += employee.getTotalDeduct();
		this.grossWage += employee.getGrossWage();
		this.netPay += employee.getNetPay();
		
		this.toDateDeduction += (employee.getToDateFederal()+employee.getToDateState()+employee.getToDateLocal());
		
	}
	
	public void printCompanyReport()
	{	
		NumberFormat moneyFormat =  NumberFormat.getCurrencyInstance();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Weekly Summary"));
		String[] column = {" ", "Current", "Year to Date"};
		Object[][] data = {
				{"Federal", moneyFormat.format(this.currentFederal), moneyFormat.format(this.toDateFederal)},
				{"Stage", moneyFormat.format(this.currentState), moneyFormat.format(this.toDateState)},
				{"Local", moneyFormat.format(this.currentLocal), moneyFormat.format(this.toDateLocal)},
				{"Total Deductions", moneyFormat.format(this.totalDeduction), moneyFormat.format(this.toDateDeduction)},
				{"Gross Wages",  moneyFormat.format(this.grossWage), " "},
				{"Net Pay",  moneyFormat.format(this.netPay), " "}
				
		};
		JTable table = new JTable(data, column);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(250,100));
		panel.add(scrollPane);
		JOptionPane.showMessageDialog(null, panel, "The " + this.name +" Company", JOptionPane.INFORMATION_MESSAGE);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCurrentFederal() {
		return currentFederal;
	}

	public void setCurrentFederal(double currentFederal) {
		this.currentFederal = currentFederal;
	}

	public double getToDateFederal() {
		return toDateFederal;
	}

	public void setToDateFederal(double toDateFederal) {
		this.toDateFederal = toDateFederal;
	}

	public double getCurrentState() {
		return currentState;
	}

	public void setCurrentState(double currentState) {
		this.currentState = currentState;
	}

	public double getToDateState() {
		return toDateState;
	}

	public void setToDateState(double toDateState) {
		this.toDateState = toDateState;
	}

	public double getCurrentLocal() {
		return currentLocal;
	}

	public void setCurrentLocal(double currentLocal) {
		this.currentLocal = currentLocal;
	}

	public double getToDateLocal() {
		return toDateLocal;
	}

	public void setToDateLocal(double toDateLocal) {
		this.toDateLocal = toDateLocal;
	}

	public double getTotalDeduction() {
		return totalDeduction;
	}

	public void setTotalDeduction(double totalDeduction) {
		this.totalDeduction = totalDeduction;
	}

	public double getGrossWage() {
		return grossWage;
	}

	public void setGrossWage(double grossWage) {
		this.grossWage = grossWage;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}

	public double getToDateDeduction() {
		return toDateDeduction;
	}

	public void setToDateDeduction(double toDateDeduction) {
		this.toDateDeduction = toDateDeduction;
	}
	
	
	
}

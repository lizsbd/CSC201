import java.awt.Dimension;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Employee {
	private final double LOCAL_MAX = 517.50;
	private String firstName, lastName;
	private double dependent, hour,rate, localTaxToDate, federalTaxToDate, stateTaxToDate, currentFederal, toDateFederal, currentState, toDateState, currentLocal, toDateLocal, totalDeduct, netPay, grossWage;
	
	public Employee(){
		firstName = null;
		lastName = null;
		dependent=0;
		hour=0;
		rate =0;
		localTaxToDate=0;
		federalTaxToDate=0;
		stateTaxToDate=0;
		currentFederal=0;
		toDateFederal=0;
		currentState=0;
		toDateState=0;
		currentLocal=0;
		toDateLocal=0;
		totalDeduct=0;
		netPay=0;
		grossWage=0;
	}
	
	public void readInput() 
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel header = new JLabel("Enter the information for an employee");
		JTextField firstNameInput = new JTextField(20);
		JTextField lastNameInput = new JTextField(20);
		JTextField dependentInput = new JTextField(20);
		JTextField hourInput = new JTextField(20);
		JTextField localInput = new JTextField(20);
		JTextField federalInput = new JTextField(20);
		JTextField stateInput = new JTextField(20);
		JTextField rateInput = new JTextField(20);
		
		panel.add(header);
		panel.add(new JLabel("First Name"));
		panel.add(firstNameInput);
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("Last Name"));
		panel.add(lastNameInput);
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("Number of Dependents"));
		panel.add(dependentInput);
		panel.add(new JLabel("Hourly Rate"));
		panel.add(rateInput);
		panel.add(Box.createVerticalStrut(10));
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("Number of worked hours"));
		panel.add(hourInput);
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("Local tax withheld to date"));
		panel.add(localInput);
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("Federal Tax withheld to date"));
		panel.add(federalInput);
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("State Tax withheld to date"));
		panel.add(stateInput);
		panel.add(Box.createVerticalStrut(10));
		
		int confirm = JOptionPane.showConfirmDialog(null, panel, 
	               "Please Enter Values", JOptionPane.OK_CANCEL_OPTION);
	      if (confirm == JOptionPane.OK_OPTION) {
		
	    	  this.firstName = firstNameInput.getText();
	    	  this.lastName = lastNameInput.getText();
	    	  this.dependent = Double.parseDouble(dependentInput.getText());
	    	  this.rate = Double.parseDouble(rateInput.getText());
	    	  this.hour = Double.parseDouble(hourInput.getText());
	    	  this.localTaxToDate = Double.parseDouble(localInput.getText());
	    	  this.federalTaxToDate = Double.parseDouble(federalInput.getText());
	    	  this.stateTaxToDate = Double.parseDouble(stateInput.getText());
	    	  
	      }
	}
	
	public void writeOutput()
	{
		NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Employee: " + this.firstName + " " + this.lastName));
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("Hours worked: " + this.hour));
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("Hourly Rate: " + moneyFormat.format(this.rate)));
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("Gross Wage:\t\t\t" + moneyFormat.format(this.grossWage)));
		panel.add(Box.createVerticalStrut(10));
		
		String[] column = {" ", "Current", "Year to Date"};
		Object[][] data = {
				{"Federal", moneyFormat.format(this.currentFederal), moneyFormat.format(this.toDateFederal)},
				{"Stage", moneyFormat.format(this.currentState), moneyFormat.format(this.toDateState)},
				{"Local", moneyFormat.format(this.currentLocal), moneyFormat.format(this.toDateLocal)}
		};
		JTable table = new JTable(data, column);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(250,100));
		panel.add(scrollPane);
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("Total Deductions:\t\t\t" + moneyFormat.format(this.totalDeduct)));
		panel.add(Box.createVerticalStrut(10));
		panel.add(new JLabel("Net Pay:\t\t\t" + moneyFormat.format(this.netPay)));
		
		
		JOptionPane.showMessageDialog(null, panel, "Tax Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private double income() 
	{
		double income = (this.grossWage-(15.00*this.dependent))*52;
		return income;
	}
	
	private double federal()
	{
		double federalTax = 0;
		double income = this.income();
		if((income>=0)&&(income<20000))
		{
			federalTax = 0.1*income/52;
		}
		else if((income>=20000)&&(income<40000))
		{
			federalTax = 0.2*income/52;
		}
		else if(income>=40000)
		{
			federalTax = 0.3*income/52;
		}
		else
		{
			throw new IndexOutOfBoundsException("Negative Income!");
		}
		return federalTax;
	}
	
	private double state()
	{
		double stateTax = 0;
		double income = this.income();
		if((income>=0)&&(income<30000))
		{
			stateTax = 0.05*this.grossWage;
		}
		else if (income>30000)
		{
			stateTax = 0.1*this.grossWage;
		}
		else 
		{
			throw new IndexOutOfBoundsException("Negative Income!");
		}
		return stateTax;
	}
	
	private double local()
	{
		double currentLocalTax=0;
		double income = this.income();
		if((income>0)&&(income<=45000))
		{
			currentLocalTax = income*0.0115;
		}
		else if(income>45000)
		{
			currentLocalTax = income*45000;
		}
		return currentLocalTax;
	}
	
	
	
	
	
	public void calculateData()
	{
		if(this.hour > 40)
		{
		 this.grossWage = (this.hour + (this.hour-40)/2)*this.rate;
		
		}
		else
		{
		this.grossWage = this.hour*this.rate;
		}
		
		this.currentFederal = this.federal();
		this.toDateFederal = this.federalTaxToDate + this.currentFederal;
		
		this.currentState = this.state();
		this.toDateState = this.currentState + this.stateTaxToDate;
		
		double totalLocalTax = this.local() + this.localTaxToDate;
		if(totalLocalTax<LOCAL_MAX)
		{
			this.currentLocal = this.local();
			this.toDateLocal = totalLocalTax;
		}
		else
		{
			this.toDateLocal = LOCAL_MAX;
			this.currentLocal = LOCAL_MAX - this.localTaxToDate;
		}
		
		this.totalDeduct = this.currentFederal + this.currentLocal + this.currentState;
		this.netPay = this.grossWage - this.totalDeduct;
		
	}
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
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

	public double getTotalDeduct() {
		return totalDeduct;
	}

	public void setTotalDeduct(double totalDeduct) {
		this.totalDeduct = totalDeduct;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}

	public double getGrossWage() {
		return grossWage;
	}

	public void setGrossWage(double grossWage) {
		this.grossWage = grossWage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getDependent() {
		return dependent;
	}

	public void setDependent(double dependent) {
		this.dependent = dependent;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(double hour) {
		this.hour = hour;
	}

	public double getLocalTaxToDate() {
		return localTaxToDate;
	}

	public void setLocalTaxToDate(double localTaxToDate) {
		this.localTaxToDate = localTaxToDate;
	}

	public double getFederalTaxToDate() {
		return federalTaxToDate;
	}

	public void setFederalTaxToDate(double federalTaxToDate) {
		this.federalTaxToDate = federalTaxToDate;
	}

	public double getStateTaxToDate() {
		return stateTaxToDate;
	}

	public void setStateTaxToDate(double stateTaxToDate) {
		this.stateTaxToDate = stateTaxToDate;
	}


	
	
	
}

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Temp {
	private double degree;
	private String unit;
	private final double KELVIN_MIN = 0;
	private final double CELCIUS_MIN = -273.15;
	private final double FAHRENHEIT_MIN = -459.67;
	
	
	
	public Temp(){
		degree = 0;
		unit = "Kelvin";
	}
	
	public Temp(double degree, String unit){
		double absoluteZero=0;
		switch(unit){
		case "C":
			absoluteZero = 	CELCIUS_MIN;
			break;
		case "K":
			absoluteZero = KELVIN_MIN;
			break;
		case "F":
			absoluteZero = FAHRENHEIT_MIN;
			break;
		default:
			throw new IndexOutOfBoundsException("Invalid input of unit!");
		}
		if(degree>=absoluteZero)
		{
		this.degree = degree;
		this.unit = unit;
		}
		else {
			throw new IndexOutOfBoundsException("Invalid input!");
		}
	}
	
	public void read()
	{
	
		JPanel panel = new JPanel();
		JLabel instruction = new JLabel("Enter a temperature in C, F or K");
		JLabel degreeLabel = new JLabel("Degree");
		JTextField degreeInput = new JTextField(10);
		JLabel unitLabel = new JLabel("Unit");
		JTextField unitInput = new JTextField(10);
		panel.add(instruction);
		panel.add(Box.createVerticalStrut(5));
		panel.add(degreeLabel);
		panel.add(degreeInput);
		panel.add(Box.createHorizontalStrut(15));
		panel.add(unitLabel);
		panel.add(unitInput);
		
		
		int confirm = JOptionPane.showConfirmDialog(null, panel, 
	               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
	      if (confirm == JOptionPane.OK_OPTION) {
		
		this.setUnit(unitInput.getText());
		if(degreeInput.getText().isEmpty())
		{
			throw new IndexOutOfBoundsException("Invalid input!");
		}
		else 
		{
			this.setTemp(Double.parseDouble(degreeInput.getText().toString()));
		}
		
			
			
		}
		
	}
	
	public String toString(){
		return this.degree + " " + this.unit;
	}
	
	public void setTemp(double number)
	{
		double absoluteZero=0;
		switch(this.unit){
		case "C":
			absoluteZero = 	CELCIUS_MIN;
			break;
		case "K":
			absoluteZero = KELVIN_MIN;
			break;
		case "F":
			absoluteZero = FAHRENHEIT_MIN;
			break;
		}
		if(degree>=absoluteZero)
		{
		this.degree = number;
		}
		else {
			throw new IndexOutOfBoundsException("Invalid input!");
		}
	}
	
	public void setUnit(String input)
	{
		switch(input){
		case "C":
		case "K":
		case "F":
			this.unit = input;
			break;
		default:
			throw new IndexOutOfBoundsException("Invalid input!");
		}
		
	}
	
	public double getTemp(){
		return this.degree;
	}
	
	public String getUnit(){
		return this.unit;
	}
	
	public Temp toCelcius(){
		Temp convertedTemp = new Temp();
		switch(this.unit)
		{
		case "K":
			convertedTemp = new Temp((this.degree -273.15), "C");
			break;
		case "F" :
			convertedTemp = new Temp((5.0/9.0*(this.degree-32)),"C");
			break;
		default :
			convertedTemp = this;
		}
		
		return convertedTemp;
	}
	
	public Temp toKelvin(){
		Temp convertedTemp = new Temp();
		switch(this.unit)
		{
		case "C":
			convertedTemp = new Temp((this.degree +273.15), "K");
			break;
		case "F" :
			Temp celciusTemp = this.toCelcius();
			convertedTemp = new Temp((celciusTemp.getTemp()+273.15),"K");
			break;
		default:
			convertedTemp = this;
		}
		
		return convertedTemp;
	}
	public Temp toFahrenheit()
	{
		Temp convertedTemp = new Temp();
		switch(this.unit)
		{
		case "C":
			convertedTemp = new Temp(((this.degree)*5.0/9.0+32), "F");
			break;
		case "K" :
			Temp celciusTemp = this.toCelcius();
			convertedTemp = new Temp(((celciusTemp.getTemp())*5.0/9.0+32),"F");
			break;
		default:
			convertedTemp = this;
		}
		
		return convertedTemp;
	}
	
	public boolean equals(Temp anotherTemp)
	{
		Temp comparingTemp = new Temp();
		switch(this.unit){
		case "C":
			comparingTemp = anotherTemp.toCelcius();
			break;
		case "K":
			comparingTemp = anotherTemp.toKelvin();
			break;
		case "F":
			comparingTemp = anotherTemp.toFahrenheit();
			break;
			
		}
		if(this.degree == comparingTemp.getTemp())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean greaterThan(Temp anotherTemp)
	{
		Temp comparingTemp = new Temp();
		switch(this.unit){
		case "C":
			comparingTemp = anotherTemp.toCelcius();
			break;
		case "K":
			comparingTemp = anotherTemp.toKelvin();
			break;
		case "F":
			comparingTemp = anotherTemp.toFahrenheit();
			break;
			
		}
		if(this.degree >= comparingTemp.getTemp())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public Temp add(Temp anotherTemp)
	{	
		
		Temp sumTemp = new Temp(((this.convert(anotherTemp).getTemp())+this.degree), this.unit);
		return sumTemp;
	}
		
	
	
	
	public Temp add(double number)
	{
	Temp sumTemp = new Temp((this.degree + number),this.unit);
	return sumTemp;
		
	}
		
	
		
	
	public Temp substract(Temp anotherTemp)
	{
			Temp differentTemp = new Temp((this.degree-(this.convert(anotherTemp).getTemp())), this.unit);
			return differentTemp;
	}
		
	
	
	
	public Temp substract(double number)
	{
		
			Temp differentTemp = new Temp((this.degree - number),this.unit);
			
			return differentTemp;
			
	}
	
	public Temp multiply(Temp anotherTemp)
	{
		
			Temp productTemp = new Temp(((this.convert(anotherTemp).getTemp())*this.degree), this.unit);
			
			return productTemp;
			
			
	}
		
	
	
	
	public Temp multiply(double number)
	{
		
			Temp productTemp = new Temp((this.degree*number), this.unit);
			
			return productTemp;
			
	}
		
	public Temp divide(Temp anotherTemp)
	{
		
			Temp quotientTemp = new Temp((this.degree/(this.convert(anotherTemp).getTemp())), this.unit);
			return quotientTemp;
	}
		
	
	
	
	public Temp divide(double number)
	{
		
			Temp quotientTemp = new Temp((this.degree/number),this.unit);
			return quotientTemp;
		}
		
	public Temp convert(Temp anotherTemp){
		Temp newTemp = new Temp();
		switch(this.unit)
		{
		case "C":
			newTemp = anotherTemp.toCelcius();
			break;
		case "K":
			newTemp = anotherTemp.toKelvin();
			break;
		case "F":
			newTemp = anotherTemp.toFahrenheit();
			break;
			
		}
		return newTemp;
	}
}



	
	
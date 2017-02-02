import javax.swing.JOptionPane;

public class TempDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Temp Temp1 = new Temp();
		Temp Temp2 = new Temp();
		Temp Temp3 = new Temp();
		Temp Temp4 = new Temp();
		Temp Temp5 = new Temp();
		Temp Temp6 = new Temp();
		
		Temp1.read();
		
		Temp2.read();
		
		Temp3 = Temp1.add(Temp2);
		
		Temp4 = Temp1.substract(Temp2);
		
		Temp5 = Temp1.multiply(Temp2);
		
		Temp6 = Temp1.divide(Temp2);
		
		String equal = null;
		if (Temp1.equals(Temp2)){
			equal = "the same";
		}
		else {
			equal ="different";
		}
		Temp convertedTemp = new Temp((5/9*(Temp1.getTemp()-32)),"C");
		
		JOptionPane.showMessageDialog(null, "The 2 Temp are " + equal, "Temp", JOptionPane.INFORMATION_MESSAGE);
		
		String message = "The value of Temp 1 is " + Temp1.toString() + "\nThe value of Temp 2 is " + Temp2.toString() +"\nThe sum is " + Temp3.toString() + "\nThe different is " + Temp4.toString() + "\nThe product is " + Temp5.toString() + "\nThe quotient is " + Temp6.toString();
		
		JOptionPane.showMessageDialog(null, message, "Temp", JOptionPane.INFORMATION_MESSAGE);
		
		String input = JOptionPane.showInputDialog(null, "Enter a number", "Temp", JOptionPane.INFORMATION_MESSAGE);
		int number = Integer.parseInt(input);
		String secondMessage = "The value of Temp 1 is " + Temp1.toString() + "\nThe input number is " + input +"\nThe sum is "+ Temp1.add(number).toString() + "\nThe difference is " + Temp1.substract(number).toString()
									+"\nThe product is "+ Temp1.multiply(number).toString() + "\nThe quotient is "+ Temp1.divide(number).toString();
		JOptionPane.showMessageDialog(null, secondMessage, "Temp", JOptionPane.INFORMATION_MESSAGE);
	}

}




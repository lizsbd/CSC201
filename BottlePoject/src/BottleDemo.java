
import javax.swing.JOptionPane;

public class BottleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bottle bottle1 = new Bottle();
		Bottle bottle2 = new Bottle();
		Bottle bottle3 = new Bottle();
		Bottle bottle4 = new Bottle();
		Bottle bottle5 = new Bottle();
		Bottle bottle6 = new Bottle();
		
		bottle1.read();
		
		String inputBottle2 = JOptionPane.showInputDialog(null, "Enter a number of Bottle 3", "Bottle", JOptionPane.INFORMATION_MESSAGE);
		int numberBottle2 = Integer.parseInt(inputBottle2);
		if((numberBottle2 >= 0)&&(numberBottle2<25))
		{
			bottle2.set(numberBottle2);;
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
		
		bottle3 = bottle1.add(bottle2);
		
		bottle4 = bottle1.substract(bottle2);
		
		bottle5 = bottle1.multiply(bottle2);
		
		bottle6 = bottle1.divide(bottle2);
		
		String equal = null;
		if (bottle1.equals(bottle2)){
			equal = "the same";
		}
		else {
			equal ="different";
		}
		
		JOptionPane.showMessageDialog(null, "The 2 bottle are " + equal, "Bottle", JOptionPane.INFORMATION_MESSAGE);
		
		String message = "The value of Bottle 1 is " + bottle1.get() + "\nThe value of Bottle 2 is " + bottle2.get() +"\nThe sum is " + bottle3.toString() + "\nThe different is " + bottle4.get() + "\nThe product is " + bottle5.toString() + "\nThe quotient is " + bottle6.toString();
		
		JOptionPane.showMessageDialog(null, message, "Bottle", JOptionPane.INFORMATION_MESSAGE);
		
		String input = JOptionPane.showInputDialog(null, "Enter a number", "Bottle", JOptionPane.INFORMATION_MESSAGE);
		int number = Integer.parseInt(input);
		String secondMessage = "The value of Bottle 1 is " + bottle1.get() + "\nThe input number is " + input +"\nThe sum is "+ bottle1.add(number).toString() + "\nThe difference is " + bottle1.substract(number).toString()
									+"\nThe product is "+ bottle1.multiply(number).get() + "\nThe quotient is "+ bottle1.divide(number).toString();
		JOptionPane.showMessageDialog(null, secondMessage, "Bottle", JOptionPane.INFORMATION_MESSAGE);
	}

}

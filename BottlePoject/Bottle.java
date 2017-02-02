import javax.swing.JOptionPane;

public class Bottle {
	private int bottle;
	private final int MIN = 0;
	private final int MAX = 25;
	
	public Bottle() {
		bottle = 5;
	}
	
	public Bottle(int number) {

		if((number >= MIN)&&(number<MAX))
		{
			bottle = number;
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
	
	
	public void read(String name)
	{
		String input = JOptionPane.showInputDialog(null, "Enter a number of " +name, "Bottle", JOptionPane.INFORMATION_MESSAGE);
		int number = Integer.parseInt(input);
		if((number >= MIN)&&(number<MAX))
		{
			this.bottle = number;
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
	
	public void set(int bottle)
	{
		if((bottle >= MIN)&&(bottle<MAX))
		{
			this.bottle = bottle;
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
	
	public void set(Bottle bottle)
	{
		if((bottle.get() >= MIN)&&(bottle.get()<MAX))
		{
			this.bottle = bottle.get();
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
	
	public int get()
	{
		return this.bottle;
	}
	public String toString()
	{
		return "" + this.bottle;
	}
	public Bottle add(Bottle anotherBottle)
	{
		if((anotherBottle.get() >= MIN)&&(anotherBottle.get()<MAX))
		{
			Bottle sumBottle = new Bottle();
			sumBottle.bottle = this.bottle + anotherBottle.bottle ; 
			if(sumBottle.get()<MAX)
			{
			return sumBottle;
			}
			else {
				throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
			}
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
		
	
	
	
	public Bottle add(int number)
	{
		if((number >= MIN)&&(number<MAX))
		{
			Bottle sumBottle = new Bottle((this.bottle + number));
			if(sumBottle.get()<MAX)
			{
			return sumBottle;
			}
			else {
				throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
			}
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
		
	
	public Bottle substract(Bottle anotherBottle)
	{
		if((anotherBottle.get() >= MIN)&&(anotherBottle.get()<MAX))
		{
			Bottle differentBottle = new Bottle();
			differentBottle.bottle = this.bottle - anotherBottle.bottle ; 
			if(differentBottle.get()<MAX)
			{
			return differentBottle;
			}
			else {
				throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
			}
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
		
	
	
	
	public Bottle substract(int number)
	{
		if((number >= MIN)&&(number<MAX))
		{
			Bottle differentBottle = new Bottle((this.bottle - number));
			if(differentBottle.get()<MAX)
			{
			return differentBottle;
			}
			else {
				throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
			}
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
	
	public Bottle multiply(Bottle anotherBottle)
	{
		if((anotherBottle.get() >= MIN)&&(anotherBottle.get()<MAX))
		{
			Bottle productBottle = new Bottle();
			productBottle.bottle = this.bottle*anotherBottle.bottle ; 
			if(productBottle.get()<=MAX)
			{
			return productBottle;
			}
			else {
				throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
			}
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
		
	
	
	
	public Bottle multiply(int number)
	{
		if((number >= MIN)&&(number<MAX))
		{
			Bottle productBottle = new Bottle((this.bottle*number));
			if(productBottle.get()<MAX)
			{
			return productBottle;
			}
			else{
				throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
			}
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
		
	public Bottle divide(Bottle anotherBottle)
	{
		if((anotherBottle.get() >= MIN)&&(anotherBottle.get()<MAX))
		{
			Bottle quotientBottle = new Bottle();
			quotientBottle.bottle = (int) (this.bottle/anotherBottle.bottle) ; 
			return quotientBottle;
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
		
	
	
	
	public Bottle divide(int number)
	{
		if((number >= MIN)&&(number<MAX))
		{
			Bottle quotientBottle = new Bottle((int)(this.bottle/number));
			return quotientBottle;
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
	}
		
	public boolean equals(Bottle anotherBottle)
	{
		boolean result=false;
		if((anotherBottle.get() >= MIN)&&(anotherBottle.get()<MAX))
		{
			if(this.bottle == anotherBottle.get())
			{
				result = true;
				
			}
			return result;
		}
		else{
			throw new IndexOutOfBoundsException("Invalid input\n Number of bottles must be between 0-25");
		}
		
	
		
	}
	
	}



import javax.swing.JOptionPane;

public class Execution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company company = new Company();
		company.setName("SBD SUPERWOMAN CO.");
		Employee employee = new Employee();
		String input = JOptionPane.showInputDialog(null, "Enter the number of employees in the company", "Tax Calculator", JOptionPane.QUESTION_MESSAGE);
		int numberOfEmployee = Integer.parseInt(input);
		for(int count = 0; count<numberOfEmployee; count++)
		{
			employee.readInput();
			employee.calculateData();
			employee.writeOutput();
			company.collectData(employee);
			
		}
		
		company.printCompanyReport();
	}

}

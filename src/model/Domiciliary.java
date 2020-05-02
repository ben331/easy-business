package model;

public class Domiciliary extends Employee implements Remunerable{

	public Domiciliary(String id, String name, String lastName, String celphoneNumber, String address, int hoursWorked) {
		super( id,  name,  lastName,  celphoneNumber,  address, hoursWorked);
	}

	@Override
	public void calculateSalary(double f, double v) {
		
	}
}

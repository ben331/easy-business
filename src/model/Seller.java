package model;

public class Seller extends Employee implements Remunerable{

	public Seller(String id, String name, String lastName, String celphoneNumber, String address, int hoursWorked) {
		super( id,  name,  lastName,  celphoneNumber,  address, hoursWorked);
	}

	@Override
	public void calculateSalary(double f, double v) {
		
	}
}

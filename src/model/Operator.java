package model;

public class Operator extends Employee implements Remunerable{

	public Operator(String id, String name, String lastName, String celphoneNumber, String address, int hoursWorked) {
		super( id,  name,  lastName,  celphoneNumber,  address, hoursWorked);
	}
}

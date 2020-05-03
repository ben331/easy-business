package model;

import javafx.scene.image.Image;

public class Operator extends Employee implements Remunerable{

	public Operator(String id, String name, String lastName, String celphoneNumber, String address, Image photo) {
		super( id,  name,  lastName,  celphoneNumber,  address, photo);
	}

	@Override
	public void calculateSalary(double f, double v) {
		
	}
}

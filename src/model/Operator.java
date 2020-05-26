package model;

import java.io.Serializable;

import javafx.scene.image.Image;

@SuppressWarnings("serial")
public class Operator extends Employee implements Remunerable, Serializable{

	public Operator(String id, String name, String lastName, String celphoneNumber, String address, Image photo) {
		super( id,  name,  lastName,  celphoneNumber,  address, photo);
	}

	@Override
	public void calculateSalary(double f, double v) {
		
	}
}

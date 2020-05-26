package model;

import java.io.Serializable;

import javafx.scene.image.Image;

@SuppressWarnings("serial")
public class Seller extends Employee implements Remunerable, Serializable{

	public Seller(String id, String name, String lastName, String celphoneNumber, String address, Image photo, Settings settings) {
		super( id,  name,  lastName,  celphoneNumber,  address, photo, settings);
	}

	@Override
	public double calculateSalary() {
		return getSettings().getFixedCostSeller() + getHoursWorked()*getSettings().getVarCostSeller();
	}
}

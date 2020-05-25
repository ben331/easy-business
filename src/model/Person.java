package model;

import javafx.scene.image.Image;

public abstract class Person implements Comparable<Person>{

	private String id;
	private String name;
	private String lastName;
	private String celphoneNumber;
	private String address;
	private Image photo;
	
	public Person(String id, String name, String lastName, String celphoneNumber, String address, Image photo) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.celphoneNumber = celphoneNumber;
		this.address = address;
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCelphoneNumber() {
		return celphoneNumber;
	}

	public String getAddress() {
		return address;
	}
	
	public Image getPhoto() {
		return photo;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCelphoneNumber(String celphoneNumber) {
		this.celphoneNumber = celphoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int compareTo(Person p) {
		int difference;
		if(this.lastName.equals(p.lastName)) {
			difference = this.name.compareTo(p.name);
		}else {
			difference = this.lastName.compareTo(p.lastName);
		}
		return difference;
	}
}

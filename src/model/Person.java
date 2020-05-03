package model;

public abstract class Person {

	private String id;
	private String name;
	private String lastName;
	private String celphoneNumber;
	private String address;
	
	public Person(String id, String name, String lastName, String celphoneNumber, String address) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.celphoneNumber = celphoneNumber;
		this.address = address;
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
	
	
}

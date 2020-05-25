package model;

import javafx.scene.image.Image;

public abstract class Employee extends Person  {
	//Domain constants of employee type
	public static final char SELLER = 'S';
	public static final char OPERATOR = 'O';
	public static final char DOMICILIARY = 'D';
	
	//Attributes
	private int hoursWorked;
	private Employee head;
	private Employee left;
	private Employee right;
	
	public Employee(String id, String name, String lastName, String celphoneNumber, String address, Image photo) {
		super( id,  name,  lastName,  celphoneNumber,  address, photo);
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public Employee getHead() {
		return head;
	}

	public Employee getLeft() {
		return left;
	}

	public Employee getRight() {
		return right;
	}

	public void setHead(Employee head) {
		this.head = head;
	}

	public void setLeft(Employee left) {
		this.left = left;
	}

	public void setRight(Employee right) {
		this.right = right;
	}
	
	public char getPosition() {
		char position;
		
		if(this instanceof Seller) {
			position=Employee.SELLER;
		}else if(this instanceof Operator) {
			position=Employee.OPERATOR;
		}else {
			position=Employee.DOMICILIARY;
		}
		return position;
	}
	
}

package model;

import java.io.Serializable;
import java.time.LocalTime;

import javafx.scene.image.Image;

@SuppressWarnings("serial")
public abstract class Employee extends Person implements Remunerable, Serializable {
	
	public static final String FILE_NAME_PREFIX="registersPayRoll/Payroll_OfDate_";
	public static final String EXTENSION = ".txt";
	
	//Domain constants of employee type
	public static final char SELLER = 'S';
	public static final char OPERATOR = 'O';
	public static final char DOMICILIARY = 'D';
	
	//Attributes
	private int hoursWorked;
	private Employee head;
	private Employee left;
	private Employee right;
	private LocalTime timeEntry;
	private Settings settings;
	
	public Employee(String id, String name, String lastName, String celphoneNumber, String address, Image photo, Settings settings) {
		super( id,  name,  lastName,  celphoneNumber,  address, photo);
		this.settings=settings;
	}

	public void setTimeEntry(LocalTime timeEntry) {
		this.timeEntry = timeEntry;
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
	
	public Employee getMin() {
		Employee min = this;
		while(min.getLeft()!=null) {
				min=min.getLeft();
		}
		return min;
	}

	public LocalTime getTimeEntry() {
		return timeEntry;
	}
	
	public String getTimeSEntry() {
		String m = timeEntry.toString().length()>5 ? (timeEntry+"").substring(0,5) : timeEntry.toString();
		return m ;
	}

	public Settings getSettings() {
		return settings;
	}
}

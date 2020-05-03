package model;

public abstract class Employee extends Person implements Comparable<Employee> {

	private int hoursWorked;
	private Employee head;
	private Employee left;
	private Employee right;
	
	public Employee(String id, String name, String lastName, String celphoneNumber, String address, int hoursWorked) {
		super( id,  name,  lastName,  celphoneNumber,  address);
		this.hoursWorked=hoursWorked;
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

	@Override
	public int compareTo(Employee o) {
		int diference=0;
		if(this.getLastName().equals(o.getLastName())) {
			diference=this.getName().compareTo(o.getName());
		}else {
			diference = this.getLastName().compareTo(o.getLastName());
		}
		return diference;
	}
	
	
	
}

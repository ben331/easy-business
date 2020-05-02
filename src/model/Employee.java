package model;

public class Employee extends Person implements Comparable<Employee> {

	private int hoursWorked;
	private Employee head;
	private Employee lefth;
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

	public Employee getLefth() {
		return lefth;
	}

	public Employee getRight() {
		return right;
	}

	public void setHead(Employee head) {
		this.head = head;
	}

	public void setLefth(Employee lefth) {
		this.lefth = lefth;
	}

	public void setRight(Employee right) {
		this.right = right;
	}

	@Override
	public int compareTo(Employee o) {
		
	}
	
	
	
}

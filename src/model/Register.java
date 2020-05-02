package model;

public class Register {

	public String detail;
	public double value;
	public boolean expensive;
	private Register head;
	private Register left;
	private Register rigth;
	
	public Register(String detail, double value, boolean expensive) {
		super();
		this.detail = detail;
		this.value = value;
		this.expensive = expensive;
	}

	public String getDetail() {
		return detail;
	}

	public double getValue() {
		return value;
	}

	public boolean isExpensive() {
		return expensive;
	}

	public Register getHead() {
		return head;
	}

	public Register getLeft() {
		return left;
	}

	public Register getRigth() {
		return rigth;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setExpensive(boolean expensive) {
		this.expensive = expensive;
	}

	public void setHead(Register head) {
		this.head = head;
	}

	public void setLeft(Register left) {
		this.left = left;
	}

	public void setRigth(Register rigth) {
		this.rigth = rigth;
	}
	
	
	
}

package model;

import java.time.LocalTime;

public class Register {

	public String detail;
	public double value;
	public boolean expensive;
	private Register head;
	private Register left;
	private Register rigth;
	private LocalTime time;
	
	public Register(String detail, double value, boolean expensive,LocalTime time) {
		super();
		this.detail = detail;
		this.value = value;
		this.expensive = expensive;
		this.time=time;
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

	public LocalTime getTime() {
		return time;
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

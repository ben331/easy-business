package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegisterTest {

	private Register register;
	
	void setup1() {
		register = new Register("holaa", 345, false, "13:45.30");
	}
	
	void setup2() {
		register = new Register("venta", 23, true, "12:32.00");
	}
	
	void setup3() {
		register = new Register("pago", 5, false, "11:34:34");
	}
	@Test
	void test() {
		
		setup3();
		assertEquals(register.getDetail(),"pago");
		assertEquals(register.getValue(),5);
		assertEquals(register.isExpensive(),false);
		assertEquals(register.getTime(),"11:34:34");

		
		setup2();
		
		assertEquals(register.getDetail(),"venta");
		assertEquals(register.getValue(),23);
		assertEquals(register.isExpensive(),true);
		assertEquals(register.getTime(),"12:32.00");

		
		setup1();
		
		assertEquals(register.getDetail(),"holaa");
		assertEquals(register.getValue(),345);
		assertEquals(register.isExpensive(),false);
		assertEquals(register.getTime(),"13:45.30");
	}

}

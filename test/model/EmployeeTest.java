package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	private Employee employee;
	
	void setup1() {
		
		Employee employee = new Employee("1234567890", "anderson", "cardenas", "318287020", "ander@gmail.com", 4);
	}
	
	void setup2() {
		employee = new Employee("1987654321", "benjamin", "", "311503784", "benji@gmail.com", 2);
	}
	
	void setup3() {
		employee = new Employee("1574839201", "juan", "reyes", "", "seyerman@gmail.com", 0);
	}
	@Test
	void test() {
		setup3();
		assertEquals(employee.getId(),1574839201);
		assertEquals(employee.getName(),"juan");
		assertEquals(employee.getLastName(),"reyes");
		assertEquals(employee.getCelphoneNumber(),"");
		assertEquals(employee.getAddress(),"seyerman@gmail.com");
		assertEquals(employee.getHoursWorked(),4);
		
		setup2();
		
		assertEquals(employee.getId(),1987654321);
		assertEquals(employee.getName(),"benjamin");
		assertEquals(employee.getLastName(),"");
		assertEquals(employee.getCelphoneNumber(),311503784);
		assertEquals(employee.getAddress(),"benji@gmail.com");
		assertEquals(employee.getHoursWorked(),2);
		
		setup1();
		
		assertEquals(employee.getId(),1234567890);
		assertEquals(employee.getName(),"anderson");
		assertEquals(employee.getLastName(),"caardenas");
		assertEquals(employee.getCelphoneNumber(),318287020);
		assertEquals(employee.getAddress(),"ander@gmail.com");
		assertEquals(employee.getHoursWorked(),0);
	}

}

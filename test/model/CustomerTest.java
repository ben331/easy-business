package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	private Customer costumer;
	
	
	void setup1() {
		costumer = new Customer("1234567890", "anderson", "cardenas", "318287020", "ander@gmail.com", 0);
		
		}
	
	void setup2() {
		costumer = new Customer("1987654321", "benjamin", "", "311503784", "benji@gmail.com", 32432);
	}

	void setup3() {
		costumer = new Customer("1574839201", "juan", "reyes", "", "seyerman@gmail.com", 0);
	}
	
	@Test
	void testCostumer() {
		
		setup3();
		assertEquals(costumer.getId(),1574839201);
		assertEquals(costumer.getName(),"juan");
		assertEquals(costumer.getLastName(),"reyes");
		assertEquals(costumer.getCelphoneNumber(),"");
		assertEquals(costumer.getAddress(),"seyerman@gmail.com");
		assertEquals(costumer.getDebtValue(),0);
		
		setup2();
		
		assertEquals(costumer.getId(),1987654321);
		assertEquals(costumer.getName(),"benjamin");
		assertEquals(costumer.getLastName(),"");
		assertEquals(costumer.getCelphoneNumber(),311503784);
		assertEquals(costumer.getAddress(),"benji@gmail.com");
		assertEquals(costumer.getDebtValue(),32432);
		
		setup1();
		
		assertEquals(costumer.getId(),1234567890);
		assertEquals(costumer.getName(),"anderson");
		assertEquals(costumer.getLastName(),"caardenas");
		assertEquals(costumer.getCelphoneNumber(),318287020);
		assertEquals(costumer.getAddress(),"ander@gmail.com");
		assertEquals(costumer.getDebtValue(),0);
	}
}

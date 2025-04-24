package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;


@TestMethodOrder(OrderAnnotation.class)
//the order in which test methods are executed in a test class.
class TotalDeposieClassTest {

	public static BankingApp bank;

	@BeforeAll
	//method should run before all test methods in a test class. 
	public static void setUp() {
		bank = new BankingApp();
		// Add accounts
		bank.addAccount("Alice", 1000);
		bank.addAccount("Bob", 500);
	}

	@Test
	//Order annotation is used to define the order  
	@Order(1)
	//this test will execute first to find the initial total deposite in the bank
	void testInitialTotal() {
		assertEquals(1500, bank.getTotalDeposits());
	}

	@Order(2)
	@Test
	void testDepositUpdateTotal() {
		//find the total deposite after an account's deposit
		bank.deposit("Alice", 200);
		assertEquals(1700, bank.getTotalDeposits());
	}

	@Order(3)
	@Test
	//find the total deposite after an account's withdraw
	void TestWithdrawUpdateTotal() {
		bank.withdraw("Bob", 300);
		assertEquals(1400, bank.getTotalDeposits());

	}

	@AfterAll
	//a method that should run after all tests in a test class.
	public static void tearDown() {
		bank = null;
	}
}

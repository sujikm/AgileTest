package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;

class DepositeClassTest {
	public static BankingApp bank;

	@BeforeAll
	//method will run once before all test methods in the class. 
	public static void setUp() {
		bank = new BankingApp();
		// Add accounts
		bank.addAccount("Alice", 1000);
		bank.addAccount("Bob", 500);
	}

	@AfterEach
	void tearDownAfterEach() {
		// Reset Alice,Bob balance to their initial values using a reset method after each test method
		bank.resetBalance("Alice", 1000); // Reset Alice's balance to 1000
		bank.resetBalance("Bob", 500); // Reset Bob's balance to 500
	}

	@ParameterizedTest
	//run the same test with different input values
	
	@ValueSource(doubles = { 100.0, 200.0 })
	//used to provide a set of values here doubles
	void testDepositParam(double deposit) {
		double initialBalanceAlice = bank.getBalance("Alice");//check the initial balance of Alice
		assertTrue(bank.deposit("Alice", deposit)); //deposit to Alice account a set of amounts
		double expectedBalanceAlice = initialBalanceAlice + deposit;
		assertEquals(expectedBalanceAlice, bank.getBalance("Alice"));

	}

	@Test
	void testDepositValid() {
		assertTrue(bank.deposit("Alice", 200));
		assertEquals(1200, bank.getBalance("Alice"));

	}

	@Test
	@Timeout(value = 2, unit = TimeUnit.MILLISECONDS)
	//used to specify that a test should fail if it takes longer than the specified time to execute.
	void testDepositUpdate() {
		bank.deposit("Alice", 500);
		assertEquals(1500, bank.getBalance("Alice"));

	}

	@Test
	//check for a negative amount
	void testDepositInValidAmount() {
		assertFalse(bank.deposit("Alice", -200));

	}

	@Test
	//check for an invalid name
	void testDepositInValidName() {
		assertFalse(bank.deposit("Ana", 200));

	}

	@AfterAll
	//used to define a method that should run after all tests.
	public static void tearDown() {
		bank = null;
	}

}

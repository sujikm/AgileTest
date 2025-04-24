package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WithdrawClassTest {

	public static BankingApp bank;

	@BeforeAll
	//method should run once before all test methods in a test class.
	public static void setUp() {
		bank = new BankingApp();
		// Add accounts
		bank.addAccount("Alice", 1000);
		bank.addAccount("Bob", 500);
	}

	@BeforeEach
	void setUpBeforeEach() {
		// Reset or check common state before each test
		System.out.println("Before Each Test - Current State: Bob Balance = " + bank.getBalance("Bob")
				+ ", Alice Balance = " + bank.getBalance("Alice"));
	}

	@Test
	void testWithdrawInvalidException() {
		assertThrows(IllegalArgumentException.class, () -> {
			boolean result = bank.withdraw("Alice", -100);
			if (!result) {
				throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
			}
		});
		assertThrows(IllegalArgumentException.class, () -> {
			boolean result = bank.withdraw("Alice", 0);
			if (!result) {
				throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
			}
		});
	}

	@Test
	void testWithdrawValid() {
		//check with valid name and amount
		assertTrue(bank.withdraw("Bob", 200));
		assertEquals(300, bank.getBalance("Bob"));

	}

	@Test
	void testWithdrawInSufficient() {
		//check with valid name but the aount is greater than the account balance
		assertFalse(bank.withdraw("Alice", 2000));
		assertEquals(1000, bank.getBalance("Alice"));

	}

	@Test
	//check for in valid account
	void testWithdrawNotExisted() {
		assertFalse(bank.withdraw("Job", 200));

	}

	@Test
	//check for valid naame but invalid amount
	void testWithdrawNotValidAmount() {
		assertFalse(bank.withdraw("Alice", -200));

	}

	@AfterAll
	////method that run after all tests in a test class have finished.
	public static void tearDown() {
		bank = null;
	}
}

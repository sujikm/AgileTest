package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class LoanClassTest {
	public static BankingApp bank;

	@BeforeAll
	//method should be run once before all test methods in a test class.
	public static void setUp() {
		bank = new BankingApp();
		bank.addAccount("Alice", 2000);
		bank.addAccount("Bob", 1000);
	}

	@Test
	void testApproveLoan() {
		assertTrue(bank.approveLoan("Alice", 400));
		assertEquals(400, bank.getLoan("Alice"));
	}

	@Test
	void testLoanApprovalNullPointerException() {
		//will thraw a null pointer exception for an invalid user
		assertThrows(NullPointerException.class, () -> {
			bank.approveLoan("John", 1000);
			throw new NullPointerException("Not exixting user.");
		});
	}
	
	@Test
	@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)

	void testRepayLoan() {
		bank.approveLoan("Bob", 500);
		assertTrue(bank.repayLoan("Bob", 300));
		assertEquals(200, bank.getLoan("Bob"));
	}

	@AfterAll
	public static void tearDown() {
		bank = null;
	}
}

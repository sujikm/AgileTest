package ie.atu.dip;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite
//run multiple test classes together
@SelectClasses({
	DepositeClassTest.class,
	WithdrawClassTest.class,
	LoanClassTest.class,
	TotalDeposieClassTest.class
})
class RunnerTest {

}

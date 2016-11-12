package testUnitaires;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	DaoGroupTest.class,
	DaoPersonTest.class,
	//DaoTest.class,
	GroupTest.class,
	JdbcToolsTest.class,
	PersonTest.class

})


public class ExecuteTests {

	//	public static Test suite() {
	//		TestSuite suite = new TestSuite("Tous les tests");
	//		suite.addTestSuite(DaoGroupTest.class);
	//		suite.addTestSuite(DaoPersonTest.class);
	//		suite.addTest(new TestSuite(PersonTest.class));
	//
	//		return suite;
	//	}
	//
	//	public static void main(String args[]) {
	//		junit.textui.TestRunner.run(suite());
	//	}
}

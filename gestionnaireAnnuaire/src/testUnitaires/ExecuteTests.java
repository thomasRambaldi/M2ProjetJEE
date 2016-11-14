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

}

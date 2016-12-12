package fr.test.unitaires.gestionnaire;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.test.unitaires.utils.CheckerBirthDayTest;
import fr.test.unitaires.utils.CheckerGroupNameTest;
import fr.test.unitaires.utils.CheckerMailTest;
import fr.test.unitaires.utils.CheckerWebTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	DaoGroupTest.class,
	DaoPersonTest.class,
	//DaoTest.class,
	GroupTest.class,
	JdbcToolsTest.class,
	PersonTest.class
//	CheckerBirthDayTest.class,
//	CheckerGroupNameTest.class,
//	CheckerMailTest.class,
//	CheckerWebTest.class,
//	CheckerTest.class

})


public class ExecuteTests {

}

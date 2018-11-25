package classes;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test prak3");
		suite.addTestSuite(BenutzerTest.class);
		suite.addTestSuite(BenutzerVerwaltungAdminTest.class);
		
		return suite;
	}


	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTests.suite());
	}

}

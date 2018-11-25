/**
 * 
 */
package classes;

import junit.framework.TestCase;

/**
 * @author Eugen
 *
 */
public class BenutzerTest extends TestCase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBenutzer() {
		Benutzer b1 = new Benutzer("userID", "abc");
		assertEquals("userID", b1.getUserID());
		assertEquals("abc", String.valueOf(b1.getPassWort()));
	}

	public void testEqualsBenutzer() { 
		Benutzer b1 = new Benutzer("userID", "abc"); 
		Benutzer b2 = new Benutzer("userID", "abc");
		assertEquals(b1, b2);
		assertNotSame(b1, b2);
		b1 = b2;
		assertSame(b1, b2);
		Benutzer b3 = new Benutzer("user", "password");
		assertFalse(b1.equals(b3));
	}

	public void testToStringBenutzer() { 
		char[] pass = { 'a', 'b', 'c'};
		Benutzer b = new Benutzer("User", pass);
		assertEquals(b.toString(), "Benutzer: User | passWort: abc");
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(BenutzerTest.class);
	}

}

package classes;

import junit.framework.TestCase;

/**
 * @author Eugen
 *
 */
public class BenutzerVerwaltungAdminTest extends TestCase {

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

	/*
	 * Test der Datenspeicherung
	 */
	public void testdatenhaltung() {

		//Standard Initialisierte Datenhaltung ist leer
		char[] pass = { 'a', 'b', 'c' };
		Benutzer b = new Benutzer("B", pass);

		BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();

		//Anfang Tests
		assertEquals(admin.benutzerOK(b), false);
		
		try {
			admin.benutzerEintragen(b);
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			fail();
		}

		admin.datenhaltungLeeren();
		admin.dbInitialisieren();

		assertEquals(admin.benutzerOK(b), false);

		try {
			admin.benutzerEintragen(b);
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
		}

		assertEquals(admin.benutzerOK(b), true);

		//Testen ob ein 2ter admin Datenhaltung vom ersten beeinflusst
		//Benutzer b ist in Datenhaltung bei admin vorhanden -> TEST
		BenutzerVerwaltungAdmin adminTest = new BenutzerVerwaltungAdmin();
		adminTest.datenhaltungLeeren();
		assertEquals(adminTest.benutzerOK(b), true);
		//-> Alles korrekt, es gibt nur eine Datenhaltung
		
		try {
			admin.benutzerEintragen(b);
			fail();
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
		}

		assertEquals(admin.benutzerOK(b), true);
	}

	/*
	 * Test fuer das Eintragen von Benutzern in verschiedenen Fällen
	 */
	public void testbenutzerEintragen() {
		BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
		admin.dbInitialisieren();

		char[] pass1 = { 'a', 'b', 'c' };
		Benutzer b1 = new Benutzer("B1", pass1);

		Benutzer b2 = new Benutzer("B2", "abc");

		char[] pass3 = { 'a', 'b', 'c' };
		Benutzer b3 = new Benutzer("B3", pass3);

		Benutzer b4 = new Benutzer();

		try {
			admin.benutzerEintragen(b1);
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			fail();
		}
		try {
			admin.benutzerEintragen(b1);
			fail();
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
		}

		try {
			admin.benutzerEintragen(b2);
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			fail();
		}

		try {
			admin.benutzerEintragen(b3);
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			fail();
		}

		try {
			admin.benutzerEintragen(b4);
			fail();
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
		}
	}

	/*
	 * Test fuer das Loeschen von Benutzern
	 */
	public void testbenutzerLoeschen() {
		BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
		admin.dbInitialisieren();

		char[] pass1 = { 'a', 'b', 'c' };
		Benutzer b1 = new Benutzer("B1", pass1);
		char[] pass2 = { 'a', 'b', 'c' };
		Benutzer b2 = new Benutzer("B2", pass2);

	//Löschen von nicht hinzugefügtem B1
		try {
			admin.benutzerLoeschen(b1);
			fail();
		} catch (UserNotFoundException e) {
		}

		try {
			admin.benutzerEintragen(b1);
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			fail();
		}

		//Löschen von nicht hinzugefügtem B2
		try {
			admin.benutzerLoeschen(b2);
			fail();
		} catch (UserNotFoundException e) {
		}

		try {
			admin.benutzerLoeschen(b1);
		} catch (UserNotFoundException e) {
			fail();
		}
		
		//2tes Löschen B1
		try {
			admin.benutzerLoeschen(b1);
			fail();
		} catch (UserNotFoundException e) {
		}
	}

	/*
	 * Test ob der Benutzer vorhanden ist
	 */
	public void testbenutzerOK() {
		BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
		admin.dbInitialisieren();

		char[] pass1 = { 'a', 'b', 'c' };
		Benutzer b1 = new Benutzer("B1", pass1);
		char[] pass2 = { 'a', 'b', 'c' };
		Benutzer b2 = new Benutzer("B2", pass2);

		//B1 ist noch nicht hinzugefügt
		assertEquals(admin.benutzerOK(b1), false);

		try {
			admin.benutzerEintragen(b1);
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
		}

		assertEquals(admin.benutzerOK(b1), true);

		assertEquals(admin.benutzerOK(b2), false);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(BenutzerVerwaltungAdminTest.class);
	}

}

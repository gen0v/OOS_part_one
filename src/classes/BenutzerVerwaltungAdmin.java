/**
 * 
 */
package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author Eugen
 *
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Benutzer> datenhaltung = new ArrayList<>();

	public void dbInitialisieren() {
		datenhaltung = new ArrayList<>();
		datenhaltungSpeichern();
	}

	private void datenhaltungSpeichern() {
		try {
			ObjectOutputStream output = new ObjectOutputStream(
					new FileOutputStream("datenhaltung"));
			output.writeObject(datenhaltung);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void datenhaltungLesen() {
		if (new File("datenhaltung").exists()) {
			try {
				ObjectInputStream input = new ObjectInputStream(
						new FileInputStream("datenhaltung"));
				datenhaltung = ((ArrayList<Benutzer>) input.readObject());
				input.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			dbInitialisieren();
		}
	}

	@Override
	public void benutzerEintragen(Benutzer benutzer)
			throws UserAlreadyExistsException, UserIsEmptyException {

		datenhaltungLesen();
		
		if (benutzer.isEmpty()) {
			throw new UserIsEmptyException("[User is empty!]");
		} else {
			// benutzer not empty
			if (benutzerOK(benutzer)) {
				throw new UserAlreadyExistsException("[User already exists!]");
			} else {
				datenhaltung.add(benutzer);
			}
		}

		datenhaltungSpeichern();
		
	}

	@Override
	public boolean benutzerOK(Benutzer benutzer) {
		
		datenhaltungLesen();
		
		return (datenhaltung.contains(benutzer));

	}

	public void test() {
		try {
			benutzerLoeschen(null);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void benutzerLoeschen(Benutzer benutzer) throws UserNotFoundException {
		
		datenhaltungLesen();
		
		if (benutzerOK(benutzer)) {
			datenhaltung.remove(benutzer);
		} else {
			throw new UserNotFoundException("[User doesnt exist!]");
		}
		
		datenhaltungSpeichern();
		
	}

	public void datenhaltungLeeren() {
		datenhaltung.clear();
	}
	
}

/**
 * 
 */
package classes;

import java.util.ArrayList;

/**
 * @author Eugen
 *
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

	private ArrayList<Benutzer> datenhaltung = new ArrayList<>();

	@Override
	public void benutzerEintragen(Benutzer benutzer)
			throws UserAlreadyExistsException, UserIsEmptyException {
		
		if(benutzer.isEmpty()) {
			throw new UserIsEmptyException("[User is empty!]");
		} else {
			//benutzer not empty
			if(benutzerOK(benutzer)) {
				throw new UserAlreadyExistsException("[User already exists!]");
			}else {
				datenhaltung.add(benutzer);
			}
		}
		
	}

	@Override
	public boolean benutzerOK(Benutzer benutzer) {
		return (datenhaltung.contains(benutzer) );

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
		if(benutzerOK(benutzer)) {
			datenhaltung.remove(benutzer);
		} else {
			throw new UserNotFoundException("[User doesnt exist!]");
		}
	}
	
}

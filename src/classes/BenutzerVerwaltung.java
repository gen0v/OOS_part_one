package classes;

import java.io.Serializable;

public interface BenutzerVerwaltung extends Serializable{

	/*
	 * Function for saving user in database
	 * Exceptions if : 
	 * 		1) benutzer is empty
	 * 		2) benutzer already exists
	 */
	
	/**
	 * 
	 * @param adds benutzer 
	 * @throws UserAlreadyExistsException
	 * @throws UserIsEmptyException
	 */
	public void benutzerEintragen(Benutzer benutzer) throws UserAlreadyExistsException, UserIsEmptyException;

	/**
	 * 
	 * @param controls if there is a benutzer
	 * @return
	 */
	public boolean benutzerOK(Benutzer benutzer);

}

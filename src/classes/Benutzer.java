/**
 * 
 */
package classes;

import java.io.Serializable;

/**
 * @author Eugen 
 * This class is for creating the Users.
 *
 */
public class Benutzer implements Serializable{

	private String userID;

	private char passWort[];

	public Benutzer() {
		setUserID(null);
		setPassWort(null);
	}

	public Benutzer(String id, char[] pass) {
		this.setUserID(id);
		this.setPassWort(pass);
	}

	public Benutzer(String id, String pass) {
		this.setUserID(id);
		char[] passC = pass.toCharArray();
		this.setPassWort(passC);
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public char[] getPassWort() {
		return passWort;
	}

	public void setPassWort(char passWort[]) {
		this.passWort = passWort;
	}


	public boolean equals(Object o) {
		if (o instanceof Benutzer && o != null) {
			if (((Benutzer) o).userID.equals(this.userID) && 
					String.copyValueOf(((Benutzer) o).passWort).equals(String.copyValueOf(this.passWort))){
				
				return true;
				
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Benutzer: " + userID + " | passWort: "
				+ String.copyValueOf(passWort);
	}

	public boolean isEmpty() {
		if(userID == null && passWort == null) {
			return true;
		} else {
			return false;
		}
	}
	
}

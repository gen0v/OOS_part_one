package classes;

public class Main {

	public static void main(String[] args){
		// TESTS
		char password[] = {'a','b','c'};
		
		BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
		
		
		
		Benutzer b1 = new Benutzer("B1",password);
		Benutzer b2 = new Benutzer("B2",password);

		Benutzer empty = new Benutzer();
		
		System.out.println("Beginning tests...");
		
		System.out.println(b1.toString());
		System.out.println(b2.toString());

		System.out.println(">Adding B1");
		try {
			admin.benutzerEintragen(b1);
			if(admin.benutzerOK(b1)) {
				System.out.println("B1 added!");				
			}else {
				System.out.println("B1 not added!");
			}
			if(!admin.benutzerOK(b2)) {
				System.out.println("B2 not added!");				
			}
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			System.out.println(e.getMessage());;
		}
		
		System.out.println(">Adding B1");
		try {
			admin.benutzerEintragen(b1);
			if(admin.benutzerOK(b1)) {
				System.out.println("B1 added!");				
			}else {
				System.out.println("B1 not added!");
			}
			if(!admin.benutzerOK(b2)) {
				System.out.println("B2 not added!");				
			}
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(">Adding B2");
		try {
			admin.benutzerEintragen(b2);
			System.out.println("B2 added!");
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(">Adding Empty User");
		try {
			admin.benutzerEintragen(empty);
			System.out.println("Empty added!");
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(">Adding B1");
		try {
			admin.benutzerEintragen(b1);
			System.out.println("B1 added!");
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(">Removing B1");
		try {
			admin.benutzerLoeschen(b1);
			System.out.println("B1 deleted!");
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println(">Removing B1");
		try {
			admin.benutzerLoeschen(b1);
			System.out.println("B1 deleted!");
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//mit benutzerok nochmal testen ob gelöscht ist
		
		System.out.println(">Adding B1");
		try {
			admin.benutzerEintragen(b1);
			System.out.println("B1 added!");
		} catch (UserAlreadyExistsException | UserIsEmptyException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Are B1 and B2 equal?");
		System.out.println(b1.equals(b2));
		
		System.out.println("Are B1 and B1 equal?");
		System.out.println(b1.equals(b1));
	}

}

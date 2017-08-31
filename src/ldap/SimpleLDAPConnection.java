package ldap;

import model.User;

public class SimpleLDAPConnection {

	public static void main(String[] args) {
		
		if(Abfragen.authenticateUser("raschkla", ""))
		{
			User u = Abfragen.erstelleUser("raschkla");
			System.out.println(u.getVorname() + " " + u.getNachname());
		}
		
		System.out.println("---");
		
		if(Abfragen.authenticateUser("withakan", ""))
		{
			User u = Abfragen.erstelleUser("withakan");
			System.out.println(u.getVorname() + " " + u.getNachname());
		}
		
		System.out.println("---");
		
		if(Abfragen.authenticateUser("wohlraal", ""))
		{
			User u = Abfragen.erstelleUser("wohlraal");
			System.out.println(u.getVorname() + " " + u.getNachname());
		}
		
		System.out.println("---");
	}

}

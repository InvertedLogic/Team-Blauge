package ldap;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchResult;

import model.User;

public class SimpleLDAPConnection {

	public static void main(String[] args) {
		
//		if(Abfragen.authenticateUser("raschkla", ""))
//		{
//			User u = Abfragen.erstelleUser("raschkla");
//			System.out.println(u.getVorname() + " " + u.getNachname());
//		}
//		
//		System.out.println("---");
//		
//		if(Abfragen.authenticateUser("withakan", ""))
//		{
//			User u = Abfragen.erstelleUser("withakan");
//			System.out.println(u.getVorname() + " " + u.getNachname());
//		}
//		
//		System.out.println("---");
//		
//		if(Abfragen.authenticateUser("wohlraal", ""))
//		{
//			User u = Abfragen.erstelleUser("wohlraal");
//			System.out.println(u.getVorname() + " " + u.getNachname());
//		}
//		
//		System.out.println("---");
		
		LdapConnectionClient con = new LdapConnectionClient();
 		NamingEnumeration<SearchResult> results = con.compare("uid=withakan, ou=accounts", "(sn={0})", "Withake");
 		try {
			if(results.hasMore())
			{
				SearchResult sr = (SearchResult) results.next();
				
				System.out.println("---" + sr.getAttributes());
			}
			else
			{
				System.out.println("Empty");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}

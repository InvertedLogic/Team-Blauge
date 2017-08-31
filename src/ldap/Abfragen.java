package ldap;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchResult;

import model.User;

public class Abfragen {
	
	public static boolean authenticateUser(String username, String passwort)
	{
		boolean authenticate = false;
		
		LdapConnectionClient con = new LdapConnectionClient();
		String[] returningAttributes = new String[] {"userPassword"};
 		NamingEnumeration<SearchResult> results = con.search("ou=accounts", "uid=" + username, returningAttributes);
		
		try {
			if(results.hasMore())
			{
				SearchResult sr = (SearchResult) results.next();
				
				String pw = "";
				if(sr.getAttributes().get("userPassword") != null)
				{
					pw = sr.getAttributes().get("userPassword").toString();
				}
				
				if(pw.equals(passwort))
				{
					authenticate = true;
				}
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return authenticate;
	}
	
	public static User erstelleUser(String username) {
		
		User user = null;
		
		LdapConnectionClient con = new LdapConnectionClient();
		String[] returningAttributes = new String[] {"givenName", "sn"};
 		NamingEnumeration<SearchResult> results = con.search("ou=accounts", "uid=" + username, returningAttributes);
		
		try {
			if(results.hasMore())
			{
				SearchResult sr = (SearchResult) results.next();
				
				String vorname = sr.getAttributes().get("givenName").get().toString();
				String nachname = sr.getAttributes().get("sn").get().toString();
				
				user = new User(username, false, nachname, vorname);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}

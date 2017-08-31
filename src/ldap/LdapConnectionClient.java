package ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;

public class LdapConnectionClient {
	
	private String host;
	private String rootDirectory;
	
	/**
	 * Constructor for the LDAP Connection to the HEMS-LDAP-Server.
	 */
	public LdapConnectionClient()
	{
		this.host = "ldap://10.16.1.1:636";
		this.rootDirectory = "dc=linuxmuster-net,dc=lokal";
	}
	
	/**
	 * Constructor.
	 * Creates a new connection to the LDAP-Server with SSL-SecurityProtocol and an anonymous authentication.
	 * 
	 * @param host The host name of the LDAP-Server.
	 * @param rootDirectory The root directory of the LDAP-Server.
	 */
	public LdapConnectionClient(String host, String rootDirectory)
	{
		this.host = host;
		this.rootDirectory = rootDirectory;
	}

	/**
	 * Sets up a context for the connection.
	 * The attributes for authentication and security protocol are set as "none" and "ssl".
	 * 
	 * @return The LdapContext for the Connection
	 * 
	 * @throws NamingException If the initialization of the LdapConteyt fails.
	 */
	private InitialLdapContext setUpLdapContext() throws NamingException {

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "none");
		env.put(Context.SECURITY_PROTOCOL, "ssl");
		env.put("java.naming.ldap.factory.socket", "ldap.ldapHelp.CustomSSLSocketFactory");
		env.put(Context.PROVIDER_URL, this.host + "/" + this.rootDirectory);
		InitialLdapContext ctx = new InitialLdapContext(env, null);
		return ctx;
	}
	
	/**
	 * Search function.
	 * 
	 * @param base
	 * @param filter
	 * @param returningAttributes
	 * 
	 * @return
	 */
	public NamingEnumeration<SearchResult> search(String base, String filter, String[] returningAttributes) {
		
		InitialLdapContext ctx = null;
		try {
			ctx = setUpLdapContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		SearchControls ctls = new SearchControls();
		ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		ctls.setReturningAttributes(returningAttributes);

		NamingEnumeration<SearchResult> results = null;
		try {
			results = ctx.search(base, filter, ctls);
			ctx.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (NullPointerException x) {
			x.printStackTrace();
		}
		
		return results;
	}
	
}

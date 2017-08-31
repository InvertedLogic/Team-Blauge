package ldap.ldapHelp;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

public class FakeTrustmanager implements X509TrustManager {
	
	public void checkClientTrusted(X509Certificate[] cert, String string) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] cert, String string) throws CertificateException {
	}

	public X509Certificate[] getAcceptedIssuers() {
		return new java.security.cert.X509Certificate[0];
	}

}

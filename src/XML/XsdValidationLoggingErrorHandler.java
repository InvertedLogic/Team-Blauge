package XML;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XsdValidationLoggingErrorHandler implements ErrorHandler {
	public void warning(SAXParseException ex) throws SAXException {
		System.out.println("Warnung: " + ex.getMessage());
	}

	public void error(SAXParseException ex) throws SAXException {
		System.out.println("Fehler: " + ex.getMessage());
	}

	public void fatalError(SAXParseException ex) throws SAXException {
		System.out.println("Fataler Fehler: " + ex.getMessage());
	}
}

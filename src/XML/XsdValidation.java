package XML;
import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.*;

public class XsdValidation {
	public static void validate(String xmlDocumentWithoutFileEnding) throws SAXException, IOException, FileNotFoundException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = schemaFactory.newSchema(new File("src/XML/schemas/" + xmlDocumentWithoutFileEnding + "_schema.xsd"));
			Validator validator = schema.newValidator();
			validator.setErrorHandler(new XsdValidationLoggingErrorHandler());
			validator.validate(new StreamSource(new File("src/XML/files/" + xmlDocumentWithoutFileEnding + ".xml")));
		} catch (Exception e) {
			System.out.println("Fehler: " + e.getMessage());
		}
	}
}
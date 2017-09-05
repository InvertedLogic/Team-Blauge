package XML;
import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.*;

public class XsdValidation {

	public static void main(String[] args) throws Exception {
		Projectlist test = new Projectlist();
		test.setCount(3);
		System.out.println(test.getCount());
		System.out.println();
		XsdValidation.validate("projectlist");
		XsdValidation.validate("project");
	}

	public static void validate(String xmlDokumentWithoutFileEnding) throws SAXException, IOException, FileNotFoundException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = schemaFactory.newSchema(new File("src/XML/schemas/" + xmlDokumentWithoutFileEnding + "_schema.xsd"));
			Validator validator = schema.newValidator();
			validator.setErrorHandler(new XsdValidationLoggingErrorHandler());
			validator.validate(new StreamSource(new File("src/XML/files/" + xmlDokumentWithoutFileEnding + ".xml")));
		} catch (Exception e) {
			System.out.println("Fehler: " + e.getMessage());
		}
	}
}

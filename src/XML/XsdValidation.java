package XML;
import classes.Projects.Project;
import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.*;

import classes.ProjectType;

public class XsdValidation {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("Bitte XSD-Schema und XML-Dokument angeben.");
			return;
		}
		Project test = new Project();
		System.out.println(test.getUser());
		System.out.println(args[0] + " + " + args[1]);
		XsdValidation.validate("projectlist_schema.xsd", "projectlist.xml");
	}

	public static void validate(String xsdSchema, String xmlDokument) throws SAXException, IOException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File(xsdSchema));
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new XsdValidationLoggingErrorHandler());
		validator.validate(new StreamSource(new File(xmlDokument)));
	}
}

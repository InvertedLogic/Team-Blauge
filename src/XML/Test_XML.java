package XML;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class Test_XML {
	
	 public interface ElementeVerarbeitung
	   {
	      void verarbeite( Object element );
	   }

	
	
	 public static long parseXmlElemente( String xsdDatei, String xmlDatei, String encoding, String packageName, ElementeVerarbeitung elemVerarb ) throws Exception
	   {
	      if( xsdDatei != null && xsdDatei.trim().length() > 0 ) {
	         try( Reader xml = new InputStreamReader( new FileInputStream( xmlDatei ), encoding ) ) {
	            validate( xsdDatei, xml );
	         }
	      }
	      try( Reader xml = new InputStreamReader( new FileInputStream( xmlDatei ), encoding ) ) {
	         return parseXmlElemente( xml, packageName, elemVerarb );
	      }
	   }
	  public static void validate( String xsdSchema, Reader xml ) throws SAXException, IOException
	   {
	      // Der Ausdruck "javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI" kann Probleme machen, deshalb: 
	      final String  w3cXmlSchemaNsUri = "http://www.w3.org/2001/XMLSchema";
	      SchemaFactory schemaFactory = SchemaFactory.newInstance( w3cXmlSchemaNsUri );
	      Schema        schema = schemaFactory.newSchema( new File( xsdSchema ) );
	      Validator     validator = schema.newValidator();
	      validator.validate( new StreamSource( xml ) );
	   }
	  
	  public static long parseXmlElemente( Reader xml, String packageName, ElementeVerarbeitung elemVerarb ) throws XMLStreamException, JAXBException
	   {
	      // StAX:
	      EventFilter startElementFilter = new EventFilter() {
	         @Override public boolean accept( XMLEvent event ) {
	            return event.isStartElement();
	         }
	      };
	      long            anzahlElem   = 0;
	      XMLInputFactory staxFactory  = XMLInputFactory.newInstance();
	      XMLEventReader  staxReader   = staxFactory.createXMLEventReader( xml );
	      XMLEventReader  staxFiltRd   = staxFactory.createFilteredReader( staxReader, startElementFilter );
	      // Ueberspringe StartElement:
	      staxFiltRd.nextEvent();
	      // JAXB:
	      JAXBContext     jaxbContext  = JAXBContext.newInstance( packageName );
	      Unmarshaller    unmarshaller = jaxbContext.createUnmarshaller();
	      // Parsing:
	      while( staxFiltRd.peek() != null ) {
	         Object element = unmarshaller.unmarshal( staxReader );
	         elemVerarb.verarbeite( element );
	         anzahlElem++;
	      }
	      return anzahlElem;
	   }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

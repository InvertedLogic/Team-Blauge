package XML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import org.junit.*;

import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import junit.framework.Assert;
import model.Datum;

@SuppressWarnings("deprecation")
public class Xml_Server {
	
	private static final String TEST_XSD_DATEI = "projectliste_schema.xsd";
	   private static final String TEST_XML_DATEI = "project.xml";
	   private static final String ENCODING       = "UTF-8";
	   private static final String PACKAGE        = "blauge.xml";
	   
	   static class ElementeSpeicherungInListe implements Test_XML.ElementeVerarbeitung
	   {
	       List elemente = (List) new ArrayList<Object>();

	      @Override
	      public void verarbeite( Object element )
	      {
	         ((ArrayList<Object>) this.elemente).add( element );
	      }
	   }

	
	public String[] clientAskServerTimeStamp(Datum stamp, String Name ) throws UnsupportedEncodingException, FileNotFoundException, IOException, SAXException
	{
		try( Reader xml = new InputStreamReader( new FileInputStream( TEST_XML_DATEI  ), ENCODING ) ) 
			{
            Test_XML.validate( TEST_XSD_DATEI , xml );
            
            Assert.assertEquals("lastmod", getlastmode)
			}
		
		
		return null;
		
	}

}

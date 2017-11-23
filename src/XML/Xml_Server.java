package XML;

import java.io.FileInputStream;
import org.junit.Assert; 
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
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

import com.sun.xml.internal.ws.util.Pool.Unmarshaller;

import XML.Projectlist.Project;
import XML.Projectlist.Project.Userlist;
import XML.Projectlist.Project.Userlist.User;
import model.Datum;

@SuppressWarnings("deprecation")
public class Xml_Server {
	

	   
	static class ElementeSpeicherungInListe implements Test_XML.ElementeVerarbeitung
	   {
	       List elemente = (List) new ArrayList<Object>();

	      @Override
	      public void verarbeite( Object element )
	      {
	         ((ArrayList<Object>) this.elemente).add( element );
	      }
	   }

	public static void addtoprojectList(Project pr)
	{

		    try {
		        JAXBContext jc = JAXBContext.newInstance(Project.class);
		        javax.xml.bind.Marshaller marshaller = jc.createMarshaller();
		        marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT,
		                Boolean.TRUE);
		        File XMLfile = new File("server_projectlist.xml");
		        marshaller.marshal(pr, XMLfile);
		    } catch (JAXBException e) {
		        e.printStackTrace();
		    }
		
	}
	
	public static Project searchinXML(String name) throws JAXBException, XMLStreamException
	{
		XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("server_projectlist.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);

        
        while(xsr.hasNext()) {
            if(xsr.isStartElement() && name.equals(xsr.getLocalName()))
            {
                break;
            }
            xsr.next();
         }

        // Unmarshal from the XMLStreamReader that has been advanced
        JAXBContext jc = JAXBContext.newInstance(Projectlist.class);
        javax.xml.bind.Unmarshaller unmarshaller = jc.createUnmarshaller();
        Projectlist data = unmarshaller.unmarshal(xsr, Projectlist.class).getValue();
        Project pro = new Project();
        Iterator<Project> iterator = data.getProject().iterator();
        while (iterator.hasNext()) {
		    if (name.equals(iterator.next().getName())) {
		         pro =  iterator.next();
		    }
		}
        
		
		return pro;
		
	}
	
	private static Projectlist unmarshalFromFile(String fileName) throws JAXBException {
	    JAXBContext jaxbContext = JAXBContext.newInstance(Projectlist.class);
	    javax.xml.bind.Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    return (Projectlist) jaxbUnmarshaller.unmarshal(new File(fileName));
	}
	
	private static void marshalToFile(Projectlist data, String fileName) throws JAXBException
	{
	    JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    jaxbMarshaller.marshal(data, new File(fileName));
	}
	
	private static void deleteEntry(String deleteword) throws JAXBException
	{
		Projectlist data = unmarshalFromFile("server_projectlist.xml");
		
		Iterator<Project> iterator = data.getProject().iterator();
		while (iterator.hasNext()) {
		    if (deleteword.equals(iterator.next().getName())) {
		         iterator.remove();
		    }
		}
		
		marshalToFile(data, "server_projectlist.xml");
		
	}
		
	public static void changeEntryinXML(XMLGregorianCalendar time, String name) throws JAXBException, XMLStreamException
	{
		Project pro = searchinXML(name);
		
		pro.setLastmod(time);
		String delete = pro.getName();
		
		Projectlist data = unmarshalFromFile("server_projectlist.xml");
		
		Iterator<Project> iterator = data.getProject().iterator();
		while (iterator.hasNext()) {
		    if (delete.equals(iterator.next().getName())) {
		         iterator.remove();
		    }
		}
		data.getProject().add(pro);
		
		marshalToFile(data, "server_projectlist.xml");
		
	}


	
	
	public static void main(String[] args) throws Exception 
	{
		User us = new User();
		us.setIsAdmin(false);
		us.setValue("Peter");
		
		
	    Project pr = new Project();
	    pr.setProjectname("kanban1");
	    
	    pr.setDescription("kauabanaga");
	    pr.setLastmod(null);
	    Userlist userlist = new Userlist();
	    
	    userlist = pr.getUserlist();
	    userlist.getUser().add(us);
	    //dfjjfiojgio
	    
	    

		addtoprojectList(pr);
		
	//	Project pro = searchinXML("projectname", "projectname" );
		
	//.out.println(pro.getName());
		
	}
	 
	
	

}

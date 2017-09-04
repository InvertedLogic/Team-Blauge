package XML;

import java.io.FileInputStream;
import org.junit.Assert; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import org.junit.*;

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

import XML.Projectlist.ProjectOverview;
import XML.Projectlist.ProjectOverview.Userlist;
import XML.Projectlist.ProjectOverview.Userlist.User;
import XML.Projectlist.ProjectOverview;
import model.Datum;

@SuppressWarnings("deprecation")
public class Xml_Server {
	
	
	   
	   static class ElementeSpeicherungInListe implements Test_XML.ElementeVerarbeitung
	   {
	       List elemente = (List) new ArrayList<Object>();

	      @SuppressWarnings("unchecked")
		@Override
	      public void verarbeite( Object element )
	      {
	         ((ArrayList<Object>) this.elemente).add( element );
	      }
	   }

	public static void addtoprojectList(ProjectOverview pr)
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
	
	public static ProjectOverview searchinXML(String name) throws JAXBException, XMLStreamException
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
        ProjectOverview pro = new ProjectOverview("Testprojekt", "Das ist ein Testprojekt", "blabliblubkey");
        Iterator<ProjectOverview> iterator = data.getProjectOverview().iterator();
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
	
	private static Project unmarshalFromFileProject(String fileName) throws JAXBException {
	    JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
	    javax.xml.bind.Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    return (Project) jaxbUnmarshaller.unmarshal(new File(fileName));
	}
	
	
	private static void marshalToFile(Projectlist data, String fileName) throws JAXBException
	{
	    JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    jaxbMarshaller.marshal(data, new File(fileName));
	}
	
	private static void marshalToFileProjectList(Projectlist data, String fileName) throws JAXBException
	{
	    JAXBContext jaxbContext = JAXBContext.newInstance(Projectlist.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    jaxbMarshaller.marshal(data, new File(fileName));
	}
	
	private static void deleteEntry(String deleteword) throws JAXBException
	{
		Projectlist data = unmarshalFromFile("server_projectlist.xml");
		
		Iterator<ProjectOverview> iterator = data.getProjectOverview().iterator();
		while (iterator.hasNext()) {
		    if (deleteword.equals(iterator.next().getName())) {
		         iterator.remove();
		    }
		}
		
		marshalToFile(data, "server_projectlist.xml");
		
	}
	
	
	public static void changeEntryinXML(XMLGregorianCalendar time, String name) throws JAXBException, XMLStreamException
	{
		ProjectOverview pro = searchinXML(name);
		
		pro.setLastmod(time);
		String delete = pro.getName();
		
		Projectlist data = unmarshalFromFile("server_projectlist.xml");
		
		Iterator<ProjectOverview> iterator = data.getProjectOverview().iterator();
		while (iterator.hasNext()) {
		    if (delete.equals(iterator.next().getName())) {
		         iterator.remove();
		    }
		}
		data.getProjectOverview().add(pro);
		
		marshalToFile(data, "server_projectlist.xml");
		
	}
	
	public static List<Project> checkProjectListandgiveProjectsback(String userName) throws JAXBException
	{
		ArrayList<Project> proList = new ArrayList<Project>();
		Projectlist data = unmarshalFromFile("server_projectlist.xml");
		
		ProjectOverview pOver = new ProjectOverview("Testprojekt", "Das ist ein Testprojekt", "blabliblubkey");
		Iterator<ProjectOverview> iterator = data.getProjectOverview().iterator();
		while (iterator.hasNext()) 
		{
			
			Userlist userlist = iterator.next().getUserlist();
			//User us = new User();
			
			Iterator<User> ite = (Iterator<User>) userlist.getUser();
			
			while(ite.hasNext())
			{
				if(userName.equals(ite.next().getValue()))
				{
					Project pro = unmarshalFromFileProject(iterator.next().getProjectname().toString() + ".xml");
					proList.add(pro);
					
		
				}
			}

		}
		
		
		
		return proList;
	}


	
	
	public static void main(String[] args) throws Exception 
	{
		User us = new User();
		us.setIsAdmin(false);
		us.setValue("Peter");
		
		
	    ProjectOverview pr = new ProjectOverview("Testprojekt", "Das ist ein Testprojekt", "blabliblubkey");
	    pr.setProjectname("kanban1");
	    
	    pr.setDescription("kauabanaga");
	    pr.setLastmod(null);
	    Userlist userlist = new Userlist();
	    
	    userlist = pr.getUserlist();
	    userlist.getUser().add(us);
	    
	    

		addtoprojectList(pr);
		
	//	Project pro = searchinXML("projectname", "projectname" );
		
	//.out.println(pro.getName());
		
	}
	 
	
	

}

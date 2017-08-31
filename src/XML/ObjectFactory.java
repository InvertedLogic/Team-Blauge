//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.08.31 um 01:15:01 PM CEST 
//


package XML;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the XML package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: XML
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Project }
     * 
     */
    public Project createProject() {
        return new Project();
    }

    /**
     * Create an instance of {@link Project.Tasklist }
     * 
     */
    public Project.Tasklist createProjectTasklist() {
        return new Project.Tasklist();
    }

    /**
     * Create an instance of {@link Project.Statuslist }
     * 
     */
    public Project.Statuslist createProjectStatuslist() {
        return new Project.Statuslist();
    }

    /**
     * Create an instance of {@link Project.Tasklist.Task }
     * 
     */
    public Project.Tasklist.Task createProjectTasklistTask() {
        return new Project.Tasklist.Task();
    }

}

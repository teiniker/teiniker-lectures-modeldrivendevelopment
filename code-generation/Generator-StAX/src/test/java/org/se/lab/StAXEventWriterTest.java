package org.se.lab;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import org.junit.Before;
import org.junit.Test;


public class StAXEventWriterTest
{
    private XMLOutputFactory factory;
    
    @Before
    public void setup()
    {
        // We need to bootstrap an instance of the XMLOutputFactory,
        // which is done with the static newInstance() method.        
        factory = XMLOutputFactory.newInstance();
    }
    
    
    @Test
    public void testMail() 
        throws FileNotFoundException, XMLStreamException
    {
        // XMLEventWriter instances are created using the XMLOutputFactory. 
        XMLEventWriter writer = factory.createXMLEventWriter(System.out);
        
        // To add an XMLEvent object, we must obtain an EMLEvent object
        // using an implementation of the abstract class XMLEventFactory.
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        
        // The XMLEventFactory has a series of methods for creating
        // various event objects.
        writer.add(eventFactory.createStartDocument("UTF-8", "1.0", true));
        writer.add(eventFactory.createStartElement("", "", "mail"));
        writer.add(eventFactory.createAttribute("from", "me@fhj.at"));
        
        writer.add(eventFactory.createStartElement("", "", "to"));
        writer.add(eventFactory.createCharacters("you@fhj.at"));
        writer.add(eventFactory.createEndElement("", "", "to"));
        
        writer.add(eventFactory.createStartElement("", "", "to"));
        writer.add(eventFactory.createCharacters("she@fhj.at"));
        writer.add(eventFactory.createEndElement("", "", "to"));
        
        writer.add(eventFactory.createStartElement("", "", "cc"));
        writer.add(eventFactory.createEndElement("", "", "cc"));

        writer.add(eventFactory.createStartElement("", "", "subject"));
        writer.add(eventFactory.createCharacters("Some Informations"));
        writer.add(eventFactory.createEndElement("", "", "subject"));
        
        writer.add(eventFactory.createStartElement("", "", "text"));
        writer.add(eventFactory.createCData(
        "\n" +       
        "<p>\n" +
        "    <h1> This is a simple mail message! </h1>\n"+ 
        "</p>\n" +
        "\n"));
        writer.add(eventFactory.createEndElement("", "", "text"));
        
        writer.add(eventFactory.createEndElement("", "", "mail"));
        writer.add(eventFactory.createEndDocument());
        writer.flush();
    }
    
    
    @Test
    public void testMailWithNamespace() 
        throws FileNotFoundException, XMLStreamException
    {
        final String XMLNS = "http://fh-joanneum.at";
        
        XMLEventWriter writer = factory.createXMLEventWriter(System.out);
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            
        writer.add(eventFactory.createStartDocument("UTF-8", "1.0", true));

        writer.add(eventFactory.createStartElement("", XMLNS, "mail"));
        writer.add(eventFactory.createNamespace(XMLNS));
        writer.add(eventFactory.createAttribute("from", "me@fhj.at"));
        
        writer.add(eventFactory.createStartElement("", XMLNS, "to"));
        writer.add(eventFactory.createCharacters("you@fhj.at"));
        writer.add(eventFactory.createEndElement("", XMLNS, "to"));

        //...
        
        writer.add(eventFactory.createEndElement("", XMLNS, "mail"));
        
        writer.add(eventFactory.createEndDocument());
        writer.flush();    
    }

    
    @Test
    public void testMailWithNamespacePrefix() 
        throws FileNotFoundException, XMLStreamException
    {
        final String XMLNS = "http://sourceforge.org";
        final String XMLNS_FHJ = "http://fh-joanneum.at";
        
        XMLEventWriter writer = factory.createXMLEventWriter(System.out);
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            
        writer.add(eventFactory.createStartDocument("UTF-8", "1.0", true));

        writer.add(eventFactory.createStartElement("fhj", XMLNS_FHJ, "mail"));
        writer.add(eventFactory.createNamespace(XMLNS));
        writer.add(eventFactory.createNamespace("fhj", XMLNS_FHJ));
        writer.add(eventFactory.createAttribute("from", "me@fhj.at"));
        
        writer.add(eventFactory.createStartElement("fhj", XMLNS, "to"));
        writer.add(eventFactory.createCharacters("you@fhj.at"));
        writer.add(eventFactory.createEndElement("fhj", XMLNS, "to"));

        writer.add(eventFactory.createStartElement("", XMLNS, "subject"));
        writer.add(eventFactory.createCharacters("Some Informations"));
        writer.add(eventFactory.createEndElement("", XMLNS, "subject"));
        
        //...
        
        writer.add(eventFactory.createEndElement("", XMLNS, "mail"));
        
        writer.add(eventFactory.createEndDocument());
        writer.flush();    
    }
}

package org.se.lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MType;
import org.xml.sax.SAXException;

public class JAXBTest
{
	private JAXBContext context;

	@Before
	public void setup() throws JAXBException
	{
		context = JAXBContext.newInstance(MEntity.class);
	}
		
	@Test
	public void testReadEntity() throws SAXException, JAXBException, FileNotFoundException
	{
		Source src = new StreamSource(new FileReader(new File("src/test/resources/models", "product.xml")));
		Unmarshaller unmarshaller = context.createUnmarshaller();
		JAXBElement<MEntity> element = unmarshaller.unmarshal(src, MEntity.class);
		MEntity entity = element.getValue();

		Assert.assertEquals("Product", entity.getName());
		Assert.assertEquals(4, entity.getProperties().size());
	}
	
	
	@Test
	public void testWriteEntity() throws JAXBException, IOException
	{
	    MEntity entity = new MEntity("User");
        MProperty id = new MProperty("id", new MType("int"));
        id.setId(true);
        entity.getProperties().add(id);
        
        MProperty p = new MProperty("username", new MType("String"));
        entity.getProperties().add(p);
        
        entity.getProperties().add(new MProperty("password", new MType("String")));
	    
	    
        JAXBContext context = JAXBContext.newInstance(MEntity.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Writer out = new StringWriter();
        marshaller.marshal(entity, out);
        out.close();            
        String xml = out.toString();

        System.out.println(xml);
	}	
}

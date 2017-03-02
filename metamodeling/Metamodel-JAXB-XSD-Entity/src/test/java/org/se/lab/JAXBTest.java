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
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class JAXBTest
{
	private JAXBContext context;

	@Before
	public void setup() throws JAXBException
	{
		context = JAXBContext.newInstance("org.se.lab");
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
    public void testReadAndValidateEntity() throws SAXException, JAXBException, FileNotFoundException
    {
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema xsd = schemaFactory.newSchema(new File("src/main/resources/xsd", "entity.xsd"));
        
        Source src = new StreamSource(new FileReader(new File("src/test/resources/models", "product.xml")));
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(xsd);  // validate XML against XSD
        JAXBElement<MEntity> element = unmarshaller.unmarshal(src, MEntity.class);
        MEntity entity = element.getValue();

        Assert.assertEquals("Product", entity.getName());
        Assert.assertEquals(4, entity.getProperties().size());
    }
	
	@Test
	public void testWriteEntity() throws JAXBException, IOException
	{
	    MType intType = new MType();
	    intType.setName("int");
	    MEntity entity = new MEntity();
	    entity.setName("User");
        MProperty id = new MProperty();
        id.setId(true);
        id.setName("id");
        id.setType(intType);
        entity.getProperties().add(id);
        
        MType stringType = new MType();
        stringType.setName("String");
        MProperty p1 = new MProperty();
        p1.setName("username");
        p1.setType(stringType);
        entity.getProperties().add(p1);
        
        MProperty p2 = new MProperty();
        p2.setName("password");
        p2.setType(stringType);
        entity.getProperties().add(p2);	    
	    
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<MEntity> element = factory.createEntity(entity);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Writer out = new StringWriter();
        marshaller.marshal(element, out);
        out.close();
        String xml = out.toString();

        System.out.println(xml);
	}	
}

package org.se.lab;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;

public class DAOGeneratorTest
{
	private static final String PACKAGE_NAME = "org.se.lab";
	private static final String GEN_CODE_FOLDER = "src/generated/java/org/se/lab/";
    private MEntity entity;
    
    @Before
    public void setup()
    {
        entity = new MEntity("User");
        MProperty id = new MProperty("id", new MInteger());
        id.setId(true);
        entity.getProperties().add(id);
        
        MString s = new MString();

        MProperty firstname = new MProperty("firstname", s);
        MProperty lastname = new MProperty("lastname", s);
        MProperty username = new MProperty("username", s);
        MProperty password = new MProperty("password", s);
        
        entity.getProperties().add(firstname);
        entity.getProperties().add(lastname);
        entity.getProperties().add(username);
        entity.getProperties().add(password);
    }

    @Test
    public void testDAOInterfaceGenerator()
    {
    	
    	DAOGenerator g = new DAOInterfaceGenerator();
    	String filename = entity.getName() + "DAOBase.java";
    	g.writeCodeTo(entity, PACKAGE_NAME, filename, GEN_CODE_FOLDER);
    }

    @Test
    public void testDAOClassGenerator()
    {
    	
    	DAOGenerator g = new DAOClassGenerator();
//    	System.out.println(g.generate(entity, PACKAGE_NAME));
    	String filename = entity.getName() + "DAOImplBase.java";
    	g.writeCodeTo(entity, PACKAGE_NAME, filename, GEN_CODE_FOLDER);
    }

}

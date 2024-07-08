package org.se.lab;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;

public class EntityTest
{
	private ObjectMapper mapper;

	@Before
	public void setup() 
	{
		mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}
		
	@Test
	public void testEntityToJson() throws IOException
	{
		MEntity entity = new MEntity("User");
		MProperty id = new MProperty("id", new MInteger());
		id.setId(true);
		entity.getProperties().add(id);
		MString t = new MString();
		MProperty p = new MProperty("username", t);
		entity.getProperties().add(p);
		entity.getProperties().add(new MProperty("password", new MString()));

		mapper.writeValue(new File("entity.json"), entity);
	}

	@Test
	public void testEntityFromJson() throws IOException
	{
		MEntity entity = mapper.readValue(new File("src/test/resources/json/entity.json"), MEntity.class);

		Assert.assertEquals("User", entity.getName());

		MProperty id = entity.getProperties().get(0);
		Assert.assertEquals("id", id.getName());
		Assert.assertEquals(true, id.isId());
		Assert.assertTrue(id.getType() instanceof MInteger);

		MProperty username = entity.getProperties().get(1);
		Assert.assertEquals("username", username.getName());
		Assert.assertEquals(false, username.isId());
		Assert.assertTrue(username.getType() instanceof MString);

		MProperty password = entity.getProperties().get(2);
		Assert.assertEquals("password", password.getName());
		Assert.assertEquals(false, password.isId());
		Assert.assertTrue(password.getType() instanceof MString);
	}
}
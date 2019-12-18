package org.se.lab;

public class AntGenerator
{
	private StringBuilder xml = new StringBuilder();

	public String generate(MProject project)
	{
		visit(project);
		return xml.toString();
	}
	
	private void visit(MProject project)
	{
		xml.append("<project name=\"").append(project.getName()).append("\"")
			.append(" basedir=\"").append(project.getBaseDir()).append("\">\n\n");
			
		visit(project.getDescription());
	
		for(MProperty property : project.getProperties())
		{
			visit(property);
		}
		xml.append("</project>\n");
	}
	
	private void visit(MDescription description)
	{
		xml.append("\t<description>").append(description.getText()).append("</description>\n\n");	
	}
	
	private void visit(MProperty property)
	{
		xml.append("\t<property name=\"").append(property.getName())
		.append("\" value=\"").append(property.getValue()).append("\"/>\n");	
	}	
}

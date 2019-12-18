package org.se.lab;

public class WebPageGenerator
{
	private StringBuilder html = new StringBuilder();

	public String generate(MWebPage project)
	{
		visit(project);
		return html.toString();
	}
	
	private void visit(MWebPage page)
	{
		html.append("<html>\n");
		visit(page.getHead());
		visit(page.getBody());
		html.append("</html>\n");
	}
	
	private void visit(MHead head)
	{
		html.append("\t<head>\n");
		html.append("\t\t<title>").append(head.getTitle()).append("</title>\n");
		html.append("\t</head>\n");
	}
	
	private void visit(MBody body)
	{
		html.append("\t<body>\n");
		for(MPageElement element : body.getElements())
		{
			visit(element);
		}
		html.append("\t</body>\n");
	}
	
	private void visit(MPageElement element)
	{
		if(element instanceof MHeadline)
		{
			visit((MHeadline)element);
		}
		else if(element instanceof MParagraph)
		{
			visit((MParagraph)element);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	private void visit(MHeadline headline)
	{
		html.append("\t\t<h").append(headline.getLevel()).append(">");
		html.append(headline.getText());
		html.append("</h").append(headline.getLevel()).append(">\n");		
	}

	private void visit(MParagraph p)
	{
		html.append("\t\t<p>").append(p.getText()).append("</p>\n");
	}

}

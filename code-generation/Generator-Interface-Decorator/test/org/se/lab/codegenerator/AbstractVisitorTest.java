package org.se.lab.codegenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;

public abstract class AbstractVisitorTest {

	private MPackage pkg;
	
	@Before
	public void setup() {
		pkg = new MPackage("org.se.lab.codegenerator");
		
		MInterface iface = new MInterface("Stack");
		iface.setPublic(true);		
		pkg.getInterfaces().add(iface);
		
		MOperation push = new MOperation("push", new MType("void"));
		push.getParameters().add(new MParameter("value", new MType("int")));
		iface.getOperations().add(push);
		iface.getOperations().add(new MOperation("pop", new MType("int")));
		iface.getOperations().add(new MOperation("top", new MType("int")));
		iface.getOperations().add(new MOperation("isEmpty", new MType("boolean")));
		iface.getOperations().add(new MOperation("isFull", new MType("boolean")));
	}
	
	protected MPackage getPkg() {
		return this.pkg;
	}
	
	protected static String readFile(String file) throws IOException {
		FileReader fileReader = new FileReader("test/org/se/lab/codegenerator/" + file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		bufferedReader.close();
		return sb.toString().trim(); // remove last linebreak
	}
	
}

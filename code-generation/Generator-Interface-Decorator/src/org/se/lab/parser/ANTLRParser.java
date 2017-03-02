package org.se.lab.parser;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.se.lab.metamodel.MPackage;

public class ANTLRParser {

	public static MPackage parse(String file) throws IOException, RecognitionException {
		ANTLRFileStream fileStream = new ANTLRFileStream(file);
		InterfaceLexer interfaceLexer = new InterfaceLexer(fileStream);
		CommonTokenStream commonTokenStream = new CommonTokenStream(interfaceLexer);
		InterfaceParser interfaceParser = new InterfaceParser(commonTokenStream);
		
		return interfaceParser.package_def();
	}
	
}

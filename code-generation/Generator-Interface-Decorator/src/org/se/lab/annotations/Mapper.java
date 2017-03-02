package org.se.lab.annotations;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;

public class Mapper {

	
	public static MPackage genModel(Class<?> clazz) {
		// has Decorator annotation
		if (!clazz.isAnnotationPresent(Decorator.class)) {
			throw new IllegalArgumentException();
		}
		
		// package
		String pkgName = clazz.getPackage().getName();
		MPackage mPackage = new MPackage(pkgName);
		
		// interface
		String interfaceName = clazz.getSimpleName();
		boolean isPublic = Modifier.isPublic(clazz.getModifiers());
		MInterface mInterface = new MInterface(interfaceName);
		mInterface.setPublic(isPublic);
		mPackage.getInterfaces().add(mInterface);
		
		// methods
		for (Method method : clazz.getMethods()) {
			String name = method.getName();
			MType mType = new MType(method.getReturnType().getName());
			MOperation mOperation = new MOperation(name, mType);
			
			// parameter
			int i = 0;
			for (Class<?> parameter : method.getParameterTypes()) {
				MType parameterType = new MType(parameter.getName());
				// it is not possible to get the parameter name
				MParameter mParameter = new MParameter("arg" + i++, parameterType);
				mOperation.getParameters().add(mParameter);
			}
			mInterface.getOperations().add(mOperation);
		}
		
		return mPackage;
		
	}
}

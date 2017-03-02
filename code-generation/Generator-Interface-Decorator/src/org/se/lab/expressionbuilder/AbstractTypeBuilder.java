package org.se.lab.expressionbuilder;

import org.se.lab.metamodel.MType;

public abstract class AbstractTypeBuilder <T extends AbstractTypeBuilder<?>> {

	private static final MType T_VOID = new MType("void");
	private static final MType T_INT = new MType("int");
	private static final MType T_BOOLEAN = new MType("boolean");
	
	
	private MType type = null;
	
	@SuppressWarnings("unchecked")
	public T asVoid() {
		this.type = AbstractTypeBuilder.T_VOID;
		return (T) this;
	}
	
	@SuppressWarnings("unchecked")
	public T asInt() {
		this.type = AbstractTypeBuilder.T_INT;
		return (T) this;
	}
	
	@SuppressWarnings("unchecked")
	public T asBoolean() {
		this.type = AbstractTypeBuilder.T_BOOLEAN;
		return (T) this;
	}
	
	protected MType getType() {
		return this.type;
	}
}

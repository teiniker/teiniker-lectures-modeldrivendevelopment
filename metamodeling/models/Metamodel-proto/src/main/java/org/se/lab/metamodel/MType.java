package org.se.lab.metamodel;

public class MType
    extends MNamedElement
{
    public MType(String name)
    {
        setName(name);
    }

    /*
     * Model Validation
     */
    @Override
    public void validate()
    {
        // Validation
        if(getName() == null
                || getName().trim().length() == 0
                || !Validation.PRIMITIVE_TYPES.contains(getName()))
            throw new IllegalStateException("MType: Invalid name: " + getName());

        // Navigation
    }
}

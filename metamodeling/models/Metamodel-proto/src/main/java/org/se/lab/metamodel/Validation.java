package org.se.lab.metamodel;

import java.util.List;

public interface Validation
{
    List<String> PRIMITIVE_TYPES = List.of("bool", "int32", "float", "double", "string");

    void validate();
}

package org.se.lab.metamodel;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MInteger.class, name = "MInteger"),
        @JsonSubTypes.Type(value = MString.class, name = "MString")
})
public abstract class MType
{
}

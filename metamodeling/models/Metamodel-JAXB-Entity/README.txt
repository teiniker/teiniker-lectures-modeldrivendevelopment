
How to generate XML schema from annotated Java classes?
-------------------------------------------------------------------------------

$ schemagen src/main/java/org/se/lab/*.java


<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <xs:element name="entity" type="mEntity"/>

  <xs:complexType name="mEntity">
    <xs:complexContent>
      <xs:extension base="mNamedElement">
        <xs:sequence>
          <xs:element name="properties" minOccurs="0">
            <xs:complexType>
              <xs:sequence>
                <xs:element name="property" type="mProperty" minOccurs="0" maxOccurs="unbounded"/>
              </xs:sequence>
            </xs:complexType>
          </xs:element>
        </xs:sequence>
      </xs:extension>
    </xs:complexContent>
  </xs:complexType>

  <xs:complexType name="mNamedElement" abstract="true">
    <xs:sequence/>
    <xs:attribute name="name" type="xs:string"/>
  </xs:complexType>

  <xs:complexType name="mProperty">
    <xs:complexContent>
      <xs:extension base="mNamedElement">
        <xs:sequence>
          <xs:element name="type" type="mType" minOccurs="0"/>
        </xs:sequence>
        <xs:attribute name="id" type="xs:boolean" use="required"/>
      </xs:extension>
    </xs:complexContent>
  </xs:complexType>

  <xs:complexType name="mType">
    <xs:complexContent>
      <xs:extension base="mNamedElement">
        <xs:sequence/>
      </xs:extension>
    </xs:complexContent>
  </xs:complexType>
</xs:schema>

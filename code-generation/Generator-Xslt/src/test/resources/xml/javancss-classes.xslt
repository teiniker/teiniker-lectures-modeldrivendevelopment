<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>

	<xsl:template match="/">
	    <javancss>
	    	<xsl:message>match: root</xsl:message>
	    	<xsl:apply-templates select="javancss/functions/function"/>
	    </javancss>
	</xsl:template>

	<xsl:template match="function">
		<xsl:message>match: object</xsl:message>
	    <xsl:element name="method">
	    	<xsl:attribute name="name">
	    		<xsl:value-of select="name/text()"/>
	    	</xsl:attribute>
	    	<xsl:attribute name="ccn">
	    		<xsl:value-of select="ccn/text()"/>
	    	</xsl:attribute>	    	
	    </xsl:element>
	</xsl:template>
</xsl:stylesheet>
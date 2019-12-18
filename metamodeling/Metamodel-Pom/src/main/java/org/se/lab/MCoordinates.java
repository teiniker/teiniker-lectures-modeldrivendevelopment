package org.se.lab;

public abstract class MCoordinates
{
	/*
	 * Property: groupId:String
	 */
	private String groupId;
	public String getGroupId()
	{
		return groupId;
	}
	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}

	
	/*
	 * Property: artifact:String
	 */
	private String artifactId;
	public String getArtifactId()
	{
		return artifactId;
	}
	public void setArtifactId(String artifactId)
	{
		this.artifactId = artifactId;
	}

	
	/*
	 * Property: version:String
	 */
	private String version;
	public String getVersion()
	{
		return version;
	}
	public void setVersion(String version)
	{
		this.version = version;
	}	
}

package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class PomBuilder
{
	private String groupId;
	private String artifactId;
	private String version;
	private String packaging = "jar"; // default value
	
	private List<DependencyBuilder> dependencies = new ArrayList<>();
	
	
	public PomBuilder groupId(String groupId)
	{
		this.groupId = groupId;
		return this;
	}
	
	public PomBuilder artifactId(String artifactId)
	{
		this.artifactId = artifactId;
		return this;
	}
	
	public PomBuilder version(String version)
	{
		this.version = version;
		return this;
	}
	
	public PomBuilder packaging(String packaging)
	{
		this.packaging = packaging;
		return this;
	}
	
	public MProjectObjectModel toPom()	// 2 Points
	{
		MProjectObjectModel pom = new MProjectObjectModel();
		pom.setGroupId(groupId);
		pom.setArtifactId(artifactId);
		pom.setVersion(version);
		pom.setPackaging(packaging);
		
		// List of Dependencies
		for(DependencyBuilder db : dependencies)
		{
			pom.getDependencies().add(db.toDependency());
		}
		
		return pom;
	}
	
	public DependencyBuilder dependency()
	{
		DependencyBuilder db = new DependencyBuilder();
		dependencies.add(db);
		return db;
	}
	
	
	/*
	 * Dependency Builder 
	 */
	public class DependencyBuilder
	{
		private String groupId;
		private String artifactId;
		private String version;
		
		public DependencyBuilder groupId(String groupId)
		{
			this.groupId = groupId;
			return this;
		}
		
		public DependencyBuilder artifactId(String artifactId)
		{
			this.artifactId = artifactId;
			return this;
		}
		
		public DependencyBuilder version(String version)
		{
			this.version = version;
			return this;
		}
		
		
		protected MDependency toDependency()	
		{
			MDependency dependency = new MDependency();
			dependency.setGroupId(groupId);
			dependency.setArtifactId(artifactId);
			dependency.setVersion(version);
			return dependency;
		}
		
		public DependencyBuilder dependency()
		{
			return PomBuilder.this.dependency();
		}
		
		public MProjectObjectModel toPom()
		{
			return PomBuilder.this.toPom();
		}
	}
}

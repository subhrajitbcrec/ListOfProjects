package org.training.ListOfProjects;

public class Project {
	
	private String name;
	
	private String description;
	
	private String gitURL;
	
	private String markdown;
	
	public Project(String name, String desc, String url, String mark){
		this.name = name;
		this.description = desc;
		this.gitURL = url;
		this.markdown = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGitURL() {
		return gitURL;
	}

	public void setGitURL(String gitURL) {
		this.gitURL = gitURL;
	}

	public String getMarkdown() {
		return markdown;
	}

	public void setMarkdown(String markdown) {
		this.markdown = markdown;
	}

}

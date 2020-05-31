package org.training.ListOfProjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@PropertySource(value = "classpath:application.properties")
public class ProjectResource {

	private static final Logger LOGGER = LogManager.getLogger(ProjectResource.class);

	@Value("#{'${project.names}'.split(',')}")
	private List<String> names;

	@Value("#{'${project.description}'.split(',')}")
	private List<String> descriptions;

	@Value("#{'${project.gitURL}'.split(',')}")
	private List<String> gitURLs;

	@Value("#{'${project.markdown}'.split(',')}")
	private List<String> markdowns;

	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/listOfProjects/Angular", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
					MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Project> getProducts() {
		List<Project> projects = new ArrayList<>();
		Project project = null;
		int index = 0;
		for (String name : names) {
			LOGGER.info(name, descriptions.get(index), gitURLs.get(index), markdowns.get(index));
			project = new Project(name, descriptions.get(index), gitURLs.get(index), markdowns.get(index));
			index++;
			projects.add(project);
		}
		return projects;
	}

}

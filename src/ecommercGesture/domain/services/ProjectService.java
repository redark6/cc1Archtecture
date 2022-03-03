package ecommercGesture.domain.services;

import java.util.List;

import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.Project;
import ecommercGesture.domain.repositories.ProjectRepository;

public class ProjectService {

	private final ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public Id getNextId() {
		return projectRepository.getNextId();
	}
	
	public Project getProjectById(Id id) {
		return projectRepository.getProjectById(id);
	}
	
	public List<Project> getAll() {
		return projectRepository.getAll();
	}
	
	public List<Project> getProjectByManagerId(Id id) {
		return projectRepository.getProjectByManagerId(id);
	}
	
	public Project saveProject(Project project) {
		return projectRepository.saveProject(project);
	}

}

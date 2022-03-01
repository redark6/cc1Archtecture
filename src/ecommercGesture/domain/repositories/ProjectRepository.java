package ecommercGesture.domain.repositories;

import java.util.List;

import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.Project;

public interface ProjectRepository {

	Id getNextId();
	Project getProjectById(Id id);
	List<Project> getAll();
	Project saveProject(Project project);
	List<Project> getProjectByManagerId(Id managerId);
}

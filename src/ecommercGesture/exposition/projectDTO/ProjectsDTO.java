package ecommercGesture.exposition.projectDTO;

import java.util.List;

public class ProjectsDTO {

    public final List<ProjectDTO> projects;

    public static ProjectsDTO of(List<ProjectDTO> project) {
    	return new ProjectsDTO(project);
    }
    
    private ProjectsDTO(List<ProjectDTO> project) {
        this.projects = project;
    }
}

package ecommercGesture.application.projectQueriesCommandsEvent.queries;

import java.util.List;
import java.util.stream.Collectors;

import ecommercGesture.domain.objects.Project;
import ecommercGesture.domain.services.ProjectService;
import ecommercGesture.exposition.projectDTO.LocationDTO;
import ecommercGesture.exposition.projectDTO.ProjectDTO;
import ecommercGesture.exposition.projectDTO.ProjectsDTO;
import kernel.QueryHandler;

public class RetrieveProjectsHandler implements QueryHandler<RetrieveProjects, ProjectsDTO>{

    private final ProjectService projectService;
	
    public RetrieveProjectsHandler(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectsDTO handle(RetrieveProjects query) {
    	List<Project> projects = projectService.getAll();
    	ProjectsDTO projectResponseResult = ProjectsDTO.of(projects.stream()
    			.map(project -> 
    			ProjectDTO.of(project.getId().getId(),
    	    			project.getProjectManagerId().getId(),
    	    			project.getCreationDate(),
    	    			project.getStartProjectDate(),
    	    			project.getProjectName(),
    	    			project.getProjectDescrition(), project.getProjectPrice(),
    	    			project.getBillRate(),
    	    			LocationDTO.of(
    	    					project.getLocation().getCountry(),
    	    					project.getLocation().getRegion(),
    	    					project.getLocation().getCity(),
    	    					project.getLocation().getAddress()),
    	    			project.getWorkerIds().stream().map(workerId -> workerId.getId()).collect(Collectors.toList()),
    	    			project.getRequiredJobs().stream().map(job -> job.getJobName()).collect(Collectors.toList()),
    	    			project.getSkills().stream().map(skill -> skill.getSkillName()).collect(Collectors.toList()),
    	    			project.getDuration(),
    	    			project.getState().name())
    			).collect(Collectors.toList()));
        return projectResponseResult;
    }
}

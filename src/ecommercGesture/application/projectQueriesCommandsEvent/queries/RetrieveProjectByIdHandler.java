package ecommercGesture.application.projectQueriesCommandsEvent.queries;

import java.util.stream.Collectors;

import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.Project;
import ecommercGesture.domain.services.ProjectService;
import ecommercGesture.exposition.projectDTO.LocationDTO;
import ecommercGesture.exposition.projectDTO.ProjectDTO;
import kernel.QueryHandler;

public class RetrieveProjectByIdHandler implements QueryHandler<RetrieveProjectById, ProjectDTO>{

    private final ProjectService projectService;
	
    public RetrieveProjectByIdHandler(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO handle(RetrieveProjectById query) {
    	Id projectId = Id.of(query.projectId);
    	Project project = projectService.getProjectById(projectId);
    	ProjectDTO projectResponseResult = ProjectDTO.of(project.getId().getId(),
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
    			project.getState().name());
        return projectResponseResult;
    }
}
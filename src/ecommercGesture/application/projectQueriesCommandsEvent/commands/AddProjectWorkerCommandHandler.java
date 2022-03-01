package ecommercGesture.application.projectQueriesCommandsEvent.commands;

import java.util.stream.Collectors;

import ecommercGesture.application.projectQueriesCommandsEvent.events.AddProjectWorkerEvent;
import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.Project;
import ecommercGesture.domain.services.ProjectCreationModificationService;
import ecommercGesture.exposition.projectDTO.LocationDTO;
import ecommercGesture.exposition.projectDTO.ProjectDTO;
import kernel.CommandHandler;
import kernel.Event;
import kernel.EventDispatcher;

public class AddProjectWorkerCommandHandler implements CommandHandler<AddProjectWorker, ProjectDTO>{
	
    private final ProjectCreationModificationService creationModificationService;
    private final EventDispatcher<Event> eventDispatcher;
    
    public AddProjectWorkerCommandHandler(ProjectCreationModificationService creationModificationService, EventDispatcher<Event> eventDispatcher) {
        this.creationModificationService = creationModificationService;
    	this.eventDispatcher = eventDispatcher;
    }
    
    public ProjectDTO handle(AddProjectWorker command) {
    	Project project = creationModificationService.addWorkerToProject(Id.of(command.projectId), Id.of(command.workerDTO.workerId));
    	eventDispatcher.dispatch(AddProjectWorkerEvent.of(project.getId()));
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

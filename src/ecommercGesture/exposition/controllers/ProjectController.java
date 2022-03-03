package ecommercGesture.exposition.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ecommercGesture.application.projectQueriesCommandsEvent.commands.AddProjectWorker;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.CloseProject;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.CreateProject;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.ModifyProject;
import ecommercGesture.application.projectQueriesCommandsEvent.commands.RemoveProjectWorker;
import ecommercGesture.application.projectQueriesCommandsEvent.queries.RetrieveProjectById;
import ecommercGesture.application.projectQueriesCommandsEvent.queries.RetrieveProjects;
import ecommercGesture.application.projectQueriesCommandsEvent.queries.RetrieveProjectsByManagerId;
import ecommercGesture.exposition.projectDTO.CreateProjectDTO;
import ecommercGesture.exposition.projectDTO.ModifyProjectDTO;
import ecommercGesture.exposition.projectDTO.ProjectDTO;
import ecommercGesture.exposition.projectDTO.ProjectsDTO;
import ecommercGesture.exposition.projectDTO.WorkerDTO;
import ecommercGesture.infrastructure.exception.InvalidProjectBillRateException;
import ecommercGesture.infrastructure.exception.InvalidProjectPriceException;
import ecommercGesture.infrastructure.exception.InvalideDurationException;
import ecommercGesture.infrastructure.exception.NotMemberException;
import ecommercGesture.infrastructure.exception.ProjectAlreadyFinishedException;
import ecommercGesture.infrastructure.exception.ProjectCannotCloseUnknownWorkerException;
import ecommercGesture.infrastructure.exception.ProjectCannotEditFinishedException;
import ecommercGesture.infrastructure.exception.UnknownJobsException;
import ecommercGesture.infrastructure.exception.UnknownSkillsException;
import ecommercGesture.infrastructure.exception.UserAlreadyWorkOnProjectException;
import ecommercGesture.infrastructure.exception.UserNotMemberException;
import ecommercGesture.infrastructure.exception.UserNotWorkOnProjectException;
import ecommercGesture.infrastructure.exception.UserNotfoundException;
import kernel.CommandBus;
import kernel.NoSuchEntityException;
import kernel.QueryBus;

@RestController
@RequestMapping("project")
public class ProjectController {
	
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public ProjectController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }
    
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProjectDTO> getById(@RequestParam(name = "id") int id) {
       final ProjectDTO projectResponseResult = queryBus.send(new RetrieveProjectById(id));
       return ResponseEntity.ok(projectResponseResult);
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProjectsDTO> getAll() {
        final ProjectsDTO projectResponseResult = queryBus.send(new RetrieveProjects());
        return ResponseEntity.ok(projectResponseResult);
    }
    
    @GetMapping(value = "/manager",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProjectsDTO> getByManagerId(@RequestParam(name = "managerId") int managerId) {
       final ProjectsDTO projectResponseResult = queryBus.send(new RetrieveProjectsByManagerId(managerId));
       return ResponseEntity.ok(projectResponseResult);
    }
    
    @PostMapping(value ="/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> createProject(@RequestBody @Valid CreateProjectDTO request) {
    	final CreateProject createProject = new CreateProject(request);
    	final ProjectDTO projectResponseResult = commandBus.send(createProject);
        return ResponseEntity.ok(projectResponseResult);
    }
    
    @PutMapping(value ="/modify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> modifyProject(@RequestParam(name = "id") int id, @RequestBody @Valid ModifyProjectDTO request) {
    	final ModifyProject modifyProject = new ModifyProject(id, request);
    	final ProjectDTO projectResponseResult = commandBus.send(modifyProject);
        return ResponseEntity.ok(projectResponseResult);
    }
    
    @PostMapping(value ="/addWorker", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> addWorker(@RequestParam(name = "projectId") int projectId, @RequestBody @Valid WorkerDTO request) {
    	final AddProjectWorker addProjectWorker = new AddProjectWorker(projectId, request);
    	final ProjectDTO projectResponseResult = commandBus.send(addProjectWorker);
        return ResponseEntity.ok(projectResponseResult);
    }
    
    @DeleteMapping(value ="/removeWorker", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> removeWorker(@RequestParam(name = "projectId") int projectId, @RequestBody @Valid WorkerDTO request) {
    	final RemoveProjectWorker removeProjectWorker = new RemoveProjectWorker(projectId, request);
    	final ProjectDTO projectResponseResult = commandBus.send(removeProjectWorker);
        return ResponseEntity.ok(projectResponseResult);
    }
    
    @PostMapping(value ="/close")
    public ResponseEntity<ProjectDTO> closeProject(@RequestParam(name = "projectId") int projectId) {
    	final CloseProject closeProject = new CloseProject(projectId);
    	final ProjectDTO projectResponseResult = commandBus.send(closeProject);
        return ResponseEntity.ok(projectResponseResult);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchEntityException.class)
    public String handleEntityExceptions(
    		NoSuchEntityException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotMemberException.class)
    public String handleNotMemberException(
    		NotMemberException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotfoundException.class)
    public String handleUserNotfoundException(
    		UserNotfoundException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotWorkOnProjectException.class)
    public String handleUserNotWorkOnProjectException(
    		UserNotWorkOnProjectException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyWorkOnProjectException.class)
    public String handleUserAlreadyWorkOnProjectException(
    		UserAlreadyWorkOnProjectException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnknownSkillsException.class)
    public String handleUnknownSkillsException(
    		UnknownSkillsException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnknownJobsException.class)
    public String handleUnknownJobsException(
    		UnknownJobsException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidProjectBillRateException.class)
    public String handleInvalidProjectBillRateException(
    		InvalidProjectBillRateException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidProjectPriceException.class)
    public String handleInvalidProjectPriceException(
    		InvalidProjectPriceException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalideDurationException.class)
    public String handleInvalideDurationException(
    		InvalideDurationException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotMemberException.class)
    public String handleUserNotMemberException(
    		UserNotMemberException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProjectCannotEditFinishedException.class)
    public String handleProjectCannotEditFinishedException(
    		ProjectCannotEditFinishedException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProjectAlreadyFinishedException.class)
    public String handleProjectAlreadyFinishedException(
    		ProjectAlreadyFinishedException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProjectCannotCloseUnknownWorkerException.class)
    public String handleProjectCannotCloseUnknownWorkerException(
    		ProjectCannotCloseUnknownWorkerException ex) {
        return ex.getMessage();
    }
}

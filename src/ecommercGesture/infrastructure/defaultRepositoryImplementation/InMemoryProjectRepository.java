package ecommercGesture.infrastructure.defaultRepositoryImplementation;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.Project;
import ecommercGesture.domain.repositories.ProjectRepository;
import kernel.NoSuchEntityException;

public class InMemoryProjectRepository implements ProjectRepository{

	private final AtomicInteger count = new AtomicInteger(0);
	private final Map<Id, Project> data = new ConcurrentHashMap<>();
	
	@Override
	public Id getNextId() {
		return Id.of(count.incrementAndGet());
	}
	
	@Override
	public Project getProjectById(Id id) {
		Project project = data.get(id);
		if (project == null) {
			throw NoSuchEntityException.withIdAndElem(id,"project");
		}
		return project;
	}

	@Override
	public List<Project> getAll() {
		List<Project> result = data.values().stream().collect(Collectors.toList());
		return  result;
	}
	
	@Override
	public Project saveProject(Project project) {
		data.put(project.getId(), project);
		return project;
	}

	@Override
	public List<Project> getProjectByManagerId(Id managerId) {
		List<Project> result = data.values().stream().filter(project -> { return project.getProjectManagerId().equals(managerId); }).collect(Collectors.toList());
		return result;
	}

}

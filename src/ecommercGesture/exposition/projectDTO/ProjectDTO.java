package ecommercGesture.exposition.projectDTO;

import java.time.LocalDate;
import java.util.List;

public class ProjectDTO {
	
	public int id;
	public int projectManagerId;
	private final LocalDate creationDate;
	private LocalDate startProjectDate;
	public String projectName;
	public String projectDescrition;
	public double projectPrice;
	public double billRate;
	public LocationDTO location;
	public List<Integer> workerIds;
	public List<String> requiredJobs;
	public List<String> skills;
	public int duration;
	public String state;
	
	public static ProjectDTO of(int id, int projectManagerId,LocalDate creationDate,
			LocalDate startProjectDate, String projectName, String projectDescrition, double projectPrice,
			double billRate, LocationDTO location, List<Integer> workerIds, List<String> requiredJobs, List<String> skills,
			int duration, String state) {
    	return new ProjectDTO(id, projectManagerId,creationDate, startProjectDate, projectName, projectDescrition, projectPrice,
    		 billRate, location, workerIds, requiredJobs, skills, duration, state);
    }
	
    private ProjectDTO(int id, int projectManagerId, LocalDate creationDate,
			LocalDate startProjectDate, String projectName,
			String projectDescrition, double projectPrice, double billRate, LocationDTO location,
			List<Integer> workerIds, List<String> requiredJobs, List<String> skills, int duration, String state) {
		super();
		this.id = id;
		this.projectManagerId = projectManagerId;
		this.creationDate = creationDate;
		this.startProjectDate = startProjectDate;
		this.projectName = projectName;
		this.projectDescrition = projectDescrition;
		this.projectPrice = projectPrice;
		this.billRate = billRate;
		this.location = location;
		this.workerIds = workerIds;
		this.requiredJobs = requiredJobs;
		this.skills = skills;
		this.duration = duration;
		this.state = state;
	}

}

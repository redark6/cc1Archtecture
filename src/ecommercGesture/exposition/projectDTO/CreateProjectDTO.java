package ecommercGesture.exposition.projectDTO;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateProjectDTO {
	
    @NotNull
	public LocalDate startProjectDate;
    
	@NotNull
	public int projectManagerId;
	
    @NotNull
    @NotBlank
	public String projectName;
    
    @NotNull
    @NotBlank
	public String projectDescrition;
    
    @NotNull
	public double projectPrice;
    
    @NotNull
	public double billRate;
    
    @NotNull
	public LocationDTO location;
    
    @NotNull
	public List<String> requiredJobs;
    
    @NotNull
	public List<String> skills;
    
    @NotNull
	public int duration;

}

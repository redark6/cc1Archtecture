package ecommercGesture.exposition.projectDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LocationDTO {

    @NotNull
    @NotBlank
	public String country;
    
    @NotNull
    @NotBlank
	public String region;
    
    @NotNull
    @NotBlank
	public String city;
    
    @NotNull
    @NotBlank
	public String address;
    
    public LocationDTO() {
		// TODO Auto-generated constructor stub
	}

	public static LocationDTO of(String country, String region, String city, String address) {
    	return new LocationDTO(country, region, city,address);
    }
	
    public LocationDTO(String country, String region, String city, String address) {
		this.country = country;
		this.region = region;
		this.city = city;
		this.address = address;
	}
}

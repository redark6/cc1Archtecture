package ecommercGesture.domain.objects;

public class Location {
	
	private final String country;
	private final String region;
	private final String city;
	private final String address;
	
	public static Location of(String country, String region, String city, String address) {
		return new Location(country,region,city,address);
	}
	
	private Location(String country, String region, String city, String address) {
		this.country = country;
		this.region = region;
		this.city = city;
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public String getRegion() {
		return region;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Location [country=" + country + ", region=" + region + ", city=" + city + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}
	
}

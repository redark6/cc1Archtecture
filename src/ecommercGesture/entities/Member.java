package ecommercGesture.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Member {
	
	private final int id;
	private final String name;
	private final String lastName;
	private String password;
	private LocalDate startMembership;
	private LocalDate endMembership;
	
	private Member(int id, String name, String lastName, String password, LocalDate startMembership, LocalDate endMembership) {
		this.id = id;
		this.name = Objects.requireNonNull(name,"User name must be not null");
		this.lastName = Objects.requireNonNull(lastName,"User lastname must be not null");
		this.password = Objects.requireNonNull(password,"User password must be not null");
		this.startMembership = startMembership;
		this.endMembership = endMembership;
	}
	
    public static Member of(int id, String name, String lastName, String password, LocalDate startMembership, LocalDate endMembership) {
        return new Member(id, name, lastName, password,startMembership, endMembership);
    }
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public void changePassword(String password) {
		this.password = Objects.requireNonNull(password,"User password must be not null");
	}

	public LocalDate getStartMembership() {
		return startMembership;
	}

	public LocalDate getEndMembership() {
		return endMembership;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", lastName=" + lastName + ", password=" + password
				+ ", startMembership=" + startMembership + ", endMembership=" + endMembership + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endMembership == null) ? 0 : endMembership.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((startMembership == null) ? 0 : startMembership.hashCode());
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
		Member other = (Member) obj;
		if (endMembership == null) {
			if (other.endMembership != null)
				return false;
		} else if (!endMembership.equals(other.endMembership))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (startMembership == null) {
			if (other.startMembership != null)
				return false;
		} else if (!startMembership.equals(other.startMembership))
			return false;
		return true;
	}
	
}

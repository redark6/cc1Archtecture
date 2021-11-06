package ecommercGesture.entities;

public class UserEntity {
	
	private final int id;
	private final String name;
	private final String lastName;
	private String password;
	
	private UserEntity(int id, String name, String lastName, String password) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
	}
	
    public static UserEntity of(int id, String name, String lastname, String password) {
        return new UserEntity(id, name, lastname, password);
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
		this.password = password;
	}
	
}

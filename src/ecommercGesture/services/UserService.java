package ecommercGesture.services;

import ecommercGesture.entities.UserEntity;
import ecommercGesture.repositories.UserRepository;

public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void addUser(UserEntity user) {
		userRepository.addUser(user);
	}
	
	public UserEntity getUser(int id) {
		return userRepository.getUserById(id).get();
	}
	
	public boolean userHasValidInformations(UserEntity user) {
		if(!user.getName().isEmpty() && !user.getLastName().isEmpty() && !user.getPassword().isEmpty()) {
			return true;
		}
		return false;
	}
	
}

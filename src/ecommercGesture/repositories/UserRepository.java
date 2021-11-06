package ecommercGesture.repositories;

import java.util.Optional;

import ecommercGesture.entities.UserEntity;

public interface UserRepository {
	
	Optional<UserEntity> getUserById(int id);
	void addUser(UserEntity user);
	
}

package ecommercGesture.repositories;

import java.util.Optional;

import ecommercGesture.entities.MembershipEntity;
import ecommercGesture.entities.UserEntity;

public interface MembershipRepository {
	
	Optional<MembershipEntity> getMemberById(int id);
	void addMember(MembershipEntity membership);
	boolean isMember(UserEntity user);
	
}

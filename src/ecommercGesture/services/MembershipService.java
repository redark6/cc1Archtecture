package ecommercGesture.services;

import ecommercGesture.entities.MembershipEntity;
import ecommercGesture.entities.UserEntity;
import ecommercGesture.repositories.MembershipRepository;

public class MembershipService {
	
	private final MembershipRepository membershipRepository;
	
	public MembershipService(MembershipRepository membershipRepository) {
		this.membershipRepository = membershipRepository;
	}
	
	public MembershipEntity getMembershipById(int id) {
		return membershipRepository.getMemberById(id).get();
	}
	
	public void addMember(MembershipEntity member) {
		membershipRepository.addMember(member);
	}
	
	public boolean isMember(UserEntity user) {
		return membershipRepository.isMember(user);
	}
	
}

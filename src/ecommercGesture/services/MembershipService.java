package ecommercGesture.services;

import java.time.LocalDate;
import java.util.List;

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
		LocalDate today = LocalDate.now();
		List<MembershipEntity> memberships = membershipRepository.getMemberShipsByUser(user);
		for (MembershipEntity membership : memberships) {
			if( (membership.getStartMembership().isBefore(today) || membership.getStartMembership().isEqual(today) ) && 
					(membership.getEndMembership().isAfter(today) || membership.getEndMembership().isEqual(today) ) )
				return true;
		}
		return false;
	}
	
}

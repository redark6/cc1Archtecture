package ecommercGesture.repositories;

import java.util.Optional;

import ecommercGesture.entities.Member;

public interface MemberRepository {
	
	int getNextId();
	Optional<Member> getMemberById(int id);
	int addMember(Member member);
	
}

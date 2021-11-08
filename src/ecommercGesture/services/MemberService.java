package ecommercGesture.services;

import java.time.LocalDate;

import ecommercGesture.entities.Member;
import ecommercGesture.repositories.MemberRepository;

public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id).get();
	}
	
	public int addMember(Member member) {
		return memberRepository.addMember(member);
	}
	
	public int getNextId() {
		return memberRepository.getNextId();
	}
	
    // Simulacre pour le test
    public boolean memberHasValidInformations(Member appliant) {
    	if(appliant.getName().length() > 2 && appliant.getLastName().length() > 2 && appliant.getPassword().length() > 5) {
    		return true;
    	}
    	return false;
    }
	
	public boolean isMemberExist(int id) {
		if(memberRepository.getMemberById(id).isPresent()) {
			return true;
		}
		return false;
	}
	
	public boolean isMemberMembership(int id) {
		LocalDate today = LocalDate.now();
		Member member = memberRepository.getMemberById(id).get();
			if( (member.getStartMembership().isBefore(today) || member.getStartMembership().isEqual(today) ) && 
					(member.getEndMembership().isAfter(today) || member.getEndMembership().isEqual(today) ) )
				return true;
		return false;
	}
	
}

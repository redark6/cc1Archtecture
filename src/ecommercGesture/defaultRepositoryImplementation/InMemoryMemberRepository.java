package ecommercGesture.defaultRepositoryImplementation;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import ecommercGesture.entities.Member;
import ecommercGesture.repositories.MemberRepository;

public class InMemoryMemberRepository implements MemberRepository{
	
    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<Integer, Member> data = new ConcurrentHashMap<>();
	
	@Override
	public int getNextId() {
		return count.incrementAndGet();
	}
	
	@Override
	public Optional<Member> getMemberById(int id){
		return Optional.of(data.get(id));
	}
	
	@Override
	public int addMember(Member member) {
		data.put(member.getId(), member);
		return member.getId();
	}
}

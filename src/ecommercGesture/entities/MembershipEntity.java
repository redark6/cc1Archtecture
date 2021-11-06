package ecommercGesture.entities;

import java.time.LocalDate;

public class MembershipEntity {
	
	private final int id;
	private final UserEntity user;
	private final LocalDate startMembership;
	private final LocalDate endMembership;
	
	private MembershipEntity(int id, UserEntity user, LocalDate startMembership, LocalDate endMembership) {
		this.id = id;
		this.user = user;
		this.startMembership = startMembership;
		this.endMembership = endMembership;
	}
	
    public static MembershipEntity of(int id, UserEntity user, LocalDate startMembership, LocalDate endMembership) {
        return new MembershipEntity(id, user, startMembership, endMembership);
    }
	
	public int getId() {
		return id;
	}

	public UserEntity getUser() {
		return user;
	}

	public LocalDate getStartMembership() {
		return startMembership;
	}

	public LocalDate getEndMembership() {
		return endMembership;
	}
	
}

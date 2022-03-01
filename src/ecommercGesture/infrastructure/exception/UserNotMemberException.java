package ecommercGesture.infrastructure.exception;

import ecommercGesture.domain.objects.Id;

public class UserNotMemberException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private UserNotMemberException(String message) {
        super(message);
    }

    public static UserNotMemberException withId(Id userId) {
        return new UserNotMemberException(String.format("user with id : %d is currently not a member", userId.getId()));
    }

}

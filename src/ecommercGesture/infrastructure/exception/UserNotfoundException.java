package ecommercGesture.infrastructure.exception;

import ecommercGesture.domain.objects.Id;

public class UserNotfoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private UserNotfoundException(String message) {
        super(message);
    }

    public static UserNotfoundException withId(Id userId) {
        return new UserNotfoundException(String.format("user with id : %d not found", userId.getId()));
    }

}

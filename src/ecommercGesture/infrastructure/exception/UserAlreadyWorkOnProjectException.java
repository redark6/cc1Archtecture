package ecommercGesture.infrastructure.exception;

import ecommercGesture.domain.objects.Id;

public class UserAlreadyWorkOnProjectException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private UserAlreadyWorkOnProjectException(String message) {
        super(message);
    }

    public static UserAlreadyWorkOnProjectException withId(Id workerId) {
        return new UserAlreadyWorkOnProjectException(String.format("user with id : %d already work on this project", workerId.getId()));
    }
}

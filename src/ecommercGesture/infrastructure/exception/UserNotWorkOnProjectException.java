package ecommercGesture.infrastructure.exception;

import ecommercGesture.domain.objects.Id;

public class UserNotWorkOnProjectException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private UserNotWorkOnProjectException(String message) {
        super(message);
    }

    public static UserNotWorkOnProjectException withId(Id workerId) {
        return new UserNotWorkOnProjectException(String.format("user with id : %d not work on this project", workerId.getId()));
    }

}

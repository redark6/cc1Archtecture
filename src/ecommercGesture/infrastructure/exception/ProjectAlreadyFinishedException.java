package ecommercGesture.infrastructure.exception;

import ecommercGesture.domain.objects.Id;

public class ProjectAlreadyFinishedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private ProjectAlreadyFinishedException(String message) {
        super(message);
    }

    public static ProjectAlreadyFinishedException withId(Id projectId) {
        return new ProjectAlreadyFinishedException(String.format("project with id : %d is already finished", projectId.getId()));
    }

}

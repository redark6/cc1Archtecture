package ecommercGesture.infrastructure.exception;

import ecommercGesture.domain.objects.Id;

public class ProjectCannotCloseUnknownWorkerException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private ProjectCannotCloseUnknownWorkerException(String message) {
        super(message);
    }

    public static ProjectCannotCloseUnknownWorkerException withId(Id projectId) {
        return new ProjectCannotCloseUnknownWorkerException(String.format("project with id : %d cannot be closed because some worker are unknown", projectId.getId()));
    }

}

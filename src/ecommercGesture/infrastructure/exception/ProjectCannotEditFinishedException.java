package ecommercGesture.infrastructure.exception;

public class ProjectCannotEditFinishedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private ProjectCannotEditFinishedException(String message) {
        super(message);
    }

    public static ProjectCannotEditFinishedException of() {
        return new ProjectCannotEditFinishedException("prject cannot be created or edited with a starting date and a duration that make it already finished");
    }

}

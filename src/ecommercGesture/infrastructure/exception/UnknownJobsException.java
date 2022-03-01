package ecommercGesture.infrastructure.exception;

import java.util.List;

public class UnknownJobsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private UnknownJobsException(String message) {
        super(message);
    }

    public static UnknownJobsException withJobs(List<String> jobs) {
        return new UnknownJobsException(String.format("those jobs are not existing : %s", String.join(", ", jobs)));
    }

}

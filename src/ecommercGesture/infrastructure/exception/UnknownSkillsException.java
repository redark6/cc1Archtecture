package ecommercGesture.infrastructure.exception;

import java.util.List;

public class UnknownSkillsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private UnknownSkillsException(String message) {
        super(message);
    }

    public static UnknownSkillsException withJobs(List<String> skills) {
        return new UnknownSkillsException(String.format("those skills are not existing : %s", String.join(", ", skills)));
    }

}

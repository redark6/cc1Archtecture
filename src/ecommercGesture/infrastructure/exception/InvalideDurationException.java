package ecommercGesture.infrastructure.exception;

public class InvalideDurationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private InvalideDurationException(String message) {
        super(message);
    }

    public static InvalideDurationException withDuration(int duration) {
        return new InvalideDurationException(String.format("project duration can't be less than 1 day. value found : %d day", duration));
    }

}

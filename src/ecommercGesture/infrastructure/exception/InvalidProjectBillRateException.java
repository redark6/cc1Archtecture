package ecommercGesture.infrastructure.exception;

public class InvalidProjectBillRateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private InvalidProjectBillRateException(String message) {
        super(message);
    }

    public static InvalidProjectBillRateException withBillRate(double billRate) {
        return new InvalidProjectBillRateException(String.format("project billrate can't be less than 0 €. value found : %f €", billRate));
    }

}

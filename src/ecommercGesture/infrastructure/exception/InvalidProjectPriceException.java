package ecommercGesture.infrastructure.exception;

public class InvalidProjectPriceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private InvalidProjectPriceException(String message) {
        super(message);
    }

    public static InvalidProjectPriceException withPrice(double price) {
        return new InvalidProjectPriceException(String.format("project price can't be less than 0 €. value found : %f €", price));
    }

}

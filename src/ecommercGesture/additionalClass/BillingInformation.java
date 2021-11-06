package ecommercGesture.additionalClass;

public class BillingInformation {

	private final String cardNumber;
	private final String expirationDate;
	private final String secretPictogramme;
	private final String ownerName;
	
	private BillingInformation(String cardNumber, String expirationDate, String secretPictogramme, String ownerName) {
		super();
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.secretPictogramme = secretPictogramme;
		this.ownerName = ownerName;
	}
	
    public static BillingInformation of(String cardNumber, String expirationDate, String secretPictogramme, String ownerName) {
        return new BillingInformation(cardNumber, expirationDate, secretPictogramme, ownerName);
    }
	
	public String getCardNumber() {
		return cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public String getSecretPictogramme() {
		return secretPictogramme;
	}

	public String getOwnerName() {
		return ownerName;
	}
	
}

package ecommercGesture.additionalClass;

public class ApplicationResultIds {
	
	private final int memberId;
	private final int paymentId;
	
	private ApplicationResultIds(int memberId, int paymentId) {
		this.memberId = memberId;
		this.paymentId = paymentId;
	}
	
    public static ApplicationResultIds of(int memberId, int paymentId) {
        return new ApplicationResultIds( memberId, paymentId);
    }
	
	public int getMemberId() {
		return memberId;
	}
	
	public int getPaymentId() {
		return paymentId;
	}
	
	
	
	

}

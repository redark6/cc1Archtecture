package ecommercGesture.externalServices;

import ecommercGesture.additionalClass.BillingInformation;

public class ExternalPaymentService {

	public boolean proceedToPayment(BillingInformation billing, double transactionPrice) {
		// simulate payment from an external bank service
		return true;
	}

}

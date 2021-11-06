package ecommercGesture.Dto;

import java.util.Date;

import ecommercGesture.additionalClass.BillingInformation;

public class MembershipApplication {
	
	private final int userId;
	private final double applictionPrice;
	private final int membershipDuration;// in day
	private final Date applicationDate;
	private final BillingInformation billing;
	
	public MembershipApplication(int userId, double applictionPrice, int membershipDuration, Date applicationDate,
			BillingInformation billing) {
		this.userId = userId;
		this.applictionPrice = applictionPrice;
		this.membershipDuration = membershipDuration;
		this.applicationDate = applicationDate;
		this.billing = billing;
	}

	public int getUserId() {
		return userId;
	}

	public double getApplictionPrice() {
		return applictionPrice;
	}

	public int getMembershipDuration() {
		return membershipDuration;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public BillingInformation getBilling() {
		return billing;
	}

}

package ecommercGesture.Dto;

import java.time.LocalDate;
import java.util.Objects;

import ecommercGesture.additionalClass.BillingInformation;

public class MembershipApplication {
	
	private final String name;
	private final String lastName;
	private String password;
	private final double applictionPrice;
	private final int membershipDuration;// in day
	private final LocalDate applicationDate;
	private final BillingInformation billing;
	
	public MembershipApplication(String name, String lastName, String password, double applictionPrice, int membershipDuration, LocalDate applicationDate,
			BillingInformation billing) {
		this.name = Objects.requireNonNull(name,"User name must be not null");
		this.lastName = Objects.requireNonNull(lastName,"User lastname must be not null");
		this.password = Objects.requireNonNull(password,"User password must be not null");
		this.applictionPrice = Objects.requireNonNull(applictionPrice,"Application price must be not null");
		this.membershipDuration = Objects.requireNonNull(membershipDuration,"Membership information must be not null");
		this.applicationDate = Objects.requireNonNull(applicationDate,"Application date must be not null");
		this.billing = Objects.requireNonNull(billing,"Billing information must be not null");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public double getApplictionPrice() {
		return applictionPrice;
	}

	public int getMembershipDuration() {
		return membershipDuration;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public BillingInformation getBilling() {
		return billing;
	}

}

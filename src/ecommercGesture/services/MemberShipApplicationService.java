package ecommercGesture.services;

import java.time.LocalDate;

import ecommercGesture.Dto.MembershipApplication;
import ecommercGesture.additionalClass.BillingInformation;
import ecommercGesture.entities.MembershipEntity;
import ecommercGesture.entities.PaymentEntity;
import ecommercGesture.entities.UserEntity;

public class MemberShipApplicationService {
	
	private final UserService userService;
	private final MembershipService membershipService;
	private final GlobalPaymentService globalPaymentService;
	
	public MemberShipApplicationService(UserService service, MembershipService membershipService,
			GlobalPaymentService globalPaymentService) {
		this.userService = service;
		this.membershipService = membershipService;
		this.globalPaymentService = globalPaymentService;
	}
	
	public void applyForMembership(MembershipApplication userApplication) throws Exception {
		
		UserEntity appliant = userService.getUser(userApplication.getUserId());
		if(hasAppliantCorrectInformation(appliant)) {
			if(processToPayment(userApplication.getBilling(),userApplication.getApplictionPrice())) {
				LocalDate succesTransactionDate = LocalDate.now();
				PaymentEntity newPayment = PaymentEntity.of(0, appliant, userApplication.getApplictionPrice(), succesTransactionDate);
				this.globalPaymentService.addPayment(newPayment);
				MembershipEntity newMember = MembershipEntity.of(0, appliant, succesTransactionDate, getApplicationEndDate(succesTransactionDate,userApplication.getMembershipDuration())); 
				this.membershipService.addMember(newMember);
			}else {
				throw new Exception("Le processus de paiement à échoué");
			}
		}else {
			throw new Exception("Les informations de l'utilisateur sont incomplètes");
		}

	}
	
	private boolean hasAppliantCorrectInformation(UserEntity user) {
		if(userService.userHasValidInformations(user) && !membershipService.isMember(user)) {
			return true;
		}
		return false;
	}
	
	private boolean processToPayment(BillingInformation billing, double transactionPrice) {
		return globalPaymentService.pay(billing,transactionPrice);
	}
	
	private LocalDate getApplicationEndDate(LocalDate chosenDate,int applicationDurationInDay) {
		return chosenDate.plusDays(applicationDurationInDay);
	}
	
}

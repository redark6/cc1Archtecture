package ecommercGesture.services;

import java.time.LocalDate;

import ecommercGesture.Dto.MembershipApplication;
import ecommercGesture.additionalClass.ApplicationResultIds;
import ecommercGesture.additionalClass.BillingInformation;
import ecommercGesture.entities.Member;
import ecommercGesture.entities.PaymentEntity;

public class MembershipApplicationService {
	
	private final MemberService memberService;
	private final GlobalPaymentService globalPaymentService;
	
	public MembershipApplicationService(MemberService memberService, GlobalPaymentService globalPaymentService) {
		this.memberService = memberService;
		this.globalPaymentService = globalPaymentService;
	}
	
	public ApplicationResultIds applyForMembership(MembershipApplication Application) throws Exception {
		LocalDate membershipApplicationDate = LocalDate.now();
		Member appliant = Member.of(memberService.getNextId(), Application.getName(), Application.getLastName(), Application.getPassword(), membershipApplicationDate, getApplicationEndDate(membershipApplicationDate,Application.getMembershipDuration()));
		if(hasAppliantCorrectInformation(appliant)) {
			if(processToPayment(Application.getBilling(),Application.getApplictionPrice())) {
				PaymentEntity newPayment = PaymentEntity.of(globalPaymentService.getNextId(), appliant, Application.getApplictionPrice(), membershipApplicationDate);
				int paymentId = this.globalPaymentService.addPayment(newPayment);
				int memberId = this.memberService.addMember(appliant);
				return ApplicationResultIds.of(memberId, paymentId);
			}else {
				throw new Exception("Le processus de paiement à échoué");
			}
		}else {
			throw new Exception("Les informations de l'utilisateur sont incomplètes");
		}
	}
	
	private boolean hasAppliantCorrectInformation(Member appliant) {
		if(memberService.memberHasValidInformations(appliant)) {
			return true;
		}
		return false;
	}
	
	private boolean processToPayment(BillingInformation billing, double transactionPrice) {
		return globalPaymentService.pay(billing,transactionPrice);
	}
	
	public LocalDate getApplicationEndDate(LocalDate chosenDate,int applicationDurationInDay) {
		return chosenDate.plusDays(applicationDurationInDay);
	}
	
}

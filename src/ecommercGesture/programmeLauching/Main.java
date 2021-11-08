package ecommercGesture.programmeLauching;

import java.time.LocalDate;

import ecommercGesture.Dto.MembershipApplication;
import ecommercGesture.additionalClass.BillingInformation;
import ecommercGesture.defaultRepositoryImplementation.InMemoryMemberRepository;
import ecommercGesture.defaultRepositoryImplementation.InMemoryPaymentRepository;
import ecommercGesture.externalServices.ExternalPaymentService;
import ecommercGesture.repositories.MemberRepository;
import ecommercGesture.repositories.PaymentRepository;
import ecommercGesture.services.GlobalPaymentService;
import ecommercGesture.services.MemberService;
import ecommercGesture.services.MembershipApplicationService;
import ecommercGesture.services.PaymentService;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BillingInformation billing = BillingInformation.of("1545454895432578", "05/25", "458", "chouli redha");
		MembershipApplication application = new MembershipApplication("chouli", "redha", "mypassword", 37.5, 365, LocalDate.now(), billing);
		
		MemberRepository memberRepository = new InMemoryMemberRepository();
		PaymentRepository paymentRepository = new InMemoryPaymentRepository();
		
		PaymentService paymentService = new PaymentService(paymentRepository);
		ExternalPaymentService externalPaymentService = new ExternalPaymentService();
		
		MemberService memberService = new MemberService(memberRepository);
		GlobalPaymentService globalPaymentService = new GlobalPaymentService(paymentService, externalPaymentService);
		
		MembershipApplicationService membershipApplicationService = new MembershipApplicationService(memberService,globalPaymentService);
		
		membershipApplicationService.applyForMembership(application);

	}

}

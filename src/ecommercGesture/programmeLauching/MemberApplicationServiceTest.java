package ecommercGesture.programmeLauching;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import ecommercGesture.Dto.MembershipApplication;
import ecommercGesture.additionalClass.ApplicationResultIds;
import ecommercGesture.additionalClass.BillingInformation;
import ecommercGesture.defaultRepositoryImplementation.InMemoryMemberRepository;
import ecommercGesture.defaultRepositoryImplementation.InMemoryPaymentRepository;
import ecommercGesture.entities.Member;
import ecommercGesture.entities.PaymentEntity;
import ecommercGesture.externalServices.ExternalPaymentService;
import ecommercGesture.repositories.MemberRepository;
import ecommercGesture.repositories.PaymentRepository;
import ecommercGesture.services.GlobalPaymentService;
import ecommercGesture.services.MemberService;
import ecommercGesture.services.MembershipApplicationService;
import ecommercGesture.services.PaymentService;

public class MemberApplicationServiceTest {

	@Test
	public void memberApplication() throws Exception {
		
		BillingInformation billing = BillingInformation.of("1545454895432578", "05/25", "458", "chouli redha");
		MembershipApplication application = new MembershipApplication("redha", "chouli", "mypassword", 37.5, 365, LocalDate.now(), billing);
		
		MemberRepository memberRepository = new InMemoryMemberRepository();
		PaymentRepository paymentRepository = new InMemoryPaymentRepository();
		
		PaymentService paymentService = new PaymentService(paymentRepository);
		ExternalPaymentService externalPaymentService = new ExternalPaymentService();
		
		MemberService memberService = new MemberService(memberRepository);
		GlobalPaymentService globalPaymentService = new GlobalPaymentService(paymentService, externalPaymentService);
		
		MembershipApplicationService membershipApplicationService = new MembershipApplicationService(memberService,globalPaymentService);
		
		final ApplicationResultIds resultId = membershipApplicationService.applyForMembership(application);
		
		final Member storedMember = memberService.getMemberById(resultId.getMemberId());
		final PaymentEntity storedPayment = paymentService.getPayment(resultId.getPaymentId());
		
		Member memberToTest = Member.of(1, application.getName(), application.getLastName(), application.getPassword(), application.getApplicationDate(), membershipApplicationService.getApplicationEndDate(application.getApplicationDate(),application.getMembershipDuration()));
		PaymentEntity paymentToTest = PaymentEntity.of(1, memberToTest, application.getApplictionPrice(), application.getApplicationDate());
		
		assertEquals(memberToTest, storedMember);
		assertEquals(paymentToTest, storedPayment);
		
	}

}

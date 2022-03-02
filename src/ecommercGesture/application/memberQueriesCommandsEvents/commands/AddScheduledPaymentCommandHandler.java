package ecommercGesture.application.memberQueriesCommandsEvents.commands;

import ecommercGesture.application.memberQueriesCommandsEvents.events.AddScheduledPaymentEvent;
import ecommercGesture.domain.objects.BillingInformation;
import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.Payment;
import ecommercGesture.domain.objects.ScheduledPayment;
import ecommercGesture.domain.services.BillingInformationService;
import ecommercGesture.domain.services.GlobalPaymentService;
import ecommercGesture.exposition.memberDTO.PaymentDTO;
import ecommercGesture.exposition.memberDTO.ScheduledPaymentDTO;
import kernel.CommandHandler;
import kernel.Event;
import kernel.EventDispatcher;

public class AddScheduledPaymentCommandHandler implements CommandHandler<AddScheduledPayment, ScheduledPaymentDTO>{

    private final GlobalPaymentService globalPaymentService;
    private final BillingInformationService billingInformationService;
    private final EventDispatcher<Event> eventDispatcher;
    
    public AddScheduledPaymentCommandHandler(GlobalPaymentService globalPaymentService,BillingInformationService billingInformationService, EventDispatcher<Event> eventDispatcher) {
        this.globalPaymentService = globalPaymentService;
        this.billingInformationService = billingInformationService;
    	this.eventDispatcher = eventDispatcher;
    }
    
    public ScheduledPaymentDTO handle(AddScheduledPayment command) {
    	Id paymentId = globalPaymentService.getNextId();
    	Id scheduledPaymentId = globalPaymentService.getNextScheduledPaymentId();
    	BillingInformation billingInformationPayer = billingInformationService.getbillingInformationByUserId(Id.of(command.userPayerId));
    	BillingInformation billingInformationReceiver = billingInformationService.getbillingInformationByUserId(Id.of(command.addPaymentDTO.userReceiverId));
    	ScheduledPayment scheduledPaymentToSave = ScheduledPayment.of(
    			scheduledPaymentId,
    			Id.of(command.addPaymentDTO.userReceiverId),
    			Payment.of(
    					paymentId,Id.of(command.userPayerId),
    					command.addPaymentDTO.transactionPrice,
    					command.addPaymentDTO.paymentDate
    					),
    			billingInformationPayer,
    			billingInformationReceiver,
    			command.addPaymentDTO.paymentDate);
		ScheduledPayment scheduledResponse = globalPaymentService.addScheduledPayment(scheduledPaymentToSave);
		ScheduledPaymentDTO scheduledPayment = ScheduledPaymentDTO.of(
				scheduledResponse.getId().getId(),
				scheduledResponse.getReceiverUserId().getId(),
				PaymentDTO.of(
						scheduledResponse.getPayment().getId().getId(),
						scheduledResponse.getPayment().getMember().getId(),
						scheduledResponse.getPayment().getTransactionPrice(),
						scheduledResponse.getPayment().getPaymentDate()),
				scheduledResponse.getDatePerformPayement()
				);
    	eventDispatcher.dispatch(AddScheduledPaymentEvent.of(scheduledResponse.getId()));
    	return scheduledPayment;
    }
}

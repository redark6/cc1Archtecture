package ecommercGesture.application.memberQueriesCommandsEvents.queries;

import java.util.List;
import java.util.stream.Collectors;

import ecommercGesture.domain.objects.ScheduledPayment;
import ecommercGesture.domain.services.ScheduledPaymentService;
import ecommercGesture.exposition.memberDTO.PaymentDTO;
import ecommercGesture.exposition.memberDTO.ScheduledPaymentDTO;
import ecommercGesture.exposition.memberDTO.ScheduledPaymentsDTO;
import kernel.QueryHandler;

public class RetrieveScheduledPaymentsHandler implements QueryHandler<RetrieveScheduledPayments, ScheduledPaymentsDTO> {

    private final ScheduledPaymentService scheduledPaymentService;

    public RetrieveScheduledPaymentsHandler(ScheduledPaymentService scheduledPaymentService) {
        this.scheduledPaymentService = scheduledPaymentService;
    }
    
    @Override
    public ScheduledPaymentsDTO handle(RetrieveScheduledPayments query) {
    	List<ScheduledPayment> scheduledPayments = scheduledPaymentService.getAll();
    	
    	ScheduledPaymentsDTO membershipsResponseResult = ScheduledPaymentsDTO.of(scheduledPayments.stream()
        		.map(scheduledPayment -> 
        		ScheduledPaymentDTO.of(
        				scheduledPayment.getId().getId(),
        				scheduledPayment.getReceiverUserId().getId(),
        				PaymentDTO.of(
        						scheduledPayment.getPayment().getId().getId(),
        						scheduledPayment.getPayment().getMember().getId(),
        						scheduledPayment.getPayment().getTransactionPrice(),
        						scheduledPayment.getPayment().getPaymentDate()),
        				scheduledPayment.getDatePerformPayement())
        		).collect(Collectors.toList()));
        return membershipsResponseResult;
    }
}

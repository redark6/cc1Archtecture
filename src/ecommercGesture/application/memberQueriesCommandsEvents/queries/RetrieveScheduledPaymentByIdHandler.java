package ecommercGesture.application.memberQueriesCommandsEvents.queries;

import ecommercGesture.domain.objects.Id;
import ecommercGesture.domain.objects.ScheduledPayment;
import ecommercGesture.domain.services.ScheduledPaymentService;
import ecommercGesture.exposition.memberDTO.PaymentDTO;
import ecommercGesture.exposition.memberDTO.ScheduledPaymentDTO;
import kernel.QueryHandler;

public class RetrieveScheduledPaymentByIdHandler implements QueryHandler<RetrieveScheduledPaymentById, ScheduledPaymentDTO> {

    private final ScheduledPaymentService scheduledPaymentService;

    public RetrieveScheduledPaymentByIdHandler(ScheduledPaymentService scheduledPaymentService) {
        this.scheduledPaymentService = scheduledPaymentService;
    }
    
    @Override
    public ScheduledPaymentDTO handle(RetrieveScheduledPaymentById query) {
    	Id scheduledPaymentId = Id.of(query.scheduledPaymentId);
    	ScheduledPayment scheduledPayment = scheduledPaymentService.getScheduledPaymentById(scheduledPaymentId);
    	ScheduledPaymentDTO membershipsResponseResult = ScheduledPaymentDTO.of(
				scheduledPayment.getId().getId(),
				scheduledPayment.getReceiverUserId().getId(),
				PaymentDTO.of(
						scheduledPayment.getPayment().getId().getId(),
						scheduledPayment.getPayment().getMember().getId(),
						scheduledPayment.getPayment().getTransactionPrice(),
						scheduledPayment.getPayment().getPaymentDate()),
				scheduledPayment.getDatePerformPayement());
        return membershipsResponseResult;
    }
}

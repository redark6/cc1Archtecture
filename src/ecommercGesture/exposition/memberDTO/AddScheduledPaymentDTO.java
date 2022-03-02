package ecommercGesture.exposition.memberDTO;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class AddScheduledPaymentDTO {
	
    @NotNull
	public int userReceiverId;
    
    @NotNull
    public LocalDate paymentDate;
    
    @NotNull
    public double transactionPrice;
	
}

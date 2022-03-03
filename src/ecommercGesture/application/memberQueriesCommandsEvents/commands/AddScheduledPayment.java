package ecommercGesture.application.memberQueriesCommandsEvents.commands;

import ecommercGesture.exposition.memberDTO.AddScheduledPaymentDTO;
import kernel.Command;

public class AddScheduledPayment implements Command {
	
	public final AddScheduledPaymentDTO addPaymentDTO;
	public final int userPayerId;
	
	public AddScheduledPayment(AddScheduledPaymentDTO addPaymentDTO, int userPayerId) {
		this.addPaymentDTO = addPaymentDTO;
		this.userPayerId = userPayerId;
	}
	
}

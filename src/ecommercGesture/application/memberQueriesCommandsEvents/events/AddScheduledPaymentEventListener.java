package ecommercGesture.application.memberQueriesCommandsEvents.events;

import kernel.EventListener;

public class AddScheduledPaymentEventListener implements EventListener<AddScheduledPaymentEvent> {
	
    @Override
    public void listenTo(AddScheduledPaymentEvent event) {
        System.out.println("listening AddScheduledPaymentEvent.");
    }

}

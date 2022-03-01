package ecommercGesture.application.projectQueriesCommandsEvent.events;

import kernel.EventListener;

public class RemoveProjectWorkerEventListener implements EventListener<RemoveProjectWorkerEvent>{

    @Override
    public void listenTo(RemoveProjectWorkerEvent event) {
        System.out.println("listening RemoveProjectWorkerEvent.");
    }
}

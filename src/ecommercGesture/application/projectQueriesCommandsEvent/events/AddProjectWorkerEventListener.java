package ecommercGesture.application.projectQueriesCommandsEvent.events;

import kernel.EventListener;

public class AddProjectWorkerEventListener implements EventListener<AddProjectWorkerEvent>{

    @Override
    public void listenTo(AddProjectWorkerEvent event) {
        System.out.println("listening AddProjectWorkerEvent.");
    }
}

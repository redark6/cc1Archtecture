package ecommercGesture.application.projectQueriesCommandsEvent.events;

import kernel.EventListener;

public class CreateProjectEventListener implements EventListener<CreateProjectEvent>{

    @Override
    public void listenTo(CreateProjectEvent event) {
        System.out.println("listening CreateProjectEvent.");
    }
}

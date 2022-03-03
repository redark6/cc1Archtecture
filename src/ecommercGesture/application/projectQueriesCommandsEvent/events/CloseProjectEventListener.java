package ecommercGesture.application.projectQueriesCommandsEvent.events;

import kernel.EventListener;

public class CloseProjectEventListener implements EventListener<CloseProjectEvent>{

    @Override
    public void listenTo(CloseProjectEvent event) {
        System.out.println("listening CloseProjectEvent.");
    }

}

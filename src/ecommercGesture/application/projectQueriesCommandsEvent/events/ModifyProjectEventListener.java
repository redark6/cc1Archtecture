package ecommercGesture.application.projectQueriesCommandsEvent.events;

import kernel.EventListener;

public class ModifyProjectEventListener implements EventListener<ModifyProjectEvent>{

    @Override
    public void listenTo(ModifyProjectEvent event) {
        System.out.println("listening ModifyProjectEvent.");
    }
}

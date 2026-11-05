package Facade;

import Profile.Profile;
import UI_Format.UILayout;

public class BookingCoordinator implements BookingMediator {
    private Profile profile;

    // This is the constructor Main.java is looking for:
    public BookingCoordinator(Profile profile) {
        this.profile = profile;
    }

    @Override
    public void notify(Object sender, String eventType) {
        if ("PROFILE_UPDATED".equals(eventType)) {
            System.out.println("[Mediator] Profile change detected. Synchronizing subsystems...");
            
            if ("Spanish".equalsIgnoreCase(profile.getNationality())) {
                UILayout.getInstance().setLanguage("SP");
                System.out.println("[Mediator] -> Nationality is Spanish. UI language automatically set to: SP");
            } else {
                UILayout.getInstance().setLanguage("EN");
                System.out.println("[Mediator] -> Nationality is International. UI language automatically set to: EN");
            }
        }
    }
}
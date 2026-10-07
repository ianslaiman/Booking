package UI_Format;

public class App {
    public static void main(String[] args) {
        System.out.println("=== INITIAL CONFIGURATION ===");
        new UILayout.ScreenHome().display();

        System.out.println("\n=== RENDERING FORMS ===");
        MobileForm mobileForm = new MobileForm();
        mobileForm.display();

        DesktopForm desktopForm = new DesktopForm();
        desktopForm.display();

        System.out.println("\n=== UPDATING GLOBAL LAYOUT ===");
        UILayout ui = UILayout.getInstance();
        ui.setLanguage("ES");
        ui.setFontSize(14);
        ui.setTextColor("#FFFFFF");

        System.out.println("\n=== RE-RENDERING FORMS WITH NEW SETTINGS ===");
        mobileForm.display();
        desktopForm.display();
        
    }
}
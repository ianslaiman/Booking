package UI_Format;

public class UILayout {
    private static UILayout instance;
    // General UI
    private String BackgroundColor; // Hex Number
    // Text
    private String language;
    private Integer FontSize;
    private String TextColor;

    private UILayout() {
        this.BackgroundColor = "#12239E";
        this.language = "EN";
        this.FontSize = 20;
        this.TextColor = "#000000";
    }

    public static UILayout getInstance(){
        if (instance == null) {
            instance = new UILayout();
        }
        return instance;
    }

    // Getters
    public String getBackgroundColor(){
        return BackgroundColor;
    }
    public String getLanguage(){
        return language;
    }
    public  Integer getFontSize(){
        return FontSize;
    }
    public  String getTextColor(){
        return TextColor;
    }

    // Setters
    public void setBackgroundColor(String BackgroundColor){
        this.BackgroundColor = BackgroundColor;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public void setFontSize(int FontSize){
        this.FontSize = FontSize;
    }
    public void setTextColor(String TextColor){
        this.TextColor = TextColor;
    }

    public static class ScreenHome{
        public void display(){
            UILayout UI = UILayout.getInstance();
            System.out.println("ScreenHome.  BackgroundColor: " + UI.getBackgroundColor() + " Language: " + UI.getLanguage() + " Fontsize: " + UI.getFontSize() + " TextColor: " + UI.getTextColor());
        }
    }

    public static class ScreenSettings{
        public void display(){
            UILayout UI = UILayout.getInstance();
            System.out.println("ScreenSettings. BackgroundColor: " + UI.BackgroundColor + " Language: " + UI.getLanguage() + " Fontsize: " + UI.getFontSize() + " TextColor: " + UI.getTextColor());
        }
    }

    public static void main(String[] args) {
        new ScreenHome().display();
        new ScreenSettings().display();
        System.out.println();
        UILayout UI = UILayout.getInstance();
        UI.setLanguage("SP");
        UI.setFontSize(16);
        UI.setBackgroundColor("#597C");
        UI.setTextColor("#111111");

        new ScreenHome().display();
        new ScreenSettings().display();
    }
    
    
}

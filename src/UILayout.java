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

    private static UILayout getInstance(){
        if (instance == null) {
            instance = new UILayout();
        }
        return instance;
    }

    // Getters
    private String getBackgroundColor(){
        return BackgroundColor;
    }
    private String getLanguage(){
        return language;
    }
    private  Integer getFontSize(){
        return FontSize;
    }
    private  String getTextColor(){
        return TextColor;
    }

    // Setters
    private void setBackgroundColor(String BackgroundColor){
        this.BackgroundColor = BackgroundColor;
    }
    private void setLanguage(String language){
        this.language = language;
    }
    private void setFontSize(int FontSize){
        this.FontSize = FontSize;
    }
    private void setTextColor(String TextColor){
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
        UILayout UI = UILayout.getInstance();
        UI.setLanguage("SP");
        UI.setFontSize(16);
        UI.setBackgroundColor("#597C");
        UI.setTextColor("#111111");

        new ScreenHome().display();
        new ScreenSettings().display();
    }
    
    
}

package UI_Format;

public class DesktopTextField implements TextField {
    @Override
    public void display(){
        UILayout ui = UILayout.getInstance();
        System.out.println("[DESKTOP Text Field] Rendered with font size " 
            + ui.getFontSize() + " and text color " + ui.getTextColor());
    }
    
}

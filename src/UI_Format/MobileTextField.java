package UI_Format;

public class MobileTextField implements TextField {
    @Override 
    public void display(){
        UILayout ui = UILayout.getInstance();
        System.out.println("[MOBILE Text Field] Rendered with font size " 
            + ui.getFontSize() + " and text color " + ui.getTextColor());
    }
}

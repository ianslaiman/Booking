package UI_Format;

public abstract class Form {
    public abstract TextField createTextField();
    void display(){
        TextField tf = createTextField();
        tf.display();
    }
}

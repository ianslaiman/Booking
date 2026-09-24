class MainUIManager{
       public static MainUIManager instance;
       public String option = "MENU";

     
       public static MainUIManager getInstance(){
	       if (instance == null){
		       instance = new MainUIManager(); 
	       }
	       return instance;
       }

       public void setOption(String option){
	       this.option = option;
       }

       public String getOption(){
	       return option;
       }       
}

class SelectionChoice {
	public void display() {
		MainUIManager manager = MainUIManager.getInstance();
		System.out.println("Current Option Selected: " + manager.getOption());
	}
}

public class MainUI{
	public static void main(String[] args)
	{
		MainUIManager manager = MainUIManager.getInstance();
		
		new SelectionChoice().display();
	}
} 

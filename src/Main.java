import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args){
		
		//DEN YLOPOIITHIKE H DYNATOTHTA MULTI-PLAYER
		
		ScreenSize sc = ScreenSize.getInstance();
		
		int height = sc.getHeight(); //Checks the user's screen size
		int width = sc.getWidth();
        
        if (height < 700 || width < 800) //This game is optimized for monitors bigger than 800x600
        	JOptionPane.showMessageDialog(null, "Screen size not supported!", "Error!", JOptionPane.ERROR_MESSAGE);
        else
        	new MainMenu();
		
	}
}
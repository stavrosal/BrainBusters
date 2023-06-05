import java.awt.Dimension;
import java.awt.Toolkit;

class ScreenSize {
	 private static ScreenSize single_instance = null; //Singleton class to get the user's screen resolution

	 private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	 public int width;
	 public int height;
	 

	 private ScreenSize() {
		 this.width = (int) screenSize.getWidth();
		 
		 this.height = (int) screenSize.getHeight();
	 }
	 
	 
	 public static synchronized ScreenSize getInstance() {
	       if (single_instance == null)
	           single_instance = new ScreenSize();
	  
	       return single_instance;
	 }
	 
	 public int getWidth() {
		 return this.width;
	 }
	 
	 public int getHeight() {
		 return this.height;
	 }

}



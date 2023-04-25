//import java.io.*;

public class Player {
	private String name;
	private int correct_answers;
	private int wrong_answers;
	private float win_rate;
	
	public Player(String name, int correct, int wrong) {
		this.name = name;
		this.correct_answers = correct;
		this.wrong_answers = wrong;
		if (wrong_answers != 0)
			win_rate = correct_answers / wrong_answers;
		else
			win_rate = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCorrect() {
		return correct_answers;
	}
	
	public int getWrong() {
		return wrong_answers;
	}
	
	public float getWinRate() {
		return win_rate;
	}
	
	
	
	/*public void saveStats() {
		try {
			FileOutputStream player = new FileOutputStream(name + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(player);
			out.writeObject(this);
			out.close();
		} catch (IOException e) {
			System.out.println("An error occured while trying to write to the file");
			e.printStackTrace();
		}	
	}*/	
	
}

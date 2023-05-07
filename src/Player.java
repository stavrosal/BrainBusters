import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

//import java.io.*;

public class Player implements Serializable{
	private String name;
	private int correct_answers;
	private int wrong_answers;
	private double win_rate;
	
	public Player(String name, int correct, int wrong) {
		this.name = name;
		this.correct_answers = correct;
		this.wrong_answers = wrong;
		if (wrong_answers != 0)
			win_rate = (double) correct_answers / wrong_answers; //convert one of them to double so the result will be also double
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
	
	public double getWinRate() {
		return win_rate;
	}
	
	
	
	public void saveStats() {
		try {
			FileOutputStream player = new FileOutputStream("players/"+ name + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(player);
			out.writeObject(this);
			out.close();
		} catch (IOException e) {
			System.out.println("An error occured while trying to write to the file");
			e.printStackTrace();
		}	
	}
	
	
}

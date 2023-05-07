import java.io.*;
import java.util.ArrayList;

public class Main implements Serializable{
	public static void main(String[] args) throws IOException{
		ArrayList<Question> questions = new ArrayList<Question>();
		String link = "https://www.quiztriviagames.com/multiple-choice-trivia-questions/";
		
		Scrape test = new Scrape(link, questions);
		test.ScrapeQuestions();
		
		/*Registry reg = new Registry("local");
		//reg.addPlayer(new Player("Stavros", 0, 1));
		ArrayList<Player> p = reg.fetchPlayers();
		
		for (Player pl : p)
			System.out.println(pl.getName());*/
		

		new MainMenu();
	}
}

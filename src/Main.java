import java.io.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException{
		ArrayList<Question> questions = new ArrayList<Question>();
		String link = "https://www.quiztriviagames.com/multiple-choice-trivia-questions/";
		
		Scrape test = new Scrape(link, questions);
		test.ScrapeQuestions();
		
		new MainMenu();
	}
}

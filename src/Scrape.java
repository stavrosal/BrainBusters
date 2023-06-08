import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Scrape {
	private String link;
	private ArrayList<Question> questions;
	private Document doc;
	
	public Scrape(String link, ArrayList<Question> questions) {
		this.link = link;
		this.questions = questions;
	}
	
	public void ScrapeQuestions() throws IOException{
		doc = Jsoup.connect(link).timeout(6000).get();
		Elements body = doc.select("div.entry-content.single-page");
		
		//System.out.println(body.select("ol").size());  --FOR TESTING PURPOSES
		
		String q;
		for (Element e : body.select("li")) {
			q = e.ownText().strip();
			if (e.childrenSize() > 0 && e.child(0).normalName().equals("ol")) {
				
				//System.out.println(q); --FOR TESTING PURPOSES
			
				ArrayList<String> temp = new ArrayList<String>();
				for (Element child : e.child(0).children()) {
					temp.add(child.text());
				}
				
				String ans = null;
				for (Element tag : doc.select("strong")) {
					if (tag.parent().normalName().equals("li") && 
					!(tag.text().equals("the best quizzes for the ultimate trivia night!"))) {
						for (String s : temp) {
							String temp_ans = s.replaceAll("\\s", "").toUpperCase(); //Makes all upper-case and strip whitespaces to avoid any mismatch 
							if (temp_ans.equals(tag.text().toUpperCase().replaceAll("\\s", ""))) { //With the website's answer
								ans = s;
								break;
							}
						}
					}
				}
				
				questions.add(new Question(q, temp, ans)); //Creates and adds a new object to the ArrayList
				
				/*      ---FOR TESTING PURPOSES---
				
				for (Question x : questions)
					x.printQuestions();   */
			}
			
			
		}
	}
}

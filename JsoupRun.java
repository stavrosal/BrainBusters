import java.io.*;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.opencsv.CSVWriter;

public class JsoupRun{
	/*public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://www.imdb.com/chart/top").timeout(6000).get();
		Elements body = doc.select("tbody.lister-list");
		
		System.out.println("Movies: " + body.select("tr").size() + "\n");
		
		for (Element e : body.select("tr"))
		{
			String title = e.select("td.posterColumn img").attr("alt");
			String year = e.select("td.titleColumn span.secondaryInfo").text();
			String rate = e.select("td.ratingColumn.imdbRating").text().trim();
			System.out.println(title + " " + year + " " + rate);
		}
	}*/
	
	//https://www.mentimeter.com/blog/audience-energizers/55-free-trivia-and-fun-quiz-question-templates#sports
	
	//https://jsoup.org/apidocs/org/jsoup/nodes/Element.html
	public static void main(String[] args) throws IOException{
		//Document doc = Jsoup.connect("https://www.ultimatequizquestions.com/multiple-choice-trivia-questions/") // <---- to site
		//		.timeout(6000).get();
		Document doc = Jsoup.connect("https://www.quiztriviagames.com/multiple-choice-trivia-questions/")
				.timeout(6000).get();
		Elements body = doc.select("div.entry-content.single-page");
		
		System.out.println(body.select("li").size());
	
		try {
			FileWriter file = new FileWriter("test.csv"); //DONT FORGET TO CLOSE THE FILE <-----------
			//Create CSV Writer
			CSVWriter writer = new CSVWriter(file);
			//Set the header of the file
			String[] header = {"Question", "Answers"};
			writer.writeNext(header);
			String[] h = {"Hello", "How are you"}
			writer.writeNext(h);
			

		
		
			//Find the answers (they are in <strong> tags in the web page)
			ArrayList<String> CorrectAnswers = new ArrayList<String>();
			for (Element tag : doc.getElementsByTag("strong")) { //Contains some tags that are not related with the questions
				CorrectAnswers.add(tag.text() );
				//file.write(tag.text() + "\n");
			}
			writer.writeAll(CorrectAnswers.iterator());
	
			String temp;
			for (Element e : body.select("li")) {
				temp = e.wholeOwnText().strip();
				
				if (temp.endsWith("?")) {
					System.out.println(temp);
					for (Element child : e.child(0).children()) {
						System.out.println("   " + child.text());
						
					}
				}
				
				
			}
			file.close();
	
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

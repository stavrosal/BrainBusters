import java.awt.Font;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SingleGame extends JFrame{
	private JPanel panel = new JPanel(new FlowLayout());
	private JLabel lab = new JLabel();
	
	public SingleGame() throws IOException {
		ArrayList<Question> questions = new ArrayList<Question>();
		String link = "https://www.quiztriviagames.com/multiple-choice-trivia-questions/";
		
		Scrape test = new Scrape(link, questions);
		test.ScrapeQuestions();
		
		//lab.setBounds(100, 50, 500, 50);
		lab.setFont(new Font("Calibri", Font.BOLD, 30));
		panel.add(lab);
		
		for(Question q : questions)
			lab.setText(q.getQuestion());
		
		
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(1000, 800);
		this.setTitle("BrainBusters");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

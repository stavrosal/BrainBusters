import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SingleGame extends JFrame{
	private JPanel mainpanel = new JPanel();
	private JPanel questionp = new JPanel(new FlowLayout());
	private JPanel ansp1 = new JPanel();
	private JPanel ansp2 = new JPanel();
	private JPanel quitPanel = new JPanel();
	private JLabel correctAns = new JLabel();
	private JLabel lab = new JLabel();
	private JLabel lab2 = new JLabel();
	private JLabel points = new JLabel();
	private JButton option1 = new JButton();
	private JButton option2 = new JButton();
	private JButton option3 = new JButton();
	private JButton option4 = new JButton();
	private JButton quit = new JButton();
	private ImageIcon icon;
	private String link;
	private String quiz_name;
	private int total_points;
			
	
	public SingleGame(String quiz_name, String link, int count, int corr, int wrong, int total_points) throws IOException {
		this.quiz_name = quiz_name;
		this.link = link;
		this.total_points = total_points;
		ArrayList<Question> questions = new ArrayList<Question>();
		
		Scrape test = new Scrape(link, questions);
		test.ScrapeQuestions();
		
		Border grayline = BorderFactory.createLineBorder(Color.gray);
		questionp.setBorder(grayline);
			
		
		option1.setPreferredSize(new Dimension(400, 150));
		option2.setPreferredSize(new Dimension(400, 150));
		option3.setPreferredSize(new Dimension(400, 150));
		option4.setPreferredSize(new Dimension(400, 150));
		quit.setMaximumSize(new Dimension(300, 200));
		
		
		lab.setFont(new Font("Calibri", Font.BOLD, 30));
		lab2.setFont(new Font("Calibri", Font.BOLD, 50));
		points.setFont(new Font("Calibri", Font.BOLD, 40));
		correctAns.setFont(new Font("Calibri", Font.BOLD, 30));
		
		
		questionp.add(lab);
		ansp1.add(option1);
		ansp1.add(option2);
		ansp2.add(option3);
		ansp2.add(option4);
		
		quit.setText("QUIT");
		quit.setAlignmentX(Component.CENTER_ALIGNMENT); //Center the labels and the button
		lab2.setAlignmentX(Component.CENTER_ALIGNMENT);
		points.setAlignmentX(Component.CENTER_ALIGNMENT);
		correctAns.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		quitPanel.add(lab2);
		quitPanel.add(points);
		quitPanel.add(correctAns); //label which will show the correct answer (triggered by button press)
		quitPanel.add(Box.createVerticalGlue()); //this will make some distance between the corr/wrong label and the quit button
		quitPanel.add(quit);
		quitPanel.setLayout(new BoxLayout(quitPanel, BoxLayout.PAGE_AXIS));
		
	
		Question q = questions.get(count);
		
		
		lab.setText(q.getQuestion());
			
		ArrayList<String> answers = q.getAnswers();
			
		option1.setText(answers.get(0));
		option2.setText(answers.get(1));
		option3.setText(answers.get(2));
		option4.setText(answers.get(3));
				
		
		
		
		
		ButtonListener listener = new ButtonListener(q.getCorrectAnswer(), count, questions.size(), this, corr, wrong); //passing the stats to the next window
		option1.addActionListener(listener);
		option2.addActionListener(listener);
		option3.addActionListener(listener);
		option4.addActionListener(listener);
		quit.addActionListener(listener);
		
		
		java.net.URL imgURL = getClass().getResource("images/logo.png");

		icon = new ImageIcon(imgURL);
		setIconImage(icon.getImage());
		
		mainpanel.add(questionp);
		mainpanel.add(ansp1);
		mainpanel.add(ansp2);
		mainpanel.add(quitPanel);
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.PAGE_AXIS));
		
		this.setContentPane(mainpanel);
		
		ScreenSize sc = ScreenSize.getInstance();

        int width = sc.getWidth() - 100 ;

        int height = sc.getHeight() - 100;
           

		this.setVisible(true);
		this.setSize(width, height);
		this.setTitle("BrainBusters");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Prompts the user to use the QUIT button by disabling the X button on the upper right side
	
	}
	
	class ButtonListener implements ActionListener{
		private String correct;
		private int count;
		private SingleGame window;
		private int corr;
		private int wrong;
		private int max; //the number of questions in total
		
		private boolean check_answer;

		
		public ButtonListener(String correct, int count, int max, SingleGame window, int corr, int wrong) {
			this.correct = correct;
			this.count = count;
			this.max = max;
			this.window = window;
			this.corr = corr;
			this.wrong = wrong;
		}
		
		public void DisableButtons() { //A function to disable the panel's button so the user won't double-click
			window.option1.setEnabled(false);
			window.option2.setEnabled(false);
			window.option3.setEnabled(false);
			window.option4.setEnabled(false);
			window.quit.setEnabled(false);
		}
		
		public void actionPerformed(ActionEvent e) {
			String ans = ((JButton) e.getSource()).getText();
			
			
			ActionListener listen = new ActionListener() { //Listener for the timer, it opens a new window for the question
				@Override                                  //and closes the old one
				public void actionPerformed(ActionEvent e) {
					window.dispose();
					try {
						if (count+1 < max)
							
							new SingleGame(SingleGame.this.quiz_name, SingleGame.this.link, count+1, corr, wrong, SingleGame.this.total_points);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			};
			
			Timer timer = new Timer(1800, listen); //Creates the timer with 1.5 second wait
			timer.setRepeats(false); //Makes the timer execute only once
				
			
			if (e.getSource() == option1) {
				DisableButtons();
				timer.start();
				if (ans.equals(correct)) {
					window.lab2.setForeground(Color.GREEN);
					window.lab2.setText("\nCORRECT!");
					check_answer = true;
					corr++;
				}
				else {
					lab2.setForeground(Color.RED);
					window.lab2.setText("WRONG!");	
					window.correctAns.setText("Correct Answer: " + correct);
					if (correct != null) //We check if the answer is null (that means that the scraper couldn't find the answer) so we don't count that question
						check_answer = false;
						wrong++;
				}
			}
				
			if (e.getSource() == option2) {
				DisableButtons();
				timer.start();
				if (ans.equals(correct)) {
					window.lab2.setForeground(Color.GREEN);
					window.lab2.setText("\nCORRECT!");
					check_answer = true;
					corr++;
				}
				else {
					lab2.setForeground(Color.RED);
					window.lab2.setText("WRONG!");	
					window.correctAns.setText("Correct Answer: " + correct);
					if (correct != null)
						check_answer = false;
						wrong++;
				}
			}
				
			if (e.getSource() == option3) {
				DisableButtons();
				timer.start();
				if (ans.equals(correct)) {
					window.lab2.setForeground(Color.GREEN);
					window.lab2.setText("\nCORRECT!");
					check_answer = true;
					corr++;
				}
				else {
					lab2.setForeground(Color.RED);
					window.lab2.setText("WRONG!");	
					window.correctAns.setText("Correct Answer: " + correct);
					if (correct != null)
						check_answer = false;
						wrong++;
				}
			}
				
			if (e.getSource() == option4) {
				DisableButtons();
				timer.start();
				if (ans.equals(correct)) {
					window.lab2.setForeground(Color.GREEN);
					window.lab2.setText("\nCORRECT!");
					check_answer = true;
					corr++;
				}
				else {
					lab2.setForeground(Color.RED);
					window.lab2.setText("WRONG!");	
					window.correctAns.setText("Correct Answer: " + correct);
					if (correct != null)
						check_answer = false;
						wrong++;
				}
					
			}
			if (e.getSource() == quit || count+1 == max) {
				new EnterName(SingleGame.this.quiz_name, corr, wrong, total_points);
				window.dispose();
			}
			total_points = calculatePoints(check_answer, total_points);
			
			window.points.setForeground(Color.BLUE);

	
			window.points.setText("Total points: " + String.valueOf(total_points));

			
		}
	}
	
	public int calculatePoints(boolean check_answer, int total_points) {
		if (check_answer) {
	  		return total_points = total_points + 20;
		}
		else {
			return total_points; 
		}
	}
	
	
}
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SingleGame extends JFrame{
	private JPanel mainpanel = new JPanel();
	private JPanel questionp = new JPanel(new FlowLayout());
	private JPanel ansp1 = new JPanel(new FlowLayout());
	private JPanel ansp2 = new JPanel(new FlowLayout());
	private JPanel quitPanel = new JPanel();
	private JLabel lab = new JLabel();
	private JLabel lab2 = new JLabel();
	private JButton option1 = new JButton();
	private JButton option2 = new JButton();
	private JButton option3 = new JButton();
	private JButton option4 = new JButton();
	private JButton quit = new JButton();
	private ImageIcon icon;
			
	
	public SingleGame(int count, int corr, int wrong) throws IOException {

		
		ArrayList<Question> questions = new ArrayList<Question>();
		String link = "https://www.quiztriviagames.com/multiple-choice-trivia-questions/";
		
		Scrape test = new Scrape(link, questions);
		test.ScrapeQuestions();
		
		Border grayline = BorderFactory.createLineBorder(Color.gray);
		questionp.setBorder(grayline);
			
		
		option1.setPreferredSize(new Dimension(400, 50));
		option2.setPreferredSize(new Dimension(400, 50));
		option3.setPreferredSize(new Dimension(400, 50));
		option4.setPreferredSize(new Dimension(400, 50));
		quit.setPreferredSize(new Dimension(200, 50));
		
		
		lab.setFont(new Font("Calibri", Font.BOLD, 30));
		lab2.setFont(new Font("Calibri", Font.BOLD, 50));
		
		questionp.add(lab);
		ansp1.add(option1);
		ansp1.add(option2);
		ansp2.add(option3);
		ansp2.add(option4);
		
		quitPanel.add(lab2);
		quitPanel.add(quit);
		
		
		

		Question q = questions.get(count);
		lab.setText(q.getQuestion());
			
		ArrayList<String> answers = q.getAnswers();
			
		option1.setText(answers.get(0));
		option2.setText(answers.get(1));
		option3.setText(answers.get(2));
		option4.setText(answers.get(3));
		quit.setText("QUIT");
		
		ButtonListener listener = new ButtonListener(q.getCorrectAnswer(), count, this, corr, wrong);
		option1.addActionListener(listener);
		option2.addActionListener(listener);
		option3.addActionListener(listener);
		option4.addActionListener(listener);
		quit.addActionListener(listener);
		
		
		icon = new ImageIcon("logo.png");
		setIconImage(icon.getImage());
		
		mainpanel.add(questionp);
		mainpanel.add(ansp1);
		mainpanel.add(ansp2);
		mainpanel.add(quitPanel);
		
		
		
		
		this.setContentPane(mainpanel);

		this.setVisible(true);
		this.setSize(1000, 800);
		this.setTitle("BrainBusters");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	class ButtonListener implements ActionListener{
		private String correct;
		private int count;
		private SingleGame window;
		private int corr;
		private int wrong;
		
		public ButtonListener(String correct, int count, SingleGame window, int corr, int wrong) {
			this.correct = correct;
			this.count = count;
			this.window = window;
			this.corr = corr;
			this.wrong = wrong;
		}
		
		public void actionPerformed(ActionEvent e) {
			String ans = ((JButton) e.getSource()).getText();

			
			if (e.getSource() == option1) {
				if (ans.equals(correct)) {
					window.lab2.setForeground(Color.GREEN);
					window.lab2.setText("\nCORRECT!");
					corr++;
				}
				else {
					lab2.setForeground(Color.RED);
					window.lab2.setText("WRONG!");	
					wrong++;
				}
				try {
					//window.dispose();
					new SingleGame(count+1, corr, wrong);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if (e.getSource() == option2) {
				if (ans.equals(correct)) {
					window.lab2.setForeground(Color.GREEN);
					window.lab2.setText("\nCORRECT!");
				}
				else {
					lab2.setForeground(Color.RED);
					window.lab2.setText("WRONG!");
					try {
						//window.dispose();
						new SingleGame(count+1, corr, wrong);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			if (e.getSource() == option3) {
				if (ans.equals(correct)) {
					window.lab2.setForeground(Color.GREEN);
					window.lab2.setText("\nCORRECT!");
				}
				else {
					lab2.setForeground(Color.RED);
					window.lab2.setText("WRONG!");
					try {
						//window.dispose();
						new SingleGame(count+1, corr, wrong);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			if (e.getSource() == option4) {
				if (ans.equals(correct)) {
					window.lab2.setForeground(Color.GREEN);
					window.lab2.setText("\nCORRECT!");
				}
				else {
					lab2.setForeground(Color.RED);
					window.lab2.setText("WRONG!");
					try {
						//window.dispose();
						new SingleGame(count+1, corr, wrong);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			if (e.getSource() == quit) {
				new EnterName(corr, wrong);
				window.dispose();
			}
		}
	}
	
}

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
	private JPanel showRes = new JPanel();
	private JPanel quitPanel = new JPanel(new FlowLayout());
	private JLabel lab = new JLabel();
	private JLabel lab2 = new JLabel();
	private JButton option1 = new JButton();
	private JButton option2 = new JButton();
	private JButton option3 = new JButton();
	private JButton option4 = new JButton();
	private JButton quit = new JButton();
	private ImageIcon icon;
	
	
	private int count;
	
	
	public SingleGame(int count) throws IOException {
		this.count = count;
		ArrayList<Question> questions = new ArrayList<Question>();
		String link = "https://www.quiztriviagames.com/multiple-choice-trivia-questions/";
		
		Scrape test = new Scrape(link, questions);
		test.ScrapeQuestions();
		
		Border grayline = BorderFactory.createLineBorder(Color.gray);
		questionp.setBorder(grayline);
		
		showRes.setLayout(new BoxLayout(showRes, BoxLayout.Y_AXIS));
		
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
		showRes.add(lab2);
		quitPanel.add(quit);
		
		

		Question q = questions.get(count);
		lab.setText(q.getQuestion());
			
		ArrayList<String> answers = q.getAnswers();
			
		option1.setText(answers.get(0));
		option2.setText(answers.get(1));
		option3.setText(answers.get(2));
		option4.setText(answers.get(3));
		quit.setText("QUIT");
		
		ButtonListener listener = new ButtonListener(q.getCorrectAnswer(), count, this);
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
		mainpanel.add(showRes);
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
		
		public ButtonListener(String correct, int count, SingleGame window) {
			this.correct = correct;
			this.count = count;
			this.window = window;
		}
		
		public void actionPerformed(ActionEvent e) {
			String ans = ((JButton) e.getSource()).getText();
			
			if (e.getSource() == option1) {
				if (ans.equals(correct)) {
					window.lab2.setForeground(Color.GREEN);
					window.lab2.setText("\nCORRECT!");
				}
				else {
					lab2.setForeground(Color.RED);
					window.lab2.setText("WRONG!");
					try {
						//window.dispose();
						new SingleGame(count+1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
						new SingleGame(count+1);
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
						new SingleGame(count+1);
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
						new SingleGame(count+1);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			if (e.getSource() == quit) {
				window.dispose();
			}
		}
	}
	
}

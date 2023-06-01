import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;


import javax.swing.*;

public class MainMenu extends JFrame {
	private JPanel panel = new JPanel(null);
	private JLabel name = new JLabel("BrainBusters");
	private JButton play = new JButton("Play");
	private JButton stats = new JButton("Stats");
	private JButton credits = new JButton("Credits");
	private JButton quit = new JButton("Quit");
	private JLabel img = new JLabel();
	private ImageIcon icon;
	
	public MainMenu() {
		play.setBounds(400, 350, 150, 50);
		stats.setBounds(400, 450, 150, 50);
		credits.setBounds(400, 550, 150, 50);
		quit.setBounds(400, 650, 150, 50);
		name.setBounds(380, 250, 350, 50);
		name.setFont(new Font("Calibri", Font.BOLD, 40));
		
		img.setBounds(380, 25, 200, 179);
		
//		icon = new ImageIcon("logo.png");
//		setIconImage(icon.getImage());
//		
//		ImageIcon logo = new ImageIcon("logo.png");
//		img.setIcon(logo);
		
		java.net.URL imgURL = getClass().getResource("images/logo.png");

		//icon = new ImageIcon("logo.png");
		icon = new ImageIcon(imgURL);
		setIconImage(icon.getImage());
		
		ImageIcon logo = new ImageIcon(imgURL);
		img.setIcon(logo);
		 
		panel.add(img);
		panel.add(name);
		panel.add(play);
		panel.add(stats);
		panel.add(credits);
		panel.add(quit);
		
		ButtonListener listener = new ButtonListener();
		play.addActionListener(listener);
		stats.addActionListener(listener);
		credits.addActionListener(listener);
		quit.addActionListener(listener);
		
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(1000, 800);
		this.setTitle("BrainBusters");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String[] SelectQuiz(){
		HashMap<String, String> choices = new HashMap<String, String>();
		choices.put("Food Quiz", "https://www.quiztriviagames.com/food-trivia-multiple-choice-questions/"); 
		choices.put("Trivia Quiz", "https://www.quiztriviagames.com/multiple-choice-trivia-questions/");		
		choices.put("History Quiz", "https://www.quiztriviagames.com/history-multiple-choice-questions/");
		choices.put("Thanksgiving Quiz", "https://www.quiztriviagames.com/thanksgiving-multiple-choice-questions/");
		choices.put("Family Quiz", "https://www.quiztriviagames.com/family-quiz/");
		
		
		/* ADD HERE NEW QUIZES 
		DONT FORGET TO ADD THE NAME TO THE names ARRAY TOO! */
		

		String[] names = {"Food Quiz", "Trivia Quiz", "History Quiz", "Thanksgiving Quiz", "Family Quiz"};
		
		String option = (String) JOptionPane.showInputDialog(null, "Select a Quiz", "Select", JOptionPane.PLAIN_MESSAGE, null, names, names[0]);
		
		String[] temp = {option, choices.get(option)};
		
		return temp; //Returns the quiz name and the link (they are needed in the SingleGame class)
	}
	
		class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == play) {
					try {
						String[] choice = SelectQuiz();
						
	 					if (choice[0] != null)
							new SingleGame(choice[0], choice[1], 0, 0, 0, 0);
	 					
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else if (e.getSource() == stats) {
					new EnterName(0, 0);
				}
				else if (e.getSource() == credits) {
					new Credits();
				}
				else if (e.getSource() == quit) {
					MainMenu.this.dispose();
				}
			}
		}

		
}
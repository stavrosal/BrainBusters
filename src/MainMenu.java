import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;


import javax.swing.*;

public class MainMenu extends JFrame {
	private JPanel panel = new JPanel(new FlowLayout());
	private JPanel img_panel = new JPanel();
	private JPanel pan = new JPanel();
	private JLabel name = new JLabel("BrainBusters");
	private JButton play = new JButton("Play");
	private JButton stats = new JButton("Stats");
	private JButton credits = new JButton("Credits");
	private JButton quit = new JButton("Quit");
	private JLabel img = new JLabel();
	private ImageIcon icon;
	
	public MainMenu() {
		FlowLayout layout = new FlowLayout();
		layout.setHgap(5000); //Makes sure the image doesn't collapse with the buttons
		img_panel.setLayout(layout);
		
		pan.setLayout(new GridLayout(0,1));
	
		name.setFont(new Font("Calibri", Font.BOLD, 40));
		
		
		java.net.URL imgURL = getClass().getResource("images/logo.png");

		icon = new ImageIcon(imgURL);
		setIconImage(icon.getImage());
		img.setIcon(icon);
		
		 
		img_panel.add(img);
		
		pan.add(name);
		pan.add(Box.createVerticalGlue()); //Make some space between the buttons
		pan.add(play);
		pan.add(Box.createVerticalGlue());
		pan.add(stats);
		pan.add(Box.createVerticalGlue());
		pan.add(credits);
		pan.add(Box.createVerticalGlue());
		pan.add(quit);
		

		panel.add(img_panel);
		panel.add(pan);
		
		ButtonListener listener = new ButtonListener();
		play.addActionListener(listener);
		stats.addActionListener(listener);
		credits.addActionListener(listener);
		quit.addActionListener(listener);
		
		
		this.setContentPane(panel);
		
		ScreenSize sc = ScreenSize.getInstance();

        int height = sc.getHeight() - 100;
		
		this.setVisible(true);
		this.setSize(600, height);
		this.setTitle("BrainBusters");
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
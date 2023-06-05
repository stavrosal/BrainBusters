import java.awt.Font;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Stats extends JFrame {
	private JPanel mainpanel = new JPanel();
	private JLabel lab = new JLabel();
	private JLabel quiz_name = new JLabel();
	private JLabel points = new JLabel();
	private JLabel correct = new JLabel();
	private JLabel wrong = new JLabel();
	private JLabel percentage = new JLabel();	
	private ImageIcon icon;
	
	
	public Stats(String name) {
		try {
			//Try to read the file
			FileInputStream file = new FileInputStream("players/"+ name + ".ser");
			ObjectInputStream obj = new ObjectInputStream(file);
			Player p = (Player) obj.readObject();
			obj.close();
		
			//GUI stuff
			mainpanel.setLayout(new GridLayout(0,1));
			
			Map<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>(); //This is needed for underlining the back-end and front-end
			map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			
			lab.setText(p.getName());
			lab.setFont(new Font("Calibri", Font.BOLD, 60).deriveFont(map));
			
			
			java.net.URL imgURL = getClass().getResource("images/logo.png");

			icon = new ImageIcon(imgURL);
			setIconImage(icon.getImage());
			
			
			//Rounding the win-rate at 2 decimal places with this trick
			double temp = p.getWinRate();
			temp = Math.round(temp * 100);
			temp = temp / 100;
			
			quiz_name.setText("Quiz: " + p.getQuizName());
			points.setText("Points: " + p.getTotalPoints());
			correct.setText("Correct answers: " + p.getCorrect());
			wrong.setText("Wrong answers: " + p.getWrong());
			percentage.setText("Winrate: " + temp);
			
			quiz_name.setFont(new Font("Calibri", Font.PLAIN, 25));
			points.setFont(new Font("Calibri", Font.PLAIN, 25));
			correct.setFont(new Font("Calibri", Font.PLAIN, 30));
			wrong.setFont(new Font("Calibri", Font.PLAIN, 30));
			percentage.setFont(new Font("Calibri", Font.PLAIN, 30));
			
			//Center items and add them to panel
			lab.setHorizontalAlignment(JLabel.CENTER);
			quiz_name.setHorizontalAlignment(JLabel.CENTER);
			points.setHorizontalAlignment(JLabel.CENTER);
			correct.setHorizontalAlignment(JLabel.CENTER);
			wrong.setHorizontalAlignment(JLabel.CENTER);
			percentage.setHorizontalAlignment(JLabel.CENTER);
			
			mainpanel.add(lab);
			mainpanel.add(quiz_name);
			mainpanel.add(points);
			mainpanel.add(correct);
			mainpanel.add(wrong);
			mainpanel.add(percentage);
			
			this.setContentPane(mainpanel);
			
			ScreenSize sc = ScreenSize.getInstance();

	        int height = sc.getHeight() - 100;
			
			this.setVisible(true);
			this.setSize(500, height);
			this.setTitle("Statistics");
			//this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		} catch (IOException | ClassNotFoundException e) { //FileNotFoundException is caught by the similar IOException
			JOptionPane.showMessageDialog(null, "Couldn't find player!", "Error!", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		}
	
	
	}
}


import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Stats extends JFrame {
	private JPanel mainpanel = new JPanel();
	private JLabel lab = new JLabel();
	private JLabel correct = new JLabel();
	private JLabel wrong = new JLabel();
	private JLabel percentage = new JLabel();
	
	
	public Stats(String name) {
		try {
			//Try to read the file
			FileInputStream file = new FileInputStream("players/"+ name + ".ser");
			ObjectInputStream obj = new ObjectInputStream(file);
			Player p = (Player) obj.readObject();
			obj.close();
		
			//GUI stuff
			mainpanel.setLayout(new GridLayout(0,1));
			
			lab.setText(p.getName());
			lab.setFont(new Font("Calibri", Font.BOLD, 60));
			
			
			ImageIcon icon = new ImageIcon("logo.png");
			setIconImage(icon.getImage());
			
			//Rounding the win-rate at 2 decimal places with this trick
			double temp = p.getWinRate();
			temp = Math.round(temp * 100);
			temp = temp / 100;
			
			correct.setText("Correct answers: " + p.getCorrect());
			wrong.setText("Wrong answers: " + p.getWrong());
			percentage.setText("Winrate: " + temp);
			
			correct.setFont(new Font("Calibri", Font.PLAIN, 30));
			wrong.setFont(new Font("Calibri", Font.PLAIN, 30));
			percentage.setFont(new Font("Calibri", Font.PLAIN, 30));
			
			//Center items and add them to panel
			lab.setHorizontalAlignment(JLabel.CENTER);
			correct.setHorizontalAlignment(JLabel.CENTER);
			wrong.setHorizontalAlignment(JLabel.CENTER);
			percentage.setHorizontalAlignment(JLabel.CENTER);
			
			mainpanel.add(lab);
			mainpanel.add(correct);
			mainpanel.add(wrong);
			mainpanel.add(percentage);
			
			this.setContentPane(mainpanel);
			
			this.setVisible(true);
			this.setSize(600, 800);
			this.setTitle("Statistics");
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		} catch (IOException | ClassNotFoundException e) { //FileNotFoundException is caught by the similar IOException
			JOptionPane.showMessageDialog(null, "Couldn't find player!", "Error!", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		}
	
	
	}
}


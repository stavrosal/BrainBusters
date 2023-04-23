import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnterName extends JFrame {
	private JPanel panel = new JPanel(null);
	private JLabel text = new JLabel("Name: ");
	private JLabel name = new JLabel("BrainBusters");
	private JLabel img = new JLabel();
	private JTextField field = new JTextField();
	private JButton play = new JButton("Play");
	
	public EnterName() {
		text.setBounds(350, 350, 150, 50);
		text.setFont(new Font("Calibri", Font.BOLD, 20));
		
		name.setBounds(380, 250, 350, 50);
		name.setFont(new Font("Calibri", Font.BOLD, 40));
		
		field.setText("Write here...");
		field.setBounds(410, 360, 200, 25);
		
		img.setBounds(380, 25, 200, 179);
		
		play.setBounds(400, 450, 150, 50);
		
		ButtonListener listener = new ButtonListener();
		play.addActionListener(listener);
		
		ImageIcon logo = new ImageIcon("logo.png");
		img.setIcon(logo);
		
		panel.add(img);
		panel.add(name);
		panel.add(text);
		panel.add(field);
		panel.add(play);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(1000, 800);
		this.setTitle("Enter Name");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == play) {
				try {
					new SingleGame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}

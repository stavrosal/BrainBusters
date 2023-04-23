import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.*;

public class MainMenu extends JFrame {
	private JPanel panel = new JPanel(null);
	private JLabel name = new JLabel("BrainBusters");
	private JButton play = new JButton("Play");
	private JLabel img = new JLabel();
	
	public MainMenu() {
		play.setBounds(400, 350, 150, 50);
		name.setBounds(380, 250, 350, 50);
		name.setFont(new Font("Calibri", Font.BOLD, 40));
		
		img.setBounds(380, 25, 200, 179);
		
		ImageIcon logo = new ImageIcon("logo.png");
		img.setIcon(logo);
		
		panel.add(img);
		panel.add(name);
		panel.add(play);
		
		ButtonListener listener = new ButtonListener();
		play.addActionListener(listener);
		
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(1000, 800);
		this.setTitle("BrainBusters");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == play) {
				new EnterName();
			}
		}
	}

}

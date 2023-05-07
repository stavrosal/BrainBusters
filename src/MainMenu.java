import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;

import javax.swing.*;

public class MainMenu extends JFrame {
	private JPanel panel = new JPanel(null);
	private JLabel name = new JLabel("BrainBusters");
	private JButton play = new JButton("Play");
	private JButton stats = new JButton("Stats");
	private JButton credits = new JButton("Credits");
	private JLabel img = new JLabel();
	private ImageIcon icon;
	
	public MainMenu() {
		play.setBounds(400, 350, 150, 50);
		stats.setBounds(400, 450, 150, 50);
		credits.setBounds(400, 550, 150, 50);
		name.setBounds(380, 250, 350, 50);
		name.setFont(new Font("Calibri", Font.BOLD, 40));
		
		img.setBounds(380, 25, 200, 179);
		
		icon = new ImageIcon("logo.png");
		setIconImage(icon.getImage());
		
		ImageIcon logo = new ImageIcon("logo.png");
		img.setIcon(logo);
		
		panel.add(img);
		panel.add(name);
		panel.add(play);
		panel.add(stats);
		panel.add(credits);
		
		ButtonListener listener = new ButtonListener();
		play.addActionListener(listener);
		stats.addActionListener(listener);
		credits.addActionListener(listener);
		
		
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
					try {
						new SingleGame(0, 0, 0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else if (e.getSource() == stats) {
					
				}
				else if (e.getSource() == credits) {
					new Credits();
				}
			}
		}

}

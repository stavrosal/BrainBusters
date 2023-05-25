import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class SelectPlayers extends JFrame 
{	
	JPanel panel = new JPanel();
	JButton singleButton = new JButton("Singleplayer");
	JButton multiButton = new JButton("Multiplayer");
	
	
	public SelectPlayers()
	{
		singleButton.setBounds(40, 30, 140, 40);
		singleButton.setFocusable(false);
		
		multiButton.setBounds(220, 30, 140, 40);
		multiButton.setFocusable(false);
		
		
		panel.add(singleButton);
		panel.add(multiButton);	
		
		
		ButtonListener listener = new ButtonListener();
		singleButton.addActionListener(listener);
		multiButton.addActionListener(listener);
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(400, 100);
		this.setTitle("Players Selection");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	

	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == singleButton)
			{
				try {
					new SingleGame(0, 0, 0);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else
			{
				/*
				try {
					new MultiGame(0, 0, 0);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				*/
			}
			
		}
	}
}

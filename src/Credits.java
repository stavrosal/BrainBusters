import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Credits extends JFrame{
	private JPanel panel = new JPanel(null);
	private JLabel label = new JLabel("Credits");
	private JLabel label2 = new JLabel("Back-end");
	private JLabel back_end = new JLabel();
	private JLabel front_end = new JLabel();
	
	public Credits() {
		label.setBounds(180, 0, 150, 150);
		label.setFont(new Font("Calibri", Font.BOLD, 40));
		
		label2.setBounds(180, 150, 150, 100);
		label2.setFont(new Font("Calibri", getFont().ITALIC, 30));
		
		panel.add(label);
		panel.add(label2);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(500, 800);
		this.setTitle("Credits");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

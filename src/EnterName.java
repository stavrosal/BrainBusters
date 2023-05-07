import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnterName extends JFrame{
	private JPanel panel = new JPanel(null);
	private JLabel text = new JLabel("Name: ");
	private JLabel name_label = new JLabel("BrainBusters");
	private JLabel img = new JLabel();
	private JTextField field = new JTextField();
	private JButton save = new JButton("Save");
	private ImageIcon icon;
	private int correct;
	private int wrong;
	
	public EnterName(int correct, int wrong) {
		this.correct = correct;
		this.wrong = wrong;
		icon = new ImageIcon("logo.png");
		setIconImage(icon.getImage());
		
		text.setBounds(350, 350, 150, 50);
		text.setFont(new Font("Calibri", Font.BOLD, 20));
		
		name_label.setBounds(380, 250, 350, 50);
		name_label.setFont(new Font("Calibri", Font.BOLD, 40));
		
		field.setText("Write here...");
		field.setBounds(410, 360, 200, 25);
		
		img.setBounds(380, 25, 200, 179);
		
		save.setBounds(400, 450, 150, 50);
		
		ButtonListener listener = new ButtonListener();
		save.addActionListener(listener);
		
		ImageIcon logo = new ImageIcon("logo.png");
		img.setIcon(logo);
		
		panel.add(img);
		panel.add(name_label);
		panel.add(text);
		panel.add(field);
		panel.add(save);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(1000, 800);
		this.setTitle("Enter Name");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String name = EnterName.this.field.getText();
			if (e.getSource() == save) {
					Player p = new Player(name, correct, wrong);
					p.saveStats();
					System.out.println(correct+" " + wrong);
					JOptionPane.showMessageDialog(null, "Statistics saved!");
					new Stats(name);
					EnterName.this.dispose();
					
			}
		}
	}
}

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



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
	private JLabel lab = new JLabel("Enter your name...");
	private JTextField field = new JTextField();
	private JButton button = new JButton();
	private ImageIcon icon;
	private String quiz;
	private int correct;
	private int wrong;
	private int total_points;
	
	public EnterName(String quiz, int correct, int wrong, int total_points) { //the window is called for stats saving
		this.quiz = quiz;
		this.correct = correct;								
		this.wrong = wrong;
		this.total_points = total_points;
		icon = new ImageIcon("logo.png");
		setIconImage(icon.getImage());
		
		button.setText("Save");

		
		text.setBounds(300, 350, 150, 50);
		text.setFont(new Font("Calibri", Font.BOLD, 20));
		
		name_label.setBounds(330, 250, 350, 50);
		name_label.setFont(new Font("Calibri", Font.BOLD, 40));
		
		lab.setBounds(350, 280, 200, 100);
		lab.setFont(new Font("Calibri", Font.ITALIC, 22));
		
		field.setText("Write here...");
		field.setBounds(360, 360, 200, 25);
		
		img.setBounds(330, 25, 200, 179);
		
		button.setBounds(350, 450, 150, 50);
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		
		ImageIcon logo = new ImageIcon("logo.png");
		img.setIcon(logo);
		
		panel.add(img);
		panel.add(lab);
		panel.add(name_label);
		panel.add(text);
		panel.add(field);
		panel.add(button);

		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(900, 600);
		this.setTitle("Enter Name");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public EnterName(int correct, int wrong) { //the window is called for stats loading
		this.correct = correct;								
		this.wrong = wrong;
		icon = new ImageIcon("logo.png");
		setIconImage(icon.getImage());
		
	
		button.setText("Load");
		
		text.setBounds(300, 350, 150, 50);
		text.setFont(new Font("Calibri", Font.BOLD, 20));
		
		name_label.setBounds(330, 250, 350, 50);
		name_label.setFont(new Font("Calibri", Font.BOLD, 40));
		
		lab.setBounds(350, 280, 200, 100);
		lab.setFont(new Font("Calibri", Font.ITALIC, 22));
		
		field.setText("Write here...");
		field.setBounds(360, 360, 200, 25);
		
		img.setBounds(330, 25, 200, 179);
		
		button.setBounds(350, 450, 150, 50);
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		
		ImageIcon logo = new ImageIcon("logo.png");
		img.setIcon(logo);
		
		panel.add(img);
		panel.add(lab);
		panel.add(name_label);
		panel.add(text);
		panel.add(field);
		panel.add(button);

		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(900, 600);
		this.setTitle("Enter Name");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String name = EnterName.this.field.getText();
			if (e.getSource() == button) {
				
				if ( ((JButton) e.getSource()).getText().equals("Save") ) { //Checks which button was pressed, Save or Load
//					Player p = new Player(name, quiz,  correct, wrong);
					Player p = new Player(name, quiz, correct, wrong, total_points);
					p.saveStats();
					JOptionPane.showMessageDialog(null, "Statistics saved!");
					new Stats(name);
				}
				else {
					new Stats(name);
				}
				
					EnterName.this.dispose();
					
			}
		}
	}
}

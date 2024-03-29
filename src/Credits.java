import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Credits extends JFrame{
	private JPanel panel = new JPanel(null); 
	private JLabel label = new JLabel("Credits");
	private JLabel label2 = new JLabel("Back-end");
	private JLabel label3 = new JLabel("Front-end");
	private JLabel back_end = new JLabel();
	private JLabel front_end = new JLabel();
	private ImageIcon icon;
	
	public Credits() {
		label.setBounds(170, 0, 150, 150);
		label.setFont(new Font("Calibri", Font.BOLD, 50));
		
		Map<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>(); //This is needed for underlining the back-end and front-end
		map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		label2.setBounds(180, 100, 150, 100);
		
		label2.setFont(new Font("Calibri", Font.ITALIC, 30).deriveFont(map));
		
		back_end.setText("<html> Alexandridis Lazaros <br> "
				+ "Almpanopoulos Stavros <br> "
				+ "Kaitetzidis Konstanrtinos"
				+ "<br> Karastathi Ourania <br> "
				+ "Karastavrou Dimitrios <br> "
				+ "Karkaletsi Afroditi <br> "
				+ "Monosopoulli Gianni <br>"
				+ "Varnas Dimitrios</html>");
		back_end.setFont(new Font("Calibri", Font.PLAIN, 20));
		back_end.setBounds(150, 120, 350, 300);
		
		label3.setBounds(180, 450, 150, 100);
		label3.setFont(new Font("Calibri", Font.ITALIC, 30).deriveFont(map));
		

		front_end.setText("<html>Aggelakakis Athanasios <br>"
				+ "Pyretzis Athanasios <br>"
				+ "Sarantolakis Ilias-Christos <br>"
				+ "Tsatsos Zisis <br>"
				+ "Tsitsopoulos Gavriil </html>");
		front_end.setFont(new Font("Calibri", Font.PLAIN, 20));
		front_end.setBounds(150, 470, 350, 220);
		
		
		java.net.URL imgURL = getClass().getResource("images/logo.png");
		
		icon = new ImageIcon(imgURL);
		setIconImage(icon.getImage());

		
		
		panel.add(label);
		panel.add(label2);
		panel.add(back_end);
		panel.add(label3);
		panel.add(front_end);
		
		this.setContentPane(panel);
		
		ScreenSize sc = ScreenSize.getInstance();
		
        int height = sc.getHeight() - 50; //Here the width doesn't need adjustment
		
		this.setVisible(true);
		this.setSize(500, height);
		this.setTitle("Credits");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}

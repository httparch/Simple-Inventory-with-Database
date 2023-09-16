import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	static JProgressBar progressBar_1 = new JProgressBar();
	static JLabel progress = new JLabel(""); 
	
	public static void main(String[] args) {
		SplashScreen frame = new SplashScreen();
		frame.setVisible(true);
		
		int x;
		
		try {
			for(x = 0; x <= 100; x++) {
				progressBar_1.setValue(x);
				//lblNewLabel_1.setText(Integer.toString(x)+" %");
				Thread.sleep(75);
				
				switch(x) {
				case 0:
					progress.setText("Loading Interface...");
					break;
				case 20:
					progress.setText("Connecting to Database...");
					break;
				case 70:
					progress.setText("Linking Data...");
					break;
				case 100:
					progress.setText("Complete.");
					break;
				}
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		adminPage admin = new adminPage();
		frame.dispose();
		admin.setVisible(true);
	}
	
	public SplashScreen() {
		setType(Type.UTILITY);
		setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 445, 251);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setUndecorated(true);
		
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setLabelFor(this);
		ImageIcon img4 = new ImageIcon(this.getClass().getResource("/anima.gif"));
		lblNewLabel.setIcon(img4);
		lblNewLabel.setBounds(140, 0, 150, 158);
		contentPane.add(lblNewLabel);
		progressBar_1.setEnabled(false);
		progressBar_1.setIndeterminate(true);
		progressBar_1.setFont(new Font("Monospaced", Font.PLAIN, 11));
		progressBar_1.setToolTipText("");
		progressBar_1.setStringPainted(true);
		progressBar_1.setBackground(new Color(223, 223, 223));
		progressBar_1.setForeground(new Color(17, 150, 14));
		
		
		progressBar_1.setBounds(129, 171, 177, 14);
		contentPane.add(progressBar_1);
		progress.setHorizontalAlignment(SwingConstants.CENTER);
		progress.setFont(new Font("Monospaced", Font.PLAIN, 11));
		progress.setBounds(130, 155, 187, 14);
		
		contentPane.add(progress);

	}
}

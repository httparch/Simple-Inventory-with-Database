import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class adminPage extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPage frame = new adminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public adminPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Max\\Downloads\\1539833.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 439);
		setTitle("Inventory System");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(96, 159, 133));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userField = new JTextField();
		userField.requestFocus();
		userField.setBackground(new Color(255, 255, 255));
		userField.setForeground(new Color(0, 0, 0));
		userField.setBounds(74, 138, 197, 32);
		contentPane.add(userField);
		userField.setColumns(10);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
		chckbxNewCheckBox.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBounds(74, 234, 140, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		Image img2 = new ImageIcon(this.getClass().getResource("/Custom-Icon-Design-Silky-Line-User-User.32.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(32, 138, 32, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/newlock.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img3));
		lblNewLabel_3.setBounds(32, 195, 34, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setForeground(new Color(122, 122, 122));
		lblNewLabel_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblNewLabel_4.setBounds(74, 124, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setForeground(new Color(122, 122, 122));
		lblNewLabel_4_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(74, 181, 66, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/nobg.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img4));
		lblNewLabel_2.setBounds(373, 49, 294, 309);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(44, 88, 88));
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(23, 11, 310, 366);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("ADMIN LOGIN");
		lblNewLabel_5.setBackground(new Color(240, 240, 240));
		lblNewLabel_5.setForeground(new Color(81, 81, 81));
		lblNewLabel_5.setBounds(95, 80, 102, 22);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(72, 279, 160, 32);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 17));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(51, 186, 197, 32);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("System");
		lblNewLabel_1.setBounds(170, 22, 148, 32);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
		lblNewLabel_1.setForeground(new Color(64, 128, 128));
		
		JLabel lblNewLabel_1_1 = new JLabel("Inventory");
		lblNewLabel_1_1.setBounds(27, 22, 170, 32);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_1.setForeground(new Color(102, 102, 102));
		lblNewLabel_1_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(332, 28, 10, 361);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(33, 375, 302, 14);
		contentPane.add(panel_2);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(userField.getText().equals("admin") && passwordField.getText().equals("admin123")) {
					Inventory invent = new Inventory();
					dispose();
					invent.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Input correct password!");
				}
			}
		});
		
	}
}

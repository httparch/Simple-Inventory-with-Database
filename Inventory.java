import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Inventory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField refTextfield;
	private JTextField nameTextfield;
	private JTextField quanTextfield;
	private JTextField priceTextfield;
	JLabel sumLabel = new JLabel();
	JLabel stockLabel_1 = new JLabel();
	JLabel lowLabel_1_1 = new JLabel();
	
	Connection con;
	Statement st;
	PreparedStatement pst;
	String query;
	ResultSetMetaData rsmd;
	DefaultTableModel model;
	ResultSet rs;
	private JTextField searchField;
	int counts;
	int outStock;
	int lowStock;
	private JTextField manufacturerField;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory frame = new Inventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void counter()
	{
		try {
			query = "select count(*) from product";
			rs = st.executeQuery(query);
			rs.next();	//check next row
			counts = rs.getInt(1);	//retrieve value column
		}catch(Exception e5) {
			e5.printStackTrace();
		}
	}
	
	public void stockValue()
	{	
		try {
			query = "Select sum(price) from product where quantity > 0";
			pst = con.prepareStatement(query);	//sends the given query to the database to compile and save it
			rs = pst.executeQuery();	//
			
			if(rs.next()) {			
				String sum = rs.getString("sum(price)");
				sumLabel.setText("P "+sum);
			}
		}catch(Exception e) {
			
		}			
	}
		
	public Inventory()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Max\\Downloads\\1539833.png"));
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 494);
		setTitle("Inventory System");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 249, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root","admin123");	//establish connection to database
			st = con.createStatement();
		}catch(Exception e2) {
			e2.printStackTrace();
		}		
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setForeground(new Color(95, 95, 95));
		lblNewLabel.setBounds(10, 0, 161, 35);
		lblNewLabel.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(UIManager.getBorder("Menu.border"));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 35, 223, 305);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		panel_1.setBounds(0, 0, 223, 30);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDashboard = new JLabel("Summary");
		lblDashboard.setForeground(new Color(95, 95, 95));
		lblDashboard.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 20));
		lblDashboard.setBounds(10, 0, 86, 30);
		panel_1.add(lblDashboard);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 87, 6));
		panel_5.setBounds(10, 49, 203, 53);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		//counter();
		JLabel countLabel = new JLabel(counts+"");
		countLabel.setForeground(new Color(255, 255, 255));
		countLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 35));
		countLabel.setBounds(160, 0, 43, 52);
		panel_5.add(countLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Total Products");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNewLabel_6.setBounds(50, 6, 107, 14);
		panel_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/box.png")).getImage();
		lblNewLabel_7.setIcon(new ImageIcon(img3));
		lblNewLabel_7.setBounds(10, 9, 36, 36);
		panel_5.add(lblNewLabel_7);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(0, 128, 255));
		panel_5_1.setBounds(10, 113, 203, 53);
		panel.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		JLabel lblNewLabel_6_1 = new JLabel("Out of Stock");
		lblNewLabel_6_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNewLabel_6_1.setBounds(50, 6, 107, 14);
		panel_5_1.add(lblNewLabel_6_1);
		
		JLabel box2 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/box.png")).getImage();
		box2.setIcon(new ImageIcon(img4));
		box2.setBounds(10, 9, 36, 36);
		panel_5_1.add(box2);
		stockLabel_1.setText("0");
		
		stockLabel_1.setForeground(Color.WHITE);
		stockLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 35));
		stockLabel_1.setBounds(160, 0, 43, 52);
		panel_5_1.add(stockLabel_1);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBackground(new Color(255, 128, 128));
		panel_5_2.setBounds(10, 177, 203, 53);
		panel.add(panel_5_2);
		panel_5_2.setLayout(null);
		
		JLabel box3 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/box.png")).getImage();
		box3.setIcon(new ImageIcon(img5));
		box3.setBounds(10, 9, 36, 36);
		panel_5_2.add(box3);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Low Stock ");
		lblNewLabel_6_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNewLabel_6_1_1.setBounds(50, 6, 143, 14);
		panel_5_2.add(lblNewLabel_6_1_1);
		
		lowLabel_1_1.setText("0");
		lowLabel_1_1.setForeground(Color.WHITE);
		lowLabel_1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 35));
		lowLabel_1_1.setBounds(160, 0, 43, 52);
		panel_5_2.add(lowLabel_1_1);
		
		JPanel panel_5_3 = new JPanel();
		panel_5_3.setBackground(new Color(192, 179, 3));
		panel_5_3.setBounds(10, 241, 203, 53);
		panel.add(panel_5_3);
		panel_5_3.setLayout(null);
		
		JLabel box4 = new JLabel("");
		Image img6 = new ImageIcon(this.getClass().getResource("/money.png")).getImage();
		box4.setIcon(new ImageIcon(img6));
		box4.setBounds(10, 9, 36, 36);
		panel_5_3.add(box4);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("Stock Value");
		lblNewLabel_6_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNewLabel_6_1_1_1.setBounds(50, 6, 89, 14);
		panel_5_3.add(lblNewLabel_6_1_1_1);
		sumLabel.setForeground(new Color(255, 255, 255));
		sumLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
		
		sumLabel.setBounds(85, 24, 118, 21);
		panel_5_3.add(sumLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.BLACK);
		panel_3.setBorder(UIManager.getBorder("Menu.border"));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(243, 35, 473, 305);
		contentPane.add(panel_3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		panel_1_1.setBounds(0, 0, 473, 30);
		panel_3.add(panel_1_1);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setForeground(new Color(95, 95, 95));
		lblProduct.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 20));
		lblProduct.setBounds(10, 0, 86, 30);
		panel_1_1.add(lblProduct);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 41, 453, 259);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(242, 242, 242));
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(10, 351, 706, 95);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				try {
					outStock = 0;	
					lowStock = 0;
					counter();
					//outStock();
					stockValue();
					countLabel.setText(counts+"");
					
					btnNewButton.setEnabled(false);	
					//Class.forName("com.mysql.cj.jdbc.Driver");
					//con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root","admin123"); //establish connection
					
					st = con.createStatement(); //for instruction ng query, nagseset.
					query = "select * from product";
					rs = st.executeQuery(query); // rs yung nagrerepresent nung data set na kinuha muna dun sa data base
					rsmd = rs.getMetaData();	//provides info dun sa nakuhang result set
					model = (DefaultTableModel) table.getModel(); //ginamit para hindi na gagawa ng table sa java, mismong kukunin na niya yung table columns and rows dun sa database
						
					int cols = rsmd.getColumnCount();	//column count
					String[] colName = new String[cols];	
					for(int i = 0 ; i < cols; i++) 
						colName[i] = rsmd.getColumnName(i+1);
					
					model.setColumnIdentifiers(colName);
					
					String ref_no, p_name, quan, price,manufacturer; 	
					while(rs.next()) {					//forwards to nxt row 
						ref_no = rs.getString(1);		//kinukuha yung string value ng database 
						p_name = rs.getString(2);
						quan = rs.getString(3);
						price = rs.getString(4);
						manufacturer = rs.getString(5);
						if(quan.equals("0")) {
							outStock++;
						}else if(Integer.parseInt(quan) <= 100) {
							lowStock++;
						}
						stockLabel_1.setText(outStock+"");
						lowLabel_1_1.setText(lowStock+"");
						String[] row = {ref_no, p_name, quan, price,manufacturer};
						model.addRow(row);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(550, 59, 125, 30);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Add product");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(64, 128, 128));
		btnNewButton_2.setFont(new Font("MS Gothic", Font.BOLD, 10));
		btnNewButton_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				try {
				String names = nameTextfield.getText();		///this line checks if existing na yung product
				
				query = "Select * from product where productName='"+names+"'";
				
				rs = st.executeQuery(query);
				
				if(rs.next()) {//checks every row
					JOptionPane.showMessageDialog(null, "Product already in the list");			
				}else {
					
					int no = Integer.parseInt(refTextfield.getText());
					String name = nameTextfield.getText();
					int quan = Integer.parseInt(quanTextfield.getText());
					double price = Double.parseDouble(priceTextfield.getText());
					String manufacturer = manufacturerField.getText();
					query = "insert into product values("+no+",'"+name+"',"+quan+","+price+",'"+manufacturer+"')";
					JOptionPane.showMessageDialog(null, "Product Successfully Added!");
					st.executeUpdate(query);
					table.setModel(new DefaultTableModel());	
				}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(10, 59, 125, 30);
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Product");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(64, 128, 128));
		btnNewButton_3.setFont(new Font("MS Gothic", Font.BOLD, 10));
		btnNewButton_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				try {
					String nos = refTextfield.getText().toString();
					String names = nameTextfield.getText();
					String quans = quanTextfield.getText().toString();
					String prices = priceTextfield.getText().toString();
					String manufacturers = manufacturerField.getText();
					
					pst = con.prepareStatement("UPDATE product SET productName = ?, quantity=?,price=?,manufacturer=? WHERE referenceNo=?");
					pst.setString(1,names);
					pst.setString(2, quans);
					pst.setString(3, prices);
					pst.setString(4, manufacturers);
					pst.setString(5, nos);
							
					int k = pst.executeUpdate(); //updates the table
					if(k==1) {
					JOptionPane.showMessageDialog(null, "Product Record Updated!");
					refTextfield.setText("");
					nameTextfield.setText("");
					quanTextfield.setText("");
					priceTextfield.setText("");
					searchField.setText("");
					manufacturerField.setText("");
					refTextfield.requestFocus();
										
					table.setModel(new DefaultTableModel());
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(145, 59, 125, 30);
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete Product");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(200, 11, 44));
		btnNewButton_4.setFont(new Font("MS Gothic", Font.BOLD, 10));
		btnNewButton_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(refTextfield.getText());
				query = "delete from product where referenceNo = "+ num;
				try {										
					int k = st.executeUpdate(query);
					if(k==1) {
					JOptionPane.showMessageDialog(null, "Product Deleted!");
					refTextfield.setText("");
					nameTextfield.setText("");
					quanTextfield.setText("");
					priceTextfield.setText("");
					searchField.setText("");
					manufacturerField.setText("");
					refTextfield.requestFocus();
					table.setModel(new DefaultTableModel());
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(280, 59, 125, 30);
		panel_4.add(btnNewButton_4);
		
		refTextfield = new JTextField();
		refTextfield.setBounds(10, 26, 125, 30);
		panel_4.add(refTextfield);
		refTextfield.setColumns(10);
		
		nameTextfield = new JTextField();
		nameTextfield.setColumns(10);
		nameTextfield.setBounds(145, 26, 125, 30);
		panel_4.add(nameTextfield);
		
		quanTextfield = new JTextField();
		quanTextfield.setColumns(10);
		quanTextfield.setBounds(280, 26, 125, 30);
		panel_4.add(quanTextfield);
		
		priceTextfield = new JTextField();
		priceTextfield.setColumns(10);
		priceTextfield.setBounds(415, 26, 125, 30);
		panel_4.add(priceTextfield);
		
		JLabel lblNewLabel_2 = new JLabel("Reference Number:");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setBounds(10, 11, 125, 14);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Product Name:");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_3.setBounds(145, 11, 125, 14);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity:");
		lblNewLabel_4.setForeground(new Color(128, 128, 128));
		lblNewLabel_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblNewLabel_4.setBounds(280, 11, 125, 14);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Price:");
		lblNewLabel_5.setForeground(new Color(128, 128, 128));
		lblNewLabel_5.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblNewLabel_5.setBounds(415, 11, 125, 14);
		panel_4.add(lblNewLabel_5);
		
		manufacturerField = new JTextField();
		manufacturerField.setColumns(10);
		manufacturerField.setBounds(550, 26, 125, 30);
		panel_4.add(manufacturerField);
		
		JLabel lblNewLabel_5_1 = new JLabel("Manufacturer:");
		lblNewLabel_5_1.setForeground(Color.GRAY);
		lblNewLabel_5_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblNewLabel_5_1.setBounds(550, 12, 156, 14);
		panel_4.add(lblNewLabel_5_1);
		
		JButton btnClear = new JButton("Refresh");
		btnClear.setBounds(415, 59, 125, 30);
		panel_4.add(btnClear);
		btnClear.setFont(new Font("MS Gothic", Font.BOLD, 11));
		btnClear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {			
				table.setModel(new DefaultTableModel());
				btnNewButton.setEnabled(true);
				refTextfield.setText("");
				nameTextfield.setText("");
				quanTextfield.setText("");
				priceTextfield.setText("");
				manufacturerField.setText("");
			}
		});
		
		searchField = new JTextField();
		searchField.setBounds(451, 12, 170, 20);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(631, 12, 85, 20);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("MS Gothic", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					String search = searchField.getText();
				
					pst = con.prepareStatement("Select * from product where referenceNo = ?");
					pst.setString(1,search);//parameter(column, ipapasa)
					rs = pst.executeQuery();
					
					if(rs.next() == true) {
						refTextfield.setText(rs.getString(1));
						nameTextfield.setText(rs.getString(2));
						quanTextfield.setText(rs.getString(3));
						priceTextfield.setText(rs.getString(4));
						manufacturerField.setText(rs.getString(5));
					}else {
						JOptionPane.showMessageDialog(null, "No Record Found!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}

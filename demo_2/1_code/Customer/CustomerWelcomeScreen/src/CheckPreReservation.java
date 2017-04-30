import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckPreReservation extends JFrame implements ActionListener {
	
	JButton next, back;
	JTextField namefield = new JTextField(30);
	JTextField numberfield = new JTextField(20);
	String customer_name;
	String contact_number = "NONE";
	Connection myConn;
	Statement myStmt;
	ResultSet c_profile;
	
	public CheckPreReservation() {
		//System.out.println("New Reservation Class");
		super("Zest-Ware: Customer Welcome Screen (CWS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		JLabel title = new JLabel("Check Reservation");
		title.setBounds(200,50,600,70);
		
		Font titlefont = new Font("Cambria", Font.BOLD, 24);
		title.setFont(titlefont);
		
		JLabel nameLabel = new JLabel("Customer Name: ");
		nameLabel.setBounds(160, 130, 150, 50);
		
		Font labelfont = new Font("Cambria", Font.PLAIN, 14);
		nameLabel.setFont(labelfont);

		namefield.setBounds(300, 140, 200, 30);
		
		JLabel numberlabel = new JLabel("Contact # or email:");
		numberlabel.setBounds(160, 180, 150, 50);
		
		numberlabel.setFont(labelfont);
		
		numberfield.setBounds(300, 190, 150, 30);
		
		ImageIcon nextIcon = new ImageIcon("icons/next.gif");
		ImageIcon backIcon = new ImageIcon("icons/back.gif");
		
		next = new JButton(nextIcon);
		back = new JButton(backIcon);
		
		next.setBounds(520,400,100,43);
		back.setBounds(80,400,100,43);
		
		next.addActionListener(this);
		back.addActionListener(this);
		
		panel.add(title);
		panel.add(nameLabel);
		panel.add(namefield);
		panel.add(numberlabel);
		panel.add(numberfield);
		panel.add(next);
		panel.add(back);
		
		getContentPane().add(panel);
		setSize(800, 600);
		setVisible(true);
		try {
			Runtime.getRuntime().exec("cmd /c C:\\Windows\\System32\\osk.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == next) {
			
			if (namefield.getText().isEmpty()) {
				displayError(1);
			}
			
			else if ( numberfield.getText().isEmpty()) {
				displayError(2);
			}
			else {
				customer_name = namefield.getText();
				contact_number = numberfield.getText();
			
				setVisible(false);
				
				connectToDB();
				boolean flag = false;
				try {
					c_profile = myStmt.executeQuery("select * from profiles");
					
					while(c_profile.next()) {
						String tempName = c_profile.getString("name");
						String tempCont = c_profile.getString("contact");
						
						int comp1 = tempName.compareToIgnoreCase(customer_name);
						int comp2 = tempCont.compareToIgnoreCase(contact_number);
						
						if ( comp1 == 0 && comp2 == 0 ) {
							
							int p_s = c_profile.getInt("size");
							String date = c_profile.getString("date");
							String r_t = c_profile.getString("reservationtime");
							int t_n = c_profile.getInt("tablenum");
							flag = true;
							DisplayReservation obj = new DisplayReservation(customer_name, p_s, date, r_t, contact_number, t_n);
						}
					}
					
					if ( !flag ) {
						displayError(3);
						setVisible(false);
						CheckPreReservation cpr = new CheckPreReservation();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if (source == back) {
			setVisible(false);
			PreReservation pr = new PreReservation();
		}
		
	}
	
	public boolean connectToDB() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			/* Get a connection to database */
			//myConn = DriverManager.getConnection("jdbc:mysql://zest-ware-cluster.cluster-c7ormjiryir8.us-east-2.rds.amazonaws.com:3306/zestDB", "zestwareCustomer", "faheemisfriend");
			//myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "1234");
			
			myConn = DriverManager.getConnection("jdbc:mysql://cwsdb-cluster-1.cluster-cqpyryktf2nb.us-east-2.rds.amazonaws.com:3306/cwsdb", "root", "12345678");
			
			/* Create a statement */
			myStmt = myConn.createStatement();
						
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void displayError(int x) {
		JFrame frame = new JFrame();
		
		switch (x) {
		
		case 1: JOptionPane.showMessageDialog(frame , "Please enter name.");
		break;
		
		case 2: JOptionPane.showMessageDialog(frame , "Please enter contact # or email.");
		break;
		
		case 3: JOptionPane.showMessageDialog(frame , "No reservation found for the name and contact provided. Please! Re-enter name and contact and try again.");
		break;
		}
	}

}

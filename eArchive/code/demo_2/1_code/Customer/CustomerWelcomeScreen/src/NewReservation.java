/* NewReservation.java */
// written by:	Fahd Humayun
// tested by:	Shehpar Sohail
// debugged by:	Nathan Morgenstern

import java.awt.event.*;
import java.io.IOException;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import java.awt.*;

public class NewReservation extends JFrame implements ActionListener {
	
	JButton next, back;
	JTextField namefield = new JTextField(30);
	JTextField numberfield = new JTextField(20);
	JComboBox sizeBox = new JComboBox();
	String customer_name;
	String contact_number = "NONE";
	int party_size;
	
	public NewReservation() {
		//System.out.println("New Reservation Class");
		super("Zest-Ware: Customer Welcome Screen (CWS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		JLabel title = new JLabel("Make New Reservation");
		title.setBounds(200,50,600,70);
		
		Font titlefont = new Font("Cambria", Font.BOLD, 24);
		title.setFont(titlefont);
		
		JLabel nameLabel = new JLabel("Customer Name: ");
		nameLabel.setBounds(180, 130, 150, 50);
		
		Font labelfont = new Font("Cambria", Font.PLAIN, 14);
		nameLabel.setFont(labelfont);

		namefield.setBounds(300, 140, 200, 30);
		
		JLabel sizelabel = new JLabel("Party Size: ");
		sizelabel.setBounds(210, 180, 70, 50);
		
		sizelabel.setFont(labelfont);
		
		int sizeArray[] = {1,2,3,4};
		
		for (int i = 0; i < sizeArray.length; i++)
			sizeBox.addItem(sizeArray[i]);
		
		sizeBox.setBounds(300, 190, 50, 30);
		
		JLabel numberlabel = new JLabel("Contact # (Optional):");
		numberlabel.setBounds(160, 230, 150, 50);
		
		numberlabel.setFont(labelfont);
		
		numberfield.setBounds(300, 240, 150, 30);
		
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
		panel.add(sizelabel);
		panel.add(sizeBox);
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
				displayError();
			}
			else {
				customer_name = namefield.getText();
				party_size = (int)sizeBox.getSelectedItem();
				contact_number = numberfield.getText();
				//DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				//Date d = Calendar.getInstance().getTime();
				//String date = df.format(d);
				
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
				Date d = Calendar.getInstance().getTime();
				String date = df.format(d);
				
				SimpleDateFormat tm = new SimpleDateFormat("HH:mm:ss");
				String time = tm.format(d);
			
				setVisible(false);
			
			try {
				dbSQL DB = new dbSQL(0, customer_name, party_size, contact_number, date, time);
				
				final int NUM_OF_TABLES = 10;
				boolean[] tables_status = new boolean[NUM_OF_TABLES];
				tables_status = DB.tables_status();
				
				int t_id = DB.getAvailableTable();
				
				if ( t_id == -1 ) {
					
					int estimate_time = DB.getEstimate();
					
					System.out.println(estimate_time);
					FMS fms = new FMS(tables_status, party_size, DB);
					fms.display2(estimate_time);
				}
				
				else {
					FMS fms = new FMS(tables_status, party_size, DB);
					fms.display();
				}
				
				}
			catch (ExceptionsModified er) {
				er.printStackTrace();
			}
			}
		}
		else if (source == back) {
			setVisible(false);
			CWS cws = new CWS();
		}
		
	}
	
	public void displayError() {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame , "Please enter name.");
	}
	
	

}

// NewPreReservation.java
// written by:	Fahd Humayun
// tested by:	Shehpar Sohail
// debugged by:	Nathan Morgenstern

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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewPreReservation extends JFrame implements ActionListener {
	
	JButton next, back;
	JTextField namefield = new JTextField(30);
	JTextField numberfield = new JTextField(20);
	JComboBox sizeBox = new JComboBox();
	JComboBox timeBox = new JComboBox();
	String customer_name;
	String contact_number = "NONE";
	int party_size;
	String ResTime;
	JFormattedTextField dateField;
	String date;
	String timeArray[] = {"10:00:00", "10:30:00", "11:00:00", "11:30:00",
			"12:00:00", "12:30:00", "13:00:00", "13:30:00", "14:00:00", "14:30:00",
			"15:00:00", "15:30:00", "16:00:00", "16:30:00", "17:00:00", "17:30:00",
			"18:00:00", "18:30:00", "19:00:00", "19:30:00", "20:00:00", "21:30:00",
			"22:00:00"};
	
	public NewPreReservation() {
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
		
		JLabel timelabel = new JLabel("Time: ");
		timelabel.setBounds(210, 280, 70, 50);
		timelabel.setFont(labelfont);
		
		timeBox = new JComboBox (timeArray);
		
		//for (int i = 0; i < 23; i++)
		//	timeBox.addItem(timeArray[i]);
		
		timeBox.setBounds(300, 290, 100, 30);
		
		JLabel numberlabel = new JLabel("Contact # or email:");
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
		panel.add(timelabel);
		panel.add(timeBox);
		
		JLabel datelabel = new JLabel("Choose Date:");
		datelabel.setBounds(160, 330, 150, 50);
		
		dateField = new JFormattedTextField(new SimpleDateFormat("MM/dd/yyyy"));
		dateField.setValue(new java.util.Date()); // today
		dateField.setBounds(300, 340, 150, 30);
		
		panel.add(dateField);
		panel.add(datelabel);
		
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
			
			if (namefield.getText().isEmpty() ) {
				displayError(1);
			}
			else if (numberfield.getText().isEmpty() ) {
				displayError(2);
			}
			else {
				customer_name = namefield.getText();
				party_size = (int)sizeBox.getSelectedItem();
				contact_number = numberfield.getText();
				
				ResTime = (String) timeBox.getSelectedItem();
				date = dateField.getText();
				/*
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
				Date d = Calendar.getInstance().getTime();
				String date = df.format(d);
				
				SimpleDateFormat tm = new SimpleDateFormat("HH:mm:ss");
				String time = tm.format(d);
				*/
			
				setVisible(false);
			
			try {
				dbSQL DB = new dbSQL(0, customer_name, party_size, contact_number, date, ResTime);
				
				final int NUM_OF_TABLES = 10;
				boolean[] tables_status = new boolean[NUM_OF_TABLES];
				tables_status = DB.tables_status();
				
				int t_id = DB.checkTableReservation(party_size, ResTime, date);
				
				if ( t_id == -1 ) {
					
					displayError(3);
					setVisible(false);
					NewPreReservation npr = new NewPreReservation();
				}
				
				else {
					DB.writeToDB(t_id, contact_number);
					DB.set_table_newReservation(t_id, ResTime, date);
					
					ReservationConfirmed rc = new ReservationConfirmed(t_id, 3);
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
	
	public void displayError(int x) {
		JFrame frame = new JFrame();
		
		switch (x) {
		case 1: JOptionPane.showMessageDialog(frame , "Name missing.");
		break;
		
		case 2: JOptionPane.showMessageDialog(frame , "Contact # or email missing.");
		break;
		
		case 3: JOptionPane.showMessageDialog(frame , "No tables available for this date and time.");
		break;
		}
		
	}

}

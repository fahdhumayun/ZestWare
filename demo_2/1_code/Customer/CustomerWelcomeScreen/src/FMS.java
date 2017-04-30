/* FMS.java */

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import java.awt.*;

public class FMS extends JFrame {
	
	JButton confirmReservation, cancelReservation;
	JButton[] tButton = new JButton[10];
	JPanel panel = new JPanel();
	
	JTextField numberfield = new JTextField(20);
	
	int t_num, party_size;
	final int NUM_OF_TABLES = 48;
	boolean[] tables_status = new boolean[NUM_OF_TABLES];
	boolean flag = true;
	
	dbSQL DB;
	
	public FMS(boolean t_status[], int p_size, dbSQL db) {
		
		super("Zest-Ware: Customer Welcome Screen (CWS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		
		tables_status = t_status;
		party_size = p_size;
		DB = db;
	}
	
	public void display() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		
		JLabel title = new JLabel("Floor Map");
		title.setBounds(100,10,200,70);
		
		Font titlefont = new Font("Cambria", Font.BOLD, 24);
		title.setFont(titlefont);
		
		

		
		int xs = -20, ys = 80, ws = 60, hs = 34;
		int xms = -20, yms = 150, wms = 60, hms = 68;
		int xxs = 10, xxms = 10;
		
		for (int i = 0; i < 10; i++) {
			if ( i < 5 ) {
				if ( tables_status[i]) {
					ImageIcon newRes = new ImageIcon("icons/fms/small-available.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xs += 70, ys, ws, hs);
					int tN = i;
					tButton[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if ( party_size > 2 ) {
								displayMessage();
							}
							else {
								
								
								t_num = tN + 1;
								
								resetImageIcons();
								
								ImageIcon newIco = new ImageIcon("icons/fms/small-confirm.gif");
								tButton[tN].setIcon(newIco);
							}
				        }}
					);
					
					panel.add(tButton[i]);
				}
				
				else {
					ImageIcon newRes = new ImageIcon("icons/fms/small-occupied.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xs += 70, ys, ws, hs);

					tButton[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							displayError();
						}
					});
					
					panel.add(tButton[i]);
				}
				
				JLabel num = new JLabel (Integer.toString(i+1));
				num.setBounds(xxs += 70, 114, 20, 20);
				panel.add(num);
			}
			
			else {
				if ( tables_status[i]) {
					ImageIcon newRes = new ImageIcon("icons/fms/medsq-available.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xms += 70, yms, wms, hms);
					
					int tN = i;
					
					tButton[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t_num = tN + 1;
							resetImageIcons();
							
							ImageIcon newIco = new ImageIcon("icons/fms/medsq-confirm.gif");
							tButton[tN].setIcon(newIco);
						}
					});
					panel.add(tButton[i]);
				}
				
				else {
					ImageIcon newRes = new ImageIcon("icons/fms/medsq-occupied.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xms += 70, yms, wms, hms);
					tButton[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							displayError();
						}
					});
					panel.add(tButton[i]);
				}
				
				JLabel num = new JLabel (Integer.toString(i+1));
				num.setBounds(xxms += 70, 230, 20, 20);
				panel.add(num);
			}
		}
		
		
		panel.add(title);

		
		String msg1 = "Please select the table from";
		String msg2 = "available tables!";
		String msg3 = "and confirm reservation!";
		
		JLabel m1 = new JLabel(msg1);
		m1.setBounds(500,180,300,70);
		Font m1font = new Font("Cambria", Font.BOLD, 20);
		m1.setFont(m1font);
		
		JLabel m2 = new JLabel(msg2);
		m2.setBounds(500,210,300,70);
		m2.setFont(m1font);
		
		JLabel m3 = new JLabel(msg3);
		m3.setBounds(500,240,300,70);
		m3.setFont(m1font);
		
		panel.add(m1);
		panel.add(m2);
		panel.add(m3);
		
		ImageIcon conRes = new ImageIcon("icons/confirmRes.gif");
		ImageIcon canRes = new ImageIcon("icons/cancelRes.gif");
		
		confirmReservation = new JButton(conRes);
		cancelReservation = new JButton(canRes);
		
		confirmReservation.setBounds(500, 310, 200, 47);
		cancelReservation.setBounds(500, 380, 200, 47);
		
		confirmReservation.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
				Date d = Calendar.getInstance().getTime();
				String date = df.format(d);
				
				SimpleDateFormat tm = new SimpleDateFormat("HH:mm:ss");
				String time = tm.format(d);
				
				setVisible(false);
				DB.writeToDB(t_num, "-1");
				DB.set_table_status(t_num, false);
				DB.set_table_currentReservation(t_num, time, date);
				
				ReservationConfirmed rc = new ReservationConfirmed(t_num, -1);
			}
		});
		cancelReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CWS cws = new CWS();
			}
		});
		
		panel.add(confirmReservation);
		panel.add(cancelReservation);
		
		getContentPane().add(panel);
		setSize(800, 600);
		setVisible(true);
	 }
	
	public void displayError() {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame , "This table is not available.");
	}
	
	public void displayMessage() {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame , "This table is not suited for the party size. Please select a table suitable for your party size.");
	}
	
	public void resetImageIcons() {
		
			
		for (int i = 0; i < 10; i++) {
			if ( i < 5 ) {
				
				if ( tables_status[i]) {
					ImageIcon newRes = new ImageIcon("icons/fms/small-available.gif");
					tButton[i].setIcon(newRes);
				}
				
				else {
					ImageIcon newRes = new ImageIcon("icons/fms/small-occupied.gif");
					tButton[i].setIcon(newRes);
				}
				
			}
			
			else {
				if ( tables_status[i]) {
					ImageIcon newRes = new ImageIcon("icons/fms/medsq-available.gif");
					tButton[i].setIcon(newRes);
				}
				
				else {
					ImageIcon newRes = new ImageIcon("icons/fms/medsq-occupied.gif");
					tButton[i].setIcon(newRes);
				}
			}
		}
	}
	
	public void display2(int estimate_time) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		
		JLabel title = new JLabel("Floor Map");
		title.setBounds(100,10,200,70);
		
		Font titlefont = new Font("Cambria", Font.BOLD, 24);
		title.setFont(titlefont);
		
		
		
		int xs = -20, ys = 80, ws = 60, hs = 34;
		int xms = -20, yms = 150, wms = 60, hms = 68;
		int xxs = 10, xxms = 10;
		
		for (int i = 0; i < 10; i++) {
			if ( i < 5 ) {
				if ( tables_status[i]) {
					ImageIcon newRes = new ImageIcon("icons/fms/small-available.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xs += 70, ys, ws, hs);					
					panel.add(tButton[i]);
				}
				
				else {
					ImageIcon newRes = new ImageIcon("icons/fms/small-occupied.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xs += 70, ys, ws, hs);
					panel.add(tButton[i]);
				}
				
				JLabel num = new JLabel (Integer.toString(i+1));
				num.setBounds(xxs += 70, 114, 20, 20);
				panel.add(num);
			}
			
			else {
				if ( tables_status[i]) {
					ImageIcon newRes = new ImageIcon("icons/fms/medsq-available.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xms += 70, yms, wms, hms);
					panel.add(tButton[i]);
				}
				
				else {
					ImageIcon newRes = new ImageIcon("icons/fms/medsq-occupied.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xms += 70, yms, wms, hms);
					panel.add(tButton[i]);
				}
				
				JLabel num = new JLabel (Integer.toString(i+1));
				num.setBounds(xxms += 70, 230, 20, 20);
				panel.add(num);
			}
		}
		
		
		panel.add(title);
		
		int t_n = DB.next_available_table(party_size);

		String msg1 = "Sorry, no tables currently available!";
		String msg7 = "Next available table will be # " + t_n + " with";
		String msg6 = "Estimate wait time of " + estimate_time + " minutes";
		String msg2 = "Please enter Contact # or email!";
		String msg3 = "and click confirm reservation!";
		String msg4 = "To get notified by an email or SMS";
		String msg5 = "when next table is available.";
		
		JLabel m1 = new JLabel(msg1);
		m1.setBounds(420,60,350,70);
		Font m1font = new Font("Cambria", Font.BOLD, 20);
		m1.setFont(m1font);
		
		JLabel m2 = new JLabel(msg2);
		m2.setBounds(430,150,300,70);
		m2.setFont(m1font);
		
		JLabel m7 = new JLabel(msg7);
		m7.setBounds(425,90,350,70);
		m7.setFont(m1font);
		m7.setForeground(Color.RED);
		
		JLabel m6 = new JLabel(msg6);
		m6.setBounds(420,120,350,70);
		m6.setFont(m1font);
		m6.setForeground(Color.RED);
		
		JLabel m3 = new JLabel(msg3);
		m3.setBounds(450,180,300,70);
		m3.setFont(m1font);
		
		JLabel m4 = new JLabel(msg4);
		m4.setBounds(425,210,350,70);
		m4.setFont(m1font);
		
		JLabel m5 = new JLabel(msg5);
		m5.setBounds(470,240,300,70);
		m5.setFont(m1font);
		
		panel.add(m1);
		panel.add(m2);
		panel.add(m3);
		panel.add(m4);
		panel.add(m5);
		panel.add(m6);
		panel.add(m7);
		
		JLabel numberlabel = new JLabel("Contact #/email:");
		numberlabel.setBounds(400, 300, 150, 50);
		
		Font labelfont = new Font("Cambria", Font.PLAIN, 14);
		numberlabel.setFont(labelfont);
		
		numberfield.setBounds(510, 310, 150, 30);
		
		panel.add(numberlabel);
		panel.add(numberfield);
		
		ImageIcon conRes = new ImageIcon("icons/confirmRes.gif");
		ImageIcon canRes = new ImageIcon("icons/cancelRes.gif");
		
		confirmReservation = new JButton(conRes);
		cancelReservation = new JButton(canRes);
		
		confirmReservation.setBounds(500, 370, 200, 47);
		cancelReservation.setBounds(500, 440, 200, 47);
		
		confirmReservation.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				String contact_number = numberfield.getText();
				
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
				Date d = Calendar.getInstance().getTime();
				String date = df.format(d);
				
				SimpleDateFormat tm = new SimpleDateFormat("HH:mm:ss");
				String time = tm.format(d);
				Date t;
				String newTime = "";
				try {
					t = tm.parse(time);
					Calendar cal = Calendar.getInstance();
					cal.setTime(d);
					cal.add(Calendar.MINUTE, estimate_time);
					newTime = tm.format(cal.getTime());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				setVisible(false);
				DB.writeToDB(t_n, "-1");
				//DB.set_table_status(t_num, false);
				DB.set_table_newReservation(t_n, newTime, date);
				
				ReservationConfirmed rc = new ReservationConfirmed(t_n, 1);
			}
		});
		cancelReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CWS cws = new CWS();
			}
		});
		
		panel.add(confirmReservation);
		panel.add(cancelReservation);
		
		getContentPane().add(panel);
		setSize(800, 600);
		setVisible(true);
		
	}
}

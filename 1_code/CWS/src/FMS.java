/* FMS.java */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FMS extends JFrame implements ActionListener {
	
	JButton confirmReservation, cancelReservation;
	JButton[] tButton = new JButton[10];
	JPanel panel = new JPanel();
	
	int t_num;
	final int NUM_OF_TABLES = 48;
	boolean[] tables_status = new boolean[NUM_OF_TABLES];
	
	dbSQL DB;
	
	public FMS(boolean t_status[], int table_num, dbSQL db) {
		
		super("Zest-Ware: Customer Welcome Screen (CWS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		
		tables_status = t_status;
		t_num = table_num;
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
			if ( i < 6 ) {
				if ( i + 1 == t_num ) {
					ImageIcon newRes = new ImageIcon("icons/fms/small-confirm.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xs += 70, ys, ws, hs);
					panel.add(tButton[i]);
				}
				
				else if ( tables_status[i]) {
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
				if ( i + 1 == t_num ) {
					ImageIcon newRes = new ImageIcon("icons/fms/medsq-confirm.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xms += 70, yms, wms, hms);
					panel.add(tButton[i]);
				}
				else if ( tables_status[i]) {
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

		String tabAvail = "Table # " + Integer.toString(t_num) + " is Available!";
		
		JLabel tavail = new JLabel(tabAvail);
		tavail.setBounds(500,210,300,70);
		Font tavailfont = new Font("Cambria", Font.BOLD, 20);
		tavail.setFont(tavailfont);
		
		panel.add(tavail);
		
		ImageIcon conRes = new ImageIcon("icons/confirmRes.gif");
		ImageIcon canRes = new ImageIcon("icons/cancelRes.gif");
		
		confirmReservation = new JButton(conRes);
		cancelReservation = new JButton(canRes);
		
		confirmReservation.setBounds(500, 310, 200, 47);
		cancelReservation.setBounds(500, 380, 200, 47);
		
		confirmReservation.addActionListener(this);
		cancelReservation.addActionListener(this);
		
		panel.add(confirmReservation);
		panel.add(cancelReservation);
		
		getContentPane().add(panel);
		setSize(800, 600);
		setVisible(true);
	 }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == confirmReservation) {
			setVisible(false);
			
			DB.writeToDB(t_num);
			DB.set_table_status(t_num, false);
			
			ReservationConfirmed rc = new ReservationConfirmed(t_num);
	
		}
		else if (source == cancelReservation) {
			setVisible(false);
			CWS cws = new CWS();
		}
		
	}

	/*
	public FMS(boolean tables_status[], int t_num) {
		
		super("Zest-Ware: Customer Welcome Screen (CWS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		
		JLabel title = new JLabel("Floor Map");
		title.setBounds(100,10,200,70);
		
		Font titlefont = new Font("Cambria", Font.BOLD, 24);
		title.setFont(titlefont);
		
		set_table_num(t_num);
		
		int xs = -20, ys = 80, ws = 60, hs = 34;
		int xms = -20, yms = 150, wms = 60, hms = 68;
		int xxs = 10, xxms = 10;
		
		for (int i = 0; i < 10; i++) {
			if ( i < 6 ) {
				if ( i + 1 == t_num ) {
					ImageIcon newRes = new ImageIcon("icons/fms/small-confirm.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xs += 70, ys, ws, hs);
					panel.add(tButton[i]);
				}
				
				else if ( tables_status[i]) {
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
				if ( i + 1 == t_num ) {
					ImageIcon newRes = new ImageIcon("icons/fms/medsq-confirm.gif");
					tButton[i] = new JButton(newRes);
					tButton[i].setBounds(xms += 70, yms, wms, hms);
					panel.add(tButton[i]);
				}
				else if ( tables_status[i]) {
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
		
		//tButton.addActionListener(this);
		
		panel.add(title);

		String tabAvail = "Table # " + Integer.toString(t_num) + " is Available!";
		
		JLabel tavail = new JLabel(tabAvail);
		tavail.setBounds(500,210,300,70);
		Font tavailfont = new Font("Cambria", Font.BOLD, 20);
		tavail.setFont(tavailfont);
		
		panel.add(tavail);
		//panel.add(tavailButton);
		
		ImageIcon conRes = new ImageIcon("icons/confirmRes.gif");
		ImageIcon canRes = new ImageIcon("icons/cancelRes.gif");
		
		confirmReservation = new JButton(conRes);
		cancelReservation = new JButton(canRes);
		
		confirmReservation.setBounds(500, 310, 200, 47);
		cancelReservation.setBounds(500, 380, 200, 47);
		
		confirmReservation.addActionListener(this);
		cancelReservation.addActionListener(this);
		
		panel.add(confirmReservation);
		panel.add(cancelReservation);
		
		getContentPane().add(panel);
		setSize(800, 600);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == confirmReservation) {
			setVisible(false);
			ReservationConfirmed rc = new ReservationConfirmed(table_num);
		}
		else if (source == cancelReservation) {
			//setVisible(false);
			
		}
		
	}
	
	public void set_table_num(int t_num) {
		table_num = t_num;
	}
	
	public int get_table_num() {
		return table_num;
	}
	*/
}

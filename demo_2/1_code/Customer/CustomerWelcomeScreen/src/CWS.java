/* CWS.java */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CWS extends JFrame implements ActionListener {
	
	JButton newReservation, preReservation;
	
	public CWS() {
		super("Zest-Ware: Customer Welcome Screen (CWS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.setLayout(null);

		JLabel title = new JLabel("Customer Welcome Screen (CWS)");
		title.setBounds(130,50,600,100);
		
		Font font = new Font("Georgia", Font.BOLD, 30);
		title.setFont(font);
		
		ImageIcon newRes = new ImageIcon("icons/newRes.gif");
		ImageIcon preRes = new ImageIcon("icons/preRes.gif");
		
		newReservation = new JButton(newRes);
		preReservation = new JButton(preRes);
		
		newReservation.setBounds(170,240,200,47);
		preReservation.setBounds(420,240,200,47);
		
		newReservation.addActionListener(this);
		preReservation.addActionListener(this);
		
		panel.add(title);
		panel.add(newReservation);
		panel.add(preReservation);
		
		JLabel bg = new JLabel("icons/bg.gif");
		bg.setLayout(new BorderLayout() );
		setContentPane( bg );
		
		getContentPane().add(panel);
		setSize(800, 600);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == newReservation) {
			//System.out.println("New Reservation");
			setVisible(false);
			NewReservation nr = new NewReservation();
		}
		else if (source == preReservation) {
			//System.out.println("Pre Reservation");
			setVisible(false);
			PreReservation pr = new PreReservation();
		}
		
	}
	
	public static void main(String[] args) {
		CWS cws = new CWS();
	}
	
}

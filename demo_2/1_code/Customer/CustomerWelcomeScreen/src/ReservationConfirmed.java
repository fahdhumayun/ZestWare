/* ReservationConfirmed.java */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ReservationConfirmed extends JFrame implements ActionListener {
	
	JButton back;
	
	public ReservationConfirmed(int t_num, int check) {
		
		super("Zest-Ware: Customer Welcome Screen (CWS)");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		
		String message1 = "Table # " + Integer.toString(t_num) + ":";
		String message2 = "Reservation Confirmed!";
		String message3 = "Please be seated at the table";
		
		
		
		JLabel title1 = new JLabel(message1);
		title1.setBounds(320,100,600,200);
		
		Font titlefont = new Font("Cambria", Font.BOLD, 24);
		title1.setFont(titlefont);
		
		JLabel title2 = new JLabel(message2);
		title2.setBounds(250,150,600,200);
		title2.setFont(titlefont);
		
		JLabel title3 = new JLabel(message3);
		title3.setBounds(220,200,600,200);
		title3.setFont(titlefont);
		
		if ( check == 1 ) {
			String message4 = "When you are notified";
			JLabel title4 = new JLabel(message4);
			title4.setBounds(250,250,600,200);
			title4.setFont(titlefont);
			panel.add(title4);
		}
		
		panel.add(title1);
		panel.add(title2);
		
		if ( check != 3)
			panel.add(title3);
		
		//ImageIcon backIcon = new ImageIcon("icons/back.gif");
		back = new JButton("Back To Main Screen");
		back.setBounds(520,400,200,43);
		back.addActionListener(this);
		panel.add(back);
		
		getContentPane().add(panel);
		setSize(800, 600);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == back) {
			setVisible(false);
			CWS cws = new CWS();
		}
		else {
			//setVisible(false);
		}
		
	}

}

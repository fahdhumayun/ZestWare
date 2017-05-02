/* PreReservation.java */
// written by:	Fahd Humayun
// tested by:	Shehpar Sohail
// debugged by:	Nathan Morgenstern

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PreReservation extends JFrame implements ActionListener {
	
	JButton newPreReservation, checkReservation;
	
	public PreReservation() {
		
		super("Zest-Ware: Customer Welcome Screen (CWS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.setLayout(null);

		JLabel title = new JLabel("Pre Reservation");
		title.setBounds(250,50,600,100);
		
		Font font = new Font("Georgia", Font.BOLD, 30);
		title.setFont(font);
		
		ImageIcon newRes = new ImageIcon("icons/newPreRes.gif");
		ImageIcon preRes = new ImageIcon("icons/checkRes.gif");
		
		newPreReservation = new JButton(newRes);
		checkReservation = new JButton(preRes);
		
		newPreReservation.setBounds(170,240,200,47);
		checkReservation.setBounds(420,240,200,47);
		
		newPreReservation.addActionListener(this);
		checkReservation.addActionListener(this);
		
		panel.add(title);
		panel.add(newPreReservation);
		panel.add(checkReservation);
		
		getContentPane().add(panel);
		setSize(800, 600);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == newPreReservation) {
			//System.out.println("New Reservation");
			setVisible(false);
			NewPreReservation nr = new NewPreReservation();
		}
		else if (source == checkReservation) {
			//System.out.println("Pre Reservation");
			setVisible(false);
			CheckPreReservation cpr = new CheckPreReservation();
		}
		
	}


}

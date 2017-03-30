/* PreReservation.java */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PreReservation extends JFrame implements ActionListener {
	
	JButton back;
	
	public PreReservation() {
		
		super("Zest-Ware: Customer Welcome Screen (CWS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		String message1 = "~ UNDER CONSTRUCTION ~";
		
		JLabel title1 = new JLabel(message1);
		title1.setBounds(220,100,600,200);
		
		Font titlefont = new Font("Cambria", Font.BOLD, 24);
		title1.setFont(titlefont);
		
		panel.add(title1);
		
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

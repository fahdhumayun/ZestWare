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

public class DisplayReservation  extends JFrame implements ActionListener {
	
	JButton next, back;
	
	public DisplayReservation(String name, int party_size, String date, String time, String contact, int table_num) {
		super("Zest-Ware: Customer Welcome Screen (CWS)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		JLabel title = new JLabel("Reservation Details");
		title.setBounds(200,50,600,70);
		
		Font titlefont = new Font("Cambria", Font.BOLD, 24);
		title.setFont(titlefont);
		
		JLabel nameLabel = new JLabel("Customer Name: ");
		nameLabel.setBounds(160, 130, 150, 50);
		
		Font labelfont = new Font("Cambria", Font.PLAIN, 14);
		nameLabel.setFont(labelfont);
		
		JLabel nameL = new JLabel(name);

		nameL.setBounds(300, 140, 200, 30);
		Font lfont = new Font("Cambria", Font.BOLD, 15);
		nameL.setFont(lfont);
		
		JLabel numberlabel = new JLabel("Contact # or email:");
		numberlabel.setBounds(160, 180, 150, 50);
		
		numberlabel.setFont(labelfont);
		
		JLabel numberL = new JLabel(contact);
		
		numberL.setBounds(300, 190, 150, 30);
		numberL.setFont(lfont);
		
		JLabel sizelabel = new JLabel("Party Size:");
		sizelabel.setBounds(160, 230, 150, 50);
		
		sizelabel.setFont(labelfont);
		
		JLabel sizeL = new JLabel(Integer.toString(party_size));
		
		sizeL.setBounds(300, 240, 150, 30);
		sizeL.setFont(lfont);
		
		JLabel datelabel = new JLabel("Reservation Date:");
		datelabel.setBounds(160, 280, 150, 50);
		
		datelabel.setFont(labelfont);
		
		JLabel dateL = new JLabel(date);
		
		dateL.setBounds(300, 290, 150, 30);
		dateL.setFont(lfont);
		
		JLabel timelabel = new JLabel("Reservation Time:");
		timelabel.setBounds(160, 330, 150, 50);
		
		timelabel.setFont(labelfont);
		
		JLabel timeL = new JLabel(time);
		
		timeL.setBounds(300, 340, 150, 30);
		timeL.setFont(lfont);
		
		JLabel tablelabel = new JLabel("Table #:");
		tablelabel.setBounds(160, 380, 150, 50);
		
		tablelabel.setFont(labelfont);
		
		JLabel tableL = new JLabel(Integer.toString(table_num));
		
		tableL.setBounds(300, 390, 150, 30);
		tableL.setFont(lfont);
		
		//ImageIcon nextIcon = new ImageIcon("icons/next.gif");
		//ImageIcon backIcon = new ImageIcon("icons/back.gif");
		
		//next = new JButton(nextIcon);
		back = new JButton("Main Menu");
		
		//next.setBounds(520,420,100,43);
		back.setBounds(520,420,100,43);
		
		//next.addActionListener(this);
		back.addActionListener(this);
		
		panel.add(title);
		panel.add(nameLabel);
		panel.add(nameL);
		panel.add(numberlabel);
		panel.add(numberL);
		panel.add(sizelabel);
		panel.add(sizeL);
		panel.add(datelabel);
		panel.add(dateL);
		panel.add(timelabel);
		panel.add(timeL);
		panel.add(tableL);
		panel.add(tablelabel);
		panel.add(tableL);
		//panel.add(next);
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

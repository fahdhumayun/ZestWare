import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//Coded by: Nathan Morgenstern
//Tested by: --------------

//****************************************************************
//******************* CALL ASSISTANCE (CTS) **********************
//****************************************************************
//Constructor for the interface upon user selection
//of the CallAssistance button
public class CallAssistance extends JFrame implements ActionListener {

  //Create the back JButton for the CallAssistance interface
  JButton back;
  int tableID;
  dbSQLCTS db = new dbSQLCTS();

  public CallAssistance(int table_id){
    super("Calling Assistance (CTS)");
    tableID = table_id;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane = new JPanel();
    pane.setLayout(null);

    //Setting the Title and location
    JLabel title = new JLabel("Calling Assistance (CTS)");
	JLabel tableNumber = new JLabel("Table # " + tableID);
    JLabel notification = new JLabel("A server will be with you shortly....");
	
    title.setBounds(230,50,600,100);
    tableNumber.setBounds(600,450,400,43);
    notification.setBounds(120,150,700,150);

    Font font = new Font("Cambria", Font.BOLD, 30);
    Font font2 = new Font("Cambria", Font.BOLD, 20);
    title.setFont(font);
    tableNumber.setFont(font2);
    notification.setFont(font);


    ImageIcon back_Icon = new ImageIcon("icons/back.gif");
    back                = new JButton(back_Icon);
    back.setBounds(120,450,100,43);

    //adding the title, tableNumber, and back button to the JPanel
    pane.add(title);
    pane.add(tableNumber);
    pane.add(notification);
    pane.add(back);

    back.addActionListener(this);

    getContentPane().add(pane);
    setSize(800,600);
    setVisible(true);
    db.connectToDB();
    db.setAssistance(tableID);
    db.disconnectFromDB();
  }

  //****************************************************************
  //******************* CUSTOMER ACTIONS      **********************
  //****************************************************************
  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();

    if(source == back){
      setVisible(false);
      CustomerTableScreen cts = new CustomerTableScreen(tableID);
    }

    }



} //end class CallAssistance

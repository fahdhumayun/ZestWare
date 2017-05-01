import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

//Coded by: Nathan Morgenstern
//Debugged by: Shehpar Sohail
//Tested by: Fahd Humayun


public class CustomerTableScreenSetup extends JFrame implements ActionListener {

  //****************************************************************
  //******************* CUSTOMER TABLE SCREEN(Setup) ***************
  //****************************************************************
  JComboBox sizeBox = new JComboBox();
  JButton next;
  JButton tableNumber;


  //Constructor for the Customer table screen setup interface
  //Allows the Restaurant staff to set an initial table number for the screen
  public CustomerTableScreenSetup() {

    super("Customer Table Screen Setup");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane = new JPanel();
    pane.setLayout(null);

    //Setting the Title and location
    JLabel title = new JLabel("Customer Table Screen Setup (CTS)");
    JLabel prompt = new JLabel("Please select the tableid:");
    title.setBounds(150,50,600,100);

    Font font = new Font("Cambria", Font.BOLD, 30);
    title.setFont(font);
    Font font1 = new Font("Cambria", Font.BOLD, 20);
    prompt.setFont(font1);

    /*try {
      Class.forName("com.mysql.jdbc.Driver");
      // 1. Get a connection to database
      Connection myConn = DriverManager.getConnection("customertablescreen-cluster.cluster-c7ormjiryir8.us-east-2.rds.amazonaws.com:3306", "root", "faheemisfriend");
      // 2. Create a statement
      Statement myStmt = myConn.createStatement();
      // 3. Execute SQL query
      ResultSet t_profile;

      t_profile = myStmt.executeQuery("select * from tables");

      //Create vector of initial size 30
      Vector<Integer> table_number = new Vector<>(20,1);

      while (t_profile.next()) {
        table_number.addElement( t_profile.getInt("tableid") ); //store all of the tables into vector
        //System.out.println(t_profile.getInt("tableid") );
      }*/

    //int tableSize = table_number.capacity();

    //Populate the sizebox witht the tableIDs from the database
    for(int i = 1; i <= 10; i++)
    	sizeBox.addItem(i);

    ImageIcon next_Icon  = new ImageIcon("icons/next.gif");
    next = new JButton(next_Icon);

    next.setBounds(520,400,180,70);
    sizeBox.setBounds(500, 180, 50, 30);
    prompt.setBounds(180, 95, 350, 200);

    next.addActionListener(this);

    //Add the title, prompt, sizebox, and next icon to the interface
    pane.add(title);
    pane.add(prompt);
    pane.add(sizeBox);
    pane.add(next);

    getContentPane().add(pane);
    setSize(800,600);
    setVisible(true);
    //}	catch (Exception e) {
    //    e.printStackTrace();
  //}
}

  //****************************************************************
  //******************* CUSTOMER ACTIONS      **********************
  //****************************************************************
  @Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

    if( source == next){
      	int table = (int)sizeBox.getSelectedItem();

        //System.out.println("Table ID: " + table);
        setVisible(false);
        CustomerTableScreen cts = new CustomerTableScreen(table);
    }
  }

public static void main(String[] args){
  //Call the CustomerTableScreen Setup
  CustomerTableScreenSetup cts = new CustomerTableScreenSetup();
}
} //end class CustomerTableScreen

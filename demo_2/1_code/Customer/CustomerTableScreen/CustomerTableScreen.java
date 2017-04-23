import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//Coded by: Nathan Morgenstern
//Tested by: --------------

public class CustomerTableScreen extends JFrame implements ActionListener {

  //****************************************************************
  //******************* CUSTOMER TABLE SCREEN **********************
  //****************************************************************
  JButton placeOrder;
  JButton makePayment;
  JButton callAssistance;
  JButton entertainment;
  int tableID;

  //Constructor for the Customer table screen interface
  public CustomerTableScreen(int table_id) {
    super("Customer Table Screen");
    tableID = table_id;
    //System.out.println("Table ID: " + table_id);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane = new JPanel();
    pane.setLayout(null);

    //Setting the Title and location
    JLabel title = new JLabel("Customer Table Screen (CTS)");
    title.setBounds(200,50,600,100);

    Font font = new Font("Cambria", Font.BOLD, 30);
    title.setFont(font);

    //Import the image icons for the buttons
    ImageIcon placeOrder_Icon      = new ImageIcon("icons/placeOrder.gif");
    ImageIcon makePayment_Icon     = new ImageIcon("icons/payment.gif");
    ImageIcon callAssistance_Icon  = new ImageIcon("icons/assistance.gif");
    ImageIcon entertainment_Icon   = new ImageIcon("icons/entertainment.gif");

    placeOrder     = new JButton(placeOrder_Icon);
    makePayment    = new JButton(makePayment_Icon);
    callAssistance = new JButton(callAssistance_Icon);
    entertainment  = new JButton(entertainment_Icon);

    placeOrder.setBounds(150,150,220,150);
    makePayment.setBounds(450,150,220,150);
    callAssistance.setBounds(150,350,220,150);
    entertainment.setBounds(450,350,220,150);

    pane.add(title);
    pane.add(placeOrder);
    pane.add(makePayment);
    pane.add(callAssistance);
    pane.add(entertainment);


    //Adding action listeners placeOrder, makePayment, callAssistance, and entertainment
    placeOrder.addActionListener(this);
    makePayment.addActionListener(this);
    callAssistance.addActionListener(this);
    entertainment.addActionListener(this);

    getContentPane().add(pane);
    setSize(800,600);
    setVisible(true);
  }

  //****************************************************************
  //******************* CUSTOMER ACTIONS      **********************
  //****************************************************************
  @Override
	public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();

    if (source == placeOrder) {
      setVisible(false);
      TestScroll ts = new TestScroll(tableID);
      //PlaceOrder po = new PlaceOrder(tableID);
    }
    if ( source == makePayment){
      setVisible(false);
      MakePayment mp = new MakePayment(tableID);
    }
    if ( source == callAssistance){
      setVisible(false);
      CallAssistance ca = new CallAssistance(tableID);
    }
    if ( source == entertainment){
      setVisible(false);
      UnderConstruction un = new UnderConstruction(tableID);
    }
  }

  public static void main(String[] args){
    //Call the CustomerTableScreen Setup
    CustomerTableScreen cts = new CustomerTableScreen(1);

  }

} //end class CustomerTableScreen

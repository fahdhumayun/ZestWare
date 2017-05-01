import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.math.BigDecimal;

//Coded by: Nathan Morgenstern
//Debugged by: Shehpar Sohail
//Tested by: Fahd Humayun

//****************************************************************
//*****************  BITCOIN PAYMENT (CTS)  **********************
//****************************************************************
//Constructor for the interface that the user goes to
//upon clicking the makePayment button
public class CashPayment extends JFrame implements ActionListener {

  //Create the buttons of the Place Order Screen
  JButton bitcoinQR;
  JButton back;
  JButton confirm;
  int tableID;
  dbSQLCTS db = new dbSQLCTS();

  public CashPayment(int table_id)
  {
	super("Bitcoin Payment (CTS)");
	tableID = table_id;
	db.connectToDB();
  JPanel payPane = needsPayment(tableID);

  }



  public JPanel needsPayment(int table_id){

	  tableID = table_id;
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  JPanel pane = new JPanel();
	  pane.setLayout(null);

	  //Setting the Title and location
	  JLabel title = new JLabel("Cash Payment (CTS)");
	  JLabel tableNumber = new JLabel("Table # " + tableID);

	  title.setBounds(230,10,400,100);
	  tableNumber.setBounds(520,480,300,43);

	  Font font = new Font("Cambria", Font.BOLD, 30);
	  Font font2 = new Font("Cambria", Font.BOLD, 20);
	  title.setFont(font);
	  tableNumber.setFont(font2);


	  String total   = db.getTotalPrice(tableID);
	  //System.out.println(address);
      BigDecimal test = new BigDecimal(total);
	  JLabel usdPrice;
    JLabel waiterNot;
	  if(test.compareTo(BigDecimal.ZERO) != 0){
		    usdPrice = new JLabel("Total: $" + total);
        waiterNot = new JLabel("A waiter will be with you shortly");
    }
	  else{
		    usdPrice = new JLabel("Total: $0.00");
        waiterNot = new JLabel("You don't have any bills to pay!");
    }

	  Font waitFont = new Font("Cambria", Font.BOLD,25);
	  usdPrice.setBounds(275,150,400,50);
	  usdPrice.setFont(font);
    waiterNot.setFont(waitFont);
    waiterNot.setBounds(180,265,600,50);

	  //btcLabel.setBounds(300,375,25,25);
	  ImageIcon back_Icon     = new ImageIcon("icons/back.gif");
	  back      = new JButton(back_Icon);
	  back.setBounds(120,480,100,43);


	  pane.add(title);
	  pane.add(back);
	  pane.add(tableNumber);
	  pane.add(usdPrice);
      pane.add(waiterNot);


	    //Adding action listeners card, cash, bitcoin, and back buttons
	    back.addActionListener(this);

	    getContentPane().add(pane);
	    setSize(800,600);
	    setVisible(true);

	  return pane;
  }


//****************************************************************
//******************* CUSTOMER ACTIONS      **********************
//****************************************************************
@Override
public void actionPerformed(ActionEvent e) {
  Object source = e.getSource();

  if( source == back){
    setVisible(false);
    CustomerTableScreen cts = new CustomerTableScreen(tableID);
    db.disconnectFromDB();
    //System.out.println("CustomerTableScreen()");
  }


}

/*public static void main(String[] args)
{
	CashPayment bp = new CashPayment(1);
}*/

}

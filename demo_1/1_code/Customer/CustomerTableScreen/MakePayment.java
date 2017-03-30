import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//Coded by: Nathan Morgenstern
//Tested by: --------------

//****************************************************************
//******************** MAKE PAYMENT (CTS) ************************
//****************************************************************
//Constructor for the interface that the user goes to
//upon clicking the makePayment button
public class MakePayment extends JFrame implements ActionListener {

  //Create the buttons of the Place Order Screen
  JButton cash;
  JButton card;
  JButton bitcoin;
  JButton back;
  int tableID;

  public MakePayment(int table_id){
    super("Payment (CTS)");
    tableID = table_id;

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane = new JPanel();
    pane.setLayout(null);

    //Setting the Title and location
    JLabel title = new JLabel("Payment (CTS)");
    JLabel tableNumber = new JLabel("Table # " + tableID);
    title.setBounds(300,50,600,100);
    tableNumber.setBounds(500,450,300,43);

    Font font = new Font("Cambria", Font.BOLD, 30);
    Font font2 = new Font("Cambria", Font.BOLD, 20);
    title.setFont(font);
    tableNumber.setFont(font2);

    //Import the image icons for the buttons
    ImageIcon cash_Icon     = new ImageIcon("icons/cash.gif");
    ImageIcon card_Icon     = new ImageIcon("icons/card.gif");
    ImageIcon bitcoin_Icon  = new ImageIcon("icons/bitcoin.gif");
    ImageIcon back_Icon     = new ImageIcon("icons/back.gif");

    cash    = new JButton(cash_Icon);
    card    = new JButton(card_Icon);
    bitcoin = new JButton(bitcoin_Icon);
    back    = new JButton(back_Icon);

    card.setBounds(70,200,200,136);
    cash.setBounds(295,200,200,136);
    bitcoin.setBounds(520,200,200,136);
    back.setBounds(120,450,100,43);

    pane.add(title);
    pane.add(card);
    pane.add(cash);
    pane.add(bitcoin);
    pane.add(back);
    pane.add(tableNumber);


    //Adding action listeners card, cash, bitcoin, and back buttons
    card.addActionListener(this);
    cash.addActionListener(this);
    bitcoin.addActionListener(this);
    back.addActionListener(this);


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
  if( source == card){
    setVisible(false);
    UnderConstruction uc = new UnderConstruction(tableID);
    //System.out.print("Card Payment Selected\n");
  }
  if( source == cash){
    setVisible(false);
    UnderConstruction uc = new UnderConstruction(tableID);
    //System.out.print("Cash Payment Selected\n");
  }
  if( source == bitcoin){
    setVisible(false);
    BitcoinPayment btc = new BitcoinPayment(tableID);
  }
  if( source == back){
    setVisible(false);
    CustomerTableScreen cts = new CustomerTableScreen(tableID);
    //System.out.println("CustomerTableScreen()");
  }

}

} //end class MakePayment

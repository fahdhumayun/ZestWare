import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//Coded by: Nathan Morgenstern
//Tested by: --------------

//****************************************************************
//*********************  PLACE ORDER (CTS)  **********************
//****************************************************************
//Constructor for the interface that the user goes to
//upon clicking the placeOrder button
public class PlaceOrder extends JFrame implements ActionListener {

  //Create the buttons of the Place Order Screen
  JButton food;
  JButton drinks;
  JButton sideOrders;
  JButton desserts;
  JButton specials;
  JButton back;
  int tableID;

  public PlaceOrder(int table_id){
  super("Place Order(CTS)");
  tableID = table_id;

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JPanel pane = new JPanel();
  pane.setLayout(null);

  //Setting the Title and location
  JLabel title = new JLabel("Place Order (CTS)");
  JLabel tableNumber = new JLabel("Table # " + tableID);
  title.setBounds(300,5,600,100);
  tableNumber.setBounds(500,450,300,43);

  Font font = new Font("Cambria", Font.BOLD, 30);
  Font font2 = new Font("Cambria", Font.BOLD, 20);
  title.setFont(font);
  tableNumber.setFont(font2);

  //Import the image icons for the buttons
  ImageIcon food_Icon       = new ImageIcon("icons/food.gif");
  ImageIcon drinks_Icon     = new ImageIcon("icons/drinks.gif");
  ImageIcon sideOrders_Icon = new ImageIcon("icons/sideOrders.gif");
  ImageIcon desserts_Icon   = new ImageIcon("icons/desserts.gif");
  ImageIcon specials_Icon   = new ImageIcon("icons/specials.gif");
  ImageIcon back_Icon       = new ImageIcon("icons/back.gif");


  food       = new JButton(food_Icon);
  drinks     = new JButton(drinks_Icon);
  sideOrders = new JButton(sideOrders_Icon);
  desserts   = new JButton(desserts_Icon);
  specials   = new JButton(specials_Icon);
  back       = new JButton(back_Icon);

  food.setBounds(50,100,220,150);
  drinks.setBounds(290,100,220,150);
  sideOrders.setBounds(530,100,220,150);
  desserts.setBounds(180,280,220,150);
  specials.setBounds(440,280,220,150);
  back.setBounds(70,450,100,43);

  //Adding the buttons to the pane
  pane.add(title);
  pane.add(tableNumber);
  pane.add(food);
  pane.add(drinks);
  pane.add(sideOrders);
  pane.add(desserts);
  pane.add(specials);
  pane.add(back);

  //Adding action listeners food,drinks,sideOrders,desserts, and specials
  food.addActionListener(this);
  drinks.addActionListener(this);
  sideOrders.addActionListener(this);
  desserts.addActionListener(this);
  specials.addActionListener(this);
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

  if( source == food){
    setVisible(false);
    UnderConstruction uc = new UnderConstruction(tableID);
    //System.out.println("Food Selected");
  }
  if( source == drinks){
    setVisible(false);
    UnderConstruction uc = new UnderConstruction(tableID);
    //System.out.println("Drink Selected");
  }
  if( source == sideOrders){
    setVisible(false);
    UnderConstruction uc = new UnderConstruction(tableID);
    //System.out.println("SideOrders Selected");
  }
  if( source == desserts){
    setVisible(false);
    UnderConstruction uc = new UnderConstruction(tableID);
    //System.out.println("Desserts Selected");
  }
  if( source == specials){
    setVisible(false);
    UnderConstruction uc = new UnderConstruction(tableID);
    //System.out.println("Specials Selected");
  }
  if( source == back){
    setVisible(false);
    //CustomerTableScreen cts = new CustomerTableScreen(tableID);
  }

}

} // end class PlaceOrder

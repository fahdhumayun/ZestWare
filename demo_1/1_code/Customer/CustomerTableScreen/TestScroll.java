import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.math.*;

public class PlaceOrder extends JFrame implements ActionListener
{
  BigDecimal total = new BigDecimal("0.00");
  //JBUttons for the food pane
  JButton mangoChicken;
  JButton orangeChicken;
  JButton sesameChicken;
  //JButtons for the drink pane including soft drinks, juice, and milk shakes
  JButton coke;   JButton strawMilk; JButton orangeJuice;
  JButton pepsi;  JButton chocMilk;  JButton grapeJuice;
  JButton sprite; JButton vanMilk;   JButton appleJuice;

  int tableID;

  public PlaceOrder(int table_id)
  {
    super("Place Order Pane");
    tableID = table_id;
    JTabbedPane tabPane  = new JTabbedPane();
    //Create new jpanels for food, drink, appetizers, desserts, and bill
    JPanel foodPane      = foodPane();
    JPanel drinkPane     = drinkPane();
    JPanel appetizerPane = appetizerPane();
    JPanel dessertPane   = dessertPane();
    JPanel billPane      = billPane();


    //Set up JScrollPane for scrolling ability in the food Pane
    JScrollPane scrollFrame = new JScrollPane(foodPane,
    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    foodPane.setAutoscrolls(true);
    scrollFrame.setPreferredSize(new Dimension( 800,600));

    //Set up JScrollPane for scrolling ability in the drink Pane
    JScrollPane scrollFrame2 = new JScrollPane(drinkPane,
    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    drinkPane.setAutoscrolls(true);
    scrollFrame2.setPreferredSize(new Dimension(800,600));

    //Set up JScrollPane for scrolling ability in the drink Pane
    JScrollPane scrollFrame3 = new JScrollPane(appetizerPane,
    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    appetizerPane.setAutoscrolls(true);
    scrollFrame3.setPreferredSize(new Dimension(800,600));

    //Set up JScrollPane for scrolling ability in the drink Pane
    JScrollPane scrollFrame4 = new JScrollPane(dessertPane,
    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    dessertPane.setAutoscrolls(true);
    scrollFrame4.setPreferredSize(new Dimension(800,600));

    //Image Icon setup for Appetizer Items
    //Image Icon setup for Dessert Items

    //Add all the items to the JPanel
    this.add(scrollFrame);
    this.add(scrollFrame2);
    this.add(scrollFrame3);
    this.add(scrollFrame4);
    //Adding the tabs to the JPanel
    tabPane.add("Food Pane",  scrollFrame);
    tabPane.add("Drink Pane", scrollFrame2);
    tabPane.add("Appetizer Pane", scrollFrame3);
    tabPane.add("Dessert Pane", scrollFrame4);
    tabPane.add("Bill Pane",  billPane);
    //Adding all the components together to create the JFrame
    this.add(tabPane);
    setSize(800,600);
    setVisible(true);
}
//References: http://stackoverflow.com/questions/21636895/how-to-add-a-scroll-bar-to-a-jtabbedpane-basically-i-have-an-admin-panel-which


public JPanel foodPane()
{
  JPanel foodPane = new JPanel();
  foodPane.setPreferredSize(new Dimension(800,1500));
  foodPane.setLayout(null);
  Font defaultFont = new Font("Cambria", Font.BOLD, 12);
  Font headerFont  = new Font("Cambria", Font.BOLD, 30);
  //Image Icons setup for food items
  ImageIcon orangeChicken_Icon = new ImageIcon("menuImages/food/orangeChicken.jpg");
  ImageIcon mangoChicken_Icon  = new ImageIcon("menuImages/food/mangoChicken.jpg");
  ImageIcon sesameChicken_Icon = new ImageIcon("menuImages/food/sesameChicken.jpg");

  //Setting up the image postions with setBounds() for food panel
  orangeChicken   = new JButton(orangeChicken_Icon);
  orangeChicken.setBounds(50,150,200,150);
  mangoChicken   = new JButton(mangoChicken_Icon);
  mangoChicken.setBounds(275,150,200,150);
  sesameChicken = new JButton(sesameChicken_Icon);
  sesameChicken.setBounds(500,150,200,150);

  //Setting the fonts and location of the menu headers
  JLabel mainEntree = new JLabel("Main Entrees");
  mainEntree.setBounds(300,5,200,150);
  //Setting Fonts and location of the menu items
  JLabel food1 = new JLabel("Orange Chicken....$8.75");
  JLabel food2 = new JLabel("Mango  Chicken....$8.75");
  JLabel food3 = new JLabel("Sesame Chicken....$8.75");
  //Setting the font and location of the food panel items
  food1.setBounds(80,250,200,150);
  food2.setBounds(300,250,200,150);
  food3.setBounds(520,250,200,150);
  food1.setFont(defaultFont);
  food2.setFont(defaultFont);
  food3.setFont(defaultFont);
  mainEntree.setFont(headerFont);

  //Adding action listeners placeOrder, makePayment, callAssistance, and entertainment
  orangeChicken.addActionListener(this);
  mangoChicken.addActionListener(this);
  sesameChicken.addActionListener(this);

  //Adding items to the foodPane
  foodPane.add(mainEntree);
  foodPane.add(food1);
  foodPane.add(food2);
  foodPane.add(food3);
  foodPane.add(orangeChicken);
  foodPane.add(mangoChicken);
  foodPane.add(sesameChicken);

  return foodPane;
}

public JPanel drinkPane()
{
  JPanel drinkPane   = new JPanel();
  drinkPane.setLayout(null);
  //Setting the preferred dimension sizes of the JPanel
  drinkPane.setPreferredSize(new Dimension(800,1500));
  //Image Icon setup for Drink Items
  ImageIcon coke_Icon   = new ImageIcon("menuImages/drink/coke.jpg");
  ImageIcon pepsi_Icon  = new ImageIcon("menuImages/drink/pepsi.gif");
  ImageIcon sprite_Icon = new ImageIcon("menuImages/drink/sprite.jpg");

  ImageIcon orange_Icon = new ImageIcon("menuImages/drink/orangeJuice.jpg");
  ImageIcon grape_Icon  = new ImageIcon("menuImages/drink/grapeJuice.jpg");
  ImageIcon apple_Icon  = new ImageIcon("menuImages/drink/appleJuice.jpg");

  ImageIcon chocMilk_Icon  = new ImageIcon("menuImages/drink/chocMilk.jpg");
  ImageIcon vanMilk_Icon   = new ImageIcon("menuImages/drink/vanillaShake.jpg");
  ImageIcon strawMilk_Icon = new ImageIcon("menuImages/drink/strawMilk.jpg");
  //Setting up the image postions with setBounds() for food panel
  //Soft Drink Icons
  coke   = new JButton(coke_Icon);
  pepsi   = new JButton(pepsi_Icon);
  sprite = new JButton(sprite_Icon);
  //Juice Icons:
  orangeJuice = new JButton(orange_Icon);
  grapeJuice  = new JButton(grape_Icon);
  appleJuice  = new JButton(apple_Icon);
  //Milk Shake Icons:
  chocMilk = new JButton(chocMilk_Icon);
  vanMilk  = new JButton(vanMilk_Icon);
  strawMilk = new JButton(strawMilk_Icon);

  coke.setBounds(50,150,200,150);
  pepsi.setBounds(275,150,200,150);
  sprite.setBounds(500,150,200,150);

  orangeJuice.setBounds(50,425,200,150);
  grapeJuice.setBounds(270,425,200,150);
  appleJuice.setBounds(500,425,200,150);

  chocMilk.setBounds(50,700,200,150);
  vanMilk.setBounds(270,700,200,150);
  strawMilk.setBounds(500,700,200,150);

  //Setting up the fonts to be used in the panels
  Font defaultFont = new Font("Cambria", Font.BOLD, 12);
  Font headerFont  = new Font("Cambria", Font.BOLD, 30);
  //Setting the fonts and location of the menu headers
  JLabel sodaHeader = new JLabel("Soft Drinks");
  JLabel juiceHeader = new JLabel("Juice");
  JLabel milkHeader  = new JLabel("Milk Shakes");
  //Setting the location of the headers
  sodaHeader.setBounds(300,5,200,150);
  juiceHeader.setBounds(330,300,200,150);
  milkHeader.setBounds(300,595,200,150);
  //Setting Fonts and location of the menu items
  JLabel drink1 = new JLabel("Coke....$1.99");
  JLabel drink2 = new JLabel("Pepsi....$1.99");
  JLabel drink3 = new JLabel("Sprite....$1.99");

  JLabel drink4 = new JLabel("Orange Juice....$2.10");
  JLabel drink5 = new JLabel("Grape Juice....$2.10");
  JLabel drink6 = new JLabel("Apple Juice....$2.10");

  JLabel drink7 = new JLabel("Chocolate Shake....$3.39");
  JLabel drink8 = new JLabel("Vanilla Shake....$3.39");
  JLabel drink9 = new JLabel("Strawberry Shake....$3.39");
  //Setting the font and location of the food panel items
  drink1.setBounds(95,250,200,150);
  drink2.setBounds(320,250,200,150);
  drink3.setBounds(540,250,200,150);

  drink4.setBounds(75,525,200,150);
  drink5.setBounds(300,525,200,150);
  drink6.setBounds(540,525,200,150);

  drink7.setBounds(50,800,200,150);
  drink8.setBounds(280,800,200,150);
  drink9.setBounds(520,800,200,150);

  drink1.setFont(defaultFont);
  drink2.setFont(defaultFont);
  drink3.setFont(defaultFont);

  drink4.setFont(defaultFont);
  drink5.setFont(defaultFont);
  drink6.setFont(defaultFont);

  drink7.setFont(defaultFont);
  drink8.setFont(defaultFont);
  drink9.setFont(defaultFont);

  sodaHeader.setFont(headerFont);
  juiceHeader.setFont(headerFont);
  milkHeader.setFont(headerFont);
  //Adding items to the foodPane
  drinkPane.add(sodaHeader);
  drinkPane.add(drink1);
  drinkPane.add(drink2);
  drinkPane.add(drink3);
  drinkPane.add(coke);
  drinkPane.add(pepsi);
  drinkPane.add(sprite);

  drinkPane.add(juiceHeader);
  drinkPane.add(drink4);
  drinkPane.add(drink5);
  drinkPane.add(drink6);
  drinkPane.add(orangeJuice);
  drinkPane.add(grapeJuice);
  drinkPane.add(appleJuice);

  drinkPane.add(milkHeader);
  drinkPane.add(drink7);
  drinkPane.add(drink8);
  drinkPane.add(drink9);
  drinkPane.add(chocMilk);
  drinkPane.add(vanMilk);
  drinkPane.add(strawMilk);
  //Adding action listeners for drinks...
  coke.addActionListener(this);
  pepsi.addActionListener(this);
  sprite.addActionListener(this);

  orangeJuice.addActionListener(this);
  appleJuice.addActionListener(this);
  grapeJuice.addActionListener(this);

  chocMilk.addActionListener(this);
  vanMilk.addActionListener(this);
  strawMilk.addActionListener(this);

  return drinkPane;
}

public JPanel appetizerPane()
{
  JPanel appetizerPane = new JPanel();
  appetizerPane.setLayout(null);
  appetizerPane.setPreferredSize(new Dimension(800,1500));

  //Setting up the fonts to be used in the panels
  Font defaultFont = new Font("Cambria", Font.BOLD, 12);
  Font headerFont  = new Font("Cambria", Font.BOLD, 30);

  return appetizerPane;
}

public JPanel dessertPane()
{
  JPanel dessertPane   = new JPanel();
  dessertPane.setLayout(null);
  dessertPane.setPreferredSize(new Dimension(800,1500));

  //Setting up the fonts to be used in the panels
  Font defaultFont = new Font("Cambria", Font.BOLD, 12);
  Font headerFont  = new Font("Cambria", Font.BOLD, 30);

  return dessertPane;
}

public JPanel billPane()
{
  JPanel billPane  = new JPanel();
  billPane.setLayout(null);
  return billPane;
}

  @Override
  public void actionPerformed(ActionEvent e)
  {
    Object source = e.getSource();

    BigDecimal _ch  = new BigDecimal("8.75");
    System.out.println("_ch:" + _ch);
    BigDecimal _sd  = new BigDecimal("1.99");
    System.out.println("_sd:" + _sd);
    BigDecimal _ms  = new BigDecimal("2.10");
    System.out.println("_ms:" + _ms);

    if (source == orangeChicken || source == mangoChicken || source == sesameChicken)
      total = total.add(_ch);
    if( source == coke || source == pepsi || source == sprite)
      total = total.add(_sd);
    if(source == orangeJuice || source == grapeJuice || source == appleJuice)
      total = total.add(_ms);

    System.out.print("Total: " + total + "\n");
  }


  public static void main(String[] args)
  {
    PlaceOrder ts = new PlaceOrder(1);
  }

}

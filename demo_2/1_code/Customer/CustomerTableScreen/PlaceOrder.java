import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import javax.swing.table.*;

public class PlaceOrder extends JFrame implements ActionListener
{
  JTabbedPane tabPane;

  BigDecimal total = new BigDecimal("0.00");
  //JButtons for the billpane
  JButton back;
  JButton confirm;
  //JBUttons for the food pane including meats,
  JButton mangoChicken;  JButton grilledSalmon;  JButton spaghetti;
  JButton orangeChicken; JButton grilledChicken; JButton lasagna;
  JButton sesameChicken; JButton chickenWings;   JButton ravioli;
  //JButtons for the drink pane including soft drinks, juice, and milk shakes
  JButton coke;   JButton strawMilk; JButton orangeJuice;
  JButton pepsi;  JButton chocMilk;  JButton grapeJuice;
  JButton sprite; JButton vanMilk;   JButton appleJuice;
  //JButtons for the appetizer pane including
  JButton caesarSalad;    JButton frenchFries;
  JButton fruitSalad;     JButton mozzarellaSticks;
  JButton vegetableSalad; JButton onionRings;
  //JButtons for the dessert pane including ice cream, and cakes
  JButton chocIceCream;   JButton redCake;
  JButton vanIceCream;    JButton cheeseCake;
  JButton strawIceCream;  JButton carrotCake;

  //Other variables needed for the functionality
  int tableID;

  String[][] foodArray = {
    {"Orange Chicken", "Mango Chicken", "Sesame Chicken","Grilled Salmon", "Grilled Chicken",
     "Chicken Wings", "Spaghetti and Meatballs","Lasagna", "Ravioli"},
    {"0", "0", "0","0","0","0"},
  };
  String[][] drinkArray = {
    {"Coke", "Pepsi", "Sprite","Orange Juice", "Grape Juice", "Apple Juice",
    "Chocolate Shake", "Vanilla Shake", "Strawberry Shake"},
    {"0","0","0","0","0","0","0","0","0"},
  };
  String[][] appetizerArray = {
    {"Caesar Salad","Fruit Salad","Vegetable Salad","French Fries","Mozzarella Sticks","Onion Rings"},
    {"0","0","0","0","0","0"},
  };
  String[][] dessertArray = {
    {"Chocolate Ice Cream","Vanilla Ice Cream","Strawberry Ice Cream","Red Velvet Cake","Cheese Cake","Carrot Cake"},
    {"0","0","0","0","0","0"},
  };
  String[][] currentOrder = {
    {" "," "," "," "," "," "," "," "," "," "},
    {"0","0","0","0","0","0","0","0","0","0"},
  };


  // add header of the table


  public PlaceOrder(int table_id)
  {
    super("Place Order Pane");
    tableID = table_id;
    tabPane  = new JTabbedPane();
    //Create new jpanels for food, drink, appetizers, desserts, and bill
    JPanel foodPane      = foodPane();
    JPanel drinkPane     = drinkPane();
    JPanel appetizerPane = appetizerPane();
    JPanel dessertPane   = dessertPane();
    JPanel billPane      = billPane(total);

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
  //Image Icons setup for food items on the food panel
  ImageIcon orangeChicken_Icon = new ImageIcon("menuImages/food/orangeChicken.jpg");
  ImageIcon mangoChicken_Icon  = new ImageIcon("menuImages/food/mangoChicken.jpg");
  ImageIcon sesameChicken_Icon = new ImageIcon("menuImages/food/sesameChicken.jpg");

  ImageIcon grilledSalmon_Icon  = new ImageIcon("menuImages/food/grilledSalmon.jpg");
  ImageIcon grilledChicken_Icon = new ImageIcon("menuImages/food/grilledChicken.jpg");
  ImageIcon chickenWings_Icon   = new ImageIcon("menuImages/food/grilledChickenWings.jpg");

  ImageIcon spaghetti_Icon      = new ImageIcon("menuImages/food/spaghetti.jpg");
  ImageIcon lasagna_Icon        = new ImageIcon("menuImages/food/lasagna.jpg");
  ImageIcon ravioli_Icon        = new ImageIcon("menuImages/food/ravioli.jpg");
  //Setting the JButton images for each of the food panel items
  orangeChicken  = new JButton(orangeChicken_Icon);
  mangoChicken   = new JButton(mangoChicken_Icon);
  sesameChicken  = new JButton(sesameChicken_Icon);
  grilledSalmon  = new JButton(grilledSalmon_Icon);
  grilledChicken = new JButton(grilledChicken_Icon);
  chickenWings   = new JButton(chickenWings_Icon);
  spaghetti      = new JButton(spaghetti_Icon);
  lasagna        = new JButton(lasagna_Icon);
  ravioli        = new JButton(ravioli_Icon);

  orangeChicken.setBounds(50,150,200,150);
  mangoChicken.setBounds(275,150,200,150);
  sesameChicken.setBounds(500,150,200,150);

  grilledSalmon.setBounds(50,375,200,150);
  grilledChicken.setBounds(275,375,200,150);
  chickenWings.setBounds(500,375,200,150);

  spaghetti.setBounds(50,600,200,150);
  lasagna.setBounds(275,600,200,150);
  ravioli.setBounds(500,600,200,150);
  //Setting the fonts and location of the menu headers
  JLabel mainEntree = new JLabel("Main Entrees");
  mainEntree.setBounds(300,5,200,150);
  //Setting Fonts and location of the menu items
  JLabel food1 = new JLabel("Orange Chicken....$8.75");
  JLabel food2 = new JLabel("Mango  Chicken....$8.75");
  JLabel food3 = new JLabel("Sesame Chicken....$8.75");

  JLabel food4 = new JLabel("Grilled Salmon....$8.25");
  JLabel food5 = new JLabel("Grilled Chicken....$7.75");
  JLabel food6 = new JLabel("Chicken Wings....$7.75");

  JLabel food7 = new JLabel("Spaghetti....$5.95");
  JLabel food8 = new JLabel("Lasagna....$6.75");
  JLabel food9 = new JLabel("Ravioli....$6.25");
  //Setting the font and location of the food panel items
  food1.setBounds(80,250,200,150);
  food2.setBounds(300,250,200,150);
  food3.setBounds(520,250,200,150);

  food4.setBounds(80,475,200,150);
  food5.setBounds(300,475,200,150);
  food6.setBounds(520,475,200,150);

  food7.setBounds(80,700,200,150);
  food8.setBounds(300,700,200,150);
  food9.setBounds(540,700,200,150);

  food1.setFont(defaultFont);
  food2.setFont(defaultFont);
  food3.setFont(defaultFont);

  food4.setFont(defaultFont);
  food5.setFont(defaultFont);
  food6.setFont(defaultFont);

  food7.setFont(defaultFont);
  food8.setFont(defaultFont);
  food9.setFont(defaultFont);

  mainEntree.setFont(headerFont);

  //Adding items to the foodPane
  foodPane.add(mainEntree);
  foodPane.add(food1);
  foodPane.add(food2);
  foodPane.add(food3);
  foodPane.add(food4);
  foodPane.add(food5);
  foodPane.add(food6);
  foodPane.add(food7);
  foodPane.add(food8);
  foodPane.add(food9);
  foodPane.add(orangeChicken);
  foodPane.add(mangoChicken);
  foodPane.add(sesameChicken);
  foodPane.add(grilledSalmon);
  foodPane.add(grilledChicken);
  foodPane.add(chickenWings);
  foodPane.add(spaghetti);
  foodPane.add(lasagna);
  foodPane.add(ravioli);
  //Adding action listeners placeOrder, makePayment, callAssistance, and entertainment
  orangeChicken.addActionListener(this);
  mangoChicken.addActionListener(this);
  sesameChicken.addActionListener(this);
  grilledSalmon.addActionListener(this);
  grilledChicken.addActionListener(this);
  chickenWings.addActionListener(this);
  spaghetti.addActionListener(this);
  lasagna.addActionListener(this);
  ravioli.addActionListener(this);
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
  //Setting up the image postions with setBounds() for food panel
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
  //Setting the JLabels for each of the food panel items
  JLabel drink1 = new JLabel("Coke....$1.99");
  JLabel drink2 = new JLabel("Pepsi....$1.99");
  JLabel drink3 = new JLabel("Sprite....$1.99");

  JLabel drink4 = new JLabel("Orange Juice....$2.10");
  JLabel drink5 = new JLabel("Grape Juice....$2.10");
  JLabel drink6 = new JLabel("Apple Juice....$2.10");

  JLabel drink7 = new JLabel("Chocolate Shake....$3.39");
  JLabel drink8 = new JLabel("Vanilla Shake....$3.39");
  JLabel drink9 = new JLabel("Strawberry Shake....$3.39");
  //Setting the location of the food panel items
  drink1.setBounds(95,250,200,150);
  drink2.setBounds(320,250,200,150);
  drink3.setBounds(540,250,200,150);

  drink4.setBounds(75,525,200,150);
  drink5.setBounds(300,525,200,150);
  drink6.setBounds(540,525,200,150);

  drink7.setBounds(50,800,200,150);
  drink8.setBounds(280,800,200,150);
  drink9.setBounds(520,800,200,150);
  //Setting the fonts of the drink pane items
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
  //Image Icon setup for Appetizer Items
  ImageIcon caesarSalad_Icon = new ImageIcon("menuImages/appetizer/caesarSalad.jpg");
  ImageIcon fruitSalad_Icon  = new ImageIcon("menuImages/appetizer/fruitSalad.jpg");
  ImageIcon vegetableSalad_Icon = new ImageIcon("menuImages/appetizer/vegetableSalad.jpg");

  ImageIcon frenchFries_Icon      = new ImageIcon("menuImages/appetizer/frenchFries.jpg");
  ImageIcon mozzarellaSticks_Icon = new ImageIcon("menuImages/appetizer/mozzarellaSticks.jpg");
  ImageIcon onionRings_Icon       = new ImageIcon("menuImages/appetizer/onionRing.jpg");

  //Salad Icons
  caesarSalad      = new JButton(caesarSalad_Icon);
  fruitSalad       = new JButton(fruitSalad_Icon);
  vegetableSalad   = new JButton(vegetableSalad_Icon);

  frenchFries      = new JButton(frenchFries_Icon);
  mozzarellaSticks = new JButton(mozzarellaSticks_Icon);
  onionRings       = new JButton(onionRings_Icon);
  //Setting up the image postions with setBounds() for food panel
  caesarSalad.setBounds(50,150,200,150);
  fruitSalad.setBounds(275,150,200,150);
  vegetableSalad.setBounds(500,150,200,150);

  frenchFries.setBounds(50,425,200,150);
  mozzarellaSticks.setBounds(270,425,200,150);
  onionRings.setBounds(500,425,200,150);
  //Setting up the fonts to be used in the panels
  Font defaultFont = new Font("Cambria", Font.BOLD, 12);
  Font headerFont  = new Font("Cambria", Font.BOLD, 30);
  //Setting the fonts and location of the menu headers
  JLabel saladHeader = new JLabel("Salads");
  JLabel snackHeader = new JLabel("Snacks");
  //Setting the location of the headers
  saladHeader.setBounds(300,5,200,150);
  snackHeader.setBounds(330,300,200,150);
  //Setting the JLabels for each of the food panel items
  JLabel appetizer1 = new JLabel("Caesar Salad....$1.50");
  JLabel appetizer2 = new JLabel("Fruit Salad....$1.00");
  JLabel appetizer3 = new JLabel("Vegetable Salad....$1.50");

  JLabel appetizer4 = new JLabel("French Fries....$2.19");
  JLabel appetizer5 = new JLabel("Mozzarella Sticks....$2.75");
  JLabel appetizer6 = new JLabel("Onion Rings....$2.19");
  //Setting the font and location of the food panel items
  appetizer1.setBounds(80,250,200,150);
  appetizer2.setBounds(300,250,200,150);
  appetizer3.setBounds(520,250,200,150);

  appetizer4.setBounds(75,525,200,150);
  appetizer5.setBounds(300,525,200,150);
  appetizer6.setBounds(520,525,200,150);

  appetizer1.setFont(defaultFont);
  appetizer2.setFont(defaultFont);
  appetizer3.setFont(defaultFont);
  saladHeader.setFont(headerFont);
  snackHeader.setFont(headerFont);
  //adding the items to the appetizer pane
  appetizerPane.add(saladHeader);
  appetizerPane.add(snackHeader);
  appetizerPane.add(appetizer1);
  appetizerPane.add(appetizer2);
  appetizerPane.add(appetizer3);
  appetizerPane.add(appetizer4);
  appetizerPane.add(appetizer5);
  appetizerPane.add(appetizer6);
  appetizerPane.add(caesarSalad);
  appetizerPane.add(fruitSalad);
  appetizerPane.add(vegetableSalad);
  appetizerPane.add(frenchFries);
  appetizerPane.add(mozzarellaSticks);
  appetizerPane.add(onionRings);

  //Adding action listeners for each of the appetizer buttons
  caesarSalad.addActionListener(this);
  fruitSalad.addActionListener(this);
  vegetableSalad.addActionListener(this);
  frenchFries.addActionListener(this);
  mozzarellaSticks.addActionListener(this);
  onionRings.addActionListener(this);


  return appetizerPane;
}

public JPanel dessertPane()
{
  JPanel dessertPane   = new JPanel();
  dessertPane.setLayout(null);
  //Setting the preferred dimension sizes of the JPanel
  dessertPane.setPreferredSize(new Dimension(800,1500));
  //Image Icon setup for Dessert Items
  ImageIcon chocIce_Icon   = new ImageIcon("menuImages/dessert/chocIceCream.jpg");
  ImageIcon vanIce_Icon  = new ImageIcon("menuImages/dessert/vanIceCream.jpg");
  ImageIcon strawIce_Icon = new ImageIcon("menuImages/dessert/strawIceCream.jpg");

  ImageIcon redCake_Icon = new ImageIcon("menuImages/dessert/redVelvetCake.jpg");
  ImageIcon cheeseCake_Icon = new ImageIcon("menuImages/dessert/cheeseCake.jpg");
  ImageIcon carrotCake_Icon = new ImageIcon("menuImages/dessert/carrotCake.jpg");
  //Initializing dessert items
  chocIceCream  = new JButton(chocIce_Icon);
  vanIceCream   = new JButton(vanIce_Icon);
  strawIceCream = new JButton(strawIce_Icon);

  redCake = new JButton(redCake_Icon);
  cheeseCake = new JButton(cheeseCake_Icon);
  carrotCake = new JButton(carrotCake_Icon);
  //Setting the position of the dessert pane items
  chocIceCream.setBounds(50,150,200,150);
  vanIceCream.setBounds(275,150,200,150);
  strawIceCream.setBounds(500,150,200,150);

  redCake.setBounds(50,425,200,150);
  cheeseCake.setBounds(275,425,200,150);
  carrotCake.setBounds(500,425,200,150);
  //Setting up the fonts to be used in the panels
  Font defaultFont = new Font("Cambria", Font.BOLD, 12);
  Font headerFont  = new Font("Cambria", Font.BOLD, 30);
  //Setting the fonts and location of the menu headers
  JLabel iceCreamHeader = new JLabel("Ice Cream");
  JLabel cakeHeader     = new JLabel("Cakes");
  iceCreamHeader.setBounds(300,5,200,150);
  cakeHeader.setBounds(320,300,200,150);
  //Setting Fonts and location of the menu items
  JLabel dessert1 = new JLabel("Chocolate Ice Cream....$2.25");
  JLabel dessert2 = new JLabel("Vanilla Ice Cream....$2.25");
  JLabel dessert3 = new JLabel("Strawberry Ice Cream....$2.25");
  JLabel dessert4 = new JLabel("Red Velvet Cake....$6.75");
  JLabel dessert5 = new JLabel("Cheese Cake....$6.25");
  JLabel dessert6 = new JLabel("Carrot Cake....$6.09");
  //Setting the font and location of the dessert panel items
  dessert1.setBounds(80,250,200,150);
  dessert2.setBounds(300,250,200,150);
  dessert3.setBounds(520,250,200,150);
  dessert4.setBounds(80,525,200,150);
  dessert5.setBounds(300,525,200,150);
  dessert6.setBounds(520,525,200,150);
  //Setting the fonts of the dessert panel items
  dessert1.setFont(defaultFont);
  dessert2.setFont(defaultFont);
  dessert3.setFont(defaultFont);
  dessert4.setFont(defaultFont);
  dessert5.setFont(defaultFont);
  dessert6.setFont(defaultFont);
  iceCreamHeader.setFont(headerFont);
  cakeHeader.setFont(headerFont);
  //Adding items to the foodPane
  dessertPane.add(iceCreamHeader);
  dessertPane.add(cakeHeader);
  dessertPane.add(dessert1);
  dessertPane.add(dessert2);
  dessertPane.add(dessert3);
  dessertPane.add(dessert4);
  dessertPane.add(dessert5);
  dessertPane.add(dessert6);
  dessertPane.add(chocIceCream);
  dessertPane.add(vanIceCream);
  dessertPane.add(strawIceCream);
  dessertPane.add(redCake);
  dessertPane.add(cheeseCake);
  dessertPane.add(carrotCake);
  //Adding action listeners
  chocIceCream.addActionListener(this);
  vanIceCream.addActionListener(this);
  strawIceCream.addActionListener(this);
  redCake.addActionListener(this);
  cheeseCake.addActionListener(this);
  carrotCake.addActionListener(this);

  return dessertPane;
}

public JPanel billPane(BigDecimal _bd)
{
  JPanel billPane  = new JPanel();
  billPane.setLayout(null);
  Font headerFont  = new Font("Cambria", Font.BOLD, 30);
  Font defaultFont = new Font("Cambria", Font.BOLD, 12);
  //Setting the fonts and location of the menu headers
  JLabel invoice = new JLabel("Total: " + _bd);
  JLabel itemCol = new JLabel("Item(s)");
  JLabel qtyCol  = new JLabel("Quantity");
  invoice.setBounds(50,5,200,150);
  itemCol.setBounds(300,40,200,150);
  qtyCol.setBounds(450,40,200,150);
  invoice.setFont(headerFont);
  itemCol.setFont(defaultFont);
  qtyCol.setFont(defaultFont);
  ImageIcon back_Icon = new ImageIcon("icons/back.gif");
  back = new JButton(back_Icon);
  back.setBounds(120,450,100,43);


  // create object of table and table model
  JTable tbl = new JTable();
  String[] header = new String[] {"Item(s)", "Quantity"};
  DefaultTableModel dtm = new DefaultTableModel(0, 0);
  // add header in table model
  dtm.setColumnIdentifiers(header);
  //set model into the table object
  tbl.setModel(dtm);

    int tmp = 0;
    for (int count = 0; count < 6; count++)
    {
      tmp = Integer.parseInt(foodArray[1][count]);
      if(tmp != 0)
       dtm.addRow(new Object[] {foodArray[0][count], foodArray[1][count] });
    }
    for(int count2 = 0; count2 < 9; count2++)
    {
      tmp = Integer.parseInt(drinkArray[1][count2]);
      if(tmp != 0)
        dtm.addRow(new Object[] {drinkArray[0][count2], drinkArray[1][count2]});
    }
    for(int count3 = 0; count3 < 6; count3++)
    {
      tmp = Integer.parseInt(appetizerArray[1][count3]);
      if(tmp != 0)
        dtm.addRow(new Object[] {appetizerArray[0][count3],appetizerArray[1][count3]});
    }

  /*DefaultTableModel model = new DefaultTableModel(new String[][]
  {
      { "Chicken", "1" }, { "Coke", "2" } }, new String[] { "Item(s)", "Quantity" });
  JTable table = new JTable(model);*/
  //table.setBounds(250,130,300,250);
  tbl.setBounds(250,130,300,250);
  billPane.add(tbl);
  //billPane.add(table);
  billPane.add(invoice);
  billPane.add(back);
  billPane.add(itemCol);
  billPane.add(qtyCol);
  //billPane.add(confirm);
  back.addActionListener(this);
  //confirm.addActionListener(this);
  return billPane;
}

/*
*        METHODS FOR UPDATING THE ARRAY
*        VALUES OF FOOD,DRINK,DESSERT,
*        APPETIZER, ETC
*/
public void updateFoodArray(Object source)
{
  if(source == orangeChicken)
    foodArray[1][0] = incrString(foodArray[1][0]);
  else if(source == mangoChicken)
    foodArray[1][1] = incrString(foodArray[1][1]);
  else if(source == sesameChicken)
    foodArray[1][2] = incrString(foodArray[1][2]);
  else if(source == grilledSalmon){
    foodArray[1][3] = incrString(foodArray[1][3]);
    total = total.add(new BigDecimal("8.25"));
  }
  else if(source == grilledChicken){
    foodArray[1][4] = incrString(foodArray[1][4]);
    total = total.add(new BigDecimal("7.75"));
  }
  else if(source == chickenWings){
    foodArray[1][5] = incrString(foodArray[1][5]);
    total = total.add(new BigDecimal("7.75"));
  }
  else if(source == spaghetti){
    foodArray[1][6] = incrString(foodArray[1][6]);
    total = total.add(new BigDecimal("5.95"));
  }
  else if(source == lasagna){
    foodArray[1][7] = incrString(foodArray[1][7]);
    total = total.add(new BigDecimal("6.75"));
  }
  else if(source == ravioli){
    foodArray[1][8] = incrString(foodArray[1][8]);
    total = total.add(new BigDecimal("6.25"));
  }
}

public void updateDrinkArray(Object source)
{
  if( source == coke)
      drinkArray[1][0] = incrString(drinkArray[1][0]);
  else if( source == pepsi)
      drinkArray[1][1] = incrString(drinkArray[1][1]);
  else if( source == sprite)
      drinkArray[1][2] = incrString(drinkArray[1][2]);
  else if( source == orangeJuice)
      drinkArray[1][3] = incrString(drinkArray[1][3]);
  else if( source == grapeJuice)
      drinkArray[1][4] = incrString(drinkArray[1][4]);
  else if( source == appleJuice)
      drinkArray[1][5] = incrString(drinkArray[1][5]);
  else if( source == chocMilk)
      drinkArray[1][6] = incrString(drinkArray[1][6]);
  else if( source == vanMilk)
      drinkArray[1][7] = incrString(drinkArray[1][7]);
  else if( source == strawMilk)
      drinkArray[1][8] = incrString(drinkArray[1][8]);
}
public void updateAppetizerArray(Object source)
{
  if( source == caesarSalad){
      appetizerArray[1][0] = incrString(appetizerArray[1][0]);
      total = total.add(new BigDecimal("1.50"));
    }
  else if( source == fruitSalad){
      appetizerArray[1][1] = incrString(appetizerArray[1][1]);
      total = total.add(new BigDecimal("1.00"));
    }
  else if( source == vegetableSalad){
      appetizerArray[1][2] = incrString(appetizerArray[1][2]);
      total = total.add(new BigDecimal("1.50"));
    }
  else if( source == frenchFries)
      appetizerArray[1][3] = incrString(appetizerArray[1][3]);
  else if( source == mozzarellaSticks)
      appetizerArray[1][4] = incrString(appetizerArray[1][4]);
  else if( source == onionRings)
      appetizerArray[1][5] = incrString(appetizerArray[1][5]);
}

public void updateDessertArray(Object source)
{
  BigDecimal _rc = new BigDecimal("6.75");
  BigDecimal _ch = new BigDecimal("6.25");
  BigDecimal _cc = new BigDecimal("6.09");

  if( source == chocIceCream)
    dessertArray[1][0] = incrString(dessertArray[1][0]);
  else if( source == vanIceCream)
    dessertArray[1][1] = incrString(dessertArray[1][1]);
  else if( source == strawIceCream)
    dessertArray[1][2] = incrString(dessertArray[1][2]);
  else if( source == redCake)
  {
    dessertArray[1][3] = incrString(dessertArray[1][3]);
    total = total.add(_rc);
  }
  else if( source == cheeseCake)
  {
    dessertArray[1][4] = incrString(dessertArray[1][4]);
    total = total.add(_ch);
  }
  else if( source == carrotCake)
  {
      dessertArray[1][5] = incrString(dessertArray[1][5]);
      total = total.add(_cc);
  }
}
public String incrString(String str)
{
  int tmp = 0;
  String strTmp;
  tmp = Integer.parseInt(str);
  tmp+=1;
  strTmp = String.valueOf(tmp);
  return strTmp;
}



  @Override
  public void actionPerformed(ActionEvent e)
  {
    Object source = e.getSource();

    BigDecimal _ch  = new BigDecimal("8.75");
    BigDecimal _sd  = new BigDecimal("1.99");
    BigDecimal _ju  = new BigDecimal("2.10");
    BigDecimal _ms  = new BigDecimal("3.39");
    BigDecimal _ic  = new BigDecimal("2.25");

    if (source == orangeChicken || source == mangoChicken || source == sesameChicken)
    {
      total = total.add(_ch);
      updateFoodArray(source);
    }
    if(source == grilledSalmon || source == grilledChicken || source == chickenWings ||
       source == spaghetti || source == lasagna || source == ravioli)
       {
         updateFoodArray(source);
       }
    else if( source == coke || source == pepsi || source == sprite)
    {
      total = total.add(_sd);
      updateDrinkArray(source);
    }
    else if(source == orangeJuice || source == grapeJuice || source == appleJuice)
    {
      total = total.add(_ju);
      updateDrinkArray(source);
    }
    else if(source == chocMilk || source == vanMilk || source == strawMilk)
    {
      total = total.add(_ms);
      updateDrinkArray(source);
    }
    else if(source == chocIceCream || source == vanIceCream || source == strawIceCream)
    {
      total = total.add(_ic);
      updateDessertArray(source);
    }
    else if(source == redCake || source == cheeseCake || source == carrotCake)
      updateDessertArray(source);
    else if(source == caesarSalad || source == fruitSalad || source == vegetableSalad ||
            source == frenchFries || source == mozzarellaSticks || source == onionRings)
            {
              updateAppetizerArray(source);
            }
    else if(source == back)
    {
      setVisible(false);
      CustomerTableScreen cts = new CustomerTableScreen(tableID);
    }

    //Update the billPane with the new values
    JPanel newBillPane = billPane(total);
    tabPane.setComponentAt(4,newBillPane);
  }


  public static void main(String[] args)
  {
    PlaceOrder ts = new PlaceOrder(1);
  }

}

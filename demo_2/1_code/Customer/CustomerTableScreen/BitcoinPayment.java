import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//Coded by: Nathan Morgenstern
//Tested by: --------------

//****************************************************************
//*****************  BITCOIN PAYMENT (CTS)  **********************
//****************************************************************
//Constructor for the interface that the user goes to
//upon clicking the makePayment button
public class BitcoinPayment extends JFrame implements ActionListener {

  //Create the buttons of the Place Order Screen
  JButton bitcoinQR;
  JButton back;
  int tableID;

  public BitcoinPayment(int table_id){
    super("Bitcoin Payment (CTS)");
    tableID = table_id;

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane = new JPanel();
    pane.setLayout(null);

    //Setting the Title and location
    JLabel title = new JLabel("Bitcoin Payment (CTS)");
    JLabel tableNumber = new JLabel("Table # " + tableID);
    title.setBounds(250,10,400,100);
    tableNumber.setBounds(500,450,300,43);

    Font font = new Font("Cambria", Font.BOLD, 30);
    Font font2 = new Font("Cambria", Font.BOLD, 20);
    title.setFont(font);
    tableNumber.setFont(font2);

    //Import the image icons for the buttons
    //Will be updated to generate QR Based on the customer menu choices
    //using either Blockchain.info API or a Custom Built class to generate scannable QR codes
    try {
      Class.forName("com.mysql.jdbc.Driver");
      // 1. Get a connection to database
      Connection myConn = DriverManager.getConnection("ctsdb-cluster.cluster-c7ormjiryir8.us-east-2.rds.amazonaws.com:3306", "root", "12345678");
      // 2. Create a statement
      Statement myStmt = myConn.createStatement();
      // 3. Execute SQL query
      ResultSet btc_address;

      t_profile = myStmt.executeQuery("select * from tables");
    }catch (Exception e) {
        e.printStackTrace();
      }
    downloadImage()

    ImageIcon bitcoin_Icon  = new ImageIcon("icons/addr.gif");
    ImageIcon back_Icon     = new ImageIcon("icons/back.gif");

    bitcoinQR = new JButton(bitcoin_Icon);
    back      = new JButton(back_Icon);

    bitcoinQR.setBounds(250,100,304,330);
    back.setBounds(120,450,100,43);

    pane.add(title);
    pane.add(bitcoinQR);
    pane.add(back);
    pane.add(tableNumber);


    //Adding action listeners card, cash, bitcoin, and back buttons
    back.addActionListener(this);

    getContentPane().add(pane);
    setSize(800,600);
    setVisible(true);
    }

  public void downloadImage(String addrStr)
  {
    String imageDef = "https://chart.googleapis.com/chart?chs=250x250&cht=qr&chl=";
    String imageUrl = imageDef+addrStr;

    InputStream inputStream = null;
    OutputStream outputStream = null;

    try {
        URL url = new URL(imageUrl);
        inputStream = url.openStream();
        outputStream = new FileOutputStream("icons/addr.jpg");

        byte[] buffer = new byte[2048];
        int length;

        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }

      } catch (MalformedURLException e) {
        System.out.println("MalformedURLException :- " + e.getMessage());

      }  catch (FileNotFoundException e) {
        System.out.println("FileNotFoundException :- " + e.getMessage());
      } catch (IOException e) {
        System.out.println("IOException :- " + e.getMessage());

      } finally {
        try {
          inputStream.close();
          outputStream.close();
      } catch (IOException e) {
          System.out.println("Finally IOException :- " + e.getMessage());
      }
  }
}//Reference: http://www.technicalkeeda.com/java-tutorials/how-to-download-image-from-url-using-java

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
    //System.out.println("CustomerTableScreen()");
  }

}

} //end class MakePayment

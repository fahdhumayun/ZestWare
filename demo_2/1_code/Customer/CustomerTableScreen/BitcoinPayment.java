import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

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
  JButton confirm;
  int tableID;
  dbSQLCTS db = new dbSQLCTS();

  public BitcoinPayment(int table_id)
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
	  JLabel title = new JLabel("Bitcoin Payment (CTS)");
	  JLabel tableNumber = new JLabel("Table # " + tableID);
	  JLabel btcLabel = new JLabel(new ImageIcon("icons/btc.png"));
	    
	  title.setBounds(210,10,400,100);
	  tableNumber.setBounds(520,480,300,43);
	  btcLabel.setBounds(300,375,25,25);

	  Font font = new Font("Cambria", Font.BOLD, 30);
	  Font font2 = new Font("Cambria", Font.BOLD, 20);
	  title.setFont(font);
	  tableNumber.setFont(font2);
	    

	  //Import the image icons for the buttons
	  //Will be updated to generate QR Based on the customer menu choices
	  //using either Blockchain.info API or a Custom Built class to generate scannable QR codes

	  String address = db.getBTCAddress(tableID);
	  String total   = db.getTotalPrice(tableID);
	  //System.out.println(address);
	  downloadImage(address);
	    
	  Font btcFont = new Font("Cambria", Font.BOLD,20);
	  JLabel btcPrice = new JLabel(getBTCPrice(total));
	  btcPrice.setBounds(328,365,150,50); 
	  btcPrice.setFont(btcFont);

	    //btcLabel.setBounds(300,375,25,25);
	    
	    ImageIcon bitcoin_Icon  = new ImageIcon("icons/addr.jpg");
	    ImageIcon back_Icon     = new ImageIcon("icons/back.gif");
	    ImageIcon confirm_Icon  = new ImageIcon("icons/confirm.gif");
	    
	    bitcoinQR = new JButton(bitcoin_Icon);
	    back      = new JButton(back_Icon);
	    confirm   = new JButton(confirm_Icon);

	    bitcoinQR.setBounds(250,100,250,250);
	    back.setBounds(120,480,100,43);
	    confirm.setBounds(320,420,100,43);

	    pane.add(title);
	    pane.add(bitcoinQR);
	    pane.add(back);
	    pane.add(confirm);
	    pane.add(tableNumber);
	    pane.add(btcLabel);
	    pane.add(btcPrice);


	    //Adding action listeners card, cash, bitcoin, and back buttons
	    back.addActionListener(this);

	    getContentPane().add(pane);
	    setSize(800,600);
	    setVisible(true);

	  return pane;
  }
  
  
  public String getBTCPrice(String tot)
  {
		 String defURL = "https://blockchain.info/tobtc?currency=USD&value=";
		  String string = "";
		  BigDecimal bd = new BigDecimal("30.45");
		  String stringVal = bd.toString();
		  String getBTCVal = defURL + stringVal;
		  try {
		     URLConnection connection = new URL(
		             getBTCVal)
		             .openConnection();
		     Scanner scanner = new Scanner(connection.getInputStream());
		     while (scanner.hasNext()) {
		         string += scanner.next() + " ";
		     }
		     scanner.close();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return string;
  } //Reference: http://stackoverflow.com/questions/21076075/read-first-text-line-of-an-url

  public void downloadImage(String addrStr)
  {
    String imageDef = "https://chart.googleapis.com/chart?chs=250x250&cht=qr&chl=";
    String imageUrl = imageDef+addrStr;

    InputStream inputStream = null;
    OutputStream outputStream = null;

    try {
        URL url = new URL(imageUrl);
        inputStream = url.openStream();
        outputStream = new FileOutputStream("./icons/addr.jpg");

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
  else if(source == confirm)
  {
	  System.out.println("Success");
  }

}



/*public static void main(String[] args)
{
	BitcoinPayment bp = new BitcoinPayment(1);
}*/

}

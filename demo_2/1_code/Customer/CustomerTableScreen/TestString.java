import java.util.*;
import java.io.*;
import java.net.*;
import java.math.*;
import java.lang.*;

public class TestString{

  public static void main(String[] args)
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

   System.out.println(string);
} //Reference: http://stackoverflow.com/questions/21076075/read-first-text-line-of-an-url

}

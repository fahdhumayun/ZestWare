import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dbSQLCTS{
  Connection myConn;
  Statement myStmt;

  public void connectToDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			myConn = DriverManager.getConnection("jdbc:mysql://ctsdb-cluster.cluster-c7ormjiryir8.us-east-2.rds.amazonaws.com:3306/ctsdb", "root", "12345678");

			/* Create a statement */
			myStmt = myConn.createStatement();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

  public void disconnectFromDB() {

		try {
			myConn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


public String getBTCAddress(int tableID)
{

	String addr = " ";

try {
  Statement myStmt = myConn.createStatement();
  ResultSet btc_address;
  btc_address = myStmt.executeQuery("select * from cts");

  while(btc_address.next())
  {
	  if(tableID == btc_address.getInt("table_id")){
		  addr = btc_address.getString("btc_addr");
		  break;
	  }
  }


}catch (Exception e) {
    e.printStackTrace();
  }

	return addr;
}
public String getTotalPrice(int tableID)
{
	String price = " ";

try {
  Statement myStmt = myConn.createStatement();
  ResultSet tot_price;

  tot_price = myStmt.executeQuery("select * from cts");

  while(tot_price.next())
  {
	  if(tableID == tot_price.getInt("table_id")){
		  price = tot_price.getString("total_price");
		  break;
	  }
  }


}catch (Exception e) {
    e.printStackTrace();
  }

	return price;
}

public void setTotalPrice (int t_number, String totPrice) {
	
	try {
		ResultSet setter;
		setter = myStmt.executeQuery("select * from cts");

	/* Process the result set */
		String query2 = "update cts set total_price = ? where table_id = ?";
		
		PreparedStatement pStmt = myConn.prepareStatement(query2);
		pStmt.setString(1, totPrice);
		pStmt.setInt(2, t_number);
			
		pStmt.executeUpdate();
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}

}

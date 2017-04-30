/* dbSQL.java */

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dbSQL {
	
	/* Attributes */
	Connection myConn;
	Statement myStmt;
	ResultSet c_profile, t_status;
	String customer_name;
	int id, party_size;
	String contact_number;
	String date;
	String time;
	int estimate_time = -1;
	
	/* Constructor */
	public dbSQL(int c_id, String c_name, int p_size, String c_number, String d, String t) throws ExceptionsModified 
	{
			
		if (c_id < 0)
			throw new ExceptionsModified("ERROR! id less than 0.");
			
		if (p_size <= 0 || p_size > 4)
			throw new ExceptionsModified("ERROR! Party size should be from 1 to 4.");

		
		id = c_id;
		customer_name = c_name;
		party_size = p_size;
		contact_number = c_number;
		date = d;
		time = t;
		
		connectToDB();
	}
	
	/* Methods */
	public boolean connectToDB() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			/* Get a connection to database */
			//myConn = DriverManager.getConnection("jdbc:mysql://zest-ware-cluster.cluster-c7ormjiryir8.us-east-2.rds.amazonaws.com:3306/zestDB", "zestwareCustomer", "faheemisfriend");
			//myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "1234");
			myConn = DriverManager.getConnection("jdbc:mysql://cwsdb-cluster-1.cluster-cqpyryktf2nb.us-east-2.rds.amazonaws.com:3306/cwsdb", "root", "12345678");
					
			/* Create a statement */
			myStmt = myConn.createStatement();
						
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean disconnectFromDB() {
		
		try {
			myConn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public int getAvailableTable() {
		
		int table_number, table_size;
		boolean table_status, flag = false;
				
		try {
		
			/* Execute SQL query */
			t_status = myStmt.executeQuery("select * from tables");
			
			/* Process the result set */
			while (t_status.next()) {
				
				table_size = t_status.getInt("size");
				table_status = t_status.getBoolean("status");
						
				if (table_size >= party_size && table_status == true && !flag) {
					flag = true;
					return table_number = t_status.getInt("tableid");
				}
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return -1;
	}
	
	
	public void writeToDB(int t_number, String c_num) {
		
		if ( c_num != "-1" ) {
			contact_number = c_num;
		}
		
		try {
			
		/* Execute SQL query */
			c_profile = myStmt.executeQuery("select * from profiles");
		
			id = 0;
			
			int temp_id = id;
		
		/* Process the result set */
			while (c_profile.next()) {
				id = c_profile.getInt("id");
				if (id > temp_id) {
					temp_id = id;
				}
			}
		
			temp_id++;

			String query = " insert into profiles (id, name, size, date, reservationtime, contact, tablenum)" + 
				" values (?, ?, ?, ?, ?, ?, ?)";
						
											
			PreparedStatement preparedStmt = myConn.prepareStatement(query);
				
			preparedStmt.setInt(1, temp_id);
			preparedStmt.setString(2, customer_name);
			preparedStmt.setInt(3, party_size);
			preparedStmt.setString(4, date);
			preparedStmt.setString(5, time);
			preparedStmt.setString(6, contact_number);
			preparedStmt.setInt(7, t_number);
				
			preparedStmt.execute(); 
							
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setTimeOut(int c_id, String tOut) {
		try {
				
			Class.forName("com.mysql.jdbc.Driver");
			
			/* Get a connection to database */
			//myConn = DriverManager.getConnection("jdbc:mysql://zest-ware-cluster.cluster-c7ormjiryir8.us-east-2.rds.amazonaws.com:3306/zestDB", "zestwareCustomer", "faheemisfriend");
			//Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "1234");
			
			Connection Conn = DriverManager.getConnection("jdbc:mysql://cwsdb-cluster-1.cluster-cqpyryktf2nb.us-east-2.rds.amazonaws.com:3306/cwsdb", "root", "12345678");
			
			/* Create a statement */
			//myStmt = Conn.createStatement();
			
			/* Execute SQL query */
				//c_profile = myStmt.executeQuery("select * from profiles");

				String query3 = "update profiles set timeout = ? where id = ?";
					
				PreparedStatement pStmt = Conn.prepareStatement(query3);
				pStmt.setString(1, tOut);
				pStmt.setInt(2, c_id);
					
				pStmt.executeUpdate();
				
				Conn.close();				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void set_table_status (int t_number, boolean status) {
		
		try {
		/* Execute SQL query */
			t_status = myStmt.executeQuery("select * from tables");
	
		/* Process the result set */
			String query2 = "update tables set status = ? where tableid = ?";
			
			PreparedStatement pStmt = myConn.prepareStatement(query2);
			pStmt.setBoolean(1, false);
			pStmt.setInt(2, t_number);
				
			pStmt.executeUpdate();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void set_table_currentReservation (int t_number, String ResTime, String ResDate) {
		
		try {
		/* Execute SQL query */
			t_status = myStmt.executeQuery("select * from tables");
	
		/* Process the result set */
			String query2 = "update tables set reservationct = ? where tableid = ?";
			
			PreparedStatement pStmt = myConn.prepareStatement(query2);
			pStmt.setString(1, ResTime);
			pStmt.setInt(2, t_number);
				
			pStmt.executeUpdate();
			
			String query3 = "update tables set reservationcd = ? where tableid = ?";
			
			PreparedStatement pStmt2 = myConn.prepareStatement(query3);
			pStmt2.setString(1, ResDate);
			pStmt2.setInt(2, t_number);
				
			pStmt2.executeUpdate();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void set_table_newReservation (int t_number, String ResTime, String ResDate) {
		
		try {
		/* Execute SQL query */
			t_status = myStmt.executeQuery("select * from tables");
	
		/* Process the result set */
			String query2 = "update tables set reservationnt = ? where tableid = ?";
			
			PreparedStatement pStmt = myConn.prepareStatement(query2);
			pStmt.setString(1, ResTime);
			pStmt.setInt(2, t_number);
				
			pStmt.executeUpdate();
			
			String query3 = "update tables set reservationnd = ? where tableid = ?";
			
			PreparedStatement pStmt2 = myConn.prepareStatement(query3);
			pStmt2.setString(1, ResDate);
			pStmt2.setInt(2, t_number);
				
			pStmt2.executeUpdate();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean[] tables_status() {
		
		final int NUM_OF_TABLES = 48;
		boolean[] tables_status = new boolean[NUM_OF_TABLES];
		int index = 0;
		boolean table_status;
		
		try {
		/* Execute SQL query */
			t_status = myStmt.executeQuery("select * from tables");
		
		/* Process the result set */
			while (t_status.next()) {
				table_status = t_status.getBoolean("status");
		
			if (! (index >= NUM_OF_TABLES))
				tables_status[index] = table_status;
			index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tables_status;
	}
	
	public void checkAttributes() {
		
		System.out.println("id: " + id);
		System.out.println("Customer Name: " + customer_name);
		System.out.println("Party Size: " + party_size);
		System.out.println("Contact Number: " + contact_number);
		System.out.println("Date: " + date);
	}
	
	public int getId() {
		
		int c_id = -1;
		
		try {
			/* Execute SQL query */
				t_status = myStmt.executeQuery("select * from profiles");
			
			/* Process the result set */
				c_id = t_status.getInt("id");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return c_id;
	}
	
	public String getName() {
		
		String c_name = "";
		
		try {
			/* Execute SQL query */
				t_status = myStmt.executeQuery("select * from profiles");
			
			/* Process the result set */
				c_name = t_status.getString("name");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return c_name;
	}
	
	public String getContactNumber() {
		
		String c_num = "";
		
		try {
			/* Execute SQL query */
				t_status = myStmt.executeQuery("select * from profiles");
			
			/* Process the result set */
				c_num = t_status.getString("contact");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return c_num;
	}
	
	public int getTableNum() {
		
		int c_tNum = -1;
		
		try {
			/* Execute SQL query */
				t_status = myStmt.executeQuery("select * from profiles");
			
			/* Process the result set */
				c_tNum = t_status.getInt("tablenum");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return c_tNum;
	}
	
	public int getSize() {
		
		int c_size = -1;
		
		try {
			/* Execute SQL query */
				t_status = myStmt.executeQuery("select * from profiles");
			
			/* Process the result set */
				c_size = t_status.getInt("size");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return c_size;
	}
	
	public String getDate() {
		
		String c_date = "";
		
		try {
			/* Execute SQL query */
				t_status = myStmt.executeQuery("select * from profiles");
			
			/* Process the result set */
				c_date = t_status.getString("date");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return c_date;
	}
	
	public String getReservationTime() {
		
		String c_time = "";
		
		try {
			/* Execute SQL query */
				t_status = myStmt.executeQuery("select * from profiles");
			
			/* Process the result set */
				c_time = t_status.getString("reservationtime");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return c_time;
	}
	
	public String getTimeOut() {
		
		String c_out = "";
		
		try {
			/* Execute SQL query */
				t_status = myStmt.executeQuery("select * from profiles");
			
			/* Process the result set */
				c_out = t_status.getString("timeout");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return c_out;
	}
	
	public int getEstimate() {
		
		
		
		String timeIn, timeOut;
		SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
		Date t1;
		Date t2;
		int total = 0;
		int count = 0;
		long diff = 0;
		int tSec = 0;
		int hrs = 0;
		int mins = 0;
		try {
			/* Execute SQL query */
				t_status = myStmt.executeQuery("select * from profiles");
			
			/* Process the result set */
				while (t_status.next()) {
					timeIn = t_status.getString("reservationtime");
					System.out.println(timeIn);
					timeOut = t_status.getString("timeout");
					System.out.println(timeOut);
					
					if (timeOut == "") {
						continue;
					}
					
					t1 = tf.parse(timeIn);
					System.out.println(t1);
					t2 = tf.parse(timeOut);
					System.out.println(t2);
					diff = t2.getTime() - t1.getTime();
					System.out.println(diff);
					tSec = (int)diff/1000;
					hrs = tSec / 3600;
					System.out.println(hrs);
					
					if ( hrs == 1 ) {
						mins = 60;
					}
					else {
						tSec = tSec - (hrs * 3600);
						mins = tSec / 60;
					}
					
					System.out.println(mins);
					total += mins;
					System.out.println(total);
					count++;
					System.out.println(count);
					System.out.println("\n\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		estimate_time = total/count;
		
		return estimate_time;
	}
	
	public int next_available_table(int p_s) {
		int next = -1;
		int count = 1;
		String cT[] = new String[11];
		String compStr;
		String nT[] = new String[11];
		int min = 1;
		try {
			t_status = myStmt.executeQuery("select * from tables");
			
			while(t_status.next()) {
				
				
				nT[count] = t_status.getString("reservationnt");
				
				cT[count] = t_status.getString("reservationct");
				
				
				count++;
				
			}
			
			compStr = cT[1];
			
			for (int i = 1; i <= 10; i++) {
				
				if ( p_s > 2 && i <= 5 ) {
					i = 5;
					compStr = cT[6];
					continue;
				}
				
				if ( nT[i] != null )
				{
					continue;
				}
				
				int compare = compStr.compareToIgnoreCase(cT[i]);
				System.out.println(compare + " " + compStr);
				
				if ( compare < 0 ) {
					continue;
				}
				else if ( compare > 0 ) {
					compStr = cT[i];
					min = i;
				}
				else {
					continue;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		next = min;
		System.out.println("next: " + next);
		return next;
	}
	
	public int checkTableReservation(int p_size, String t, String d) {
		int t_no = -1;
		
		String nT[] = new String[11];
		String nD[] = new String[11];
		int count = 1;
		
		try {
			t_status = myStmt.executeQuery("select * from tables");
			
			while(t_status.next()) {
			
				if ( p_size > 2 && count < 6) {
					count++;
					continue;
				}
								
				nT[count] = t_status.getString("reservationnt");
				nD[count] = t_status.getString("reservationnd");
				
				if ( nT[count] == null || nD[count] == null)
					return count;
				
				int compare1 = d.compareToIgnoreCase(nD[count]);
				int compare2 = t.compareToIgnoreCase(nT[count]);
				
				if ( compare1 == 0 && compare2 == 0 ) {
					count++;
					continue;
				}
				else {
					return count;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t_no;
	}

}

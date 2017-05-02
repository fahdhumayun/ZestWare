/* dbSQL.java */

import java.sql.*;

public class dbSQL {
	
	/* Attributes */
	Connection myConn;
	Statement myStmt;
	ResultSet c_profile, t_status;
	String customer_name;
	int id, party_size;
	String contact_number;
	String date;
	
	/* Constructor */
	public dbSQL(int c_id, String c_name, int p_size, String c_number, String d) throws ExceptionsModified 
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
		
		connectToDB();
	}
	
	/* Methods */
	public boolean connectToDB() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			/* Get a connection to database */
			myConn = DriverManager.getConnection("jdbc:mysql://zest-ware-cluster.cluster-c7ormjiryir8.us-east-2.rds.amazonaws.com:3306/zestDB", "zestwareCustomer", "faheemisfriend");
			
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
	
	
	public void writeToDB(int t_number) {
		
		try {
			
		/* Execute SQL query */
			c_profile = myStmt.executeQuery("select * from profiles");
		
			id = 0;
		
		/* Process the result set */
			while (c_profile.next()) {
				id = c_profile.getInt("id");
			}
		
			id++;

			String query = " insert into profiles (id, name, size, time, contact, tablenum)" + 
				" values (?, ?, ?, ?, ?, ?)";
						
											
			PreparedStatement preparedStmt = myConn.prepareStatement(query);
				
			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, customer_name);
			preparedStmt.setInt(3, party_size);
			preparedStmt.setString(4, date);
			preparedStmt.setString(5, contact_number);
			preparedStmt.setInt(6, t_number);
				
			preparedStmt.execute(); 
			
			set_table_status (t_number, false);	
							
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

}

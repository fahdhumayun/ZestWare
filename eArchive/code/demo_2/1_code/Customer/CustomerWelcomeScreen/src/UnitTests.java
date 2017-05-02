/* UnitTests.java */
// written by:	Fahd Humayun
// tested by:	Shehpar Sohail
// debugged by:	Nathan Morgenstern

import java.io.IOException;

public class UnitTests {
	
	public void dbSQLTests() {
		
		/* Testing Constructor for Failed Cases */
		System.out.println("***** Testing of Constructor *****\n\n");
		try {
			dbSQL testObj = new dbSQL(-1, "John Doe", 3, "(609)-123-4567", "03/20/2017", "23:14:00");
			testObj.checkAttributes();
			System.out.println("Test 1 Passed!\n");
		}
		catch (ExceptionsModified e) {
			System.out.println("Test 1 Failed!\n");
			e.printStackTrace();
		}
		
		try {
			dbSQL testObj = new dbSQL(1, "John Doe", 0, "(609)-123-4567", "03/20/2017", "23:14:00");
			testObj.checkAttributes();
			System.out.println("Test 2 Passed!\n");
		}
		catch (ExceptionsModified e) {
			System.out.println("Test 2 Failed!\n");
			e.printStackTrace();
		}
		
		try {
			dbSQL testObj = new dbSQL(1, "John Doe", 5, "(609)-123-4567", "03/20/2017", "23:14:00");
			testObj.checkAttributes();
			System.out.println("Test 3 Passed!\n");
		}
		catch (ExceptionsModified e) {
			System.out.println("Test 3 Failed!\n");
			e.printStackTrace();
		}
		
		
		/* Testing Constructor for Passed Case */
		try {
			dbSQL testObj = new dbSQL(1, "John Doe", 3, "(609)-123-4567", "03/20/2017", "23:14:00");
			System.out.println("Test 4 Passed!\n");
			testObj.checkAttributes();
		}
		catch (ExceptionsModified e) {
			System.out.println("Test 4 Failed!\n");
			e.printStackTrace();
		}
		
		
		/* Testing Connection to SQL database */
		System.out.println("\n\n***** Testing of Connection Method *****");
		try {
			dbSQL testObj = new dbSQL(1, "John Doe", 3, "(609)-123-4567", "03/20/2017", "23:14:00");
			if (!testObj.connectToDB())
				throw new ExceptionsModified("ERROR! Connection Failed!");
			else
				System.out.println("Test Passed!\nConnection Successful!");
				
		}
		catch (ExceptionsModified e) {
			System.out.println("Test Failed!\n");
			e.printStackTrace();
		}
		
		
		/* Testing getAvailableTable Method */
		System.out.println("\n\n***** Testing of getAvailableTable Method *****");
		try {
			dbSQL testObj = new dbSQL(1, "John Doe", 3, "(609)-123-4567", "03/20/2017", "23:14:00");
			testObj.connectToDB();
			int t_id = testObj.getAvailableTable();
			
			if(t_id == -1)
				throw new ExceptionsModified ("ERROR! Unable to get tables information from DB\n");
			
			System.out.println("Test Passed!");
			System.out.println("Table Number: " + t_id + " available!\n");
				
		}
		catch (ExceptionsModified e) {
			System.out.println("Test Failed!\n");
			e.printStackTrace();
		}
		
		
		/* Testing writeToDB and set_table_status Method */
		System.out.println("\n\n***** Testing of writeToDB and set_table_status Method *****");
		try {
			dbSQL testObj = new dbSQL(1, "John Doe", 3, "(609)-123-4567", "03/20/2017", "23:14:00");
			testObj.connectToDB();
			
			int t_id = testObj.getAvailableTable();
			
			testObj.writeToDB(t_id, "-1");	
			
			System.out.println("Test Passed (Result evident from database)!\n");
		}
		catch (ExceptionsModified e) {
			System.out.println("Test Failed!\n");
			e.printStackTrace();
		}
		
		
	}
	
	public static void main (String[] args) {
		
		System.out.println("\n\n***** Testing of writeToDB and set_table_status Method *****");
		try {
			dbSQL testObj = new dbSQL(1, "John Doe", 3, "(609)-123-4567", "03/20/2017", "23:14:00");
			testObj.connectToDB();
			
			testObj.writeToDB(5, "-1");	
			testObj.setTimeOut(5, "23:54:00");
			int e_time = testObj.getEstimate();
			System.out.println("Test Passed (Result evident from database)!" + e_time);
			
		}
		catch (ExceptionsModified e) {
			System.out.println("Test Failed!\n");
			e.printStackTrace();
		}
		
		try {
			Runtime.getRuntime().exec("cmd /c C:\\Windows\\System32\\osk.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		
		UnitTests obj = new UnitTests();
		
		System.out.println("*********************************************");
		System.out.println("******** Unit Testing of dbSQL Class ********");
		System.out.println("*********************************************\n");
		obj.dbSQLTests();
		*/
	}

}

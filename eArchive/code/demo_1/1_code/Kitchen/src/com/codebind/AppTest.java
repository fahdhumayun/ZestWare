package com.codebind;
import junit.framework.Assert;
import junit.framework.TestCase;
import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;



/**
 * Created by power on 3/27/17.
 */
public class AppTest extends TestCase {

    public void testGetConnection() throws Exception {
        Connection connection1, testConnection;
        connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chef","amd","drworm");
        testConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chef","amd","drworm");
        assertEquals(connection1,testConnection);
    }

/*    public void testGetUsersListChef() throws Exception {
        ArrayList<ChefsList> userList = new ArrayList<>();



    }

    public void testGetUsersListWait() throws Exception {

    }

    public void testMain() throws Exception {

    }*/
}
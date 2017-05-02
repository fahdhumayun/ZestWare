package com.codebind;

//import com.mysql.jdbc.PreparedStatement;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


public class App {
    // Keypad Buttons used for Kitchen Login Screen
    private JPanel panelCLOCKIN;
    private JTextField textFieldInput;
    private JButton buttonDEL;
    private JButton buttonZERO;
    private JButton buttonOK;
    private JButton buttonONE;
    private JButton buttonTWO;
    private JButton buttonTHREE;
    private JButton buttonFOUR;
    private JButton buttonFIVE;
    private JButton buttonSIX;
    private JButton buttonSEVEN;
    private JButton buttonEIGHT;
    private JButton buttonNINE;
    private JPanel panelCHEF;
    private JTabbedPane tabbedPane;
    public JTable tableCHEF;
    private JButton CHEFADDTEST;
    private JButton buttonDELETE;
    private JPanel panelWaiter;
    private JTable tableWAIT;
    private JButton buttonDELwait;
    private JPanel panelMAP;



    private JScrollPane ScrollPaneCHEF;
    private JScrollPane ScrollPaneWAIT;
    private JDatePickerImpl DateSelector;
    private JButton buttonPINSCRN;
    private JScrollPane ScrollPaneSCHED;
    private JTable tableSCHED;
    private JButton buttonGetSched;
    private JPanel panelSCHED;
    private JPanel panelSHAPE;

    String[] CHEFcolNames = {"Order Name", "Notes", "Table","Server","id"};
    String[] SCHEDcolNames = {"SUN", "MON", "TUES","WED","THURS","FRI","SAT"};
    Object[][] rowdata;

    boolean isSchedPIN = false;
    int schedPIN = 0;


    public App() {

        new initDB();

        tableCHEF.setRowHeight(tableCHEF.getRowHeight() + 30);
        tableWAIT.setRowHeight(tableWAIT.getRowHeight() + 30);
        tableSCHED.setRowHeight(tableSCHED.getRowHeight() + 30);
        // Creates a new instances of a data model for the chef screen


        DefaultTableModel datamodelCHEF = (DefaultTableModel)tableCHEF.getModel();
        datamodelCHEF.setDataVector(rowdata, CHEFcolNames);
        datamodelCHEF.fireTableDataChanged();
       //Uploads the new data model saved in  datamodelCHEF
        //tableCHEF.setModel(datamodelCHEF);

        DefaultTableModel datamodelWAIT = (DefaultTableModel)tableWAIT.getModel();
        datamodelWAIT.setDataVector(rowdata, CHEFcolNames);
        datamodelWAIT.fireTableDataChanged();

        DefaultTableModel datamodelSCHED = (DefaultTableModel)tableSCHED.getModel();
        datamodelSCHED.setDataVector(rowdata, SCHEDcolNames);
        datamodelSCHED.fireTableDataChanged();

        new updateCHEF();

        /*ImageIcon icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, icon0, clearIcon, enterIcon, deleteIcon;
        icon1 = new ImageIcon(getClass().getResource("numberOne.png"));
        icon2 = new ImageIcon(getClass().getResource("numberTwo.png"));
        icon3 = new ImageIcon(getClass().getResource("numberThree.png"));
        icon4 = new ImageIcon(getClass().getResource("numberFour.png"));
        icon5 = new ImageIcon(getClass().getResource("numberFive.png"));
        icon6 = new ImageIcon(getClass().getResource("numberSix.png"));
        icon7 = new ImageIcon(getClass().getResource("numberSeven.png"));
        icon8 = new ImageIcon(getClass().getResource("numberEight.png"));
        icon9 = new ImageIcon(getClass().getResource("numberNine.png"));
        icon0 = new ImageIcon(getClass().getResource("numberZero.png"));
        enterIcon = new ImageIcon(getClass().getResource("verification.png"));
        //clearIcon = new ImageIcon(getClass().getResource("delete.png"));
        deleteIcon = new ImageIcon(getClass().getResource("delete.png"));

        buttonZERO = new JButton(icon0);
        buttonONE = new JButton(icon1);
        buttonTWO = new JButton(icon2);
        buttonTHREE = new JButton(icon3);
        buttonFOUR = new JButton(icon4);
        buttonFIVE = new JButton(icon5);
        buttonSIX = new JButton(icon6);
        buttonSEVEN = new JButton(icon7);
        buttonEIGHT = new JButton(icon8);
        buttonNINE = new JButton(icon9);
        buttonOK = new JButton(enterIcon);
        buttonDEL = new JButton(deleteIcon);*/

        // Action Listeners for the keypad buttons
        buttonONE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "1");
            }
        });
        buttonZERO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "0");
            }
        });
        buttonTWO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "2");
            }
        });
        buttonTHREE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "3");
            }
        });
        buttonFOUR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "4");
            }
        });
        buttonFIVE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "5");
            }
        });
        buttonSIX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "6");
            }
        });
        buttonSEVEN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "7");
            }
        });
        buttonEIGHT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "8");
            }
        });
        buttonNINE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "9");
            }
        });
        //Updates the table of elements whenever a item is deleted
        buttonDEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = textFieldInput.getText().length();
                int number = textFieldInput.getText().length() - 1;
                String store;

                //If there is a value build a string using the string builder in the text field, if not keep it blank

                if(length > 0){
                    StringBuilder back = new StringBuilder(textFieldInput.getText());
                    back.deleteCharAt(number);
                    store = back.toString();
                    textFieldInput.setText(store);
                }
            }
        });

        buttonDELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel datamodelCHEF = (DefaultTableModel)tableCHEF.getModel();
                Connection connection = getConnection();
                String sql = "DELETE FROM chefslist WHERE `id` = ?";
                String selOrderCHEF = datamodelCHEF.getValueAt(tableCHEF.getSelectedRow(),0).toString();
                String selNotesCHEF = datamodelCHEF.getValueAt(tableCHEF.getSelectedRow(),1).toString();
                String selTableNoCHEF = datamodelCHEF.getValueAt(tableCHEF.getSelectedRow(),2).toString();
                String selServerCHEF = datamodelCHEF.getValueAt(tableCHEF.getSelectedRow(),3).toString();
                String selidCHEF = datamodelCHEF.getValueAt(tableCHEF.getSelectedRow(),4).toString();
                try {
                    java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, selidCHEF);
                    int deleteCount = pstmt.executeUpdate();


                } catch (Exception ee){
                    ee.printStackTrace();
                }

                ArrayList<ChefsList> list = getUsersListWait();

                sql = "INSERT INTO waiterslist values(?,?,?,?,?)";
                try{
                    java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, selOrderCHEF);
                    pstmt.setString(2, selNotesCHEF);
                    pstmt.setString(3, selTableNoCHEF);
                    pstmt.setString(4, selServerCHEF);
                    pstmt.setString(5, String.valueOf(list.size() + 1));
                    int deleteCount = pstmt.executeUpdate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }




                list = getUsersListChef();
                rowdata = new Object [list.size()][5];

                for(int i = 0; i < list.size();i++){
                    rowdata[i][0] = list.get(i).getOrder();
                    rowdata[i][1] = list.get(i).getNotes();
                    rowdata[i][2] = list.get(i).getTableNo();
                    rowdata[i][3] = list.get(i).getServer();
                    rowdata[i][4] = i + 1;
                }

                datamodelCHEF.setDataVector(rowdata, CHEFcolNames);
                datamodelCHEF.fireTableDataChanged();

                sql = "DELETE FROM chefslist";
                try {
                    java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                    int deleteCount = pstmt.executeUpdate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                sql = "INSERT INTO chefslist values(?,?,?,?,?)";
                for(int i = 0; i < list.size(); i++) {
                    try {
                        java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                        pstmt.setString(1, list.get(i).getOrder());
                        pstmt.setString(2, list.get(i).getNotes());
                        pstmt.setString(3, String.valueOf(list.get(i).getTableNo()));
                        pstmt.setString(4, list.get(i).getServer());
                        pstmt.setString(5, String.valueOf(i + 1));
                        int deleteCount = pstmt.executeUpdate();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }



                list = getUsersListWait();
                rowdata = new Object [list.size()][5];

                for(int i = 0; i < list.size();i++){
                    rowdata[i][0] = list.get(i).getOrder();
                    rowdata[i][1] = list.get(i).getNotes();
                    rowdata[i][2] = list.get(i).getTableNo();
                    rowdata[i][3] = list.get(i).getServer();
                    rowdata[i][4] = i + 1;
                }

                DefaultTableModel datamodelWAIT = (DefaultTableModel)tableWAIT.getModel();
                datamodelWAIT.setDataVector(rowdata, CHEFcolNames);
                datamodelWAIT.fireTableDataChanged();




                //tableCHEF.setModel(datamodelCHEF);
                //datamodelCHEF.fireTableDataChanged();
               // ScrollPaneCHEF.revalidate();
              //  ScrollPaneCHEF.repaint();
              //  panelCHEF.revalidate();
               // panelCHEF.repaint();
            }
        });

        
        // WAITER TAB
        buttonDELwait.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel datamodelWAIT = (DefaultTableModel)tableWAIT.getModel();
                Connection connection = getConnection();
                String sql = "DELETE FROM waiterslist WHERE `Order` = ?";
                String selOrderWAIT = datamodelWAIT.getValueAt(tableWAIT.getSelectedRow(),0).toString();
                int tableno = (int) datamodelWAIT.getValueAt(tableWAIT.getSelectedRow(),3);
                try {
                    java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, selOrderWAIT);
                    int deleteCount = pstmt.executeUpdate();


                } catch (Exception ee){
                    ee.printStackTrace();
                }
                ArrayList<ChefsList> list = getUsersListWait();
                rowdata = new Object [list.size()][5];

                for(int i = 0; i < list.size();i++){
                    rowdata[i][0] = list.get(i).getOrder();
                    rowdata[i][1] = list.get(i).getNotes();
                    rowdata[i][2] = list.get(i).getTableNo();
                    rowdata[i][3] = list.get(i).getServer();
                    rowdata[i][4] = i + 1;
                }

                sql = "DELETE FROM chefslist";
                try {
                    java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                    int deleteCount = pstmt.executeUpdate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                sql = "INSERT INTO chefslist values(?,?,?,?,?)";
                for(int i = 0; i < list.size(); i++) {
                    try {
                        java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                        pstmt.setString(1, list.get(i).getOrder());
                        pstmt.setString(2, list.get(i).getNotes());
                        pstmt.setString(3, String.valueOf(list.get(i).getTableNo()));
                        pstmt.setString(4, list.get(i).getServer());
                        pstmt.setString(5, String.valueOf(i + 1));
                        int deleteCount = pstmt.executeUpdate();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }


                datamodelWAIT.setDataVector(rowdata, CHEFcolNames);
                datamodelWAIT.fireTableDataChanged();


                //panelMAP.setTableStatus(tableno, )

                //tableCHEF.setModel(datamodelCHEF);
                //datamodelCHEF.fireTableDataChanged();
            }
        });
        // Action listener for the java swing ok button that logins in the entry Pre-Condition: Must be a five digit number, Post-Condition: information is pushed to the
        //database upon completion. Success Prompt "YOU DID IT!".
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(textFieldInput.getText().length() != 5){
                   JOptionPane.showMessageDialog(null, "Clock-in pin must be 5 digits.");
               }
               else{
                   String firstName = "";
                   String lastName = "";

                   //JOptionPane.showMessageDialog(null, "YOU DID IT!");

                   String toFind = textFieldInput.getText();

                   Connection connection = getConnection();
                   String query = "SELECT FirstName, LastName from clockin WHERE idClockIn = ?";
                   try {

                       java.sql.PreparedStatement pstmt = connection.prepareStatement(query);
                       pstmt.setString(1, toFind);
                       ResultSet rs;

                       rs = pstmt.executeQuery();
                       while(rs.next()){
                           firstName = rs.getString("FirstName");
                           lastName = rs.getString("LastName");
                       }

                       String messageString = firstName + lastName + " has been clocked!";

                       JOptionPane.showMessageDialog(null, messageString);

                       connection.close();


                   }
                   catch(Exception ee){
                        JOptionPane.showMessageDialog(null,"Error in finding the id entered!");
                        System.err.println(ee.getMessage());
                   }
               }
            }
        });

        //****************************Button that opens number pad in schedule tab******************************
        buttonPINSCRN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrejmNUMPAD frejm = new FrejmNUMPAD();
                frejm.setSize(500,400);
                frejm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frejm.setVisible(true);



            }
        });
        buttonGetSched.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                java.util.GregorianCalendar selectedDate = (java.util.GregorianCalendar) DateSelector.getModel().getValue();

                if ((selectedDate.getTime() != null) && (isSchedPIN = true)) {
                    int casevar = selectedDate.get(Calendar.DAY_OF_WEEK);

                    switch (casevar) {
                        case 2:
                            selectedDate.add(Calendar.DATE, -1);
                            break;
                        case 3:
                            selectedDate.add(Calendar.DATE, -2);
                            break;
                        case 4:
                            selectedDate.add(Calendar.DATE, -3);
                            break;
                        case 5:
                            selectedDate.add(Calendar.DATE, -4);
                            break;
                        case 6:
                            selectedDate.add(Calendar.DATE, -5);
                            break;
                        case 7:
                            selectedDate.add(Calendar.DATE, -6);
                            break;
                        default:
                            break;
                    }

                    //String selectedDateFULL1 = String.valueOf(selectedDate.getTime());
                    java.sql.Date selectedDateFULL1 = new java.sql.Date(selectedDate.getTimeInMillis());
                    selectedDate.add(Calendar.DATE, 13);
                    java.sql.Date selectedDateFULL2 = new java.sql.Date(selectedDate.getTimeInMillis());
                    //String selectedDateFULL2 = String.valueOf(selectedDate.getTime());

                    //JOptionPane.showMessageDialog(null, "The Schedule Viewer would now update." + selectedDate.getTime());

                    new updateSCHED(String.valueOf(schedPIN), String.valueOf(selectedDateFULL1), String.valueOf(selectedDateFULL2));

                }//END IF STATEMENT

            }
        });

    }
    // Creates a JDBC connection to a data source using the Driver Manager which is part of the
    // Java sql library. Returns a connections to the data source
    public static Connection getConnection(){
        Connection con = null;
        try{
            String url = "jdbc:mysql://chef.clvbnnnbtnmd.us-west-2.rds.amazonaws.com:3306/chef";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,"amd","password");
            return con;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public ArrayList<ChefsList> getUsersListChef()
    {
        ArrayList<ChefsList> usersList = new ArrayList<>();
        Connection connection = getConnection();

        String query = "SELECT * FROM  `chefslist` ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            ChefsList chefsList;

            while(rs.next())
            {
                chefsList = new ChefsList(rs.getString("Order"),rs.getString("Notes"),rs.getInt("TableNo"),rs.getString("Server"),rs.getInt("id"));
                usersList.add(chefsList);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public ArrayList<ChefsList> getUsersListWait()
    {
        ArrayList<ChefsList> usersList = new ArrayList<>();
        Connection connection = getConnection();

        String query = "SELECT * FROM  `waiterslist` ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            ChefsList chefsList;

            while(rs.next())
            {
                chefsList = new ChefsList(rs.getString("Order"),rs.getString("Notes"),rs.getInt("TableNo"),rs.getString("Server"),rs.getInt("id"));
                usersList.add(chefsList);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }



    //PUTS THE SELECTED DATES AND START TIMES IN SCHEDLIST INSTANCE
    public ArrayList<SchedList> getUsersListSched(String id, String dateOne, String dateLast)
    {
        ArrayList<SchedList> usersList = new ArrayList<>();
        Connection connection = getConnection();

        String query = "SELECT * FROM  chef.`" + String.valueOf(schedPIN) +"` WHERE idDate >= ? AND idDate <= ? ";
        //String query = "SELECT * FROM  chef.`55555` BETWEEN ? AND ? ";

        Statement st;
        //ResultSet rs;

        try {
            java.sql.PreparedStatement pstmt = connection.prepareStatement(query);
            //pstmt.setString(1, id);
            pstmt.setString( 1, dateOne);
            pstmt.setString(2, String.valueOf(dateLast));

            ResultSet rs;

            rs = pstmt.executeQuery();


            SchedList schedList;

            while(rs.next())
            {
                schedList = new SchedList(rs.getDate("idDate"),rs.getString("begin"),rs.getString("end"));
                usersList.add(schedList);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }



    // BEGIN FREJMNUMPAD
    public class FrejmNUMPAD extends JFrame{
        JFrame FrameNUMPAD = new JFrame();

        public FrejmNUMPAD(){


            JTextField pinField = new JTextField(10);
            pinField.setEditable(false);

            //++++++++++++++++++INITIATING BUTTONS AND LISTENERS
            JButton button0 = new JButton("0");
            JButton button1 = new JButton("1");
            JButton button2 = new JButton("2");
            JButton button3 = new JButton("3");
            JButton button4 = new JButton("4");
            JButton button5 = new JButton("5");
            JButton button6 = new JButton("6");
            JButton button7 = new JButton("7");
            JButton button8 = new JButton("8");
            JButton button9 = new JButton("9");
            JButton buttonOK = new JButton("OK");
            JButton buttonDEL = new JButton("DEL");

            button0.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {pinField.setText(pinField.getText() + "0");}
            });

            button1.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {pinField.setText(pinField.getText() + "1");}
            });

            button2.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {pinField.setText(pinField.getText() + "2");}
            });

            button3.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {pinField.setText(pinField.getText() + "3");}
            });

            button4.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {pinField.setText(pinField.getText() + "4");}
            });

            button5.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {pinField.setText(pinField.getText() + "5");}
            });

            button6.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {pinField.setText(pinField.getText() + "6");}
            });

            button7.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {pinField.setText(pinField.getText() + "7");}
            });

            button8.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {pinField.setText(pinField.getText() + "8");}
            });

            button9.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {pinField.setText(pinField.getText() + "9");}
            });

            buttonOK.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    isSchedPIN = true;
                    if(pinField.getText().length() != 5){
                        JOptionPane.showMessageDialog(null, "Clock-in pin must be 5 digits.");
                    }
                    else{
                        int searchedID = 0;
                        String firstName = "";
                        String lastName = "";

                        //JOptionPane.showMessageDialog(null, "YOU DID IT!");

                        String toFind = pinField.getText();

                        Connection connection = getConnection();
                        String query = "SELECT idClockIn, FirstName, LastName from clockin WHERE idClockIn = ?";
                        try {

                            java.sql.PreparedStatement pstmt = connection.prepareStatement(query);
                            pstmt.setString(1, toFind);
                            ResultSet rs;

                            rs = pstmt.executeQuery();
                            while(rs.next()){
                                searchedID = rs.getInt("idClockIn");
                                firstName = rs.getString("FirstName");
                                lastName = rs.getString("LastName");
                            }

                            if (searchedID != 0) {
                                String messageString = firstName + lastName + " has been clocked!";

                                isSchedPIN = true;

                                schedPIN = searchedID;

                                setVisible(false);

                                //JOptionPane.showMessageDialog(null, isSchedPIN);                    //COMMENT OUT LATER
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Employee PIN Not Found.");     //COMMNENT OUT LATER
                            }

                            connection.close();


                        }
                        catch(Exception ee){
                            JOptionPane.showMessageDialog(null,"Error in finding the id entered!");
                            System.err.println(ee.getMessage());
                        }
                    }
                }

            });

            buttonDEL.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    int length = pinField.getText().length();
                    int number = pinField.getText().length() - 1;
                    String store;

                    //If there is a value build a string using the string builder in the text field, if not keep it blank

                    if(length > 0){
                        StringBuilder back = new StringBuilder(pinField.getText());
                        back.deleteCharAt(number);
                        store = back.toString();
                        pinField.setText(store);
                    }
                }
            });

            setLayout(new GridBagLayout());

            GridBagConstraints gc = new GridBagConstraints();

            //********NUMBERS OK DEL*************

            gc.weightx = 0.5;
            gc.weighty = 0.5;

            gc.gridx = 1;
            gc.gridy = 0;
            add(pinField, gc);

            gc.gridx = 0;
            gc.gridy = 1;
            add(button7, gc);

            gc.gridx = 1;
            gc.gridy = 1;
            add(button8, gc);

            gc.gridx = 2;
            gc.gridy = 1;
            add(button9, gc);

            gc.gridx = 0;
            gc.gridy = 2;
            add(button4, gc);

            gc.gridx = 1;
            gc.gridy = 2;
            add(button5, gc);

            gc.gridx = 2;
            gc.gridy = 2;
            add(button6, gc);

            gc.gridx = 0;
            gc.gridy = 3;
            add(button1, gc);

            gc.gridx = 1;
            gc.gridy = 3;
            add(button2, gc);

            gc.gridx = 2;
            gc.gridy = 3;
            add(button3, gc);

            gc.gridx = 0;
            gc.gridy = 4;
            add(buttonDEL, gc);

            gc.gridx = 1;
            gc.gridy = 4;
            add(button0, gc);

            gc.gridx = 2;
            gc.gridy = 4;
            add(buttonOK, gc);
        }

    }
    // END FREJMNUMPAD

    // display data in CHEF JTable
    public class updateCHEF{
        String[] CHEFcolNames = {"Order Name", "Notes", "Table","Server","id"};
         //= {{"Cheeseburger French Fries","Well done","7","Kathy"},{"Lobster Bisque","none","5","Jay"}};

        public updateCHEF(){
            ArrayList<ChefsList> list = getUsersListChef();
            rowdata = new Object [list.size()][5];

            for(int i = 0; i < list.size();i++){
                rowdata[i][0] = list.get(i).getOrder();
                rowdata[i][1] = list.get(i).getNotes();
                rowdata[i][2] = list.get(i).getTableNo();
                rowdata[i][3] = list.get(i).getServer();
                rowdata[i][4] = i + 1;
            }

            DefaultTableModel datamodelCHEF = (DefaultTableModel)tableCHEF.getModel();
            datamodelCHEF.setDataVector(rowdata, CHEFcolNames);
            datamodelCHEF.fireTableDataChanged();


            //tableCHEF.setModel(datamodelCHEF);
        }
    }

    public class updateWAIT{
        String[] CHEFcolNames = {"Order Name", "Notes", "Table","Server","id"};
        //= {{"Cheeseburger French Fries","Well done","7","Kathy"},{"Lobster Bisque","none","5","Jay"}};

        public updateWAIT(){
            ArrayList<ChefsList> list = getUsersListChef();
            rowdata = new Object [list.size()][5];

            for(int i = 0; i < list.size();i++){
                rowdata[i][0] = list.get(i).getOrder();
                rowdata[i][1] = list.get(i).getNotes();
                rowdata[i][2] = list.get(i).getTableNo();
                rowdata[i][3] = list.get(i).getServer();
                rowdata[i][4] = i + 1;
            }

            DefaultTableModel datamodelWAIT = (DefaultTableModel)tableWAIT.getModel();
            datamodelWAIT.setDataVector(rowdata, CHEFcolNames);
            datamodelWAIT.fireTableDataChanged();

            tableWAIT.setModel(datamodelWAIT);
        }
    }

    // display data in CHEF JTable
    public class updateSCHED{
        String[] CHEFcolNames = {"SUN", "MON","TUES","WED","THURS","FRI","SAT"};
        //= {{"Cheeseburger French Fries","Well done","7","Kathy"},{"Lobster Bisque","none","5","Jay"}};

        public updateSCHED(String id, String dateOne, String dateLast){
            ArrayList<SchedList> list = getUsersListSched(id, dateOne, dateLast);
            rowdata = new Object [4][7];

            for(int i = 0; i < 7;i++){
                rowdata[0][i] = list.get(i).getIdDate();
                rowdata[1][i] = list.get(i).getBegin() +"-"+ list.get(i).getEnd();
                //rowdata[2][i] = list.get(i).getEnd();
                //rowdata[i][4] = i + 1;
            }
            for(int i = 7; i < list.size();i++){
                rowdata[2][i-7] = list.get(i).getIdDate();
                rowdata[3][i-7] = list.get(i).getBegin() +"-"+ list.get(i).getEnd();
                //rowdata[2][i] = list.get(i).getEnd();
                //rowdata[i][4] = i + 1;
            }

            DefaultTableModel datamodelSCHED = (DefaultTableModel)tableSCHED.getModel();
            datamodelSCHED.setDataVector(rowdata, CHEFcolNames);
            datamodelSCHED.fireTableDataChanged();


            //tableCHEF.setModel(datamodelCHEF);
        }
    }


    //used for demonstration purposes when not fully integrated with customer and manager part
    public class initDB{
        public initDB(){
            Connection connection = getConnection();
            String query0 = "TRUNCATE TABLE chefslist";
            String query1 = "TRUNCATE TABLE waiterslist";
            String query2 = "INSERT INTO chefslist " + "VALUES('Cheeseburger','Bacon',7,'Nancy',1)";
            String query3 = "INSERT INTO chefslist " + "VALUES('Lobster','none',3,'Brett',2)";
            String query4 = "INSERT INTO chefslist " + "VALUES('Italian Sub','none',4,'Andy',3)";
            String query5 = "INSERT INTO chefslist " + "VALUES('Fish Sticks','none',4,'Andy',4)";
            String query6 = "INSERT INTO chefslist " + "VALUES('Cheesesteak','cheese whiz',5,'Sarah',5)";

            try {
                boolean rs;

                java.sql.PreparedStatement pstmt = connection.prepareStatement(query0);
                rs = pstmt.execute(query0);

                pstmt = connection.prepareStatement(query1);
                rs = pstmt.execute(query1);

                pstmt = connection.prepareStatement(query2);
                rs = pstmt.execute(query2);

                pstmt = connection.prepareStatement(query3);
                rs = pstmt.execute(query3);

                pstmt = connection.prepareStatement(query4);
                rs = pstmt.execute(query4);

                pstmt = connection.prepareStatement(query5);
                rs = pstmt.execute(query5);

                pstmt = connection.prepareStatement(query6);
                rs = pstmt.execute(query6);


                //String messageString = firstName + lastName + " has been clocked!";

                //JOptionPane.showMessageDialog(null, messageString);

                connection.close();

            }
            catch(Exception ee){
                JOptionPane.showMessageDialog(null,"Error in finding the id entered!");
                System.err.println(ee.getMessage());
            }
        }

    }





/*START OF THE MAIN FUNCTION*/
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
/*END OF THE MAIN FUNCTION*/
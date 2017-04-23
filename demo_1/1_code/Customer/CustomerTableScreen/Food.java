import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class Food extends JFrame{

JButton placeOrder;
JButton makePayment;
JButton callAssistance;
JButton entertainment;

public Food(){

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JPanel pane = new JPanel();
  pane.setLayout(null);
  JScrollPane scrollFrame = new JScrollPane(pane);
  pane.setAutoscrolls(true);
  scrollFrame.setPreferredSize(new Dimension( 800,300));
  this.add(scrollFrame);
  //Import the image icons for the buttons
  ImageIcon placeOrder_Icon      = new ImageIcon("icons/placeOrder.gif");
  ImageIcon makePayment_Icon     = new ImageIcon("icons/payment.gif");
  ImageIcon callAssistance_Icon  = new ImageIcon("icons/assistance.gif");
  ImageIcon entertainment_Icon   = new ImageIcon("icons/entertainment.gif");

  placeOrder     = new JButton(placeOrder_Icon);
  makePayment    = new JButton(makePayment_Icon);
  callAssistance = new JButton(callAssistance_Icon);
  entertainment  = new JButton(entertainment_Icon);

  placeOrder.setBounds(150,150,220,150);
  makePayment.setBounds(450,150,220,150);
  callAssistance.setBounds(150,350,220,150);
  entertainment.setBounds(450,850,220,150);

  pane.add(placeOrder);
  pane.add(makePayment);
  pane.add(callAssistance);
  pane.add(entertainment);

  //pane.add(scrollFrame);

  getContentPane().add(pane);
  setSize(800,600);
  setVisible(true);
}




public static void main(String[] args){
  Food f = new Food();
}



}

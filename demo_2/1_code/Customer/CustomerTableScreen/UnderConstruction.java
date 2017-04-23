import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class UnderConstruction extends JFrame implements ActionListener {

JButton back;
int tableID;

public UnderConstruction(int table_id) {

super("Under Construction (CTS)");
tableID = table_id;

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel pane = new JPanel();
pane.setLayout(null);

//Setting the Title and location
JLabel title = new JLabel("Under Construction (CTS)...");
title.setBounds(230,100,600,100);

Font font = new Font("Cambria", Font.BOLD, 30);
title.setFont(font);

ImageIcon back_Icon = new ImageIcon("icons/back.gif");
back                = new JButton(back_Icon);
back.setBounds(120,450,100,43);

//adding the title, notification, and back button to the JPanel
pane.add(title);
pane.add(back);

back.addActionListener(this);

getContentPane().add(pane);
setSize(800,600);
setVisible(true);
}

//****************************************************************
//******************* CUSTOMER ACTIONS      **********************
//****************************************************************
@Override
public void actionPerformed(ActionEvent e) {
  Object source = e.getSource();

  if(source == back){
    setVisible(false);
    CustomerTableScreen cts = new CustomerTableScreen(tableID);
  }
}

public static void main(String args[]) {
  UnderConstruction uc = new UnderConstruction(3);
}

}

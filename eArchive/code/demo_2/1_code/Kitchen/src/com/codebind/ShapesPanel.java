package com.codebind;

import javafx.scene.control.Tab;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

import javax.swing.*;





public class ShapesPanel extends JPanel {

    Shape[] Tabels;
    int[] TStatus;
    int index = -1;
    int indexCnt = -1;



    public ShapesPanel() {
        TStatus = new int[8];
        for (int j = 0; j < TStatus.length; j++){
            TStatus[j] = 1;
        }
        Tabels = new Shape[8];

        setPreferredSize(new Dimension(824, 990));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                indexCnt = 0;
                for (Shape s : Tabels) {

                    if (s.contains(me.getPoint())) {//check if mouse is clicked within shape
                        index = indexCnt;
                        //we can either just print out the object class name
                        System.out.println("Clicked a " + s.getClass().getName());

                        FrejmSTATUS frejm = new FrejmSTATUS();
                        frejm.setSize(800,400);
                        frejm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frejm.setVisible(true);
                        repaint();
                        break;
                        //or check the shape class we are dealing with using instance of with nested if
                        /*if (s instanceof Rectangle2D) {
                            System.out.println("Clicked a rectangle");
                        } else if (s instanceof Ellipse2D) {
                            System.out.println("Clicked a circle");
                        }*/

                    }
                    indexCnt = indexCnt + 1;
                }
                repaint();
            }
        });
    }

    public int getTableStatus(int index){
        if (index < TStatus.length){
            return TStatus[index];
        }else{
            return -1;
        }
    }

    public void setTableStatus(int index, int status){
        if (index < TStatus.length && status > 0 && status < 6){
            TStatus[index] = status;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        System.out.println("PAINTING");


        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        Rectangle2D rect = new Rectangle2D.Double(20, 0,100,30);
        g2d.setPaint(new Color(51,25,0));
        g2d.fill(rect);
        ((Graphics2D) g).draw(rect);

        rect = new Rectangle2D.Double(20, 930,100,30);
        g2d.setPaint(new Color(51,25,0));
        g2d.fill(rect);
        ((Graphics2D) g).draw(rect);

        rect = new Rectangle2D.Double(700, 930,100,30);
        g2d.setPaint(new Color(51,25,0));
        g2d.fill(rect);
        ((Graphics2D) g).draw(rect);

        g2d.setPaint(new Color(102,204,0));

        Tabels[0] = new Rectangle2D.Double(710, 720,100,150);
        switch(TStatus[0]){
            case 1:  g2d.setPaint(new Color(102,204,0));
                        break;
            case 2:  g2d.setPaint(new Color(102,178,255));
                        break;
            case 3: g2d.setPaint(new Color(255,128,0));
                        break;
            case 4: g2d.setPaint(new Color(192,192,192));
                        break;
            case 5: g2d.setPaint(new Color(255,102,102));
                        break;
            default:    g2d.setPaint(new Color(255,102,102));
                        break;
        }
        g2d.fill(Tabels[0]);
        ((Graphics2D) g).draw(Tabels[0]);


        Tabels[1] = new Rectangle2D.Double(710, 380,100,150);
        switch(TStatus[1]){
            case 1:  g2d.setPaint(new Color(102,204,0));
                break;
            case 2:  g2d.setPaint(new Color(102,178,255));
                break;
            case 3: g2d.setPaint(new Color(255,128,0));
                break;
            case 4: g2d.setPaint(new Color(192,192,192));
                break;
            case 5: g2d.setPaint(new Color(255,102,102));
                break;
            default:    g2d.setPaint(new Color(255,102,102));
                break;
        }
        g2d.fill(Tabels[1]);
        ((Graphics2D) g).draw(Tabels[1]);


        Tabels[2] = new Rectangle2D.Double(710, 40,100,150);
        switch(TStatus[2]){
            case 1:  g2d.setPaint(new Color(102,204,0));
                break;
            case 2:  g2d.setPaint(new Color(102,178,255));
                break;
            case 3: g2d.setPaint(new Color(255,128,0));
                break;
            case 4: g2d.setPaint(new Color(192,192,192));
                break;
            case 5: g2d.setPaint(new Color(255,102,102));
                break;
            default:    g2d.setPaint(new Color(255,102,102));
                break;
        }
        g2d.fill(Tabels[2]);
        ((Graphics2D) g).draw(Tabels[2]);


        Tabels[3] = new Rectangle2D.Double(418, 720,200,150);
        switch(TStatus[3]){
            case 1:  g2d.setPaint(new Color(102,204,0));
                break;
            case 2:  g2d.setPaint(new Color(102,178,255));
                break;
            case 3: g2d.setPaint(new Color(255,128,0));
                break;
            case 4: g2d.setPaint(new Color(192,192,192));
                break;
            case 5: g2d.setPaint(new Color(255,102,102));
                break;
            default:    g2d.setPaint(new Color(255,102,102));
                break;
        }
        g2d.fill(Tabels[3]);
        ((Graphics2D) g).draw(Tabels[3]);


        Tabels[4] = new Rectangle2D.Double(118, 720,200,150);
        switch(TStatus[4]){
            case 1:  g2d.setPaint(new Color(102,204,0));
                break;
            case 2:  g2d.setPaint(new Color(102,178,255));
                break;
            case 3: g2d.setPaint(new Color(255,128,0));
                break;
            case 4: g2d.setPaint(new Color(192,192,192));
                break;
            case 5: g2d.setPaint(new Color(255,102,102));
                break;
            default:    g2d.setPaint(new Color(255,102,102));
                break;
        }
        g2d.fill(Tabels[4]);
        ((Graphics2D) g).draw(Tabels[4]);


        Tabels[5] = new Rectangle2D.Double(418, 380,200,150);
        switch(TStatus[5]){
            case 1:  g2d.setPaint(new Color(102,204,0));
                break;
            case 2:  g2d.setPaint(new Color(102,178,255));
                break;
            case 3: g2d.setPaint(new Color(255,128,0));
                break;
            case 4: g2d.setPaint(new Color(192,192,192));
                break;
            case 5: g2d.setPaint(new Color(255,102,102));
                break;
            default:    g2d.setPaint(new Color(255,102,102));
                break;
        }
        g2d.fill(Tabels[5]);
        ((Graphics2D) g).draw(Tabels[5]);


        Tabels[6] = new Rectangle2D.Double(118, 380,200,150);
        switch(TStatus[6]){
            case 1:  g2d.setPaint(new Color(102,204,0));
                break;
            case 2:  g2d.setPaint(new Color(102,178,255));
                break;
            case 3: g2d.setPaint(new Color(255,128,0));
                break;
            case 4: g2d.setPaint(new Color(192,192,192));
                break;
            case 5: g2d.setPaint(new Color(255,102,102));
                break;
            default:    g2d.setPaint(new Color(255,102,102));
                break;
        }
        g2d.fill(Tabels[6]);
        ((Graphics2D) g).draw(Tabels[6]);


        Tabels[7] = new Ellipse2D.Double(418, 40,200,200);
        switch(TStatus[7]){
            case 1:  g2d.setPaint(new Color(102,204,0));
                break;
            case 2:  g2d.setPaint(new Color(102,178,255));
                break;
            case 3: g2d.setPaint(new Color(255,128,0));
                break;
            case 4: g2d.setPaint(new Color(192,192,192));
                break;
            case 5: g2d.setPaint(new Color(255,102,102));
                break;
            default:    g2d.setPaint(new Color(255,102,102));
                break;
        }
        g2d.fill(Tabels[7]);
        ((Graphics2D) g).draw(Tabels[7]);

    }




    public class FrejmSTATUS extends JFrame{
        JFrame FrameNUMPAD = new JFrame();

        public FrejmSTATUS(){
            JTextArea statusPrompt = new JTextArea();
            statusPrompt.setText("Choose a Status:");


            //++++++++++++++++++INITIATING BUTTONS AND LISTENERS
            JButton buttonEclean = new JButton("Empty, Clean");
            JButton buttonEdirty = new JButton("Empty, Dirty");
            JButton buttonTnoO = new JButton("Taken, No Orders");
            JButton buttonTO = new JButton("Taken, Orders");
            JButton buttonTP = new JButton("Taken, Paying");
            JButton buttonCancel = new JButton("Cancel");


            buttonEclean.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    TStatus[index] = 1;
                    System.out.println("INDEX: " + index);
                    setVisible(false);

                }
            });

            buttonEdirty.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    TStatus[index] = 2;
                    System.out.println("INDEX: " + index);
                    setVisible(false);
                }
            });

            buttonTnoO.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    TStatus[index] = 3;
                    System.out.println("INDEX: " + index);
                    setVisible(false);
                }
            });

            buttonTO.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    TStatus[index] = 4;
                    System.out.println("INDEX: " + index);
                    setVisible(false);
                }
            });

            buttonTP.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    TStatus[index] = 5;
                    System.out.println("INDEX: " + index);
                    setVisible(false);
                }
            });

            buttonCancel.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });


            setLayout(new GridBagLayout());

            GridBagConstraints gc = new GridBagConstraints();

            //********NUMBERS OK DEL*************

            gc.weightx = 0.5;
            gc.weighty = 0.5;

            /*gc.gridx = 0;
            gc.gridy = 0;
            add(statusPrompt, gc);*/

            gc.gridx = 0;
            gc.gridy = 1;
            add(buttonEclean, gc);

            gc.gridx = 1;
            gc.gridy = 1;
            add(buttonEdirty, gc);

            gc.gridx = 2;
            gc.gridy = 1;
            add(buttonTnoO, gc);

            gc.gridx = 3;
            gc.gridy = 1;
            add(buttonTO, gc);

            gc.gridx = 4;
            gc.gridy = 1;
            add(buttonTP, gc);

            gc.gridx = 2;
            gc.gridy = 2;
            add(buttonCancel, gc);


        }

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
}



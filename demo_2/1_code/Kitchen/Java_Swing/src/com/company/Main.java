package com.company;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.event.*;

//Padding
import java.awt.Insets;
import javax.swing.*;

public class Main extends JFrame{

    public static void main(String[] args) {
	new Main();
    }

    public Main(){
        //Java Swing Tutorial
        //Link: https://www.youtube.com/watch?v=dKnRUuYVR0Q&list=PLfyq5A05w62_verkKr3DWKWbttvdgexH3&in
        /*Chapter
        * Java Video Tutorial 20
        *   -JFrame, JTextArea, JButton, JScrollPanel, JPanel !!
        * Java Video Tutorial 21
        *   -Java Action Listeners !!
        * Java Video Tutorial 22
        *   -Java Change Listeners and Formatting Numbers Part 1
        * Java Video Tutorial 23
        *  - Java Change Listeners and Formatting Numbers Part 2
        * Java Video Tutorial 24
        * Java Video Tutorial 25
        *   -JList
        * Java Video Tutorial 26
        *   -Spinners
        * Java Video Tutorial 27
        *   -Trees
        * Java Video Tutorial 28
        *   -Layouts
        * Java Video Tutorial 29
        *  -Grid Layout and GridBag Layouts !!
        * Java Video Tutorial 30
        * Java Video Tutorial 31
        * Java Video Tutorial 32
        * Java Video Tutorial 33
        * Java Video Tutorial 34
        * Java Video Tutorial 35
        * Java Video Tutorial 36
        * Java Video Tutorial 37
        * Java Video Tutorial 38
        * Java Video Tutorial 39
        * */

        /***
         *
         * JFrame, JPanel, JTextArea,JButton, JScrollPanel Tutorial
         * */
        /*this.setSize(500,500);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width/2) - (this.getWidth()/2);
        int yPos = (dim.height/2) - (this.getHeight()/2);

        this.setLocation(xPos,yPos);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My First GUI");

        JPanel thePanel  = new JPanel();
        JLabel theLabel  = new JLabel("Tell me something");
        thePanel.add(theLabel);

        theLabel.setText("New text");
        theLabel.setToolTipText("DOES NOTHING");

        JButton button1 = new JButton("Send");
        //button1.setText("New Text");
        thePanel.add(button1);

        JTextField textField1 = new JTextField("Type here", 15);
        textField1.setColumns(16);
        textField1.setToolTipText("Its a text field ");
        thePanel.add(textField1);

        JTextArea theTextArea = new JTextArea(15,20);
        theTextArea.setText("Just a whole bunch of\n text that is important");
        theTextArea.setLineWrap(true);
        theTextArea.setWrapStyleWord(true);

        int numOfLines = theTextArea.getLineCount();
        theTextArea.append("Number of line: " + numOfLines);

        JScrollPane scrollBar1 = new JScrollPane(theTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollBar1);
        textField1.requestFocus();

        this.add(thePanel);
        this.setVisible(true);*/



        /** Kitchen Key Pad **/

        JButton numberOneKey, numberTwoKey, numberThreeKey, numberFourKey, numberFiveKey,
                numberSixKey, numberSevenKey, numberEightKey, numberNineKey, clearKey,
                enterKey, deleteKey;


        this.setSize(500,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock In");

        JPanel kitchenInterface = new JPanel();

        GridBagConstraints gridConstraints = new GridBagConstraints();

        /*Sets the default layout of the Grid for the Clock In*/
        kitchenInterface.setLayout(new GridBagLayout());
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;
        gridConstraints.weightx = 50;
        gridConstraints.weighty = 100;
        //Defines the spacing around each key to be of equal distance
        gridConstraints.insets = new Insets(5,5,5,5);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.BOTH;

        JTextField inputTextField = new JTextField("Please Enter Employee ID",20);
        /*Sets the icon for the Keypad*/

        ImageIcon icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8,icon9, icon0 ,clearIcon,enterIcon,deleteIcon;
        /*icon1 = new ImageIcon(getClass().getResource("One.png"));
        icon2 = new ImageIcon(getClass().getResource("two.png"));
        icon3 = new ImageIcon(getClass().getResource("three.png"));
        icon4 = new ImageIcon(getClass().getResource("four.png"));
        icon5 = new ImageIcon(getClass().getResource("five.png"));
        icon6 = new ImageIcon(getClass().getResource("six.png"));
        icon7 = new ImageIcon(getClass().getResource("seven.png"));
        icon8 = new ImageIcon(getClass().getResource("eight.png"));
        icon9 = new ImageIcon(getClass().getResource("nine.png"));*/
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
        clearIcon = new ImageIcon(getClass().getResource("delete.png"));
        deleteIcon = new ImageIcon(getClass().getResource("eraser.png"));



        /*Assigns the Values of the Keypad Buttons*/
        numberOneKey = new JButton(icon1);
        numberTwoKey = new JButton(icon2);
        numberThreeKey = new JButton(icon3);
        numberFourKey = new JButton(icon4);
        numberFiveKey = new JButton(icon5);
        numberSixKey = new JButton(icon6);
        numberSevenKey = new JButton(icon7);
        numberEightKey = new JButton(icon8);
        numberNineKey = new JButton(icon9);
        clearKey = new JButton(clearIcon);
        deleteKey = new JButton(icon0);
        enterKey = new JButton(enterIcon);

        /*Sets Helpful ToolTips*/

        clearKey.setToolTipText("Clears Input");
        enterKey.setToolTipText("Submits your input for verification");



        /*Defines the layout of the Keypad in a grid matrix formation*/
        gridConstraints.gridwidth = 20;
        gridConstraints.gridx = 1;
        kitchenInterface.add(inputTextField,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        kitchenInterface.add(numberOneKey,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        kitchenInterface.add(numberTwoKey,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 2;
        kitchenInterface.add(numberThreeKey,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        kitchenInterface.add(numberFourKey,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        kitchenInterface.add(numberFiveKey,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 3;
        kitchenInterface.add(numberSixKey,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        kitchenInterface.add(numberSevenKey,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 4;
        kitchenInterface.add(numberEightKey,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 4;
        kitchenInterface.add(numberNineKey,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        kitchenInterface.add(clearKey,gridConstraints);
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 5;
        kitchenInterface.add(deleteKey,gridConstraints);
        gridConstraints.gridwidth = 3;
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 5;
        kitchenInterface.add(enterKey,gridConstraints);





        this.add(kitchenInterface);
        this.setVisible(true);








    }

}

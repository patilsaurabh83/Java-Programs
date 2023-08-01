package Udemy.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CosineRuleTest{

    //Class to calculate the other side BC
    int side;
    public int side(int b, int c, int angle) {
       side  = (int) Math.sqrt((b * b) + (c * c) - (2 * b * c * Math.cos(angle)));
       return side;
    }
}

class CosineRule extends JFrame implements ActionListener {
    private JLabel firstSideLabel;
    private JLabel secondSideLabel;
    private JLabel includedAngleLabel;
    private JLabel otherSideLabel;

    private JTextField firstSide;
    private JTextField secondSide;
    private JTextField includedAngle;
    private JTextField otherSide;

    private JButton go;
    CosineRule(){
        super("Cosine Rule");
        // Here created the objects of two sides and angle (Label and Textfield also)
        firstSideLabel = new JLabel("Side AB: ");
        secondSideLabel = new JLabel("Side AC: ");
        otherSideLabel = new JLabel("Side BC: ");
        includedAngleLabel = new JLabel("Angle BAC: ");

        firstSide = new JTextField(6);
        secondSide = new JTextField(6);
        otherSide = new JTextField(6);
        includedAngle = new JTextField(6);

        go = new JButton("Go");
        setLayout(new FlowLayout());

        add(firstSideLabel);
        //ToolTipText will give you the suggestion of the field value
        firstSide.setToolTipText("First Side");
        add(firstSide);

        add(secondSideLabel);
        secondSide.setToolTipText("Second Side");
        add(secondSide);

        add(otherSideLabel);
        otherSide.setToolTipText("Other side");
        otherSide.setEditable(false);
        add(otherSide);

        add(includedAngleLabel);
        includedAngle.setToolTipText("Angle");
        add(includedAngle);

        add(go,BorderLayout.SOUTH);
        go.setDefaultCapable(true);
        //Below method will remove the unwanted border which is comes after the Clicking the button
        go.setFocusable(false);

        go.addActionListener(this);
    }


        @Override
        public void actionPerformed (ActionEvent e){
        try {

        //When Go button is clicked this part will execute

        //Obj of CosineRuleTest class
        CosineRuleTest ct = new CosineRuleTest();

        int b = Integer.parseInt(firstSide.getText());
        int c = Integer.parseInt(secondSide.getText());
        int angle = Integer.parseInt(includedAngle.getText());

        //Function call of CosineRuleTest side method
        int side = ct.side(b, c, angle);
        //Here text will be provided to the JTextfield of Side BC
        otherSide.setText(" " + side);

    } catch (NumberFormatException ex) {
            System.out.println(e);
        }
        }
}
public class Triangle{
    public static void main(String[] args) {
       CosineRule cr = new CosineRule();
       cr.setSize(300,150);

       // below method setResizable avoids from resizing the window
       cr.setResizable(false);
       cr.setVisible(true);
       cr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

package Udemy.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Student1 extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField tf,tf1;
    JCheckBox register;
    JTextArea ta;
    JButton Ok,Clear;

    Student1(){
        super("Demo");

        l1= new JLabel("First Name: ");
        l2 = new JLabel("Last Name: ");

        register = new JCheckBox("Registered");
        tf = new JTextField(10);
        tf1 = new JTextField(10);

        ta = new JTextArea(3,15);

        Ok = new JButton("Ok");
        Clear = new JButton("Clear");
        setLayout(new FlowLayout());

        add(l1);
        add(tf);
        add(l2);
        add(tf1);
        add(register);
        add(ta);
        add(Clear);
        add(Ok);
       Ok.addActionListener(this);
       Clear.addActionListener(this);
       register.addActionListener(this);

       Clear.getActionCommand();
       Ok.getActionCommand();
    }

    String str="";
    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand())
       {
           case "Clear":
               tf.setText("");
               tf1.setText("");
               break;
           case "Ok":
               if (!tf.getText().isBlank()) {

                   if (register.isSelected())
                       ta.setText(tf.getText() + " " + tf1.getText() + " is \nregistered");
                   else {
                       ta.setText(tf.getText() + " " + tf1.getText() + " is not \nregistered");
                   }
               }
               else {
                   //if you don't want any text then remove the text from here
                   ta.setText("Write something in the TextFields");
               }
       }

    }
}
public class Student {
    public static void main(String[] args) {
        Student1 s = new Student1();
        s.setSize(205,200);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

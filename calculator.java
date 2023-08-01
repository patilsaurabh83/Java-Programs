package Udemy.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


class Calculation{
    int num;
    public int calculate(String operation,int a1, int a2){
        switch (operation) {
            case "Addition" -> num = a1+a2;
            case "Subtraction" -> num = a1-a2;
            case "Multiplication" -> num = a1*a2;
            case "Division" ->  num = a1/a2;
        }
        return num;
    }
}

class Frame extends JFrame implements ActionListener {
    JTextArea tf;
    Calculation c = new Calculation();
    JPanel p1,p2;
    JButton one,two,three,four,five,six,seven,eight,nine,zero,back;
    JButton add,mul,sub,div,equals;
    String str="";
    public String str1="";
    int a1=0;
    int a2=0;

    ArrayList<Integer> a3 = new ArrayList<>();
    int count=0;
    Frame(){
        super("Calculator");

        tf = new JTextArea(3,26);
        tf.setBounds(100,100,100,200);

        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("x");
        div = new JButton("/");
        equals = new JButton("=");
        back = new JButton("Backspace");

        p1 = new JPanel();
        p2 = new JPanel();

        p1.add(tf);
        p1.setLayout(new FlowLayout());
        p1.setSize(100,100);

        p2.add(one);
        p2.add(two);
        p2.add(three);
        p2.add(add);
        p2.add(four);
        p2.add(five);
        p2.add(six);
        p2.add(sub);
        p2.add(seven);
        p2.add(eight);
        p2.add(nine);
        p2.add(mul);
        p2.add(zero);
        p2.add(div);
        p2.add(equals);
        p2.add(back);

        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        equals.addActionListener(this);
        back.addActionListener(this);

        p2.setLayout(new GridLayout(4,2));
        p2.setBounds(70,70,50,300);


        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         add.setActionCommand("Addition");
         sub.setActionCommand("Subtraction");
         mul.setActionCommand("Multiplication");
         div.setActionCommand("Division");
         equals.setActionCommand("Equals");
         back.setActionCommand("Back");

         one.setActionCommand("one");
         two.setActionCommand("two");
         three.setActionCommand("three");
         four.setActionCommand("four");
         five.setActionCommand("five");
         six.setActionCommand("six");
         seven.setActionCommand("seven");
         eight.setActionCommand("eight");
         nine.setActionCommand("nine");
         zero.setActionCommand("zero");


         switch (e.getActionCommand()){
             case "one":
                 str = str +"1";
                 tf.setText(str);
                 break;
             case "two":
                 str = str +"2";
                 tf.setText(str);
                 break;
             case "three":
                 str = str +"3";
                 tf.setText(str);
                 break;
             case "four":
                 str = str +"4";
                 tf.setText(str);
                 break;
             case "five":
                 str = str +"5";
                 tf.setText(str);
                 break;
             case "six":
                 str = str +"6";
                 tf.setText(str);
                 break;
             case "seven":
                 str = str +"7";
                 tf.setText(str);
                 break;
             case "eight":
                 str = str +"8";
                 tf.setText(str);
                 break;
             case "nine":
                 str = str +"9";
                 tf.setText(str);
                 break;
             case "zero":
                 str = str +"0";
                 tf.setText(str);
                 break;
         }

         switch (e.getActionCommand()) {
                 case "Addition":
                 case "Subtraction":
                 case "Multiplication":
                 case "Division":
                     a1 = Integer.parseInt(tf.getText());
                     str1 = e.getActionCommand();
                     tf.setText("");
                     str = "";
                     break;
                 case "Equals":
                     a2=Integer.parseInt(tf.getText());
                     tf.setText("");
                     tf.setText(String.valueOf(c.calculate(str1, a1,a2)));
                     a1 = 0;
                     a2 = 0;
                     str1 = "";
                     count++;
                     break;
             case "Back":
                str = tf.getText();
                int n = str.lastIndexOf(str);
                StringBuilder str2 = new StringBuilder(str);
                str2 =str2.deleteCharAt(n);
                tf.setText(String.valueOf(str2));
                if (str2.isEmpty()){
                    tf.setText("0");
                }
             }
    }
}
public class calculator {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(280,250);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame f=new JFrame("Converter");

        JLabel label1,label2,label3,label4, label5;
        label1 = new JLabel("Amount of Dollars");
        label1.setBounds(150,50, 200,30);

        JTextField t1;
        t1=new JTextField("");
        t1.setBounds(100,100, 200,30);

        JButton b=new JButton("Convert");
        b.setBounds(150,200,100, 40);

        label2 = new JLabel("Conversion result:");
        label2.setBounds(150,300, 200,30);

        label3 = new JLabel("-");
        label3.setBounds(100,330, 200,30);
        label3.setFont(new Font("Serif", Font.PLAIN, 18));

        label4 = new JLabel("-");
        label4.setBounds(100,350, 200,30);
        label4.setFont(new Font("Serif", Font.PLAIN, 18));

        label5 = new JLabel("");
        label5.setBounds(90,150, 300,30);
        label5.setFont(new Font("Serif", Font.PLAIN, 18));
        label5.setForeground(Color.RED);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(t1.getText().matches("[0-9]+")){
                    double dollars = Double.parseDouble(t1.getText());
                    double euro =  dollars * 1.02;
                    label3.setText(dollars + " Dollars = " );
                    label4.setText(Math.round(euro * 100.0) / 100.0 +" Euro");
                    label5.setText("");
                }else{
                    label5.setText("ONLY NUMBERS PLEASE");
                    t1.setText("");

                }

            }
        });

        f.add(b);
        f.add(t1);
        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(label4);
        f.add(label5);

        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
}
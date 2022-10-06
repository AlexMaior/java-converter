import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {

        JFrame f=new JFrame("Converter");

        JLabel label1,label2,label3,label4, label5, label6, label7;

        JRadioButton radioB1=new JRadioButton("Celsius");
        JRadioButton radioB2=new JRadioButton("Fahrenheit");
        JRadioButton radioB3=new JRadioButton("Kelvin");
        JRadioButton radioB4=new JRadioButton("Celsius");
        JRadioButton radioB5=new JRadioButton("Fahrenheit");
        JRadioButton radioB6=new JRadioButton("Kelvin");

        label1 = new JLabel("Temperature converter");
        label1.setBounds(200,10, 200,30);
        label6 = new JLabel("Enter the degrees you want to convert : ");
        label6.setBounds(150,50,300,30);

        JTextField t1;
        t1=new JTextField("");
        t1.setBounds(200,100, 100,30);

        radioB1.setBounds(105,150,100,30);
        radioB2.setBounds(205,150,100,30);
        radioB3.setBounds(305,150,100,30);

        ButtonGroup from = new ButtonGroup();
        from.add(radioB1);
        from.add(radioB2);
        from.add(radioB3);

        label7 = new JLabel("Convert to : ");
        label7.setBounds(220,200,100,30);

        radioB4.setBounds(105,250,100,30);
        radioB5.setBounds(205,250,100,30);
        radioB6.setBounds(305,250,100,30);

        ButtonGroup to = new ButtonGroup();
        to.add(radioB4);
        to.add(radioB5);
        to.add(radioB6);

        JButton b=new JButton("Convert");
        b.setBounds(200,300,100, 40);

        label2 = new JLabel("Conversion result:");
        label2.setBounds(200,350, 200,30);

        label3 = new JLabel("-");
        label3.setBounds(170,380, 400,30);
        label3.setFont(new Font("Serif", Font.PLAIN, 18));

        label4 = new JLabel("-");
        label4.setBounds(170,410, 400,30);
        label4.setFont(new Font("Serif", Font.PLAIN, 18));

        label5 = new JLabel("");
        label5.setBounds(170,410, 400,30);
        label5.setFont(new Font("Serif", Font.PLAIN, 18));
        label5.setForeground(Color.RED);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String input = t1.getText();
                input = input.replaceAll("\\s+","");
                if(!t1.getText().matches("[a-z]+")  & input.length()>0) {
                    double temp = Double.parseDouble(t1.getText());
                    String from = "";
                    String to = "";

                    from = fromBtn(radioB1, radioB2, radioB3, from);
                    to = toBtn(radioB4, radioB5, radioB6, to);

                    setResults(from, to, temp, label3, label4);

                    label5.setText("");
                }else{
                    label3.setText("");
                    label4.setText("");
                    label5.setText("");
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
        f.add(label6);
        f.add(label7);
        f.add(radioB1);
        f.add(radioB2);
        f.add(radioB3);
        f.add(radioB4);
        f.add(radioB5);
        f.add(radioB6);

        f.setSize(550,500);
        f.setLayout(null);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent ev)
            {System.exit(0);}
        });
    }

    static String fromBtn(JRadioButton radioB1,
                          JRadioButton radioB2,
                          JRadioButton radioB3,
                          String from){
        if (radioB1.isSelected()) {
            from = "Cel";
        }

        if (radioB2.isSelected()) {
            from = "Fah";
        }
        if (radioB3.isSelected()) {
            from = "Kel";
        }
        return from;
    }

    static String toBtn(JRadioButton radioB4,
                        JRadioButton radioB5,
                        JRadioButton radioB6,
                        String to){
        if (radioB4.isSelected()) {
            to = "Cel";
        }
        if (radioB5.isSelected()) {
            to = "Fah";
        }
        if (radioB6.isSelected()) {
            to = "Kel";
        }
        return to;
    }

    static void setResults(String from, String to, double temp, JLabel label3, JLabel label4){
        if (from == "Cel" && to == "Cel") {
            label3.setText(temp + " degrees Celsius = ");
            label4.setText(temp + " degrees Celsius");
        }

        if (from == "Cel" && to == "Fah") {
            label3.setText(temp + " degrees Celsius = ");
            label4.setText(temp * 1.8 + 32 + " degrees Fahrenheit");
        }

        if (from == "Cel" && to == "Kel") {
            label3.setText(temp + " degrees Celsius = ");
            label4.setText(Math.round((temp + 273.15) * 100.0) / 100.0 + " degrees Kelvin");
        }


        if (from == "Fah" && to == "Cel") {
            label3.setText(temp + " degrees Fahrenheit = ");
            label4.setText(Math.round(((temp - 32) * .5556) * 100.0) / 100.0 + " degrees Celsius");
        }

        if (from == "Fah" && to == "Fah") {
            label3.setText(temp + " degrees Fahrenheit = ");
            label4.setText(temp + " degrees Fahrenheit");
        }

        if (from == "Fah" && to == "Kel") {
            label3.setText(temp + " degrees Fahrenheit = ");
            label4.setText(Math.round(((((temp - 32) * 5) / 9) + 273.15) * 100.0) / 100.0 + " degrees Kelvin");
        }

        if (from == "Kel" && to == "Cel") {
            label3.setText(temp + " degrees Kelvin = ");
            label4.setText(temp - 273.15 + " degrees Celsius");
        }

        if (from == "Kel" && to == "Fah") {
            label3.setText(temp + " degrees Kelvin = ");
            label4.setText(Math.round((((temp - 273.15) * 9 / 5) + 32) * 100.0) / 100.0 + " degrees Fahrenheit");
        }

        if (from == "Kel" && to == "Kel") {
            label3.setText(temp + " degrees Kelvin = ");
            label4.setText(temp + " degrees Kelvin");
        }
    }

}
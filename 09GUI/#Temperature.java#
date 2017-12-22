import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Temperature extends JFrame implements ActionListener{
    private Container pane;
    private JButton b,b2;
    private JTextField text;

    public Temperature() {
        this.setTitle("Temperature GUI");
        this.setSize(600,80);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        b = new JButton("Celcius to Fahrenheit");
        b2 = new JButton("Fahrenheit to Celcius");
        text = new JTextField(15);

        b.addActionListener(this);
        b2.addActionListener(this);
        text.addActionListener(this);

        pane.add(text);
        pane.add(b);
        pane.add(b2);

    }
    public static double CtoF(double t){

	return t*9/5+32;
	
    }
    public static double FtoC(double t){

	return (t-32)*5/9;
	
    }
    public void actionPerformed(ActionEvent e){
	String event=e.getActionCommand();
	System.out.println(event); //prints the actions
	if (event.equals("Celcius to Fahrenheit")){
	    text.setText(String.valueOf(CtoF(Double.parseDouble(text.getText()))));
	}
	if (event.equals("Fahrenheit to Celcius")){
	    text.setText(String.valueOf(FtoC(Double.parseDouble(text.getText()))));
	}
    }
    public static void main(String[] args){
        Temperature g = new Temperature();
        g.setVisible(true);
	/*	System.out.println(CtoF(-40.0));
	System.out.println(CtoF(100.0));
	System.out.println(FtoC(212.0));*/
    }
}

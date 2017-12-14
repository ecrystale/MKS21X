import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Temperature extends JFrame implements ActionListener{
    private Container pane;
    private JTextField text;
    private JButton b,b2;
    public void Temperature() {
        this.setTitle("Temperature GUI");
        this.setSize(500,80);
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
	if (t<0){
	    return t;
	}
	else{
	    return t+112;
	}
    }
    public static double FtoC(double t){
	if (t<0){
	    return t;
	}
	else{
	    return t-112;
	}
    }
    public void actionPerformed(ActionEvent e){
	String event=e.getActionCommand();
        if (event.equals("CtoF")){

	};
    }
    public static void main(String[] args){
        Temperature g = new Temperature();
        g.setVisible(true);
	/*	System.out.println(CtoF(-40.0));
	System.out.println(CtoF(100.0));
	System.out.println(FtoC(212.0));*/
    }
}

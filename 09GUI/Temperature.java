import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Temperature implements ActionListener{
    TextField t=new Textfield(20);
    Button b=new Button("Enter");
    public Temperature(){
        this.setTitle("Temperature GUI");
        this.setSize(600,400);
        this.setLocation(100,100);
	pane=this.getContentPane();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

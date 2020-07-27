
package calcul;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class TracerCourbe extends JFrame implements ActionListener{

    private static final long serialVersionUID = -3914578220391097071L;

    static courbeC courbeC = new courbeC();
    private  JPanel p4 , p5;
	private JTextField aField,bField,xField,yField;
	private JComboBox<String> fctField;
	private JLabel aL,mul,pluss,b,x,y;
	JButton tracer;
	private float xmax,ymax;
    public TracerCourbe() {
    	
        super( "Tracer Courbe" );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		ImageIcon i = new ImageIcon("Images/courbe.jpg");
		this.setIconImage(i.getImage());
        JPanel contentPane = (JPanel) this.getContentPane();
        p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		p4.setBackground(Color.white);
		p5 = new JPanel();
		p4.setBounds(0, 0, 700, 50);
		p4.setPreferredSize(new Dimension(getWidth(),40));;
		p5.setLayout(new GridLayout(0, 12,10,5));
		aL = new JLabel("A");
		b = new JLabel("    B");
		pluss = new JLabel("     +");
		mul =   new JLabel("    *");
		mul.setFont(new Font("TAHOMA", Font.BOLD, 14));
		pluss.setFont(new Font("TAHOMA", Font.BOLD, 14));
		mul.setForeground(Color.red);;
		pluss.setForeground(Color.red);
		aField=new JTextField();
		aField.setBackground(new Color(32, 32, 32));
		aField.setForeground(Color.white);
		bField=new JTextField();
		bField.setBackground(new Color(32, 32, 32));
		bField.setForeground(Color.white);
		String[] s = {"x","x²","sin","cos","tan","asin","acos","atan","Ln","eˣ"};
		fctField=new JComboBox<String>(s);
		fctField.setBackground(new Color(32, 32, 32));
		fctField.setForeground(Color.white);
		xField=new JTextField();
		xField.setBackground(new Color(32, 32, 32));
		xField.setForeground(Color.white);
		xField.setText("10");
		yField=new JTextField();
		yField.setBackground(new Color(32, 32, 32));
		yField.setForeground(Color.white);
		yField.setText("10");
		aField.setText("1");
		bField.setText("0");
		x=new JLabel("Max X");
		y=new JLabel("Max Y");
		bField.setPreferredSize(new Dimension(60, 30));;
		aField.setPreferredSize(new Dimension(60, 30));;
		fctField.setPreferredSize(new Dimension(60, 30));;
		aL.setPreferredSize(new Dimension(20, 30));;
		b.setPreferredSize(new Dimension(20, 30));;
		pluss.setPreferredSize(new Dimension(50, 30));;
		mul.setPreferredSize(new Dimension(50, 30));;
		xField.setPreferredSize(new Dimension(60, 30));;
		yField.setPreferredSize(new Dimension(60, 30));;
		x.setPreferredSize(new Dimension(50, 30));;
		y.setPreferredSize(new Dimension(50, 30));;
		p4.add(aL);p4.add(aField);p4.add(mul); p4.add(fctField); p4.add(pluss);p4.add(b);p4.add(bField);
		p4.add(x);p4.add(xField);p4.add(y);p4.add(yField);p4.setVisible(true);
		tracer = new JButton("Tracer");
		tracer.setBackground(Color.orange);
		tracer.setPreferredSize(new Dimension(80, 30));;
		tracer.setBorderPainted(false);
		tracer.addActionListener(this);
		p4.add(tracer);
		p5.setVisible(false);
	
        contentPane.add( p4, BorderLayout.NORTH );
        
        contentPane.add( courbeC, BorderLayout.CENTER );
        
        
        this.setSize( 900, 470 );
        this.setLocationRelativeTo( null );
    }
    



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tracer) {
			Double av ;
			Double bv ;
			String fct ;
			xmax=Float.parseFloat(xField.getText());
			ymax=Float.parseFloat(yField.getText());
			this.courbeC.xMax=xmax;
			this.courbeC.yMax=ymax;
			if(!aField.getText().isEmpty()) 	
				if(!bField.getText().isEmpty()) 
				{
					 av = Double.parseDouble(aField.getText());
					 bv = Double.parseDouble(bField.getText());	 
				}else
				{
					 av = Double.parseDouble(aField.getText());
					 bv = 0.0;	 
				}
			else if(!bField.getText().isEmpty()) 
			{
				 av = 1.0;
				 bv = Double.parseDouble(bField.getText());	 
			}
			else{
				av=1.0;
				bv=0.0;	
			}
			fct =(String) fctField.getSelectedItem();
			if(fct.equals("x²"))
			this.courbeC.setFunction( (x) -> av*Math.pow(x, 2)+bv  );
			if(fct.equals("x"))
			this.courbeC.setFunction( (x) -> av*x+bv  );
			if(fct.equals("sin"))
			this.courbeC.setFunction( (x) -> av*Math.sin(x)+bv  );
			if(fct.equals("cos"))
			this.courbeC.setFunction( (x) -> av*Math.cos(x)+bv  );
			this.setVisible( true );
			if(fct.equals("tan"))
			this.courbeC.setFunction( (x) -> av*Math.tan(x)+bv  );
			this.setVisible( true );
			if(fct.equals("asin")) {
			this.courbeC.setFunction( (x) -> av*Math.asin(x)+bv  );
			}
			if(fct.equals("acos"))
			this.courbeC.setFunction( (x) -> av*Math.acos(x)+bv  );
			this.setVisible( true );
			if(fct.equals("atan"))
			this.courbeC.setFunction( (x) -> av*Math.atan(x)+bv  );
			this.setVisible( true );
			if(fct.equals("Ln"))
			this.courbeC.setFunction( (x) -> av*Math.log(x)+bv  );
			this.setVisible( true );
			if(fct.equals("eˣ"))
			this.courbeC.setFunction( (x) -> av*Math.exp(x)+bv  );
			this.setVisible( true );
		}
		
	}

}

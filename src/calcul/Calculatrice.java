package calcul;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculatrice extends JFrame implements ActionListener{
	
	JTextField txt;
	Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ANS, POINT;
	Button1 PN ;
	Button2 EG, MUL, PLUS, MOINS, DIV;
	JButton AC, DEL, OFF;
	JPanel p1, p2, p3, p4, panel;
	JRadioButton j1, j2;
	ButtonGroup g;
	double xp = 1, xs = 0, resultat = 0;
	boolean operation = false, mult = false, div = false, som = false, soust = false, init=true, virg=false;
	
	public Calculatrice() {
		
		super("ICalcul");
		this.setSize(300, 400);
		this.setLocationRelativeTo(null);
		
		ImageIcon i = new ImageIcon("Images/calculator.png");
		this.setIconImage(i.getImage());
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1,0));
		p1.setBackground(Color.white);
		
		txt =new JTextField("0");
		txt.setPreferredSize(new Dimension(286,60));
		txt.setEditable(false);
		txt.setBackground(Color.BLACK);
		txt.setForeground(Color.white);
		txt.setHorizontalAlignment(SwingConstants.RIGHT);
		txt.setFont(new Font("DIALOG", Font.CENTER_BASELINE+Font.BOLD, 20));
		
		p1.add(txt);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(5,0));
		
		b0 = new Button("0"); b1 = new Button("1"); b2 = new Button("2");
		b3 = new Button("3"); b4 = new Button("4"); b5 = new Button("5");
		b6 = new Button("6"); b7 = new Button("7"); b8 = new Button("8");
		b9 = new Button("9");
		AC = new JButton("AC"); DEL = new JButton("DEL"); PN = new Button1("±");
		MUL = new Button2("x"); PLUS = new Button2("+"); MOINS = new Button2("–");
		DIV = new Button2("÷"); POINT = new Button("."); EG = new Button2("=");
		ANS = new Button("Ans");
		EG.setPreferredSize(new Dimension(165,30));
		
		AC.setBackground(Color.red);
		DEL.setBackground(Color.red);
		AC.setForeground(Color.black);
		DEL.setForeground(Color.black);
		
		p2.add(AC); p2.add(DEL); p2.add(PN); p2.add(DIV);
		p2.add(b7); p2.add(b8); p2.add(b9); p2.add(MUL);
		p2.add(b4); p2.add(b5); p2.add(b6); p2.add(MOINS);
		p2.add(b1); p2.add(b2); p2.add(b3); p2.add(PLUS);
		p2.add(b0); p2.add(POINT); p2.add(ANS); p2.add(EG);
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.setBackground(Color.white);
		
		j1 = new JRadioButton("Standard");
		j1.setOpaque(false);
		j1.setSelected(true);
		j2 = new JRadioButton("Scientifique");
		j2.setOpaque(false);
		g = new ButtonGroup();
		g.add(j1);
		g.add(j2);
		
		p3.add(j1); p3.add(j2);
		
		p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		p4.setBounds(500, 200, 50, 20);
		p4.setBackground(Color.white);
		
		OFF= new JButton(new ImageIcon("Images/off.png"));
		OFF.setHorizontalTextPosition(JButton.CENTER);
		OFF.setVerticalTextPosition(JButton.CENTER);
		OFF.setMargin(new Insets(0, 0, 0, 0));
		OFF.setOpaque(false);
		OFF.setContentAreaFilled(false);
		OFF.setBorderPainted(false);
		
		p4.add(OFF);
		
		panel = new JPanel(new BorderLayout());
		
		panel.add(p1,BorderLayout.NORTH);
		panel.add(p2,BorderLayout.SOUTH);
		panel.add(p3,BorderLayout.CENTER);
		panel.add(p4,BorderLayout.EAST);
		
		
		b0.addActionListener(this); b1.addActionListener(this); b2.addActionListener(this);
        b3.addActionListener(this); b4.addActionListener(this); b5.addActionListener(this);
        b6.addActionListener(this); b7.addActionListener(this); b8.addActionListener(this);
        b9.addActionListener(this); AC.addActionListener(this); DEL.addActionListener(this);
        PN.addActionListener(this); ANS.addActionListener(this); OFF.addActionListener(this);
        MUL.addActionListener(this); PLUS.addActionListener(this); MOINS.addActionListener(this);
        DIV.addActionListener(this); POINT.addActionListener(this); EG.addActionListener(this);
		
		setContentPane(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	void activate(boolean v)
    {
		b0.setEnabled(v); b1.setEnabled(v); b2.setEnabled(v); b3.setEnabled(v);
	    b4.setEnabled(v); b5.setEnabled(v); b6.setEnabled(v); b7.setEnabled(v);
	    b8.setEnabled(v); b9.setEnabled(v); POINT.setEnabled(v); MUL.setEnabled(v);
	    DIV.setEnabled(v); PLUS.setEnabled(v); MOINS.setEnabled(v); EG.setEnabled(v);
	    ANS.setEnabled(v); DEL.setEnabled(v); PN.setEnabled(v);
    }
	
	void Resultat()
    {
    	double x2=Double.parseDouble(txt.getText());
    	resultat = x2;
    	
    	if(mult) {
    		txt.setText(""+(xp*x2));
    		xp = Double.parseDouble(txt.getText());
    		resultat = xp;
    	}
		else if(div) 
		{
			if(x2 != 0)
			{
				txt.setText(""+(xp/x2));
				xp = Double.parseDouble(txt.getText());
			}
			else
			{
				activate(false);
				txt.setForeground(Color.RED);
				txt.setText("ERREUR");
			}
			resultat = xp;
		}
		else if(som) {
			txt.setText(""+(xs+x2));
			xs = Double.parseDouble(txt.getText());
			resultat = xs;
		}
		else if(soust){
			txt.setText(""+(xs-x2));
			xs = Double.parseDouble(txt.getText());
			resultat = xs;
		}
    	
		 init = false;   
		 virg = false; 
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object src = e.getSource();
		JButton b = (JButton)src;
		
		if(src == b0 || src == b1 || src == b2 || src == b3 || src == b4 || src == b5 || src == b6 || src == b7 || src == b8 || src == b9){ 
			if(!operation)
				txt.setText(txt.getText() + b.getText());
			else if(operation){
				txt.setText(b.getText());
				operation=false;
			}
		}
		else if(src == POINT){
			if(!virg){
				txt.setText(txt.getText()+".");
				virg=true;
			}
		}
		else if(src == AC){
			txt.setText("0"); xp = 1; xs = 0; init = true; operation = false;
			mult = false; div = false; som = false; soust = false; virg = false;
			activate(true);
			txt.setForeground(Color.white);
		}
		else if(src == PN && !txt.getText().isEmpty() && Double.parseDouble(txt.getText()) != 0 )
				txt.setText("" + Double.parseDouble(txt.getText())* (-1));
		
		
		
		else if(src == DEL) {
			txt.setText(txt.getText().substring(0,txt.getText().length()-1));
			if(txt.getText().isEmpty()) {
				txt.setText("0");
			}
		}
		else if(src == MUL){
			try {
				if(init || operation) {
					xp = (Double.parseDouble(txt.getText()));
					init = false; virg = false;
					txt.setText("" + xp);
				}
				else
				{
					Resultat();
					xp=(Double.parseDouble(txt.getText()));
				}
				operation = true;
				mult = true; div = false; som = false; soust = false;
			}catch(NumberFormatException execp)
			{
				txt.setForeground(Color.RED);
				txt.setText("ERREUR");
				activate(false);
			}
		}
		else if(src == DIV)
		{
			try
			{
				if(init || operation)
				{
					xp = (Double.parseDouble(txt.getText()));
					init = false; virg = false;
					txt.setText("" + xp);
				}
				else
				{
					Resultat();
					xp = (Double.parseDouble(txt.getText()));
				}
				operation = true; mult = false; div = true; som = false; soust = false;
			}catch(NumberFormatException execp)
			{
				txt.setForeground(Color.RED);
				txt.setText("ERREUR");
				activate(false);}
		}
		else if(src == PLUS)
		{
			try
			{
				if(init || operation)
				{
					xs = (Double.parseDouble(txt.getText()));
					init = false; virg = false;
					txt.setText("" + xs);
				}
				else
				{
					Resultat();
					xs = (Double.parseDouble(txt.getText()));
				}
				operation = true; mult = false; div = false; som = true; soust = false;
			}catch(NumberFormatException execp)
			{
				txt.setForeground(Color.RED);
				txt.setText("ERREUR");
				activate(false);}
		}
		else if(src == MOINS)
		{
			try
			{
				if(init || operation)
				{
					xs = (Double.parseDouble(txt.getText()));
					init = false; virg = false;
					txt.setText("" + xs);
				}
				else
				{
					Resultat();
					xs=(Double.parseDouble(txt.getText()));
				}
				operation = true; mult = false; div = false; som = false; soust = true;
			}catch(NumberFormatException execp)
			{
				txt.setForeground(Color.RED);
				txt.setText("ERREUR");
				activate(false);
			}
		}
		else if(e.getSource() == EG)
		{
			Resultat();
			init = true; virg = false;
		}
		else if(src == ANS)
			txt.setText("" + resultat);
		else if(src == OFF)
			System.exit(0);
	
	}
	
	public static void main(String[] args) {
		new Calculatrice();
	}
	
}

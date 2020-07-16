package calcul;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Calculatrice extends JFrame implements ActionListener, ItemListener{
	
	private JTextField txt;
	private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ANS, POINT;
	private Button1 PN, sin, cos, tan, fact, ln, exp, puiss, sqrt, pi, a, c, rand;
	private Button2 EG, MUL, PLUS, MOINS, DIV;
	private JButton AC, DEL, OFF;
	private JPanel p1, p2, p3, pStan, pSci;
	private JRadioButton j1, j2;
	private int res=0;
	private ButtonGroup g;
	private double xp = 1, xs = 0, resultat = 0,aux=0;
	private boolean operation = false, mult = false, div = false, som = false, soust = false, init=true, virg=false,YX=false,nAr=false,nCr=false;
	
	public Calculatrice() {
		
		super("ICalcul");
		this.setSize(300, 400);
		this.setLocationRelativeTo(null);
		
		ImageIcon i = new ImageIcon("Images/calculator.png");
		this.setIconImage(i.getImage());
		
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.setBackground(Color.white);
		
		txt =new JTextField("0");
		txt.setPreferredSize(new Dimension(286,60));
		txt.setEditable(false);
		txt.setBackground(Color.black);
		txt.setForeground(Color.white);
		txt.setHorizontalAlignment(SwingConstants.RIGHT);
		txt.setFont(new Font("DIALOG", Font.CENTER_BASELINE+Font.BOLD, 20));
		
		
		p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setPreferredSize(new Dimension(300,110));
		
		j1 = new JRadioButton("Standard");
		j1.setOpaque(false);
		j1.setSelected(true);
		
		j2 = new JRadioButton("Scientifique");
		j2.setOpaque(false);
		
		g = new ButtonGroup();
		g.add(j1);
		g.add(j2);
		
		OFF= new JButton(new ImageIcon("Images/off.png"));
		OFF.setHorizontalTextPosition(JButton.CENTER);
		OFF.setVerticalTextPosition(JButton.CENTER);
		OFF.setMargin(new Insets(0, 0, 0, 0));
		OFF.setOpaque(false);
		OFF.setContentAreaFilled(false);
		OFF.setBorderPainted(false);
		OFF.setFocusPainted(false);
		
		p2.add(j1); p2.add(j2); p2.add(OFF);
		
		p1.add(txt, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		
		pStan = new JPanel();
		pStan.setLayout(new GridLayout(5,0));
		
		b0 = new Button("0"); b1 = new Button("1"); b2 = new Button("2");
		b3 = new Button("3"); b4 = new Button("4"); b5 = new Button("5");
		b6 = new Button("6"); b7 = new Button("7"); b8 = new Button("8");
		b9 = new Button("9");
		AC = new JButton("AC"); DEL = new JButton("DEL"); PN = new Button1("±");
		MUL = new Button2("x"); PLUS = new Button2("+"); MOINS = new Button2("–");
		DIV = new Button2("÷"); POINT = new Button("."); EG = new Button2("=");
		ANS = new Button("Ans");
		
		AC.setBackground(Color.red);
		DEL.setBackground(Color.red);
		AC.setForeground(Color.black);
		DEL.setForeground(Color.black);
		
		pStan.add(AC); pStan.add(DEL); pStan.add(PN); pStan.add(DIV);
		pStan.add(b7); pStan.add(b8); pStan.add(b9); pStan.add(MUL);
		pStan.add(b4); pStan.add(b5); pStan.add(b6); pStan.add(MOINS);
		pStan.add(b1); pStan.add(b2); pStan.add(b3); pStan.add(PLUS);
		pStan.add(b0); pStan.add(POINT); pStan.add(ANS); pStan.add(EG);
		
		pSci = new JPanel();
		pSci.setLayout(new GridLayout(0,4));
		pSci.setBackground(Color.white);
		
		sin = new Button1("sin") ; cos = new Button1("cos"); tan = new Button1("tan");
		fact = new Button1("x!"); ln = new Button1("ln"); exp = new Button1("eˣ");
		puiss = new Button1("yˣ"); sqrt = new Button1("√x"); pi = new Button1("π");
		a = new Button1("nAr"); c = new Button1("nCr"); rand = new Button1("Rand"); 
		
		pSci.add(sin); pSci.add(cos); pSci.add(tan);
		pSci.add(fact); pSci.add(ln); pSci.add(exp);
		pSci.add(puiss); pSci.add(sqrt); pSci.add(pi);
		pSci.add(a); pSci.add(c); pSci.add(rand);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(Color.white);
		getContentPane().add(p1,BorderLayout.NORTH);
		getContentPane().add(pStan,BorderLayout.SOUTH);
		getContentPane().add(pSci, BorderLayout.CENTER);
		pSci.setVisible(false);
		
		b0.addActionListener(this); b1.addActionListener(this); b2.addActionListener(this);
        b3.addActionListener(this); b4.addActionListener(this); b5.addActionListener(this);
        b6.addActionListener(this); b7.addActionListener(this); b8.addActionListener(this);
        b9.addActionListener(this); AC.addActionListener(this); DEL.addActionListener(this);
        PN.addActionListener(this); ANS.addActionListener(this); OFF.addActionListener(this);
        MUL.addActionListener(this); PLUS.addActionListener(this); MOINS.addActionListener(this);
        DIV.addActionListener(this); POINT.addActionListener(this); EG.addActionListener(this);
        puiss.addActionListener(this);sin.addActionListener(this);cos.addActionListener(this);
        tan.addActionListener(this);fact.addActionListener(this);ln.addActionListener(this);
        exp.addActionListener(this);sqrt.addActionListener(this);a.addActionListener(this);
        c.addActionListener(this);pi.addActionListener(this);rand.addActionListener(this);
        j1.addItemListener(this); j2.addItemListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	void activateST(boolean v)
    {
		b0.setEnabled(v); b1.setEnabled(v); b2.setEnabled(v); b3.setEnabled(v);
	    b4.setEnabled(v); b5.setEnabled(v); b6.setEnabled(v); b7.setEnabled(v);
	    b8.setEnabled(v); b9.setEnabled(v); POINT.setEnabled(v); MUL.setEnabled(v);
	    DIV.setEnabled(v); PLUS.setEnabled(v); MOINS.setEnabled(v); EG.setEnabled(v);
	    ANS.setEnabled(v); DEL.setEnabled(v); PN.setEnabled(v);
    }
	void activateSci(boolean v)
    {
		activateST(v);
		sin.setEnabled(v); cos.setEnabled(v); tan.setEnabled(v); sqrt.setEnabled(v);
	    fact.setEnabled(v); ln.setEnabled(v); exp.setEnabled(v); puiss.setEnabled(v);
	    rand.setEnabled(v); c.setEnabled(v); a.setEnabled(v);pi.setEnabled(v);

    }
    boolean isValide(String s)
    { 
    	boolean res=true;
    	for(int i=0;i<s.length();i++)
    	{
    		if(s.charAt(i)=='.' || s.charAt(i)=='-')
    		res=false;
    	}
    	return res;
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
				activateST(false);
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
		else if(YX)	{double res=Math.pow(aux,x2);txt.setText(""+res);}
		else if(nAr)
		{
			if((aux>=x2)&&(aux>=0)&&(x2>=0))
			{
			double res=(fact(aux)/fact((aux-x2)));
			txt.setText(""+res);
			}
			else
			{
				txt.setForeground(Color.RED);
				txt.setText("  ERROR!!  RULE  :  \"  n  doit  etre >= r  et  n >= 0  et  r >= 0  \" ");
			    activateSci(false);}
		}
		else if(nCr)
		{
			if((aux>=x2)&&(aux>=0)&&(x2>=0))
			{
				double res=(fact(aux)/(fact(x2)*fact((aux-x2))));
				txt.setText(""+res);
			}
			else
			{
				;txt.setForeground(Color.RED);
				txt.setText(" ERROR!!   RULE  :  \"  n  doit  etre  >= r  et  n  >= 0  et  r  >= 0  \" ");
			    activateSci(false);}
		}
    	
		 init = false;   
		 virg = false; 
    } 
    double fact(double x)
    {
    	double res=1;
    	if(x>=0)
    	{
    	for(int i=2;i<=x;i++)
		{
			res=res*i;
		}
		return res;
		}
		else return 0;
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
			activateST(true);activateSci(true);
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
				mult = true; div = false; som = false; soust = false;YX=false;
				nAr=false;nCr=false;
			}catch(NumberFormatException execp)
			{
				txt.setForeground(Color.RED);
				txt.setText("ERREUR");
				activateST(false);
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
				nAr=false;nCr=false;
			}catch(NumberFormatException execp)
			{
				txt.setForeground(Color.RED);
				txt.setText("ERREUR");
				activateST(false);}
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
				operation = true; mult = false; div = false; som = true; soust = false;YX=false;
				nAr=false;nCr=false;
			}catch(NumberFormatException execp)
			{
				txt.setForeground(Color.RED);
				txt.setText("ERREUR");
				activateST(false);}
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
				nAr=false;nCr=false;
			}catch(NumberFormatException execp)
			{
				txt.setForeground(Color.RED);
				txt.setText("ERREUR");
				activateST(false);
			}
		}
		else if(e.getSource() == EG)
		{
			Resultat();
			init = true; virg = false;
		}
		else if(src==puiss)
		{
			aux=Double.parseDouble(txt.getText());
			YX=true;init=false;nAr=false;nCr=false;
			operation=true;mult=false;div=false;som=false;soust=false;
		}
		else if(src==sin)
		{
			double  x=Math.toRadians(Double.parseDouble(txt.getText()));
		    double res=Math.sin(x);
			txt.setText(""+res);	
		}
		else if(src==cos)
		{
			double  x=Math.toRadians(Double.parseDouble(txt.getText()));
		    double res=Math.cos(x);
			txt.setText(""+res);	
		}
		else if(src==tan)
		{
			double  x=Math.toRadians(Double.parseDouble(txt.getText()));
		    double res=Math.tan(x);
			txt.setText(""+res);	
		}
		else if(src==fact)
		{
			
		
			if(isValide(txt.getText()))
			{double res=fact(Double.parseDouble(txt.getText()));
			txt.setText(""+res);}
			else
			{
				txt.setForeground(Color.RED);
				txt.setText(" ERROR!!  RULE :  \"  N DOIT ETRE UN ENTIER > A ZERO \" ");
			    activateSci(false);}
		}
		else if(src==ln)
		{
			double  x=Double.parseDouble(txt.getText());
			if(x>0)
			{
			double  res=Math.log(x);
			txt.setText(""+res);
			}
			else if(x<=0)
			{
				txt.setForeground(Color.RED);
				txt.setText(" ERROR!!  RULE : \"  X  DOIT  ETRE  >  A  ZERO  \" ");
			    activateSci(false);}
		}
		else if(src==exp)
		{
			double  x=Double.parseDouble(txt.getText());
			double  res=Math.exp(x);
			txt.setText(""+res);
		}
		else if(src==sqrt)
		{
			double  x=Double.parseDouble(txt.getText());
			if(x>=0)
			{double res=Math.sqrt(x);
			txt.setText(""+res);}
			else {
				txt.setForeground(Color.RED);
				txt.setText(" ERROR!!  RULE  :  \"  X  DOIT  ETRE  >  A  ZERO  \" ");
			    activateSci(false);}
		}
		else if(src==rand)
		{
			double  x=Double.parseDouble(txt.getText());
			double res=Math.random();
			txt.setText(""+res);
		}
		else if(src==a)
		{
			aux=Double.parseDouble(txt.getText());
			nAr=true;YX=false;init=false;
			operation=true;mult=false;div=false;som=false;soust=false;			
		}
			else if(src==c)
		{
			aux=Double.parseDouble(txt.getText());
			nCr=true;YX=false;init=false;
			operation=true;mult=false;div=false;som=false;soust=false;			
		}
		else if(src==pi)
		{
			txt.setText(""+Math.PI);
			virg=true;
		}
		else if(src == ANS)
			txt.setText("" + resultat);
		else if(src == OFF)
			System.exit(0);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == j1)
		{
			this.setSize(300, 400);
			pStan.setVisible(true);
			pSci.setVisible(false);
		}
		
		if(e.getSource() == j2)
		{
			this.setSize(300,450);
			pStan.setVisible(true);
			pSci.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Calculatrice();
	}
	
}

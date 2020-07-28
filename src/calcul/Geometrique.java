package calcul;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;


@SuppressWarnings("serial")
public class Geometrique extends JFrame {
    static int deg;
    static double degree;
    
	@SuppressWarnings("static-access")
	public Geometrique(int deg, double degree)
	{
		super("Le cercle trigonométrique");
		ImageIcon i = new ImageIcon("Images/Geometrie.jpeg");
		this.setIconImage(i.getImage());
		setSize(500, 500);
		setVisible(true);
		this.setResizable(false);
		this.deg = deg;
		this.degree = degree;
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		g.drawLine(0, 250, 500, 250);
		g.drawLine(250, 0, 250, 500);
		g.drawString("Sin(x)", 260, 50);
		g.drawString("Cos(x)", 450, 270);
		g.drawRect(400, 40, 80, 30);
		g.drawOval(60, 60, 380, 380);
		
		g.setColor(Color.orange);
		g.fillArc(60, 60, 380, 380, 0, deg);
		
		g.setColor(Color.orange.darker());
		g.drawString("" + degree + "°", 420, 60);
		
		g.setColor(Color.red);
		
		g.drawString("0 ", 445, 245);
		g.drawString("π/2 ", 230, 55);
		g.drawString("π ", 50, 245);
		g.drawString("3π/2 ", 220, 455);
		
		g.drawString(" π/3", 340, 80);
		g.drawString(" π/4", 385, 115);
		g.drawString(" π/6", 415, 155);
		
		g.drawString("2π/3 ", 140, 80);
		g.drawString("3π/4 ", 90, 110);
		g.drawString("5π/6 ", 55, 155);
		
		g.drawString("7π/6 ", 50, 350);
		g.drawString("5π/4 ", 85, 395);
		g.drawString("4π/3 ", 130, 430);
		
		g.drawString(" 5π/3", 340, 430);
		g.drawString(" 7π/4", 380, 400);
		g.drawString("  11π/6", 410, 355);
	}
}


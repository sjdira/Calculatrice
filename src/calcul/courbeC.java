package calcul;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class courbeC extends JComponent {
	public float xMax = 10 ;
	public float  yMax = 10 ;

	private CurveFunction function = (x) -> 0;
    
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        
        // --- White background ---
        graphics.setColor( Color.WHITE );
        graphics.fillRect( 0, 0, getWidth(), getHeight() );
        
        // --- Draw axis ---
        graphics.setColor( Color.BLACK );
        graphics.drawLine( 0, getHeight()/2, getWidth(), getHeight()/2 );
        graphics.drawLine( getWidth()/2, 0, getWidth()/2, getHeight() );
        
        // --- Draw values ---
        graphics.setColor( Color.BLACK );
        graphics.drawString( "0,0", (int)(getWidth()*0.51), (int)(getHeight()*0.54));
        graphics.drawString( "y", (int)(getWidth()*0.52), (int)10);
        graphics.drawString( "x", (int)(getWidth()*0.98), (int)(getHeight()*0.54));
        
        
        // --- Draw curve ---
        double step = 0.001;
        graphics.setColor( Color.orange );
        
        int oldX = xToPixel( -xMax );
        int oldY = yToPixel( function.compute( -xMax) );
        
        for( double lx=-xMax+step; lx<= xMax+step; lx+=step ) {
            int x = xToPixel( lx );
            int y = yToPixel( function.compute( lx ) );
            
            graphics.drawLine( x, y, oldX, oldY );
            
            oldX = x;
            oldY = y;
        }
    }
    
    public void setFunction(CurveFunction function) {
        this.function = function;
        this.repaint();
    }
    
    private int xToPixel( double x ) {
        return (int) (getWidth() * (x + xMax)/(2*xMax) );
    }

    private int yToPixel( double y ) {
        return (int)( (getHeight()) * (1 - (y +yMax)/(2*yMax)) );
    }

    
    public static interface CurveFunction {
        
        public double compute( double x );
        
    }
    
}


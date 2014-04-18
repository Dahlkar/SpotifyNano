package gui.panels;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

public class MotionPanel extends MyPanel{
    private Point initialClick;
    private JFrame parent;

    public MotionPanel(final JFrame parent){
    	super();
    	this.parent = parent;	
    	this.addMouseListener(new MouseAdapter() {
    		public void mousePressed(MouseEvent e) {
    			initialClick = e.getPoint();
    			getComponentAt(initialClick);
    		}
    	});

    	this.addMouseMotionListener(new MouseMotionAdapter() {
    		@Override
    		public void mouseDragged(MouseEvent e) {
	
	            // get location of Window
	            int thisX = parent.getLocation().x;
	            int thisY = parent.getLocation().y;
	
	            // Determine how much the mouse moved since the initial click
	            int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
	            int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);
	
	            // Move window to this position
	            int X = thisX + xMoved;
	            int Y = thisY + yMoved;
	            parent.setLocation(X, Y);
	        }
	    });
    }
  /*  
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	g.drawRoundRect(x, y, width, height, arcWidth, arcHeight)
    }
 */   
}
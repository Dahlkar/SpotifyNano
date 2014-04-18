package gui.button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import gui.handler.Handler;
import gui.handler.Handler.Close;

public class CloseButton extends MyButton {

	public CloseButton(Handler handler) {
		super();
		ClassLoader cl = getClass().getClassLoader();
		ImageIcon i = new ImageIcon(cl.getResource("resources/Close_1.png"));
		Image img = i.getImage();
		Image newimg = img.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);  
		i = new ImageIcon(newimg);  
		this.setIcon(i);
		this.addActionListener(handler.new Close());
		this.setPreferredSize(new Dimension(20, 20));
		this.addMouseListener(
				   new MouseListener()
				   {
				      public void mouseEntered(MouseEvent evt)
				      {
				         setHover("2");
				      }//end mouse entered
				 
				      public void mouseExited(MouseEvent evt)
				      {
				         setHover("1");
				      }//end mouse exited
				 
				      public void mouseClicked(MouseEvent evt){}
				      public void mousePressed(MouseEvent evt){}
				      public void mouseReleased(MouseEvent evt){}
				   }//end anonymous inner class
				);
	}
	public void setHover(String text) {
		ClassLoader cl = getClass().getClassLoader();
		ImageIcon i = new ImageIcon(cl.getResource("resources/Close_" + text +".png"));
		Image img = i.getImage();
		Image newimg = img.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);  
		i = new ImageIcon(newimg);  
		this.setIcon(i);
	}
}

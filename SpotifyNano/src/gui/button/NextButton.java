package gui.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import gui.handler.*;

public class NextButton extends MyButton {

	public NextButton(Handler handler) {
		super();
		ClassLoader cl = getClass().getClassLoader();
		ImageIcon i = new ImageIcon(cl.getResource("resources/Next_1.png"));
//		Image img = i.getImage();
//		Image newimg = img.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);  
//		i = new ImageIcon(newimg);  
		this.setIcon(i);
		this.addActionListener(handler.new Next());
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
		ImageIcon i = new ImageIcon(cl.getResource("resources/Next_" + text +".png"));
//		Image img = i.getImage();
//		Image newimg = img.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);  
//		i = new ImageIcon(newimg);  
		this.setIcon(i);
	}

}

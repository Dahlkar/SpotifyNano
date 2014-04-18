package gui.button;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import gui.handler.*;
import gui.handler.Handler.Close;

public class PlayPauseButton extends MyButton {	
	private String playpause = "";
	
	public PlayPauseButton(Handler handler, String text) {
		super();
		ClassLoader cl = getClass().getClassLoader();
		this.playpause = text;
		ImageIcon i = new ImageIcon(cl.getResource("resources/" + text + "_1.png"));
//		Image img = i.getImage();
//		Image newimg = img.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);  
//		i = new ImageIcon(newimg);  
		this.setIcon(i);
		this.addActionListener(handler.new PlayPause());
		this.setRolloverEnabled(false);
		this.setPreferredSize(new Dimension(27, 26));
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
		ImageIcon i = new ImageIcon(cl.getResource("resources/" + playpause+ "_" + text +".png"));
//		Image img = i.getImage();
//		Image newimg = img.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);  
//		i = new ImageIcon(newimg);  
		this.setIcon(i);
	}
	
	public void setIconTo(String text) {
		this.playpause = text;
		ClassLoader cl = getClass().getClassLoader();
		ImageIcon i = new ImageIcon(cl.getResource("resources/" + text + "_1.png"));
//		Image img = i.getImage();
//		Image newimg = img.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);  
//		i = new ImageIcon(newimg);  
		this.setIcon(i);
	}
}

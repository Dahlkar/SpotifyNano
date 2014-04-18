package gui;

import gui.handler.Handler;
import gui.panels.MainPanel;
import gui.panels.MotionPanel;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controller;

public class MainFrame extends JFrame {

	public MainFrame (Controller controller) {
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		MotionPanel panel = new MotionPanel(this);
		this.add(panel);
		Handler handler = new Handler(controller);
		MainPanel mPnl = new MainPanel(handler, controller);
		panel.add(mPnl);
		
		this.pack();
		this.setTitle("SpotifyNano");
		this.setVisible(true);
	}
}

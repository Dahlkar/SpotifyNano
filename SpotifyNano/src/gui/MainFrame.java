package gui;

import gui.handler.Handler;
import gui.panels.MainPanel;
import gui.panels.MotionPanel;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.geom.RoundRectangle2D;

import static java.awt.GraphicsDevice.WindowTranslucency.*;

import javax.swing.*;

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
		this.setShape(new RoundRectangle2D.Double
				(0, 0, this.getWidth()-1, this.getHeight()-1, 20, 20));
		
		
		this.setTitle("SpotifyNano");
		this.setVisible(true);
	}
}

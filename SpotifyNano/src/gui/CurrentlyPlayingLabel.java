package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

import controller.Controller;

public class CurrentlyPlayingLabel extends JLabel implements ActionListener{
	private Controller controller;
	private String artist, track;
	private int xpos = 0;
	private int xpos1;
	
	public CurrentlyPlayingLabel(Controller controller) {
		this.controller = controller;
		this.setPreferredSize(new Dimension(150, 32));
		if(controller.isPlaying()){
			track = controller.getCurrentTrack();
			artist = controller.getCurrentArtist();
		} else {
			track = "";
			artist = "";
		}
		Timer t = new Timer(500, this);
		t.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Arial", Font.BOLD, 12);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString(artist, 5, 15);
		int y = g.getFontMetrics().getHeight();
		font = new Font("Arial", Font.ITALIC, 12);
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		int len = fm.stringWidth(track);
		if(len > this.getWidth()) {	
			g.drawString(track, xpos, 15+y);
			g.drawString(track, xpos+len+10, 15+y);
			xpos--;
			if(xpos+10 < -len)
				xpos = -2;
		}else {
			g.drawString(track, 5, 15+y);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(controller.isPlaying()) {
			artist = controller.getCurrentArtist();
			track = controller.getCurrentTrack();
			repaint();
		} 
	}
}

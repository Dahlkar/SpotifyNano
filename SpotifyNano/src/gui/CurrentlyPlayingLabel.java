package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.Timer;

import controller.Controller;

public class CurrentlyPlayingLabel extends JLabel implements ActionListener{
	private Controller controller;
	private String artist, track;
	
	public CurrentlyPlayingLabel(Controller controller) {
		this.controller = controller;
		this.setPreferredSize(new Dimension(150, 35));
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
		if(controller.isPlaying()) {
			Font font = new Font("Helvetica", Font.BOLD, 12);
			g.setColor(Color.WHITE);
			g.setFont(font);
			g.drawString(artist, 0, 10);
			int y = g.getFontMetrics().getHeight();
			font = new Font("Helvetica", Font.ITALIC, 12);
			g.setFont(font);
			g.drawString(track, 0, 10+y);
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

package gui.handler;

import gui.button.PlayPauseButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Controller;

public class Handler {
	private Controller controller;
	
	public Handler(Controller controller) {
		this.controller = controller;	
	}
	
	public class PlayPause implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			controller.playpause();
			PlayPauseButton source = (PlayPauseButton)arg0.getSource();
			if(controller.isPlaying()) {
				source.setIconTo("Paus");	
			} else {
				source.setIconTo("Play");
			}
		}
	}
	
	public class Next implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.next();
		}
		
	}
	
	public class Previous implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.previous();
		}	
	}
	
	public class Close implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
}

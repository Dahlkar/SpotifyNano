package gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import gui.CurrentlyPlayingLabel;
import gui.button.*;
import gui.handler.Handler;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class MainPanel extends MyPanel {
	private MyButton closeBtn, ppBtn, nextBtn, prevBtn;
	private Handler handler;
	private Controller controller;
	private JLabel currentLbl;
	private JPanel pCenter, pSouth;
	
	public MainPanel(Handler handler, Controller controller) {
		this.handler = handler;
		this.controller = controller;
		this.createButtons();
		this.createLabels();	
		this.createPanels();
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());	
		
		this.add(pCenter, BorderLayout.CENTER);
		this.add(pSouth, BorderLayout.SOUTH);
		
		GridBagConstraints c = new GridBagConstraints();	
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		pCenter.add(currentLbl, c);
		
		c.anchor = GridBagConstraints.NORTHEAST;
		c.gridx = 1;
		c.gridy = 0;
		pCenter.add(closeBtn, c);

		pSouth.add(prevBtn);;
		pSouth.add(ppBtn);
		pSouth.add(nextBtn);
	}
	
	private void createButtons() {
		closeBtn = new CloseButton(handler);
		nextBtn = new NextButton(handler);
		prevBtn = new PreviousButton(handler);
		String text = "";
		if(controller.isPlaying()) {
			text = "Paus";
		} else {
			text = "Play";
		}
		ppBtn = new PlayPauseButton(handler, text);
	}
	
	private void createLabels() {
		currentLbl = new CurrentlyPlayingLabel(controller);
	}
	
	private void createPanels() {
		pCenter = new MyPanel();
		pCenter.setLayout(new GridBagLayout());
		pSouth = new MyPanel();
	}
}

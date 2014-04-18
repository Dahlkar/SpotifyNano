package gui.button;

import java.awt.Graphics;

import javax.swing.JFrame;

public class TestButton extends MyButton {

	public TestButton() {
		super();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = this.getWidth();
		int height = this.getHeight();
		for(int i = 0; i < 3; i++) {
			g.drawOval(0+i, 0+i, width-(i*2), height-(i*2));
		}
		
	}
	
	public static void main(String [] args){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.pack();
		frame.add(new TestButton());
	}
}

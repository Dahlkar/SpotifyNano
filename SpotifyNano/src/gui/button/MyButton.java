package gui.button;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class MyButton extends JButton {

	public MyButton() {
		this.setContentAreaFilled(false);
		final Color init = new Color(215, 215, 215);
		this.setRolloverEnabled(false);
		this.setBorderPainted(false);
		this.setForeground(init);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
	}
}

import java.io.BufferedReader;
import java.io.IOException;

import controller.Controller;


public class HandlerThread implements Runnable {
	private BufferedReader in;
	private Controller controller;
	
	public HandlerThread(Controller controller, BufferedReader in) {
		this.in = in;
		this.controller = controller;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String input = "";
		while(true) {
			try {
				input = in.readLine();
				this.perform(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void perform(String action) {
		if(action.equals("playpause")){
			controller.playpause();
		}else if(action.equals("next")) {
			controller.next();
		}else if(action.equals("previous")) {
			controller.previous();
		}
	}

}

import java.io.PrintWriter;

import controller.Controller;


public class CurrentlyPlayingThread implements Runnable {
	private PrintWriter out;
	private Controller controller;
	
	public CurrentlyPlayingThread(Controller controller, PrintWriter out) {
		this.out = out;
		this.controller = controller;		
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
				if(controller.isPlaying()) {
					out.println(controller.getCurrentArtist());
					out.println(controller.getCurrentTrack());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

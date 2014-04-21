import java.io.BufferedReader;
import java.io.IOException;


public class PlayingThread implements Runnable {
	BufferedReader in;
	public PlayingThread(BufferedReader in) {
		this.in = in;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
				for(int i = 0; i < 2; i++) {
					System.out.println(in.readLine());
				}
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

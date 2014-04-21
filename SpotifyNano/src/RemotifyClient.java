import java.net.*;
import java.io.*;

public class RemotifyClient {
	private InetAddress hostName;
	private int portNumber;
	
	public RemotifyClient() {
		try {
			hostName = InetAddress.getByName("localhost");
			portNumber = 4444;
			
			Socket remSocket = new Socket(hostName, portNumber);
			PrintWriter out = new PrintWriter(remSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
	                new InputStreamReader(remSocket.getInputStream()));
			Thread playing = new Thread(new PlayingThread(in));
			playing.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
                System.exit(1);
       }
		
	}
	
	public static void main(String [] args){
		new RemotifyClient();
	}

}

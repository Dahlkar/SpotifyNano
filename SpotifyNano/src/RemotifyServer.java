import java.net.*;
import java.io.*;

import util.MyUser32;

import com.sun.jna.platform.win32.WinDef;

import controller.Controller;
import controller.OsXController;
import controller.WinController;


public class RemotifyServer {
	private Controller controller = null;
	private int portNumber = 4444;
	private PrintWriter out = null;
	private BufferedReader in = null;
	
	public RemotifyServer() {
		String osName = System.getProperty("os.name");
		if(osName.equals("Windows 7")) {
			WinDef.HWND windowHandle = MyUser32.INSTANCE.FindWindow("SpotifyMainWindow", null);
			if(windowHandle == null) {
				System.out.println("Not found");
				System.exit(0);
			}
			controller = new WinController(windowHandle);
		} else {
			controller = new OsXController();
		}
		try{
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket clientSocket = serverSocket.accept();
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			Thread handler = new Thread(new HandlerThread(controller, in));
			Thread playing = new Thread(new CurrentlyPlayingThread(controller, out));
			handler.start();
			playing.start();
		}catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
                System.out.println(e.getMessage());
        }
	}
	
	public static void main(String [] args) {
		new RemotifyServer();
	}
}

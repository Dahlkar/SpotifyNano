import gui.MainFrame;
import util.MyUser32;

import com.sun.jna.platform.win32.*;

import controller.*;


public class SpotifyNano {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		String osName = System.getProperty("os.name");
		if(osName.equals("Windows 7")) {
			WinDef.HWND windowHandle = MyUser32.INSTANCE.FindWindow("SpotifyMainWindow", null);
			if(windowHandle == null) {
				System.out.println("Not found");
				System.exit(0);
			}
			Controller controller = new WinController(windowHandle);
			MainFrame frame = new MainFrame(controller);
		} else {
			Controller controller = new OsXController();
			MainFrame frame = new MainFrame(controller);
			
		}
	}

}

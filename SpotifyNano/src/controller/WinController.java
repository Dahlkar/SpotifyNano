package controller;

import util.MyUser32;

import com.sun.jna.platform.win32.*;

public class WinController extends Controller{
	private static final int APPCOMMAND = 0x0319;
	private static final WinDef.LPARAM PLAYPAUSE = new WinDef.LPARAM(917504);
	private static final WinDef.LPARAM PREVIOUS = new WinDef.LPARAM(786432);
	private static final WinDef.LPARAM NEXT = new WinDef.LPARAM(720896);
	private static final WinDef.WPARAM WPARAM = new WinDef.WPARAM(0);
	
	private WinDef.HWND windowHandle;
	
	public WinController(WinDef.HWND windowHandle) {
		this.windowHandle = windowHandle;
	}

	public void playpause() {
		this.sendCommand(this.PLAYPAUSE);
	}
	
	public void next() {
		this.sendCommand(this.NEXT);
	}
	
	public void previous() {
		this.sendCommand(PREVIOUS);
	}
	
	public String getCurrentTrack() {
		if(this.parseWindowTitle() == null) {
			return null;
		}
		return this.parseWindowTitle()[2];
	}

	public String getCurrentArtist() {
		if(this.parseWindowTitle() == null) {
			return null;
		}
		return this.parseWindowTitle()[1];
	}
	
	public boolean isPlaying() {
		return this.parseWindowTitle() != null;
	}
	
	private String[] parseWindowTitle() {
		int titleLen = MyUser32.INSTANCE.GetWindowTextLength(windowHandle);
		char trackinfo[] = new char[titleLen];
		MyUser32.INSTANCE.GetWindowText(windowHandle, trackinfo, titleLen+1);
		String[] trackInfo = new String(trackinfo).split("[-–]");
		if(trackInfo.length == 1) {
			return null;
		}
		return trackInfo;
	}
	
	private void sendCommand(WinDef.LPARAM command) {	
		MyUser32.INSTANCE.SendMessage(windowHandle, APPCOMMAND, WPARAM, command);
	}
}

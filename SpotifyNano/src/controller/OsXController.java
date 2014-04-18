package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OsXController extends Controller {

	@Override
	public void playpause() {
		String[] command = {"osascript", "-e", "tell application \"Spotify\" to playpause"};
		this.execCommand(command);
	}

	@Override
	public void next() {
		String[] command = {"osascript", "-e", "tell application \"Spotify\" to next track"};
		this.execCommand(command);
	}

	@Override
	public void previous() {
		String[] command = {"osascript", "-e", "tell application \"Spotify\" to previous track"};
		this.execCommand(command);
	}

	@Override
	public String getCurrentTrack() {
		String[] command = {"osascript", "-e", "tell application \"Spotify\" to name of current track"};
		return this.execCommandOutput(command);
	}

	@Override
	public String getCurrentArtist() {	
		String[] command = {"osascript", "-e", "tell application \"Spotify\" to artist of current track"};
		return this.execCommandOutput(command);
	}

	@Override
	public boolean isPlaying() {
		String[] command = {"osascript", "-e", "tell application \"Spotify\" to player state"};
		String state = this.execCommandOutput(command);
		if(state.equals("playing")) return true;
		return false;
	}

	private String execCommandOutput(String[] command) {
		StringBuffer output = new StringBuffer();
		 
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader readerErr = 
                    new BufferedReader(new InputStreamReader(p.getErrorStream()));
                        String s = null;
                        while ((s = reader.readLine()) != null) {
                        	output.append(s);
                        }
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output.toString();
	}
	
	private void execCommand(String[] command) {
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

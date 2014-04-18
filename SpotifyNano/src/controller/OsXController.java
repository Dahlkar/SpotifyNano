package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OsXController extends Controller {

	@Override
	public void playpause() {
		this.execCommand("osascript -e 'tell application \"Spotify\" to playpause'");
	}

	@Override
	public void next() {
		this.execCommand("osascript -e 'tell application \"Spotify\" to next track'");
	}

	@Override
	public void previous() {
		this.execCommand("osascript -e 'tell application \"Spotify\" to previous track'");
	}

	@Override
	public String getCurrentTrack() {
		return this.execCommandOutput("osascript -e 'tell application \"Spotify\" to name of current track'");
	}

	@Override
	public String getCurrentArtist() {	
		return this.execCommandOutput("osascript -e 'tell application \"Spotify\" to artist of current track'");
	}

	@Override
	public boolean isPlaying() {
		String state = this.execCommandOutput("osascript -e 'tell application \"Spotify\" to player sate'");
		if(state.equals("playing")) return true;
		return false;
	}

	private String execCommandOutput(String command) {
		StringBuffer output = new StringBuffer();
		 
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));
 
                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return output.toString();
	}
	
	private void execCommand(String command) {
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

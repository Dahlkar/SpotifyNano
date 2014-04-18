package controller;

public abstract class Controller {
	public abstract void playpause();
	
	public abstract void next();
	
	public abstract void previous();
	
	public abstract String getCurrentTrack();
	
	public abstract String getCurrentArtist();
	
	public abstract boolean isPlaying();
}

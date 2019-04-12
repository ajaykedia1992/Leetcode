package AdapterPattern;

public class AdapterDemo {

	public static void main(String args[]) {
		AudioPlayerAdapter audioPlayerAdapter = new AudioPlayerAdapter();
		
		audioPlayerAdapter.play("mp3", "beyond the horizon.mp3");
		audioPlayerAdapter.play("mp4", "alone.mp4");
		audioPlayerAdapter.play("vlc", "mind me.vlc");
	}
}

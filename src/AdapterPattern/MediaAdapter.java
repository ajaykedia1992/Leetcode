package AdapterPattern;

public class MediaAdapter implements MediaPlayer {

	AdvanceMediaPlayer mediaAdapter = null;

	public MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new Mp4Player();
		}
		else if (audioType.equalsIgnoreCase("vlc")) {
			mediaAdapter = new VLCPlayer();
		}
	}

	@Override
	public void play(String audioType, String fileName) {
		
		if(audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter.playMp4(fileName);
		}
		else if(audioType.equalsIgnoreCase("vlc")) {
			mediaAdapter.playVLC(fileName);
		}
		
	}
	
	
}

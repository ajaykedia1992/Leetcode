package AdapterPattern;

public class Mp4Player implements AdvanceMediaPlayer {

	@Override
	public void playMp4(String fileName) {
		System.out.println(fileName);
		
	}

	@Override
	public void playVLC(String fileName) {
		// TODO Auto-generated method stub
	}

}

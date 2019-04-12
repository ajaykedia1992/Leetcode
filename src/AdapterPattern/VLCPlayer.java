package AdapterPattern;

public class VLCPlayer implements AdvanceMediaPlayer {

	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playVLC(String fileName) {
		System.out.println(fileName);
	}

}

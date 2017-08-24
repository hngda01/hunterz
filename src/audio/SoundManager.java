package audio;

import javax.sound.sampled.Clip;

public class SoundManager {
	private WavEffect nhacNen;
	
	public SoundManager(){
		nhacNen = new WavEffect("enter_game.wav");
		nhacNen.loop(-1);
	}

	public WavEffect getNhacNen() {
		return nhacNen;
	}
	
}

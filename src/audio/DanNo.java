package audio;

import javax.sound.sampled.Clip;

public class DanNo {
	private WavEffect danNo;
	
	public void danNo(){
		danNo = new WavEffect("shoot.wav");
		danNo.loop(0);
	}

	public WavEffect getDanNo() {
		return danNo;
	}
	
	
}

package audio;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WavEffect implements LineListener{
	private Clip clip;
	private boolean isRunning = false;
	
	public WavEffect(String fileName){
		URL url = getClass().getResource("/sounds/"+fileName);//lay duong dan
		try {
			clip = AudioSystem.getClip();//lay clip ra
			AudioInputStream input = AudioSystem.getAudioInputStream(url);
			clip.open(input);
			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public void play(){
		if(clip.isRunning()){
			return;
		}
		clip.start();
		isRunning = true;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(isRunning){
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public void stop(){
		clip.stop();
		clip.close();
	}
	
	//vong lap chay bai hat, 0 - 1 lan, 1 - 2 lan
	public void loop(int number){
		clip.loop(number);
	}

	@Override
	public void update(LineEvent event) {
		if(event.getType() == LineEvent.Type.STOP || event.getType() == LineEvent.Type.CLOSE){
			isRunning = false;
		}
	}
	
}

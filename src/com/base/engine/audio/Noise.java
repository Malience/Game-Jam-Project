package com.base.engine.audio;


	import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Noise
{
	public void play(){
		
		File music = new File("res/audio/ujam(1).wav");
		
	
	 try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(music.getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
}

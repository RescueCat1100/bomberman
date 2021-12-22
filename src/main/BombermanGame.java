package main;


import javax.sound.sampled.Clip;

import gui.Frame;
import sound.Sound;

public class BombermanGame {
	
	public static void main(String[] args) {
        Clip clip = Sound.getClip("BACKGROUND");
		clip.start();
		new Frame();
	}
}

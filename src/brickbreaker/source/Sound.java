package brickbreaker.source;

import java.net.URL;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

enum Sound {
	BREAK("/brickbreaker/sounds/break.au"),
	BOING("/brickbreaker/sounds/boing.au"),
	BOUNCE("/brickbreaker/sounds/bounce.au"),
	SIZEUP("/brickbreaker/sounds/sizeup.au"),
	SIZEDOWN("/brickbreaker/sounds/sizedown.au");

	private Clip clip;
	static boolean sound = true;
	static int volume = -5; // Reduce volume by 5 dB.
	static FloatControl gainControl;

	Sound(String file) {
		try {
			URL url = this.getClass().getResource(file);
			AudioInputStream ais = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	void play() {
		if (sound) {
			if (clip.isRunning()) {
				clip.stop();
			}
			clip.setFramePosition(0);
			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume);
			clip.start();
		}
	}

	static void init() {
		values();
	}
}

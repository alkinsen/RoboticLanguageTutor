package application;

import marytts.modules.synthesis.Voice;

public class Main {
	
	public static void main(String[] args){
		TextToSpeech tts = new TextToSpeech();
		
		Voice.getAvailableVoices().stream().forEach(System.out::println);
		
		tts.setVoice("dfki-ot-hsmm");
		tts.speak("�ocuk do�ru kart� g�sterdiyse yes sesi ��kar�n.", 1.0f, false, false);
	}

}

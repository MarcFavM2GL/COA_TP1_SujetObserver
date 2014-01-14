package fr.istic.COA;

import java.util.Timer;
import java.util.TimerTask;

public class Demarrage {

	static CapteurImplemen monCapteur;
	
	public static void main(String[] args) {
		
		Canal canal1;
		Canal canal2;
		Canal canal3;
		Canal canal4;
		
		monCapteur = new CapteurImplemen();
		
		canal1 = new Canal();
		canal2 = new Canal();
		canal3 = new Canal();
		canal4 = new Canal();
		monCapteur.ajoutObservateur(canal1);
		monCapteur.ajoutObservateur(canal2);
		monCapteur.ajoutObservateur(canal3);
		monCapteur.ajoutObservateur(canal4);
		
		
		
		TimerTask tacheDemiseAJourCapteur = new TimerTask() {
			@Override
			public void run() {
				monCapteur.tick();
			}
		};
		
		Timer horloge = new Timer();
		horloge.schedule(tacheDemiseAJourCapteur, 0 ,2000);

	}

}

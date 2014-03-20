package fr.istic.COA;

import java.util.Timer;
import java.util.TimerTask;

public class Demarrage {

	static Capteur monCapteur;
	
	public static void main(String[] args) {
		
		int typeDeDiffusion;
		
		Canal canal1;
		Canal canal2;
		Canal canal3;
		Canal canal4;
		
		Canal canal5;
		Canal canal6;
		Canal canal7;
		Canal canal8;
		
		Canal canal9;
		Canal canal10;
		Canal canal11;
		Canal canal12;
		
		// Arg = 1 >> diffusion atomique
		// Arg = 2 >> diffusion sequentielle
		// Arg = 3 >> diffusion par epoque
		typeDeDiffusion = 1;
		
		monCapteur = new Capteur(typeDeDiffusion);
		
		canal1 = new Canal();
		canal2 = new Canal();
		canal3 = new Canal();
		canal4 = new Canal();
		
		canal5 = new Canal();
		canal6 = new Canal();
		canal7 = new Canal();
		canal8 = new Canal();
		
		canal9 = new Canal();
		canal10 = new Canal();
		canal11 = new Canal();
		canal12 = new Canal();
		
		monCapteur.ajoutObservateur(canal1);
		monCapteur.ajoutObservateur(canal2);
		monCapteur.ajoutObservateur(canal3);
		monCapteur.ajoutObservateur(canal4);
		
		monCapteur.ajoutObservateur(canal5);
		monCapteur.ajoutObservateur(canal6);
		monCapteur.ajoutObservateur(canal7);
		monCapteur.ajoutObservateur(canal8);
		
		monCapteur.ajoutObservateur(canal9);
		monCapteur.ajoutObservateur(canal10);
		monCapteur.ajoutObservateur(canal11);
		monCapteur.ajoutObservateur(canal12);
		
		
		TimerTask tacheDemiseAJourCapteur = new TimerTask() {
			@Override
			public void run() {
				monCapteur.tick();
			}
		};
		
		Timer horloge = new Timer();
		horloge.schedule(tacheDemiseAJourCapteur, 0 ,5000);

	}

}

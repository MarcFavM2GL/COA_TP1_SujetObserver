package controleur;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import presentation.PDemarrage;

/**
 */
public class CDemarrage {

	static Capteur monCapteur;
	PDemarrage presentation;
	
	public CDemarrage(){
		
		presentation = new PDemarrage(this);
	}
	
	/**
	 * Method main.
	 * @param args String[]
	 */
	public static void main(String[] args) {
		
		new CDemarrage();
		
	}
	
	/**
	 * Method lancementAppli.
	 * @param nbAfficheur int
	 * @param typeDiffusion int
	 * @param tempo int
	 */
	public void lancementAppli(int nbAfficheur, int typeDiffusion, int tempo){
		
		ArrayList<Canal> listeAffich = new ArrayList<>();
		
		monCapteur = new Capteur(typeDiffusion);
		
		for(int i = 1; i <= nbAfficheur; i++){
			Canal canal = new Canal();
			listeAffich.add(canal);
			monCapteur.ajoutObservateur(canal);
		}
			
		TimerTask tacheDemiseAJourCapteur = new TimerTask() {
			@Override
			public void run() {
				monCapteur.tick();
			}
		};
		
		Timer horloge = new Timer();
		horloge.schedule(tacheDemiseAJourCapteur, 0 ,tempo);
	}	
}

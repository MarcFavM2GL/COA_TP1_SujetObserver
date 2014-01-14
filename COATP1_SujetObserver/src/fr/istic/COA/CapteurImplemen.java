package fr.istic.COA;

import java.util.ArrayList;

public class CapteurImplemen implements CapteurInterf{
	
	private ArrayList<ObservateurInterf> observateurs = null;
	private int simulateurValeur;
	
	public CapteurImplemen(){
		observateurs = new ArrayList<ObservateurInterf>();
		simulateurValeur = 0;
	}
	
	@Override
	public void ajoutObservateur(ObservateurInterf obs) {
		
		observateurs.add(obs);
		
	}

	@Override
	public void suppObservateur(ObservateurInterf obs) {
		
		observateurs.remove(obs);
		
	}

	@Override
	public void notification() {

		for(ObservateurInterf obser : observateurs){
			obser.actualise(this);
		}
	}

	@Override
	public Integer getValue() {
		
		return simulateurValeur;
	}

	@Override
	public void tick() {

		simulateurValeur++;	
		System.out.println("CAPTEUR :: simulateurValeur = " + simulateurValeur);
		notification();
	}
}

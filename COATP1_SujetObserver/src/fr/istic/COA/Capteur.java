package fr.istic.COA;

import java.util.ArrayList;

public class Capteur implements CapteurInterf{
	
	private ArrayList<ObservateurInterf> observateurs = null;
	private int simulateurValeur;
	private AlgoDiffusionInterf diffusion;
	
	public Capteur(int numeroStrategie){
		observateurs = new ArrayList<ObservateurInterf>();
		simulateurValeur = 0;
		switch (numeroStrategie) {
		case 1:
			diffusion = new DiffusionAtomique();
			break;

		case 2:
			diffusion = new DiffusionSequentielle();
			break;
			
		case 3:
			diffusion = new DiffusionDate();
			break;
			
		default:
			break;
		}
		
		diffusion.configure(this);
		
	}
	
	@Override
	public void ajoutObservateur(ObservateurInterf obs) {
		
		observateurs.add(obs);
		diffusion.configure(this);
	}

	@Override
	public void suppObservateur(ObservateurInterf obs) {
		
		observateurs.remove(obs);
		diffusion.configure(this);
	}
	
	@Override
	public ArrayList<ObservateurInterf> getObservateurs(){
		return observateurs;
	}

	@Override
	public void notification() {

		diffusion.executeDiffusion();
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

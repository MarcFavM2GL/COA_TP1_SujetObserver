package controleur;

import interfaces.AlgoDiffusionInterf;
import interfaces.CapteurInterf;
import interfaces.ObservateurInterf;

import java.util.ArrayList;

import strategies.DiffusionAtomique;
import strategies.DiffusionDate;
import strategies.DiffusionSequentielle;

/**
 */
public class Capteur implements CapteurInterf{
	
	private ArrayList<ObservateurInterf> observateurs = null;
	private int simulateurValeur;
	private AlgoDiffusionInterf diffusion;
	
	/**
	 * Constructor for Capteur.
	 * @param numeroStrategie int
	 */
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
	
	/**
	 * Method ajoutObservateur.
	 * @param obs ObservateurInterf
	 * @see interfaces.SujetObserveInterf#ajoutObservateur(ObservateurInterf)
	 */
	@Override
	public void ajoutObservateur(ObservateurInterf obs) {
		
		observateurs.add(obs);
		diffusion.configure(this);
	}

	/**
	 * Method suppObservateur.
	 * @param obs ObservateurInterf
	 * @see interfaces.SujetObserveInterf#suppObservateur(ObservateurInterf)
	 */
	@Override
	public void suppObservateur(ObservateurInterf obs) {
		
		observateurs.remove(obs);
		diffusion.configure(this);
	}
	
	/**
	 * Method getObservateurs.
	 * @return ArrayList<ObservateurInterf>
	 * @see interfaces.CapteurInterf#getObservateurs()
	 */
	@Override
	public ArrayList<ObservateurInterf> getObservateurs(){
		return observateurs;
	}

	/**
	 * Method notification.
	 * @see interfaces.SujetObserveInterf#notification()
	 */
	@Override
	public void notification() {

		diffusion.executeDiffusion();
	}

	/**
	 * Method getValue.
	 * @return Integer
	 * @see interfaces.CapteurInterf#getValue()
	 */
	@Override
	public Integer getValue() {
		
		return simulateurValeur;
	}

	/**
	 * Method tick.
	 * @see interfaces.CapteurInterf#tick()
	 */
	@Override
	public void tick() {

		simulateurValeur++;	
		System.out.println("CAPTEUR :: simulateurValeur = " + simulateurValeur);
		notification();
	}
}

package controleur;

import interfaces.CapteurInterf;
import interfaces.ObservateurInterf;
import interfaces.SujetObserveInterf;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import strategies.Diffusion;

/**
 * @author Favereau
 * @version $Revision: 1.0 $
 * 
 * Canal
 */
public class Canal implements ObservateurInterf, CapteurInterf{

	static int nbCanal;
	Integer valeurIn;
	int id;
	CAfficheur monAffichage;
	Diffusion strategieDiffusion;
	
	
	public Canal() {
		nbCanal++;
		this.id = nbCanal;
		monAffichage = new CAfficheur(id);
	}
	
	/**
	 * Method actualise.
	
	
	 * @param strategie Diffusion
	 * @see interfaces.ObservateurInterf#actualise(SujetObserveInterf) */
	@Override
	public void actualise(Diffusion strategie) {
		
		this.strategieDiffusion = strategie;
		
		System.out.println("'canal update AV tempo' CANAL NUM " + id);
		System.out.flush();
		
		ScheduledExecutorService pilExec = Executors.newScheduledThreadPool(10);

		ScheduledFuture execFuture = pilExec.schedule(new Callable<Object>() {
		        public Object call() throws Exception {
		        			        	
		        	monAffichage.actualiseAff(Canal.this);

		            return null;
		        }
		    }, id*600, TimeUnit.MILLISECONDS);
		
		
		try {
			execFuture.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("'canal update AP tempo' CANAL NUM " + id);
		System.out.flush();
		
	}

	/**
	 * Method ajoutObservateur.
	 * @param obs ObservateurInterf
	
	 * @see interfaces.SujetObserveInterf#ajoutObservateur(ObservateurInterf) */
	@Override
	public void ajoutObservateur(ObservateurInterf obs) {
		
	}

	/**
	 * Method suppObservateur.
	 * @param obs ObservateurInterf
	
	 * @see interfaces.SujetObserveInterf#suppObservateur(ObservateurInterf) */
	@Override
	public void suppObservateur(ObservateurInterf obs) {
		
	}

	/**
	 * Method notification.
	 * @see interfaces.SujetObserveInterf#notification()
	 */
	@Override
	public void notification() {
		
	}

	/**
	 * Method getValue.
	
	
	 * @return Integer * @see interfaces.CapteurInterf#getValue() */
	@Override
	public Integer getValue() {
		//valeurIn = ((Capteur) this.capteurObserve).getValue();
		valeurIn = this.strategieDiffusion.recupereValeur();
		System.out.println("'canal getValue' CANAL NUM " + id + " :: valeurIn = " + valeurIn);
		System.out.flush();
		return valeurIn;
	}

	/**
	 * Method tick.
	 * @see interfaces.CapteurInterf#tick()
	 */
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Method getObservateurs.
	
	
	 * @return ArrayList<ObservateurInterf> * @see interfaces.CapteurInterf#getObservateurs() */
	@Override
	public ArrayList<ObservateurInterf> getObservateurs() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

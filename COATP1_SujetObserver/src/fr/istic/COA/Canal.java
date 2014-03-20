package fr.istic.COA;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
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
	 * @param sujetObserve SujetObserveInterf
	 * @see fr.istic.COA.ObservateurInterf#actualise(SujetObserveInterf)
	 */
	@Override
	public void actualise(Diffusion strategie) {
		
		this.strategieDiffusion = strategie;
		System.out.println("'canal update AV tempo' CANAL NUM " + id);
		System.out.flush();
		try {
			Thread.currentThread();
			Thread.sleep(500 * id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("'canal update AP tempo' CANAL NUM " + id);
		System.out.flush();
		
//		ExecutorService es = Executors.newSingleThreadExecutor();
//		
//		es.execute(new Runnable() {
//			
//			@Override
//			public void run() {
//				monAffichage.actualiseAff(Canal.this);
//			}
//		});
//		
//		es.shutdown();
		
		monAffichage.actualiseAff(Canal.this);
		
		//ScheduledExecutorService pilExec = Executors.newScheduledThreadPool(10);

//		ScheduledFuture execFuture = pilExec.schedule(new Callable<Object>() {
//		        public Object call() throws Exception {
//		        			        	
//		        	monAffichage.actualiseAff(Canal.this);
//
//		            return null;
//		        }
//		    }, id*600, TimeUnit.MILLISECONDS);
		
	}

	/**
	 * Method ajoutObservateur.
	 * @param obs ObservateurInterf
	 * @see fr.istic.COA.SujetObserveInterf#ajoutObservateur(ObservateurInterf)
	 */
	@Override
	public void ajoutObservateur(ObservateurInterf obs) {
		
	}

	/**
	 * Method suppObservateur.
	 * @param obs ObservateurInterf
	 * @see fr.istic.COA.SujetObserveInterf#suppObservateur(ObservateurInterf)
	 */
	@Override
	public void suppObservateur(ObservateurInterf obs) {
		
	}

	/**
	 * Method notification.
	 * @see fr.istic.COA.SujetObserveInterf#notification()
	 */
	@Override
	public void notification() {
		
	}

	/**
	 * Method getValue.
	 * @return Integer
	 * @see fr.istic.COA.CapteurInterf#getValue()
	 */
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
	 * @see fr.istic.COA.CapteurInterf#tick()
	 */
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Method getObservateurs.
	 * @return ArrayList<ObservateurInterf>
	 * @see fr.istic.COA.CapteurInterf#getObservateurs()
	 */
	@Override
	public ArrayList<ObservateurInterf> getObservateurs() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

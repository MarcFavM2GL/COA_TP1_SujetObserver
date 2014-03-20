package strategies;

import interfaces.ObservateurInterf;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 */
public class DiffusionAtomique extends Diffusion{

	int cmptGetVal = 0;
	
	/**
	 * Method executeDiffusion.
	 * @see interfaces.AlgoDiffusionInterf#executeDiffusion()
	 */
	@Override
	public void executeDiffusion() {
		
		ExecutorService exec = Executors.newFixedThreadPool(nombreObservateurs);
		ArrayList<Future<Void>> lesRetours = new ArrayList<>();
		ArrayList<Callable<Void>> lesExecutions = new ArrayList<>();
		
		for(final ObservateurInterf obser : capteur.getObservateurs()){
			
			Callable<Void> tache = new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					obser.actualise(DiffusionAtomique.this);
					return null;
				}
			};
			
			lesExecutions.add(tache);
			lesRetours.add(exec.submit(tache));
		}
		
		
		for(Future<Void> future : lesRetours){
			try {
				future.get();
				System.out.println("RETOUR GET FUTURE");
				System.out.flush();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method recupereValeur.
	 * @return int
	 * @see interfaces.AlgoDiffusionInterf#recupereValeur()
	 */
	@Override
	public int recupereValeur() {
		
		return capteur.getValue();
	}
}

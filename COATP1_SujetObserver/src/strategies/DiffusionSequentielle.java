package strategies;

import interfaces.ObservateurInterf;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 */
public class DiffusionSequentielle extends Diffusion{

	int valeurCourante;
	boolean lectureComplete = true;
	int nbLecture = 0;
	
	/**
	 * Method executeDiffusion.
	 * @see interfaces.AlgoDiffusionInterf#executeDiffusion()
	 */
	@Override
	public void executeDiffusion() {
		
		if(lectureComplete){
			
		nbLecture = 0;
		lectureComplete = false;
		this.valeurCourante = capteur.getValue();
		
			ExecutorService exec = Executors.newFixedThreadPool(nombreObservateurs);
			ArrayList<Future<Void>> lesRetours = new ArrayList<>();
			ArrayList<Callable<Void>> lesExecutions = new ArrayList<>();
		
			for(final ObservateurInterf obser : capteur.getObservateurs()){
			
				Callable<Void> tache = new Callable<Void>() {
					@Override
					public Void call() throws Exception {
						obser.actualise(DiffusionSequentielle.this);
						return null;
					}
				};
			
				lesExecutions.add(tache);
				lesRetours.add(exec.submit(tache));
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
		
		nbLecture++;
		lectureComplete = (nbLecture == nombreObservateurs);
		
		return this.valeurCourante;
	}

}

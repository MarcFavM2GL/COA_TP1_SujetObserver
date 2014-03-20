package strategies;

import interfaces.ObservateurInterf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 */
public class DiffusionDate extends Diffusion {
		
		HashMap<Integer, Integer> tableValeurs = new HashMap<>();
		int date = 0;		
		
		/**
		 * Method executeDiffusion.
		 * @see interfaces.AlgoDiffusionInterf#executeDiffusion()
		 */
		@Override
		public void executeDiffusion() {
			
			date++;
			tableValeurs.put(date, capteur.getValue());
						
			ExecutorService exec = Executors.newFixedThreadPool(nombreObservateurs);
			ArrayList<Future<Void>> lesRetours = new ArrayList<>();
			ArrayList<Callable<Void>> lesExecutions = new ArrayList<>();
			
			for(final ObservateurInterf obser : capteur.getObservateurs()){
				
				Callable<Void> tache = new Callable<Void>() {
					@Override
					public Void call() throws Exception {
						obser.actualise(DiffusionDate.this);
						return null;
					}
				};
			
				lesExecutions.add(tache);
				lesRetours.add(exec.submit(tache));
			}
		}

		

		/**
		 * Method recupereValeur.
		 * @return int
		 * @see interfaces.AlgoDiffusionInterf#recupereValeur()
		 */
		@Override
		public int recupereValeur() {
			
			
			return tableValeurs.get(date);
		}

}


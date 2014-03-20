package fr.istic.COA;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DiffusionAtomique extends Diffusion{

	int cmptGetVal = 0;
	
	@Override
	public void executeDiffusion() {
		
		ExecutorService exec = Executors.newFixedThreadPool(nombreObservateurs);
		ArrayList<Future<String>> lesRetours = new ArrayList<>();
		ArrayList<Callable<String>> lesExecutions = new ArrayList<>();

		int cmptCallable = 0;
		cmptGetVal = 0;
		
		//for(final ObservateurInterf obser : capteur.getObservateurs()){
		for(int i = 0; i < capteur.getObservateurs().size(); i++){
			final int index = i;
			Callable<String> toto = new Callable<String>() {
				@Override
				public String call() throws Exception {
					
					capteur.getObservateurs().get(index).actualise(DiffusionAtomique.this);
					
					return "Num callable = " + index;
				}
			};
			
			lesExecutions.add(toto);
			lesRetours.add(exec.submit(toto));
		}
		
		
		for(Future<String> future : lesRetours){
		    
			try {
				String result = future.get();
				System.out.println("RETOUR GET FUTURE : " + result);
				System.out.flush();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			
		}
		
		//System.out.println("Fin des futures.get !!!");
	}

	@Override
	public int recupereValeur() {
		
		return capteur.getValue();
	}
}

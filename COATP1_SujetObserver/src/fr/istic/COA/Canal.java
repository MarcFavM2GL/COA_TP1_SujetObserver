package fr.istic.COA;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Canal implements ObservateurInterf{

	static int nbCanal;
	Integer valeurIn;
	int id;
	
	
	
	public Canal() {
		nbCanal++;
		this.id = nbCanal;
		
	}
	@Override
	public void actualise(SujetObserveInterf sujetObserve) {
		
		valeurIn = ((CapteurImplemen) sujetObserve).getValue();
		System.out.println("CANAL NUM " + id + " :: valeurIn = " + valeurIn);
		
		ScheduledExecutorService pilExec = Executors.newScheduledThreadPool(10);

		ScheduledFuture execFuture = pilExec.schedule(new Callable<Object>() {
		        public Object call() throws Exception {
		        	
		        	


		        	
		            return null;
		        }
		    }, 500, TimeUnit.MILLISECONDS);
	}

}

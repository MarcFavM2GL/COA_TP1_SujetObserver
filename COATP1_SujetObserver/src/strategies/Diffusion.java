package strategies;

import interfaces.AlgoDiffusionInterf;
import interfaces.CapteurInterf;

import java.util.ArrayList;

/**
 */
public abstract class Diffusion implements AlgoDiffusionInterf{

	CapteurInterf capteur;
	int nombreObservateurs;
	
	/**
	 * Method configure.
	 * @param leCapteur CapteurInterf
	 * @see interfaces.AlgoDiffusionInterf#configure(CapteurInterf)
	 */
	@Override
	public void configure(CapteurInterf leCapteur) {
		
		this.capteur = leCapteur;
		this.nombreObservateurs = leCapteur.getObservateurs().size();
		
	}

	/**
	 * Method executeDiffusion.
	 * @see interfaces.AlgoDiffusionInterf#executeDiffusion()
	 */
	@Override
	abstract public void executeDiffusion();

	/**
	 * Method recupereValeur.
	 * @return int
	 * @see interfaces.AlgoDiffusionInterf#recupereValeur()
	 */
	@Override
	abstract public int recupereValeur();
	
}

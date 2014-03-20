package interfaces;

import java.util.ArrayList;

/**
 */
public interface AlgoDiffusionInterf {

	/**
	 * Method configure.
	 * @param leCapteur CapteurInterf
	 */
	void configure(CapteurInterf leCapteur);
	void executeDiffusion();
	/**
	 * Method recupereValeur.
	 * @return int
	 */
	int recupereValeur();
	
}

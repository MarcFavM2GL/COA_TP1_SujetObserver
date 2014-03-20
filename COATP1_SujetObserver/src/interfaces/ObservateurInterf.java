package interfaces;

import java.util.concurrent.Future;

import strategies.Diffusion;

/**
 */
public interface ObservateurInterf {
	
	/**
	 * Method actualise.
	 * @param diffusionStrat Diffusion
	 */
	void actualise(Diffusion diffusionStrat);

}

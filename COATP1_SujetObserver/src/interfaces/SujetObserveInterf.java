package interfaces;

import java.util.ArrayList;

/**
 */
public interface SujetObserveInterf {
	
	/**
	 * Method ajoutObservateur.
	 * @param obs ObservateurInterf
	 */
	void ajoutObservateur(ObservateurInterf obs);
	/**
	 * Method suppObservateur.
	 * @param obs ObservateurInterf
	 */
	void suppObservateur(ObservateurInterf obs);
	void notification();
}

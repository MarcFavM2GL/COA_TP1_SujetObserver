package interfaces;

import java.util.ArrayList;

/**
 */
public interface CapteurInterf extends SujetObserveInterf {

	/**
	 * Method getObservateurs.
	 * @return ArrayList<ObservateurInterf>
	 */
	ArrayList<ObservateurInterf> getObservateurs();
	/**
	 * Method getValue.
	 * @return Integer
	 */
	Integer getValue();
	void tick();
	
}

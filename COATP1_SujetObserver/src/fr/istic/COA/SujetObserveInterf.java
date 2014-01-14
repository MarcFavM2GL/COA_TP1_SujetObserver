package fr.istic.COA;

import java.util.ArrayList;

public interface SujetObserveInterf {
	
	void ajoutObservateur(ObservateurInterf obs);
	void suppObservateur(ObservateurInterf obs);
	void notification();
}

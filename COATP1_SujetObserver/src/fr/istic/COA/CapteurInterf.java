package fr.istic.COA;

import java.util.ArrayList;

public interface CapteurInterf extends SujetObserveInterf {

	ArrayList<ObservateurInterf> getObservateurs();
	Integer getValue();
	void tick();
	
}

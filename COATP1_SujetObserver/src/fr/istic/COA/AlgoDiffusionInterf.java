package fr.istic.COA;

import java.util.ArrayList;

public interface AlgoDiffusionInterf {

	void configure(CapteurInterf leCapteur);
	void executeDiffusion();
	int recupereValeur();
	
}

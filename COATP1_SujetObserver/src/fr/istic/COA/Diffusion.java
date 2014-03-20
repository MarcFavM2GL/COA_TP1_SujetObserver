package fr.istic.COA;

import java.util.ArrayList;

public abstract class Diffusion implements AlgoDiffusionInterf{

	CapteurInterf capteur;
	int nombreObservateurs;
	
	@Override
	public void configure(CapteurInterf leCapteur) {
		
		this.capteur = leCapteur;
		this.nombreObservateurs = leCapteur.getObservateurs().size();
		
	}

	@Override
	abstract public void executeDiffusion();

	@Override
	abstract public int recupereValeur();
	
}

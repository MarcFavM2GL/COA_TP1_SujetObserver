package fr.istic.COA;

import java.util.concurrent.Future;

import javax.swing.JFrame;

public class CAfficheur{
	
	int idAff;
	Integer valeur;
	PAfficheur presentation;
	
	public CAfficheur(int num){
		idAff = num;
		presentation = new PAfficheur(this);
		
		presentation.setNumAff(idAff);
	}

	public void actualiseAff(SujetObserveInterf sujetObserve) {
		
		valeur = ((Canal)sujetObserve).getValue();
		presentation.setValAff(valeur);
				
	}
	
	public PAfficheur getPresentation(){
		return presentation;
	}


}

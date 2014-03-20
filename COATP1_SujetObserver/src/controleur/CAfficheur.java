package controleur;

import interfaces.SujetObserveInterf;

import java.util.concurrent.Future;

import javax.swing.JFrame;

import presentation.PAfficheur;

/**
 * Controle chaque afficheur
 */
public class CAfficheur{
	
	int idAff;
	Integer valeur;
	PAfficheur presentation;
	
	/**
	 * Constructor for CAfficheur.
	 * @param num int
	 */
	public CAfficheur(int num){
		idAff = num;
		presentation = new PAfficheur(this);
		
		presentation.setNumAff(idAff);
	}

	/**
	 * Method actualiseAff.
	 * @param sujetObserve SujetObserveInterf
	 */
	public void actualiseAff(SujetObserveInterf sujetObserve) {
		
		valeur = ((Canal)sujetObserve).getValue();
		presentation.setValAff(valeur);
				
	}
	
	/**
	 * Method getPresentation.
	 * @return PAfficheur
	 */
	public PAfficheur getPresentation(){
		return presentation;
	}


}

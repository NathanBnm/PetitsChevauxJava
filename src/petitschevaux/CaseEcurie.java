/*
 *                                                            
 *   _____     _   _ _          _____ _                       
 *  |  _  |___| |_|_| |_ ___   |     | |_ ___ _ _ ___ _ _ _ _ 
 *  |   __| -_|  _| |  _|_ -|  |   --|   | -_| | | .'| | |_'_|
 *  |__|  |___|_| |_|_| |___|  |_____|_|_|___|\_/|__,|___|_,_|
 *                                                            
 *                                               Version 0.0.1
 *  
 *                 Nathan Bonnemains <21801526@etu.unicaen.fr>
 *                 Gérémy L'Ecuyer <21802888@etu.unicaen.fr>
 *  
 */

package petitschevaux;

/**
 * Classe CaseEcurie (hérite de CaseColoree)
 */
public class CaseEcurie extends CaseColoree {

	/**
	 * Constructeur par défaut
	 * @param Couleur
	 */
	public CaseEcurie(Couleur couleur) {
		super(couleur);
	}

	/**
	 * 
	 * @return true
	 */
	public Boolean peutPasser(Pion p) {
		return true;
	}

	/**
	 * 
	 * @return true
	 */
	public Boolean peutSArreter(Pion p) {
		return true;
	}

}
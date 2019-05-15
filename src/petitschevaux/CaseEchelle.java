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
 * 
 */
public class CaseEchelle extends CaseColoree {

	/**
	 * @param Couleur
	 */
	public CaseEchelle(Couleur couleur) {
		super(couleur);
	}

	/**
	 *peutPasser permet de vérifier si un obstacle ce trouve sur la route
	 *, soit un cheval allié.
	 * @return
	 */
	public Boolean peutPasser(Pion p) {
		Boolean res = false;
		if(getChevaux().isEmpty()) {
			res = true;
		}
		return res;
	}

	/**
	 *peutSArreter permet de vérifier si un obstacle ce trouve sur la case d'arriver
	 *, soit un cheval allié.
	 * @return
	 */
	public Boolean peutSArreter(Pion p) {
		Boolean res = false;
		if(getChevaux().isEmpty()) {
			res = true;
		}
		return res;
	}

}
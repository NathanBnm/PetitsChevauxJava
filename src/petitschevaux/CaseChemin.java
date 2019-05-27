/*
 *                                                            
 *   _____     _   _ _          _____ _                       
 *  |  _  |___| |_|_| |_ ___   |     | |_ ___ _ _ ___ _ _ _ _ 
 *  |   __| -_|  _| |  _|_ -|  |   --|   | -_| | | .'| | |_'_|
 *  |__|  |___|_| |_|_| |___|  |_____|_|_|___|\_/|__,|___|_,_|
 *                                                            
 *                                               Version 1.0.0
 *  
 *                 Nathan Bonnemains <21801526@etu.unicaen.fr>
 *                 Gérémy L'Ecuyer <21802888@etu.unicaen.fr>
 *  
 */

package petitschevaux;

/**
 * Classe CaseChemin (hérite de Case)
 */
public class CaseChemin extends Case {

	/**
	 * Constructeur par défaut
	 */
	public CaseChemin() {
	}

	/**
	 * peutPasser permet de vérifier si un obstacle ce trouve sur la route, soit un cheval adverse.
	 * @return true ou false
	 */
	public Boolean peutPasser(Pion p) {
		Boolean res = false;
		if(getChevaux().size() == 0) {
			res = true;
		} else  {
			for(Pion c : getChevaux()) {
				if(c.getCouleur() == p.getCouleur()) {
					res = true;
				}
			}
		}
		return res;
	}

	/**
	 *peutSArreter permet de vérifier si un obstacle ce trouve sur la case d'arriver.
	 *(Dans ce cas, peutSArreter retourne toujours true car on peut s'arrêter sur une case
	 *avec un cheval adverse (le manger) et sur une case avec un cheval allié.)
	 * @return true
	 */
	public Boolean peutSArreter(Pion p) {
		return true;
	}

}
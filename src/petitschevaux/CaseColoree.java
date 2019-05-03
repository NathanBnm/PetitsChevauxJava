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
public abstract class CaseColoree extends Case {

	/**
	 * @param Couleur
	 */
	public CaseColoree(Couleur couleur) {
		// TODO implement here
	}
	
	public Couleur getCouleur() {
		return null;
	}

	/**
	 * @return
	 */
	public abstract Boolean peutPasser(Pion p);

	/**
	 * @return
	 */
	public abstract Boolean peutSArreter(Pion p);

}